package org.fix4j.test.session;

import org.fix4j.test.expression.MessageExpressionParser;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.integration.FixEngineSession;
import org.fix4j.test.integration.FixEngineSessionFactory;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.messageflags.MessageFlagRule;
import org.fix4j.test.messageflags.MessageFlagRules;
import org.fix4j.test.messageflags.SessionLevelRejectMessageFlagRule;
import org.fix4j.test.plumbing.BlockingPipe;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.processors.InboundIgnoreProcessor;
import org.fix4j.test.processors.InboundMessageFlagFailureProcessor;
import org.fix4j.test.processors.InboundProcessors;
import org.fix4j.test.processors.InboundRecentMessageProcessor;
import org.fix4j.test.processors.OnFailureReporters;
import org.fix4j.test.processors.OutboundMessageFlagFailureProcessor;
import org.fix4j.test.processors.OutboundProcessors;
import org.fix4j.test.processors.OutboundRecentMessageProcessor;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.properties.CompositePropertyMap;
import org.fix4j.test.properties.MapPropertySource;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.properties.PropertySource;
import org.fix4j.test.properties.SystemEnvVariablePropertySource;
import org.fix4j.test.properties.SystemPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class AbstractContextFactory implements ContextFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractContextFactory.class);
    private final FixSpecification fixSpecification;
    private final PropertySource testRunProperties;

    public AbstractContextFactory(final Map<String, String> properties) {
        this.fixSpecification = createFixSpecification();
        this.testRunProperties = new MapPropertySource(properties, "TEST");
    }

    public AbstractContextFactory() {
        this.fixSpecification = createFixSpecification();
        this.testRunProperties = null;
    }

    protected abstract FixEngineSessionFactory createFixEngineSessionFactory(final FixSpecification fixSpecification, final ApplicationProperties properties);
    protected abstract FixSpecification createFixSpecification();

    @Override
    public TestContext createTestContext(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode) {
        final ApplicationProperties properties = createApplicationProperties();
        LOGGER.info(properties.toString());
        final FixEngineSessionFactory fixEngineSessionFactory = createFixEngineSessionFactory(fixSpecification, properties);
        final BlockingPipe<FixMessage> inboundBlockingPipe = new BlockingPipe<>("fromThirdPartyFixEngine");
        final FixEngineSession fixEngineSession = fixEngineSessionFactory.createSession(fixSessionId, fixConnectionMode, inboundBlockingPipe);
        final InboundProcessors inboundProcessors = new InboundProcessors(inboundBlockingPipe, createInboundProcessors(properties));
        final OutboundProcessors outboundProcessors = new OutboundProcessors(fixEngineSession, createOutboundProcessors(properties));
        final SessionConnectors sessionConnectors = new SessionConnectors(inboundProcessors, outboundProcessors);
        final OnFailureReporters onFailReporters = new OnFailureReporters(inboundProcessors, outboundProcessors);
        return new TestContext(sessionConnectors, fixSessionId, onFailReporters, fixConnectionMode, fixEngineSession, fixSpecification, properties);
    }

    @Override
    public FixSpecification getFixSpecification() {
        return fixSpecification;
    }

    protected ApplicationProperties createApplicationProperties() {
        return CompositePropertyMap.Builder.create("ALL")
                .addLast(testRunProperties)
                .addLast(new SystemPropertySource())
                .addLast(new SystemEnvVariablePropertySource())
                .addLast(PropertyKeysAndDefaultValues.getDefaultProperties())
                .build();
    }

    protected List<Processor<FixMessage>> createOutboundProcessors(final ApplicationProperties properties) {
        final MessageFlagRules outboundMessageFlagWarningRules = createOutboundMessageFlagWarningRules();
        final MessageFlagRules outboundMessageFlagFailureRules = createOutboundMessageFlagFailureRules();
        final OutboundRecentMessageProcessor outboundRecentMessageProcessor = new OutboundRecentMessageProcessor(outboundMessageFlagWarningRules);
        final OutboundMessageFlagFailureProcessor outboundMessageFlagFailureProcessor = new OutboundMessageFlagFailureProcessor(outboundMessageFlagFailureRules, properties.getAsBoolean(PropertyKeysAndDefaultValues.FAST_FAIL_ON_TRIGGER_OF_OUTBOUND_MESSAGE_FLAG.name()));
        return Arrays.asList(outboundRecentMessageProcessor, outboundMessageFlagFailureProcessor);
    }

    protected List<Processor<FixMessage>> createInboundProcessors(final ApplicationProperties properties) {
        final FixMessageMatcher defaultMessagesToIgnore = createMatcherForMessagesToIgnore(fixSpecification, properties);
        final MessageFlagRules inboundMessageFlagWarningRules = createInboundMessageFlagWarningRules();
        final MessageFlagRules inboundMessageFlagFailureRules = createInboundMessageFlagFailureRules();

        final InboundIgnoreProcessor inboundIgnoreProcessor = new InboundIgnoreProcessor(defaultMessagesToIgnore);
        final InboundRecentMessageProcessor inboundRecentMessageProcessor = new InboundRecentMessageProcessor(inboundMessageFlagWarningRules);
        final InboundMessageFlagFailureProcessor inboundMessageFlagFailureProcessor = new InboundMessageFlagFailureProcessor(inboundMessageFlagFailureRules, properties.getAsBoolean(PropertyKeysAndDefaultValues.FAST_FAIL_ON_TRIGGER_OF_INCOMING_MESSAGE_FLAG.name()));
        return Arrays.asList(inboundIgnoreProcessor, inboundRecentMessageProcessor, inboundMessageFlagFailureProcessor);
    }

    protected FixMessageMatcher createMatcherForMessagesToIgnore(final FixSpecification fixSpecification, final ApplicationProperties properties) {
        final MessageExpressionParser parser = new MessageExpressionParser(fixSpecification);
        return parser.parse(properties.getAsString(PropertyKeysAndDefaultValues.DEFAULT_MESSAGES_TO_IGNORE.name()));
    }

    protected MessageFlagRules createOutboundMessageFlagFailureRules() {
        final List<MessageFlagRule> rules = new ArrayList<>();
        rules.addAll(MessageFlagRules.fieldsShouldNotBeSet(
                "Field was explicitly set in message. Unless explicitly testing such functionality, this field should usually be left to the fix engine.",
                fixSpecification.getFieldTypeByName("SenderCompID"),
                fixSpecification.getFieldTypeByName("TargetCompID"),
                fixSpecification.getFieldTypeByName("SendingTime"),
                fixSpecification.getFieldTypeByName("MsgSeqNum"),
                fixSpecification.getFieldTypeByName("BeginString"),
                fixSpecification.getFieldTypeByName("CheckSum"),
                fixSpecification.getFieldTypeByName("BodyLength")));
        return new MessageFlagRules(rules);
    }

    protected MessageFlagRules createInboundMessageFlagFailureRules() {
        final List<MessageFlagRule> rules = new ArrayList<>();
        rules.add(new SessionLevelRejectMessageFlagRule(fixSpecification));
        return new MessageFlagRules(rules);
    }

    protected MessageFlagRules createOutboundMessageFlagWarningRules() {
        return MessageFlagRules.EMPTY;
    }

    protected MessageFlagRules createInboundMessageFlagWarningRules() {
        return MessageFlagRules.EMPTY;
    }
}

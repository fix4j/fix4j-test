package org.fix4j.test.integration.quickfix;

import org.fix4j.test.integration.FixEngineSession;
import org.fix4j.test.integration.MessageConverter;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.BlockingPipe;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.plumbing.ShuntFromSupplierToConsumer;
import org.fix4j.test.session.TestSessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.ConfigError;
import quickfix.Connector;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:48 AM
 */
public class QuickFixTestSession implements FixEngineSession {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestSessionHelper.class);
    private final QuickFixApplication application;
    private final SessionID sessionId;
    private final Consumer<FixMessage> quickFixConverter;
    private final Connector connector;

    public QuickFixTestSession(final Consumer<FixMessage> toTestFrameworkConsumer, final SessionID sessionId, final QuickFixApplication quickFixApplication, final FixSpecification fixSpecification, final Connector connector) {
        this.sessionId = sessionId;
        this.connector = connector;

        //Messages FROM:quickfix -> TO:testFramework
        final FromQuickFixMessageConverter fromQuickFixMessageConverter = new FromQuickFixMessageConverter(fixSpecification);
        final Consumer<quickfix.Message> fromQuickFixConvertingPipe = fromQuickFixMessageConverter.convertAndSendMessagesTo(toTestFrameworkConsumer);
        this.application = quickFixApplication;
        quickFixApplication.register(sessionId, fromQuickFixConvertingPipe);

        //Messages FROM:testFramework -> TO:quickfix
        final MessageConverter<FixMessage, Message> toQuickFixMessageConverter = new ToQuickFixMessageConverter(fixSpecification);

        final BlockingPipe<Message> queueBetweenThisFixSessionAndFixApplication = new BlockingPipe<Message>("queueBetweenThisFixSessionAndFixApplication");

        final Consumer<Message> toQuickfixApplication = new Consumer<Message>() {
            @Override
            public void accept(final Message message) {
                application.send(message, sessionId);
            }
        };
        final Consumer<FixMessage> toQuickFixConvertingPipe = toQuickFixMessageConverter.convertAndSendMessagesTo(queueBetweenThisFixSessionAndFixApplication);

        quickFixConverter = new Consumer<FixMessage>() {
            public void accept(final FixMessage fixMessage) {
                toQuickFixConvertingPipe.accept(fixMessage);
            }
        };

        new ShuntFromSupplierToConsumer<>("fromTestFrameworkSupplier-to-simpleMessageConsumerToQuickFixConverter", queueBetweenThisFixSessionAndFixApplication, toQuickfixApplication).start();
    }

    @Override
    public synchronized void logon() {
        LOGGER.info("About to login to: " + sessionId);
        Session.lookupSession(sessionId).logon();
        LOGGER.info("Logged into: " + sessionId);
    }

    @Override
    public void logout() {
        Session.lookupSession(sessionId).logout("user requested");
    }

    @Override
    public void accept(final FixMessage fixMessage) {
        quickFixConverter.accept(fixMessage);
    }

    @Override
    public void shutdown() {
        connector.stop();
    }

    @Override
    public void shutdown(boolean force) {
        connector.stop(force);
    }

    @Override
    public void startup(){
        try {
            connector.start();
        } catch (ConfigError configError) {
            throw new RuntimeException(configError);
        }
    }
}

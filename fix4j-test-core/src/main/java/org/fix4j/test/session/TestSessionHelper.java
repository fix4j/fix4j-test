package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Handler;
import org.fix4j.test.plumbing.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
I have put a queue between the fixEngineSession and the fixTestSession.  This is so that
testing is not holding up any fixEngine threads.

I have chosen not to put a queue for messages outbound.  The FixTestClientSession is a simple consumer.
I wanted outbound messages to be converted to the third-party fix messages before hopping threads, so
that any conversion exceptions would stop the test.
 */

public class TestSessionHelper {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestSessionHelper.class);
    private final ContextFactory contextFactory;

    public TestSessionHelper(final ContextFactory contextFactory) {
        this.contextFactory = contextFactory;
    }

    public MatchingSession createMatchingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode) {
        final TestContext testContext = contextFactory.createTestContext(fixSessionId, fixConnectionMode);
        testContext.fixEngineSession.startup();
        return new MatchingSession(testContext);
    }

    public DispatchingSession createDispatchingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Handler messageHandler) {
        final TestContext testContext = contextFactory.createTestContext(fixSessionId, fixConnectionMode);
        testContext.fixEngineSession.startup();
        return new DispatchingSession(testContext, messageHandler);
    }

    public ConsumerSession createConsumerSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Consumer<FixMessage> messageHandler) {
        final TestContext testContext = contextFactory.createTestContext(fixSessionId, fixConnectionMode);
        testContext.fixEngineSession.startup();
        return new ConsumerSession(testContext, messageHandler);
    }

    public BlockingSession createBlockingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode) {
        final TestContext testContext = contextFactory.createTestContext(fixSessionId, fixConnectionMode);
        testContext.fixEngineSession.startup();
        return new BlockingSession(testContext);
    }

    public FixMessage parse(final String expression) {
        return contextFactory.getFixSpecification().parse(expression);
    }
}

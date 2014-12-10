package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Handler;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.ShuntFromSupplierToConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 21/08/2014
 * Time: 5:26 AM
 */
public class DispatchingSession implements TestClientSession{
    private final static Logger LOGGER = LoggerFactory.getLogger(DispatchingSession.class);
    private final SimpleOutboundSession outboundSession;
    private final TestContext testContext;

    public DispatchingSession(final TestContext testContext, final Handler messageHandler) {
        this.testContext = testContext;
        final MessageDispatcher messageDispatcher = new MessageDispatcher(testContext.fixSpecification, messageHandler);
        new ShuntFromSupplierToConsumer<>("fromNetwork-to-messageDispatcher", testContext.sessionConnectors.inboundSupplier, messageDispatcher).start();
        this.outboundSession = new SimpleOutboundSession(testContext.fixSpecification, testContext.sessionConnectors.outboundConsumer);
    }

    public void send(final String messageStr) {
        try {
            outboundSession.send(messageStr);
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    public void send(final FixMessage message){
        try {
            outboundSession.send(message);
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    @Override
    public void shutdown() {
        testContext.fixEngineSession.shutdown();
    }

    @Override
    public FixSpecification getFixSpecification() {
        return testContext.fixSpecification;
    }

    @Override
    public FixSessionId getSessionId() {
        return testContext.fixSessionId;
    }
}

package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 21/08/2014
 * Time: 5:26 AM
 */
public class BlockingSession implements TestClientSession {
    private final static Logger LOGGER = LoggerFactory.getLogger(BlockingSession.class);

    private final SimpleOutboundSession outboundSession;
    private final TestContext testContext;

    public BlockingSession(final TestContext testContext) {
        this.outboundSession = new SimpleOutboundSession(testContext.fixSpecification, testContext.sessionConnectors.outboundConsumer);
        this.testContext = testContext;
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

    public FixMessage getNextMessage() {
        try {
            FixMessage message = null;
            while(message == null){
                message = testContext.sessionConnectors.inboundSupplier.get(testContext.applicationProperties.getAsLong(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey()));
            }
            return message;
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    public FixMessage getNextMessage(final long waitTimeoutInMs) {
        try {
            final FixMessage message = testContext.sessionConnectors.inboundSupplier.get(waitTimeoutInMs);
            if(message == null){
                throw new Failure(new TimeoutReport());
            } else {
                return message;
            }
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    @Override
    public void shutdown(){
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

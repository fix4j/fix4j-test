package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.matching.MatchingInboundSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 21/08/2014
 * Time: 5:26 AM
 */
public class MatchingSession implements TestClientSession {
    private final static Logger LOGGER = LoggerFactory.getLogger(MatchingSession.class);
    private final MatchingInboundSession inboundSession;
    private final SimpleOutboundSession outboundSession;
    private final TestContext testContext;

    public MatchingSession(final TestContext testContext) {
        this.inboundSession = new MatchingInboundSession(testContext.fixSpecification, testContext.sessionConnectors.inboundSupplier, testContext.applicationProperties);
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

    public FixMessage expect(final String fixExpression) throws InterruptedException {
        try {
            return inboundSession.expect(fixExpression).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    public FixMessage expect(final MsgType msgType) {
        try {
            return inboundSession.expect(msgType).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    public FixMessage discardUntilExpected(final String fixExpression) {
        try {
            return inboundSession.discardUntilExpected(fixExpression).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    public FixMessage discardUntilMsgTypeReceived(final MsgType msgType) throws InterruptedException {
        try {
            return inboundSession.discardUntilTypeOfMessageReceived(msgType).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    public FixMessage discardUntilExpected(final MsgType msgType, final String fixExpression) throws InterruptedException {
        try {
            return inboundSession.discardUntilTypeOfMsgReceived(msgType, fixExpression).getMessage();
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

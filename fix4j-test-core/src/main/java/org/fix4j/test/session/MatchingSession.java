package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.matching.MatchingInboundSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MatchingSession allows the user to send messages, as well as specify criteria for asserting
 * incoming messages.
 *
 * User: ben
 */
public class MatchingSession implements TestClientSession {
    private final MatchingInboundSession inboundSession;
    private final SimpleOutboundSession outboundSession;
    private final TestContext testContext;

    public MatchingSession(final TestContext testContext) {
        this.inboundSession = new MatchingInboundSession(testContext.fixSpecification, testContext.sessionConnectors.inboundSupplier, testContext.applicationProperties);
        this.outboundSession = new SimpleOutboundSession(testContext.fixSpecification, testContext.sessionConnectors.outboundConsumer);
        this.testContext = testContext;
    }

    /**
     * @see org.fix4j.test.expression.MessageExpression
     * @param messageExpression
     */
    public void send(final String messageExpression) {
        try {
            outboundSession.send(messageExpression);
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

    /**
     * @see org.fix4j.test.expression.MessageExpression
     * @param messageExpression
     * @return The FixMessage which matches the given expression.
     * @throws org.fix4j.test.session.Failure if: The next message to arrive does NOT match the given expression, or
     * if the next message does not arrive within the timeout period specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage expect(final String messageExpression) {
        try {
            return inboundSession.expect(messageExpression).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * @param msgType
     * @return The FixMessage which matches the given MsgType.
     * @throws org.fix4j.test.session.Failure if: The next message to arrive is NOT of the given MsgType, or
     * if the next message does not arrive within the timeout period specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage expect(final MsgType msgType) {
        try {
            return inboundSession.expect(msgType).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * Discards incoming messages until a message arrives which matches the given expression.  If a matching message
     * does not arrive within the timeout period, a Failure exception is thrown.
     * @see org.fix4j.test.expression.MessageExpression
     * @param messageExpression
     * @return The FixMessage which matches the given expression.
     * @throws org.fix4j.test.session.Failure if: A matching messages does not arrive within the timeout period
     * specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage discardUntil(final String messageExpression) {
        try {
            return inboundSession.discardUntilExpected(messageExpression).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * Discards incoming messages until a message arrives of the given MsgType.  If a message of the given type
     * does not arrive within the timeout period, a Failure exception is thrown.
     * @param msgType
     * @return The FixMessage of the given MsgType
     * @throws org.fix4j.test.session.Failure if: A message of the given type does not arrive within the timeout period
     * specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage discardUntil(final MsgType msgType) {
        try {
            return inboundSession.discardUntilTypeOfMessageReceived(msgType).getMessage();
        } catch (final Failure failure) {
            throw testContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * Discards incoming messages until a message arrives of the given MsgType.  Once a message of the given type
     * arrives, it is asserted against the given messageExpression.  If the message does NOT match the given
     * messageExpression, then a Failure exception is thrown.
     * @see org.fix4j.test.expression.MessageExpression
     * @param msgType
     * @param messageExpression
     * @return The FixMessage of the given MsgType
     * @throws org.fix4j.test.session.Failure if: A message of the given MsgType does not arrive within the timeout period
     * or, if a message DOES arrive of the given type, but it does not match the given messageExpression.
     */
    public FixMessage discardUntil(final MsgType msgType, final String messageExpression) {
        try {
            return inboundSession.discardUntilTypeOfMsgReceived(msgType, messageExpression).getMessage();
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

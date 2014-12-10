package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.plumbing.ShuntFromSupplierToConsumer;

/**
 * User: ben
 * Date: 21/08/2014
 * Time: 5:26 AM
 */
public class ConsumerSession implements TestClientSession{
    private final SimpleOutboundSession outboundSession;
    private final TestContext testContext;

    public ConsumerSession(final TestContext testContext, final Consumer<FixMessage> toTestClient) {
        new ShuntFromSupplierToConsumer<>("fromNetwork-to-testClient", testContext.sessionConnectors.inboundSupplier, toTestClient).start();
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

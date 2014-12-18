package org.fix4j.test.examples.config;

import org.fix4j.spec.fix50sp2.FieldTypes;
import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.spec.fix50sp2.fieldtype.MsgType;
import org.fix4j.spec.fix50sp2.fieldtype.OnBehalfOfCompID;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.examples.TestMessages;
import org.fix4j.test.fixmodel.BaseFixMessage;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.session.Failure;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * User: ben
 */
public class CustomOutboundProcessorWhichRaisesATestFailure {
    private MatchingSession client;
    private MatchingSession server;

    @Test
    public void createCustomOutboundProcessor() {
        //Here we wire in the additional processor
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory(){
            @Override
            protected List<Processor<FixMessage>> createOutboundProcessors(final ApplicationProperties properties) {
                //Get the default outboundProcessors from the super class
                final List<Processor<FixMessage>> outboundProcessors = new ArrayList<>(super.createOutboundProcessors(properties));

                //Add our own processor to raise a failure if a new order is sent
                outboundProcessors.add(new Processor<FixMessage>() {
                    @Override
                    public FixMessage process(final FixMessage message) {
                        if(message.isOfType(MsgTypes.NewOrderSingle)){
                            throw new Failure(message, "Dude, I told you to stop spending my money!");
                        } else {
                            return message;
                        }
                    }
                });
                return outboundProcessors;
            }
        });

        server = helper.createMatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);
        client.discardUntil(MsgTypes.Logon);
        server.discardUntil(MsgTypes.Logon);

        //Send a MarketDataRequest
        client.send(TestMessages.MARKET_DATA_REQUEST);

        //Wait for it to arrive at the server, all is good
        final FixMessage mdr = server.discardUntil(MsgTypes.MarketDataRequest);

        //Send a NewOrderSingle.  Expect a failure
        boolean failed = false;
        try {
            client.send(TestMessages.NEW_ORDER_SINGLE);
        } catch(final Failure failure){
            failed = true;
            assertTrue(failure.getMessage().contains("Dude, I told you to stop spending my money!"));
        }
        assertTrue(failed);
    }

    @After
    public void teardown() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }
}

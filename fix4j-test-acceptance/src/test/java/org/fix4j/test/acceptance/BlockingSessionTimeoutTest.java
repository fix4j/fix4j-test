package org.fix4j.test.acceptance;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.session.BlockingSession;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
public class BlockingSessionTimeoutTest {
    private static BlockingSession server;
    private static BlockingSession client;

    @BeforeClass
    public static void setup() throws InterruptedException {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        server = helper.createBlockingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createBlockingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);

        //Consume up the logon messages
        while(!client.getNextMessage().getTypeOfMessage().equals(MsgTypes.Logon));
        while(!server.getNextMessage().getTypeOfMessage().equals(MsgTypes.Logon));
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }

    @Test
    public void testServerTimesOut() throws InterruptedException {
        try{
            server.getNextMessage();
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    @Test
    public void testClientTimesOut() throws InterruptedException {
        try{
            client.getNextMessage();
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    public void assertTimeout(final AssertionError e) {
        assertContains(e.getMessage(), "Timeout waiting for next message");
    }

    private void assertContains(final String string, final String contains) {
        if(!string.contains(contains)){
            fail("String:'" + string + "' does not contain '" + contains + "'");
        }
    }
}

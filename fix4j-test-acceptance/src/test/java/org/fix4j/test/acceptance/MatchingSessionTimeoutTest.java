package org.fix4j.test.acceptance;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
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
public class MatchingSessionTimeoutTest {
    private static MatchingSession server;
    private static MatchingSession client;

    final String MARKET_DATA_REQUEST =
            "[MsgType]35=V[MARKETDATAREQUEST]|" +
            "[MDReqID]262=AASDJKG790|" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
                "[MDEntryType]269=0[BID]|" +
                "[MDEntryType]269=1[OFFER]|" +
            "[NoRelatedSym]146=3|" +
                "[Symbol]55=GBP/USD|" +
                "[Symbol]55=AUD/USD|" +
                "[Symbol]55=USD/JPY|";
    
    final String NEW_ORDER_SINGLE =
            "[MsgType]35=D[NEWORDERSINGLE]|" +
            "[OrderQty]38=1000|" +
            "[TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]|" +
            "[ExDestination]100=N|" +
            "[OrdType]40=1[MARKET]|" +
            "[ClOrdID]11=ORD10001|" +
            "[TransactTime]60=20070123-19:01:17|" +
            "[Symbol]55=HPQ|" +
            "[Side]54=1[BUY]|" +
            "[HandlInst]21=2[AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK]|";

    @BeforeClass
    public static void setup() throws InterruptedException {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        server = helper.createMatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);
        client.discardUntilMsgTypeReceived(MsgTypes.Logon);
        server.discardUntilMsgTypeReceived(MsgTypes.Logon);
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }

    @Test
    public void testDiscardUntilExpected_matchOnMsgTypeThenFullExpression_nothingReceived_thenTimeout() throws InterruptedException {
        try{
            server.discardUntilExpected(MsgTypes.MarketDataRequest, MARKET_DATA_REQUEST);
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    @Test
    public void testDiscardUntilExpected_matchOnMsgTypeThenFullExpression_messageDiscarded_thenTimeout() throws InterruptedException {
        client.send(NEW_ORDER_SINGLE);
        try{
            server.discardUntilExpected(MsgTypes.MarketDataRequest, MARKET_DATA_REQUEST);
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    @Test
    public void testDiscardUntilExpected_matchOnExpression_nothingReceived_thenTimeout() throws InterruptedException {
        try{
            server.discardUntilExpected(MARKET_DATA_REQUEST);
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    @Test
    public void testDiscardUntilExpected_matchOnExpression_messageDiscarded_thenTimeout() throws InterruptedException {
        client.send(NEW_ORDER_SINGLE);
        try{
            server.discardUntilExpected(MARKET_DATA_REQUEST);
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    @Test
    public void testExpectExpression_timeout() throws InterruptedException {
        try{
            server.expect(NEW_ORDER_SINGLE);
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    @Test
    public void testExpectMsgType_timeout() throws InterruptedException {
        try{
            server.expect(MsgTypes.NewOrderSingle);
        } catch(final AssertionError e){
            assertTimeout(e);
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    public void assertTimeout(final AssertionError e) {
        assertContains(e.getMessage(), "Timeout waiting for message which matches");
    }

    private void assertContains(final String string, final String contains) {
        if(!string.contains(contains)){
            fail("String:'" + string + "' does not contain '" + contains + "'");
        }
    }
}

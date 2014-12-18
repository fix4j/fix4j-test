package org.fix4j.test.examples;

/**
 * User: ben
 * Date: 19/12/14
 * Time: 5:06 AM
 */
public class TestMessages {
    public final static String MARKET_DATA_REQUEST =
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

    public final static String NEW_ORDER_SINGLE =
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
}

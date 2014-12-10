package org.fix4j.test.examples

import org.fix4j.test.fixmodel.Field
import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.spec.fix50sp2.FieldTypes
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.expression.MessageExpression
import org.fix4j.test.expression.MessageExpressionParser
import spock.lang.Specification

/**
 * User: ben
 * Date: 7/10/2014
 * Time: 5:51 AM
 */
class VariousMessageFormatsTest extends Specification {
    private FixSpecification spec = FixSpec.INSTANCE;
    private MessageExpressionParser parser = new MessageExpressionParser(spec);

    //Parse field type
    def "test parse expression - pipe as delim"() {
        when:
        final MessageExpression expression = parser.parse(
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
                "[Symbol]55=USD/JPY|");

        then:
        assertMessage(expression);
    }

    def "test parse expression - ctrl A as delim"() {
        when:
        final MessageExpression expression = parser.parse(
            "[MsgType]35=V[MARKETDATAREQUEST]^A" +
            "[MDReqID]262=AASDJKG790^A" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]^A" +
            "[MarketDepth]264=20^A" +
            "[NoMDEntryTypes]267=2^A" +
                "[MDEntryType]269=0[BID]^A" +
                "[MDEntryType]269=1[OFFER]^A" +
            "[NoRelatedSym]146=3^A" +
                "[Symbol]55=GBP/USD^A" +
                "[Symbol]55=AUD/USD^A" +
                "[Symbol]55=USD/JPY^A");

        then:
        assertMessage(expression);
    }

    def "test parse expression - ascii x0001 as delim"() {
        when:
        final MessageExpression expression = parser.parse("35=V\u0001262=AASDJKG790\u0001263=0\u0001264=20\u0001267=2\u0001269=0\u0001269=1\u0001146=3\u000155=GBP/USD\u000155=AUD/USD\u000155=USD/JPY");

        then:
        assertMessage(expression);
    }

    def "test parse expression - no annotations as delim"() {
        when:
        final MessageExpression expression = parser.parse(
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
                "[Symbol]55=USD/JPY|");

        then:
        assertMessage(expression);
    }
    
    def boolean assertMessage(final MessageExpression expression){
        assert expression.getFieldExpressions().size() == 11;
        assert expression.getFieldExpressions().get(0).equals(new Field(FieldTypes.MsgType, "V"))
        assert expression.getFieldExpressions().get(1).equals(new Field(FieldTypes.MDReqID, "AASDJKG790"))
        assert expression.getFieldExpressions().get(2).equals(new Field(FieldTypes.SubscriptionRequestType, "0"))
        assert expression.getFieldExpressions().get(3).equals(new Field(FieldTypes.MarketDepth, "20"))
        assert expression.getFieldExpressions().get(4).equals(new Field(FieldTypes.NoMDEntryTypes, "2"))
        assert expression.getFieldExpressions().get(5).equals(new Field(FieldTypes.MDEntryType, "0"))
        assert expression.getFieldExpressions().get(6).equals(new Field(FieldTypes.MDEntryType, "1"))
        assert expression.getFieldExpressions().get(7).equals(new Field(FieldTypes.NoRelatedSym, "3"))
        assert expression.getFieldExpressions().get(8).equals(new Field(FieldTypes.Symbol, "GBP/USD"))
        assert expression.getFieldExpressions().get(9).equals(new Field(FieldTypes.Symbol, "AUD/USD"))
        assert expression.getFieldExpressions().get(10).equals(new Field(FieldTypes.Symbol, "USD/JPY"))
        return true;
    }
}

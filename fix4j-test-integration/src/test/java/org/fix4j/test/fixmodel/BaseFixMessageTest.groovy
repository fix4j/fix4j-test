package org.fix4j.test.fixmodel

import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.spec.fix50sp2.FixSpec
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * User: ben
 * Date: 10/11/2014
 * Time: 7:57 PM
 */
class BaseFixMessageTest extends Specification {
    private final static Logger LOGGER = LoggerFactory.getLogger(BaseFixMessageTest.class);

    def "test GetReferenceMap"() {
        given:
        final FixSpecification fixSpecification = FixSpec.INSTANCE;
        FixMessage msg = fixSpecification.parse(
                "[MsgType]35=V[MARKETDATAREQUEST]|" +
                "[MDReqID]262=AASDJKG790|" +
                "[NoRelatedSym]146=3|" +
                    "[Symbol]55=GBP/USD|" +
                    "[SettlDate]64=SP|" +
                    "[Symbol]55=AUD/USD|" +
                    "[SettlDate]64=1W|" +
                    "[Symbol]55=USD/JPY|" +
                    "[SettlDate]64=1W|" +
                "[NoMDEntryTypes]267=2|" +
                    "[MDEntryType]269=0[BID]|" +
                    "[MDEntryType]269=1[OFFER]|");


        LOGGER.info msg.toPrettyString();

        Map<String, String> expectedMap = [

            "35":"V[MARKETDATAREQUEST]",
            "262":"AASDJKG790",
            "146":"3",
            "146[0].55":"GBP/USD",
            "146[0].64":"SP",
            "146[1].55":"AUD/USD",
            "146[1].64":"1W",
            "146[2].55":"USD/JPY",
            "146[2].64":"1W",
            "267":"2",
            "267[0].269":"0[BID]",
            "267[1].269":"1[OFFER]",

            "146[0].Symbol":"GBP/USD",
            "146[0].SettlDate":"SP",
            "146[1].Symbol":"AUD/USD",
            "146[1].SettlDate":"1W",
            "146[2].Symbol":"USD/JPY",
            "146[2].SettlDate":"1W",
            "267[0].MDEntryType":"0[BID]",
            "267[1].MDEntryType":"1[OFFER]",

            "NoRelatedSym[0].55":"GBP/USD",
            "NoRelatedSym[0].64":"SP",
            "NoRelatedSym[1].55":"AUD/USD",
            "NoRelatedSym[1].64":"1W",
            "NoRelatedSym[2].55":"USD/JPY",
            "NoRelatedSym[2].64":"1W",
            "NoMDEntryTypes[0].269":"0[BID]",
            "NoMDEntryTypes[1].269":"1[OFFER]",

            "MsgType":"V[MARKETDATAREQUEST]",
            "MDReqID":"AASDJKG790",
            "NoRelatedSym":"3",
            "NoRelatedSym[0].Symbol":"GBP/USD",
            "NoRelatedSym[0].SettlDate":"SP",
            "NoRelatedSym[1].Symbol":"AUD/USD",
            "NoRelatedSym[1].SettlDate":"1W",
            "NoRelatedSym[2].Symbol":"USD/JPY",
            "NoRelatedSym[2].SettlDate":"1W",
            "NoMDEntryTypes":"2",
            "NoMDEntryTypes[0].MDEntryType":"0[BID]",
            "NoMDEntryTypes[1].MDEntryType":"1[OFFER]"];

        when:
        Map<String,String> actualMap = msg.getFieldReferenceMap();

        and:
        final Map<String, String> inActualButNotInExpected = new LinkedHashMap<>();
        for (final String key : actualMap.keySet()) {
            if(!expectedMap.containsKey(key)){
                inActualButNotInExpected.put(key, actualMap.get(key));
            }
        }

        then:
        assert inActualButNotInExpected.size() == 0, "Found entries in actual but not in expected: " + inActualButNotInExpected.toString();

        when:
        final Map<String, String> inExpectedButNotInActual = new LinkedHashMap<>();
        for (final String key : expectedMap.keySet()) {
            if(!actualMap.containsKey(key)){
                inExpectedButNotInActual.put(key, expectedMap.get(key));
            }
        }

        then:
        assert inExpectedButNotInActual.size() == 0, "Found entries in expected but not in actual: " + inActualButNotInExpected.toString();

        when:
        final Map<String, String> inBothButDifferingValues = new LinkedHashMap<>();
        for (final String key : expectedMap.keySet()) {
            if(!actualMap.get(key).equals(expectedMap.get(key))){
                inBothButDifferingValues.put(key, expectedMap.get(key) + "!=" + actualMap.get(key));
            }
        }

        then:
        assert inExpectedButNotInActual.size() == 0, "Found actual values which are not what we expect" + inActualButNotInExpected.toString();
    }
}

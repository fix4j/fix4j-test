package org.fix4j.test.matching.matchers;

import org.fix4j.test.fixmodel.FixMessage;


/**
 * User: ben
 * Date: 20/11/14
 * Time: 1:22 AM
 */
public class AnyMsgMatcher implements FixMessageMatcher {

    public AnyMsgMatcher() {}

    @Override
    public MatchResult getMatchResult(final FixMessage message) {
        return new BaseMatchResult(true, "Any message is OK");
    }
}

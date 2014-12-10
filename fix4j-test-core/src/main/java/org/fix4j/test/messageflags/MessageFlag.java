package org.fix4j.test.messageflags;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.PrettyPrintable;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.StringUtils;

import java.util.Map;

/**
 * User: ben
 * Date: 1/10/2014
 * Time: 6:08 AM
 */
public class MessageFlag implements PrettyPrintable {
    private final FixMessage fixMessage;
    private final String alert;

    public MessageFlag(final FixMessage fixMessage, final String alert) {
        this.fixMessage = fixMessage;
        this.alert = alert;
    }

    @Override
    public String toString() {
        return toPrettyString();
    }

    public FixMessage getFixMessage() {
        return fixMessage;
    }

    @Override
    public String toPrettyString() {
        if(StringUtils.containsAtLeastOneVariable(alert)){
            final Map<String,String> fieldMap = fixMessage.getFieldReferenceMap();
            return StringUtils.substituteVariables(alert, fieldMap) + Consts.EOL;
        } else {
            return alert + Consts.EOL;
        }
    }
}

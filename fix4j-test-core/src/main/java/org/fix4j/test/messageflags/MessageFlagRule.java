package org.fix4j.test.messageflags;

import org.fix4j.test.fixmodel.FixMessage;

/**
 * User: ben
 * Date: 11/11/2014
 * Time: 4:29 PM
 */
public interface MessageFlagRule {
    boolean isTriggered(FixMessage fixMessage);
    MessageFlags getMessageFlags(FixMessage fixMessage);
}

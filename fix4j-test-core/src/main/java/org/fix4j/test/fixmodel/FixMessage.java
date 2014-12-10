package org.fix4j.test.fixmodel;


import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.session.FixSessionId;

public interface FixMessage extends FieldSource, PrettyPrintable {
    boolean isOfType(MsgType msgType);
    MsgType getTypeOfMessage();
    FieldsAndGroups getHeader();
    FieldsAndGroups getTrailer();
    FieldsAndGroups getBody();
    String toDelimitedMessageWithAnnotations();
    String toDelimitedMessage();
    FixSessionId getSessionId();
    String getSenderAndTargetCompIds();
}

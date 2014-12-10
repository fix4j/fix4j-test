package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.util.Asserts;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ben
 * Date: 23/09/2014
 * Time: 6:11 AM
 */
public class BaseFixMessage implements FixMessage {
    public static final String BANNER_STR = "------------------------------------------------------";
    public static final String PRETTY_HEADER_TITLE = "Header";
    public static final String PRETTY_BODY_TITLE = "Body";
    public static final String PRETTY_TRAILER_TITLE = "Trailer";

    private final int MSG_TYPE_TAG = 35;
    private final int BEGIN_STRING_TAG = 8;
    private final int SENDER_COMP_TAG = 49;
    private final int TARGET_COMP_TAG = 56;

    private final FieldsAndGroups header;
    private final FieldsAndGroups trailer;
    private final FieldsAndGroups body;
    private final List<Field> allFields;
    private final MsgType typeOfMessage;

    public BaseFixMessage(
            final MsgType typeOfMessage,
            final FieldsAndGroups header,
            final FieldsAndGroups body,
            final FieldsAndGroups trailer) {

        this.header = header;
        this.trailer = trailer;
        this.body = body;
        this.typeOfMessage = typeOfMessage;

        Asserts.assertEquals(typeOfMessage.getTag().getValue(), header.getField(MSG_TYPE_TAG).getValue());

        final List<Field> allFields = new ArrayList<>();
        allFields.addAll(header.getAllFieldsRecursively());
        allFields.addAll(body.getAllFieldsRecursively());
        allFields.addAll(trailer.getAllFieldsRecursively());
        this.allFields = Collections.unmodifiableList(allFields);
    }

    @Override
    public boolean isOfType(MsgType msgType) {
        return getTypeOfMessage().equals(msgType);
    }

    @Override
    public MsgType getTypeOfMessage() {
        return typeOfMessage;
    }

    @Override
    public List<Field> getAllFieldsRecursively() {
        return allFields;
    }

    @Override
    public String toDelimitedMessageWithAnnotations() {
        final StringBuilder sb = new StringBuilder();
        for (final Field field : allFields) {
            sb.append(field.toStringWithAnnotations()).append(Consts.FIX_FIELD_DISPLAY_DELIM);
        }
        return sb.toString();
    }

    @Override
    public String toDelimitedMessage() {
        final StringBuilder sb = new StringBuilder();
        for (final Field field : allFields) {
            sb.append(field.toStringWithRawValues()).append(Consts.FIX_FIELD_DISPLAY_DELIM);
        }
        return sb.toString();
    }

    @Override
    public FixSessionId getSessionId() {
        final Field beginString = header.getField(BEGIN_STRING_TAG);
        final Field senderCompId = header.getField(SENDER_COMP_TAG);
        final Field targetCompId = header.getField(TARGET_COMP_TAG);

        return new FixSessionId(beginString.getValue(), senderCompId.getValue(), targetCompId.getValue());
    }

    @Override
    public String getSenderAndTargetCompIds() {
        final Field senderCompId = header.getField(SENDER_COMP_TAG);
        final Field targetCompId = header.getField(TARGET_COMP_TAG);
        return senderCompId.getValue() + "->" + targetCompId.getValue();
    }

    @Override
    public Map<String, String> getFieldReferenceMap() {
        Map<String,String> map = new LinkedHashMap<>();
        map.putAll(header.getFieldReferenceMap());
        map.putAll(body.getFieldReferenceMap());
        map.putAll(trailer.getFieldReferenceMap());
        return map;
    }

    @Override
    public FieldsAndGroups getHeader() {
        return header;
    }

    @Override
    public FieldsAndGroups getTrailer() {
        return trailer;
    }

    @Override
    public FieldsAndGroups getBody() {
        return body;
    }

    @Override
    public String toString() {
        return this.toDelimitedMessageWithAnnotations();
    }

    @Override
    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(BANNER_STR).append(Consts.EOL);
        sb.append(this.typeOfMessage.getName()).append(Consts.EOL);
        sb.append(BANNER_STR).append(Consts.EOL);
        sb.append(PRETTY_HEADER_TITLE).append(Consts.EOL);
        sb.append(StringUtils.indentAllLines(header.toPrettyString()));
        sb.append(PRETTY_BODY_TITLE).append(Consts.EOL);
        sb.append(StringUtils.indentAllLines(body.toPrettyString()));
        sb.append(PRETTY_TRAILER_TITLE).append(Consts.EOL);
        sb.append(StringUtils.indentAllLines(trailer.toPrettyString()));
        return sb.toString();
    }
}

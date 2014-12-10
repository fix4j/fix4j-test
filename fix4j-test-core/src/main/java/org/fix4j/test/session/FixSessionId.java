package org.fix4j.test.session;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:51 AM
 */
public class FixSessionId {
    private final String beginString;
    private final String senderCompId;
    private final String targetCompId;

    public FixSessionId(final String beginString, final String senderCompId, final String targetCompId) {
        this.beginString = beginString;
        this.senderCompId = senderCompId;
        this.targetCompId = targetCompId;
    }

    public String getBeginString() {
        return beginString;
    }

    public String getSenderCompId() {
        return senderCompId;
    }

    public String getTargetCompId() {
        return targetCompId;
    }

    @Override
    public String toString() {
        return beginString + ":" + senderCompId + "->" + targetCompId;
    }
}

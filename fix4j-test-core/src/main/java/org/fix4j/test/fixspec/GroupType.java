package org.fix4j.test.fixspec;

/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:34 AM
 */


public interface GroupType extends FieldAndGroupTypes, MessageChildType{
    public FieldType getNoOfFieldType();
    public GroupKey getGroupKey(final MsgType msgType);
    public MessageChildType getFirstChildTypeOfRepeatingGroup();
    Tag<Integer> getTag();
    boolean isRequired();
}

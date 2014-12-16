package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PriorityIndicator extends BaseFieldType {
    public static final PriorityIndicator INSTANCE = new PriorityIndicator();

    private PriorityIndicator() {
        super(
            "PriorityIndicator",
            638,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field LOST_PRIORITY_AS_RESULT_OF_ORDER_CHANGE = new Field(PriorityIndicator.INSTANCE, Values.LOST_PRIORITY_AS_RESULT_OF_ORDER_CHANGE.getOrdinal());
        public final Field PRIORITY_UNCHANGED = new Field(PriorityIndicator.INSTANCE, Values.PRIORITY_UNCHANGED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        LOST_PRIORITY_AS_RESULT_OF_ORDER_CHANGE("1"),
        PRIORITY_UNCHANGED("0");

        private final String ordinal;

        private Values(final String ordinal) {
            this.ordinal = ordinal;
        }

        @Override
        public String getOrdinal() {
            return ordinal;
        }
    }
}

package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PegMoveType extends BaseFieldType {
    public static final PegMoveType INSTANCE = new PegMoveType();

    private PegMoveType() {
        super(
            "PegMoveType",
            835,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue = new FieldFactory();

    public static class FieldFactory{
        public final Field FIXED = new Field(PegMoveType.INSTANCE, Values.FIXED.getOrdinal());
        public final Field FLOATING_DEFAULT = new Field(PegMoveType.INSTANCE, Values.FLOATING_DEFAULT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FIXED("1"),
        FLOATING_DEFAULT("0");

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

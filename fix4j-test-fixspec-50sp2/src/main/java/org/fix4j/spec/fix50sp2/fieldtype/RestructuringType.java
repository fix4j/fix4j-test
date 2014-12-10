package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RestructuringType extends BaseFieldType {
    public static final RestructuringType INSTANCE = new RestructuringType();

    private RestructuringType() {
        super(
            "RestructuringType",
            1449,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue = new FieldFactory();

    public static class FieldFactory{
        public final Field NO_RESTRUCTURING_SPECIFIED = new Field(RestructuringType.INSTANCE, Values.NO_RESTRUCTURING_SPECIFIED.getOrdinal());
        public final Field FULL_RESTRUCTURING = new Field(RestructuringType.INSTANCE, Values.FULL_RESTRUCTURING.getOrdinal());
        public final Field MODIFIED_MOD_RESTRUCTURING = new Field(RestructuringType.INSTANCE, Values.MODIFIED_MOD_RESTRUCTURING.getOrdinal());
        public final Field MODIFIED_RESTRUCTURING = new Field(RestructuringType.INSTANCE, Values.MODIFIED_RESTRUCTURING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO_RESTRUCTURING_SPECIFIED("XR"),
        FULL_RESTRUCTURING("FR"),
        MODIFIED_MOD_RESTRUCTURING("MM"),
        MODIFIED_RESTRUCTURING("MR");

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

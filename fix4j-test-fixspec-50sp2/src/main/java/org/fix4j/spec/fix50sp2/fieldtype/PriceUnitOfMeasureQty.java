package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PriceUnitOfMeasureQty extends BaseFieldType {
    public static final PriceUnitOfMeasureQty INSTANCE = new PriceUnitOfMeasureQty();

    private PriceUnitOfMeasureQty() {
        super(
            "PriceUnitOfMeasureQty",
            1192,
            FieldClassLookup.lookup("QTY"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public enum Values implements FieldTypeValueEnum {
        ; //No enum values for this FieldType.

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

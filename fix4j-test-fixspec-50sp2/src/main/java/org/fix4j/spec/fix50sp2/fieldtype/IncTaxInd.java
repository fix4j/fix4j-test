package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class IncTaxInd extends BaseFieldType {
    public static final IncTaxInd INSTANCE = new IncTaxInd();

    private IncTaxInd() {
        super(
            "IncTaxInd",
            416,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue = new FieldFactory();

    public static class FieldFactory{
        public final Field GROSS = new Field(IncTaxInd.INSTANCE, Values.GROSS.getOrdinal());
        public final Field NET = new Field(IncTaxInd.INSTANCE, Values.NET.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        GROSS("2"),
        NET("1");

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

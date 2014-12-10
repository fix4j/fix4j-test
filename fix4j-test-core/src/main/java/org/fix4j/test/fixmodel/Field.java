package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.util.Consts;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ben
 * Date: 2/09/2014
 * Time: 4:51 PM
 */
public class Field implements FieldSource, Part, PrettyPrintable {
    private final FieldType fieldType;
    private final String value;

    public Field(final FieldType fieldType, final String value) {
        this.fieldType = fieldType;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isValueRegex(){
        return value != null && value.startsWith("/") && value.endsWith("/");
    }

    public boolean isValueLiteral(){
        return !isValueRegex();
    }

    public String getValueRegex(){
        if(!isValueRegex()){
            throw new IllegalArgumentException("Value is not a regex!  Regex must start and end with a foward slash '/'.  e.g. /.*/  Actual value:" + value);
        }
        return value.substring(1,value.length() - 1);
    }

    @Override
    public Tag<Integer> getTag() {
        return fieldType.getTag();
    }

    @Override
    public FieldType getType() {
        return fieldType;
    }


    public FieldType getFieldType() {
        return fieldType;
    }

    public boolean isOfTag(final Tag tag){
        return this.fieldType.getTag().equals(tag);
    }

    @Override
    public String toString() {
        return toStringWithAnnotations();
    }

    public String toStringWithAnnotations() {
        return fieldType + "=" + fieldType.formatValue(value);
    }

    public String toStringWithRawValues(){
        return fieldType.getTag().getValue() + "=" + value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;

        final Field that = (Field) o;

        if (!fieldType.getTag().equals(that.fieldType.getTag())) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldType.getTag().hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public List<Field> getAllFieldsRecursively() {
        return Collections.singletonList(this);
    }

    @Override
    public Map<String, String> getFieldReferenceMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(fieldType.getName(), fieldType.formatValue(this.value));
        map.put(""+fieldType.getTag().getValue(), fieldType.formatValue(this.value));
        return map;
    }

    @Override
    public String toPrettyString() {
        return toString() + Consts.EOL;
    }
}

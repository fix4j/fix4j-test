package org.fix4j.test.fixmodel

import spock.lang.Specification

/**
 * User: ben
 * Date: 9/12/14
 * Time: 5:32 PM
 */
class FieldTest extends Specification {
    def "test IsValueRegex"() {
        expect:
        assert ! new Field(null, "blah").isValueRegex();
        assert ! new Field(null, null).isValueRegex();
        assert new Field(null, "/asdf/").isValueRegex();
    }

    def "test IsValueLiteral"() {
        expect:
        assert new Field(null, "blah").isValueLiteral();
        assert new Field(null, null).isValueLiteral();
        assert ! new Field(null, "/asdf/").isValueLiteral();
    }

    def "test GetValueRegex"() {
        expect:
        assert new Field(null, "/asdf/").getValueRegex() == "asdf"
        assert new Field(null, "/asdf//asdf/asdf/asdf///").getValueRegex() == "asdf//asdf/asdf/asdf//"
    }

    def "test GetValueRegex - exception when not regex"() {
        when:
        assert new Field(null, "blah").getValueRegex()

        then:
        thrown IllegalArgumentException
    }

    def "test GetValueRegex - exception when field value is null"() {
        when:
        assert new Field(null, null).getValueRegex()

        then:
        thrown IllegalArgumentException
    }
}

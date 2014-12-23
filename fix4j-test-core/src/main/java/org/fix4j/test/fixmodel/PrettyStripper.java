package org.fix4j.test.fixmodel;

import org.fix4j.test.util.Consts;

/**
 * User: ben
 * Date: 31/10/2014
 * Time: 7:49 PM
 */
public class PrettyStripper {

    public static String stripPrettiness(final String prettyMessage) {
        String str = prettyMessage.replaceAll("(?s)" + BaseFixMessage.BANNER_STR + ".*" + BaseFixMessage.BANNER_STR, "");
        str = str.replaceAll("(?m)^\\s*" + BaseFixMessage.PRETTY_HEADER_TITLE + "\\s*$", "");
        str = str.replaceAll("(?m)^\\s*" + BaseFixMessage.PRETTY_BODY_TITLE + "\\s*$", "");
        str = str.replaceAll("(?m)^\\s*" + BaseFixMessage.PRETTY_TRAILER_TITLE + "\\s*$", "");

        //Strip space from start of string
        str = str.replaceAll("(?m)^\\s+", "");

        //Strip space from start of field after delimiter
        str = str.replaceAll("(?m)" + Consts.FIX_FIELD_DELIM + "\\s+", Consts.FIX_FIELD_DISPLAY_DELIM);

        //Strip space from end of string (not including carriage returns)
        str = str.replaceAll("(?m)[\\t ]+$", "");

        //Strip space from end of field up to next delimiter
        str = str.replaceAll("(?m)[\\t ]+" + Consts.FIX_FIELD_DELIM, Consts.FIX_FIELD_DISPLAY_DELIM);

        //Strip group repeat prefixes (lines starting with digits then a dot
        str = str.replaceAll("(?m)^\\d+\\.\\s*", "");

        //Strip group repeat prefixes (fields starting with digits then a dot
        str = str.replaceAll("(?m)" + Consts.FIX_FIELD_DELIM + "\\d+\\.\\s*", Consts.FIX_FIELD_DISPLAY_DELIM);

        //Strip line feeds
        str = str.replaceAll("\\r", "");

        //Strip lines containing just whitespace
        str = str.replaceAll("(?m)^\\s+$\\n", "");

        //String empty lines
        str = str.replaceAll("\\n\\1+", "\\n");

        //Finally replace all carriage returns with a delimiter
        str = str.replaceAll("\\n", Consts.FIX_FIELD_DISPLAY_DELIM);
        return str;
    }
}

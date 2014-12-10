package org.fix4j.test.properties;

import java.util.Map;

/**
 * User: ben
 * Date: 3/12/14
 * Time: 5:10 PM
 */
public class SystemEnvVariablePropertySource implements PropertySource {
    private final static String SOURCE_NAME = "ENVIRONMENT_VARIABLES";

    @Override
    public String getSourceName() {
        return SOURCE_NAME;
    }

    @Override
    public Map<String, String> getProperties() {
        return System.getenv();
    }
}

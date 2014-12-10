package org.fix4j.test.properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: ben
 * Date: 3/12/14
 * Time: 5:10 PM
 */
public class SystemPropertySource implements PropertySource {
    private final static String SOURCE_NAME = "SYSTEM_PROPERTIES";

    @Override
    public String getSourceName() {
        return SOURCE_NAME;
    }

    @Override
    public Map<String, String> getProperties() {
        Map<Object, Object> systemProperties = System.getProperties();
        Map<String, String> properties = new LinkedHashMap<>(systemProperties.size());
        for (final Object key : systemProperties.keySet()) {
            properties.put(key.toString(), systemProperties.get(key).toString());
        }
        return properties;
    }
}

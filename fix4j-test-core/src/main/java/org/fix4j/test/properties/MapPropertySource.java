package org.fix4j.test.properties;

import java.util.Collections;
import java.util.Map;

/**
 * User: ben
 * Date: 3/12/14
 * Time: 5:10 PM
 */
public class MapPropertySource implements PropertySource {
    private final Map<String, String> properties;
    private final String sourceName;

    public MapPropertySource(final Map<String, String> properties, final String sourceName) {
        this.properties = Collections.unmodifiableMap(properties);
        this.sourceName = sourceName;
    }

    @Override
    public String getSourceName() {
        return this.sourceName;
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }
}

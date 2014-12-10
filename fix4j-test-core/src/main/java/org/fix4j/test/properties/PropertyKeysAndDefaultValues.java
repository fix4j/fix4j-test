package org.fix4j.test.properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: ben
 * Date: 4/12/14
 * Time: 4:56 PM
 */
public enum PropertyKeysAndDefaultValues {
    DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS("2000"),
    POLL_PERIOD_MS("100"),
    SIZE_OF_RECENTLY_SENT_MESSAGES("5"),
    SIZE_OF_DISCARDED_MESSAGES("5"),
    DISPLAY_INCOMING_MESSAGE_FLAGS("true"),
    FAST_FAIL_ON_TRIGGER_OF_INCOMING_MESSAGE_FLAG("true"),
    FAST_FAIL_ON_TRIGGER_OF_OUTBOUND_MESSAGE_FLAG("true"),
    DEFAULT_MESSAGES_TO_IGNORE("35=0");

    private final String defaultValue;

    private PropertyKeysAndDefaultValues(final String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public static PropertySource getDefaultProperties(){
        final Map<String, String> properties = new LinkedHashMap<>(PropertyKeysAndDefaultValues.values().length);
        for (final PropertyKeysAndDefaultValues key : values()) {
            properties.put(key.name(), key.defaultValue);
        }
        return new MapPropertySource(properties, "DefaultValues");
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}

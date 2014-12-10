package org.fix4j.test.properties;

/**
 * User: ben
 * Date: 4/12/14
 * Time: 10:32 AM
 */
public interface ApplicationProperties {
    public String getAsString(final String key);
    public String getAsString(final String key, final String defaultValue);

    public Boolean getAsBoolean(final String key);
    public Boolean getAsBoolean(final String key, final Boolean defaultValue);

    public Integer getAsInt(final String key);
    public Integer getAsInt(final String key, final Integer defaultValue);

    public Double getAsDouble(final String key);
    public Double getAsDouble(final String key, final Double defaultValue);

    public Long getAsLong(final String key);
    public Long getAsLong(final String key, final Long defaultValue);
}

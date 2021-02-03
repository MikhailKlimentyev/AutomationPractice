package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyReader {

    private static String propertiesPath = "/config.properties";
    private static volatile Properties properties;
    private static InputStream inputStream;

    private PropertyReader() {
    }

    public static String getProperty(String envVariable, String propertyFromFile) {
        String value = System.getenv().get(envVariable);
        if (value == null) {
            return getProperty(propertyFromFile);
        }
        return value;
    }

    private static String getProperty(String propertyName) {
        return loadProperties().getProperty(propertyName);
    }

    private static Properties loadProperties() {
        return properties != null ? properties : readProperties();
    }

    private static Properties readProperties() {
        properties = new Properties();
        try {
            inputStream = PropertyReader.class.getResourceAsStream(getCorrectPath());
            if (inputStream != null)
                properties.load(inputStream);
        } catch (Exception ex) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (properties.getProperty("config_file") != null) {
            Properties additionalProperties = getProperties(properties.getProperty("config_file"));
            properties.putAll(additionalProperties);
        }
        return properties;
    }

    private static Properties getProperties(String path) {
        propertiesPath = path;
        return readProperties();
    }

    private static String getCorrectPath() {
        if (propertiesPath.charAt(0) != '/')
            propertiesPath = "/" + propertiesPath;
        return propertiesPath;
    }
}
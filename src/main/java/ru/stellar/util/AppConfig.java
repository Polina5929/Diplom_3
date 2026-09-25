package ru.stellar.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class AppConfig {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream input = AppConfig.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("Не найден config.properties в src/test/resources/");
            }
            PROPS.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка загрузки config.properties", e);
        }
    }

    private AppConfig() {
    }

    public static String get(String key) {
        return PROPS.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return PROPS.getProperty(key, defaultValue);
    }

    public static int getTimeoutSeconds() {
        return Integer.parseInt(PROPS.getProperty("timeout.seconds", "10"));
    }

    public static String getBaseUrl() {
        return PROPS.getProperty("base.url", "https://stellarburgers.education-services.ru");
    }
}
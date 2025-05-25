package com.demoblazce.demoblaze.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = PropertiesReader.class
                .getClassLoader()
                .getResourceAsStream("login.properties")) {

            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("No se encontró login.properties");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error cargando login.properties", ex);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

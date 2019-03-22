package com.cloud.properties;

import java.util.Properties;

import com.cloud.utils.PropertiesReader;

public class Environments {

    private static Environments instance;
    private static Properties environments;
    private static String propFileName = "environments.properties";

    private Environments() {
    }

    static Environments getInstance() {
        if (instance == null) {
            instance = new Environments();
            init();
        }
        return instance;
    }

    private static void init() {
        try {

            environments = PropertiesReader.readProperties(propFileName);
        } catch (Exception e) {
            System.out.println("Environments property file " + propFileName + "not found. Execution stopped!");
            System.exit(1);
        }
    }

    String getEnvironmentsProperty(String propertyName) {
        return environments.getProperty(propertyName);
    }
}

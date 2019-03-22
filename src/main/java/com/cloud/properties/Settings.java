package com.cloud.properties;

import java.util.Properties;

import com.cloud.utils.PropertiesReader;

public class Settings {
    private static Settings instance;
    private static Properties settings;
    private static String propFileName = "settings.properties";

    private Settings() {
    }

    static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
            init();
        }
        return instance;
    }
    
    private static void init() {
        try {
        	  
            settings = PropertiesReader.readProperties(propFileName);
        } catch (Exception e) {
            System.out.println("Settings property file " + propFileName + "not found. Execution stopped!");
            System.exit(1);
        }
    }

    String getSettingsParameter(String parameterName) {
        return settings.getProperty(parameterName);
    }

    int getTimeout() {
        return Integer.valueOf(settings.getProperty("wait"));
    }
    int getFindTimeout() {
        return Integer.valueOf(settings.getProperty("findWait"));
    }
    int getReactTimeout() {
        return Integer.valueOf(settings.getProperty("reactWait"));
    }
    int getVideo(){
    	return Integer.valueOf(settings.getProperty("videoenabled"));
    }
    int getEmail(){
    	return Integer.valueOf(settings.getProperty("videoenabled"));
    }

}

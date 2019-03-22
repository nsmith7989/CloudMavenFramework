package com.cloud.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.cloud.properties.Environments;

public class PropertiesReader {

    public static Properties readProperties(String propertiesFileName) throws IOException {
        Properties properties = new Properties();
        InputStream inStream = Environments.class.getClassLoader().getResourceAsStream(propertiesFileName);

        if (inStream == null) {
            throw new FileNotFoundException("Property file " + propertiesFileName + " not found in the classpath");
        }

        properties.load(inStream);
        inStream.close();

        return properties;
    }
}

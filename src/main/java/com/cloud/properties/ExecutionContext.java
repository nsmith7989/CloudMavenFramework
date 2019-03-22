package com.cloud.properties;

public class ExecutionContext {
    private static ExecutionContext instance;
    private Settings settings;
    private Environments environments;


    private ExecutionContext() {
        this.settings = Settings.getInstance();
        this.environments = Environments.getInstance();
      
    }

    public static synchronized ExecutionContext getInstance() {
        if (instance == null) {
            instance = new ExecutionContext();
        }
        return instance;
    }

    public String getSettingsParameter(String parameterName) {
        return settings.getSettingsParameter(parameterName);
    }

    public String getEnvironmentsProperty(String propertyName) {
        return environments.getEnvironmentsProperty(propertyName);
    }


    public int getTimeout() {
        return settings.getTimeout();
    }
    
    public int getFindTimeout() {
        return settings.getFindTimeout();
    }
    
    public int getReactTimeout() {
        return settings.getReactTimeout();
    }
    public int getVideo(){
    	return settings.getVideo();
    }
}

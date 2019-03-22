package com.cloud.exceptions;

public class TestException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8218940052034337917L;

	public TestException() {
    }
    
    public TestException(String message) {
        super(message);
    }
    
    public TestException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public TestException(Throwable cause) {
        super(cause);
    }     
}

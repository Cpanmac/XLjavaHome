package com.xl.util.persist.support;

/**
 * 
 * @author Majing
 * @version $Id: DataBaseAccessException.java 3044 2010-06-17 03:14:28Z majing $
 */
public class DataBaseAccessException extends RuntimeException {
	public DataBaseAccessException(String message) {
		super(message);
	}
	
	public DataBaseAccessException(String message, Throwable ex) {
		super(message, ex);
	}
}

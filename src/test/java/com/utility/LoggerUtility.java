package com.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {   //Global setup for logger
	
	
	private LoggerUtility() {  //private constructor as it is singleton design pattern
		
	}
	
	public static Logger getLogger(Class<?> clazz) {
		
		Logger logger =null;
		if(logger==null) {
		logger = LogManager.getLogger(clazz);
		}
		return logger;
	}

}

package com.automation.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Logger Utility Class
 */
public class LoggerUtil {

	public static Logger logger = Logger.getLogger(LoggerUtil.class.getName());
	public static String loggerInit = null;
	FileHandler fileHandle = null;

	/*
	 * Uses initialized logger to handle logs in .txt file under 'log' folder
	 * Name of .txt file is in format 'ddMMyy_HHmmss'
	 */
	public LoggerUtil() {
		if (loggerInit == null) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_hhmmss");
			
			String fileName = formatter.format(date).toString() + ".log";
			
			try {
				fileHandle = new FileHandler("./log/" + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			logger.addHandler(fileHandle);
			SimpleFormatter logformatter = new SimpleFormatter();
			fileHandle.setFormatter(logformatter);
		}
		loggerInit = "Logger Initialsed";
	}

	public Logger getLoggerInstance() {
		LoggerUtil loggerUtil = new LoggerUtil();
		return logger;
	}

}

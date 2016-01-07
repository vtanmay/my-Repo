package com.automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * LoadableComponents used to load application property file.  
 */
public class LoadableComponents {
	public static Properties properties = new Properties();
	
	public LoadableComponents() {
		String path = "./resources";
		loadFiles(path);
	}

	/*
	 * loadFiles: load property file within resources as well as from folders present inside resources.
	 */
	private static void loadFiles(String path) {
		File file = null;
		File[] storeAllFiles = null;
		file = new File(path);

		if(file.isDirectory()) {
			storeAllFiles = file.listFiles();
			for(File fileIterator : storeAllFiles) {
				loadFiles(fileIterator.getPath());
			}
		}else {
			try {
				properties.load(new FileInputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}

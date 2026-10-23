package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.ENV;

public class PropertiesUtil {
//read properties file
	public static String  readProperty(ENV env,String propetyName)  {
		
		//System.out.println(System.getProperty("user.dir"));
		
		File fileProperty = new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();

		try {
			fileReader = new FileReader(fileProperty);
			properties.load(fileReader);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = properties.getProperty(propetyName.toUpperCase(null));
		return value;
		
	}

}

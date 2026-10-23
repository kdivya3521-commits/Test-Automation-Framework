package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.ENV;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.EnvironmentUrl;

public class JSONUtility {

	public static EnvironmentUrl readJSON(ENV env) {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + "/config/config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		EnvironmentUrl environment = config.getEnvironments().get(env.name());
		return environment;
	}

}

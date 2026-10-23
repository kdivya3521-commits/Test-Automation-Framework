package com.ui.pojo;

import java.util.Map;

public class Config {
	
	Map<String, EnvironmentUrl> environments;

	public Map<String, EnvironmentUrl> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, EnvironmentUrl> environments) {
		this.environments = environments;
	}
		
}

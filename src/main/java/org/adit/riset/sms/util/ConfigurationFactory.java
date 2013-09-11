package org.adit.riset.sms.util;

import org.apache.log4j.Logger;

public class ConfigurationFactory {
	private static Configuration config;

	static Logger log = Logger.getLogger(ConfigurationFactory.class);
	
	public static Configuration getInstance() {
		
		if (config == null) {
			log.info("Create new config instance");
			config = new Configuration();
		}
	
		return config;
	}
}

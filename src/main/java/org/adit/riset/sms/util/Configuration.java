package org.adit.riset.sms.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Configuration {
	Properties prop = new Properties();
	
	public static final String CONFIG_MODEM_ID= "config.modem.id";
	public static final String CONFIG_MODEM_PORT = "config.modem.port";
	public static final String CONFIG_MODEM_BAUD_RATE = "config.modem.baudrate";
	public static final String CONFIG_MODEM_MANUFACTURE = "config.modem.manufacture";
	public static final String CONFIG_MODEM_TYPE = "config.modem.type";
	public static final String CONFIG_MODEM_SMSC = "config.modem.smsc";
	
	public String MODEM_ID;
	public String MODEM_PORT;
	public Integer BAUD_RATE;
	public String MODEM_MANUFACTURE;
	public String MODEM_TYPE;
	public String SMSC;
	
	Logger log = Logger.getLogger(Configuration.class);
	
	public Configuration() {
		// TODO Auto-generated constructor stub
		try {
            //load a properties file from class path, inside static method
			log.info("Loading configuration :");
			prop.load(Configuration.class.getClassLoader().getResourceAsStream("configuration.properties"));
			MODEM_ID = prop.getProperty(CONFIG_MODEM_ID);
			MODEM_PORT = prop.getProperty(CONFIG_MODEM_PORT);
			BAUD_RATE = Integer.parseInt(prop.getProperty(CONFIG_MODEM_BAUD_RATE));
			MODEM_MANUFACTURE = prop.getProperty(CONFIG_MODEM_MANUFACTURE);
			SMSC = prop.getProperty(CONFIG_MODEM_SMSC);
			MODEM_TYPE = prop.getProperty(CONFIG_MODEM_TYPE);
			
			log.info(MODEM_ID+":"+MODEM_PORT+":"+BAUD_RATE+":"+MODEM_MANUFACTURE+":"+MODEM_TYPE);
			
		} catch (IOException ex) {
			log.error("Unable to load configuration file : "+ex.getLocalizedMessage());
			ex.printStackTrace();
		}
	}
	
	public void setBaudRate(Integer baudRate) {
		BAUD_RATE = baudRate;
	}
	
	public void setModemId(String modemId) {
		MODEM_ID = modemId;
	}
	public void setModemManufacture(String modemManufacture) {
		MODEM_MANUFACTURE = modemManufacture;
	}
	public void setModemPort(String modemPort) {
		MODEM_PORT = modemPort;
	}
	public void setModemType(String modemType) {
		MODEM_TYPE = modemType;
	}
	public void setSMSC(String smsc) {
		SMSC = smsc;
	}
	
}

package org.adit.riset.sms.util;

import org.apache.log4j.Logger;
import org.smslib.modem.SerialModemGateway;

public class SMSModem {
	Logger log = Logger.getLogger(SMSModem.class);
	
	private SerialModemGateway gateway;
	private String modemId;
	private String port;
	private Integer baudRate;
	private String manufacture;
	private String model;
	private String smsc;
	
	public SMSModem(String modemId, String port, Integer baudRate, String manufacture, String model, String smsc){
		this.baudRate = baudRate;
		this.modemId = modemId;
		this.port = port;
		this.manufacture = manufacture;
		this.model = model;
		this.smsc = smsc;
	}
	
	public void initializeModem(){
		log.info("Try to initialize SMS Modem ");
		log.info("SMS Modem id :"+modemId+", port : "+port+", baud rate : "+baudRate+", manufacture : "+manufacture+", model : "+model+", smsc"+smsc);
		gateway = new SerialModemGateway(modemId, port, baudRate, manufacture, model);	
		gateway.setSmscNumber(smsc);
		gateway.setInbound(true);
		gateway.setOutbound(true);
		
	}
	
	public SerialModemGateway getSMSModem(){
		return gateway;
	}
	
}

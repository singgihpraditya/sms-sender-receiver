package org.adit.riset.sms.service;


import java.util.ArrayList;
import java.util.List;

import org.adit.riset.sms.util.Configuration;
import org.adit.riset.sms.util.ConfigurationFactory;
import org.adit.riset.sms.util.SMSModem;
import org.adit.riset.sms.util.ServiceFactory;
import org.apache.log4j.Logger;
import org.smslib.InboundMessage;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.Service.ServiceStatus;
import org.smslib.modem.SerialModemGateway;

public class SMSService {
	private Service service;
	private Configuration config;
	
	Logger log = Logger.getLogger(SMSService.class);
	
	public void startService(){
		service = ServiceFactory.getServiceInstance();
		config = ConfigurationFactory.getInstance();
		if(service != null){
			try{
			
				SMSModem modem = new SMSModem(config.MODEM_ID, config.MODEM_PORT, config.BAUD_RATE, config.MODEM_MANUFACTURE, config.MODEM_TYPE, config.SMSC);
				modem.initializeModem();
				SerialModemGateway gateway = modem.getSMSModem();
				service.addGateway(gateway);
				service.startService();
				log.info("Starting service.. : ");
				log.info("Modem Information:");
				log.info("-Manufacturer: " + gateway.getManufacturer());
				log.info("-Model: " + gateway.getModel());
				log.info("-Serial No: " + gateway.getSerialNo());
				log.info("-SIM IMSI: " + gateway.getImsi());
				log.info("-Signal Level: " + gateway.getSignalLevel()+ " dBm");
				log.info("Service started.. : ");
				
			}
			catch(Exception ex){
				log.error("Failed to start sms service : "+ex.getMessage());
			}
		}
		else{
			log.error("Failed to load sms service");
		}
	}
	
	public void stopService(){
		service = ServiceFactory.getServiceInstance();
		if(service != null){
			try{
				log.info("Stop service.. : ");
				service.stopService();
				log.info("Service stopped.. : ");
			}
			catch(Exception ex){
				log.error("Failed to stop sms service : "+ex.getMessage());
			}
			
		}	
		else{
			log.error("Failed to load sms service");
		}
	}
	
	public boolean sendMessage(String receiver, String message){
		log.info("Trying sending message");
		log.info("-to : "+receiver);
		log.info("-message : "+message);
		
		if(service.getServiceStatus() == ServiceStatus.STARTED){
			try{
				OutboundMessage outboundMessage = new OutboundMessage(receiver,message);
				service = ServiceFactory.getServiceInstance();
				service.queueMessage(outboundMessage);
				log.info("Success sending message");
				log.info("-to : "+receiver);
				log.info("-message : "+message);
				
			}
			catch(Exception ex){
				log.error("Failed to send sms  : "+ex.getMessage());
			}
			
			return true;
		}
		else{
			log.error("Failed to send sms, service not started");
			return false;
		}
	}
	
	private List<InboundMessage> retrieveInboundMessages(MessageClasses messageClasses){
//		log.info("Trying retrieve message");
		
		List<InboundMessage> msgList = new ArrayList<InboundMessage>();
	       
		if(service !=null && service.getServiceStatus() == ServiceStatus.STARTED){
			try{
				service.readMessages(msgList, messageClasses);
				log.info("Success reading message");
				log.info("message size : "+msgList.size());
				
			}
			catch(Exception ex){
				log.error("Failed to retrive sms  : "+ex.getMessage());
			}
			
			return msgList;
		}
		else{
			log.error("Failed to send sms, service not started");
			return msgList;
		}
	}
	
	public List<InboundMessage> retrieveUnreadInboundMessages(){
		log.info("Trying retrieve unread messages");
		return retrieveInboundMessages(MessageClasses.UNREAD);
	}
	
	
	public List<InboundMessage> retrieveReadInboundMessages(){
		log.info("Trying retrieve have read messages");
		return retrieveInboundMessages(MessageClasses.READ);
	}
		
	public List<InboundMessage> retrieveAllInboundMessages(){
		log.info("Trying retrieve all messages");
		return retrieveInboundMessages(MessageClasses.ALL);
	}
	
}

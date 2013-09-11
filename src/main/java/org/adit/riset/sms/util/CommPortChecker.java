package org.adit.riset.sms.util;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

import org.apache.log4j.Logger;

public class CommPortChecker {
	Logger log = Logger.getLogger(CommPortChecker.class);
	
	public void showActiveCommPort(){
		 Enumeration ports = CommPortIdentifier.getPortIdentifiers();
		 if(ports.hasMoreElements()){
	    	 log.info("Found active port ");
			 while(ports.hasMoreElements()){
	    		CommPortIdentifier port  = (CommPortIdentifier) ports.nextElement();
	    		log.info("\t"+port.getName()+" "+port.getPortType());
	    	 }
		 }
		 else{
			 log.info("No active port found ");
			 
		 }
	}
}

package org.adit.riset.sms.notification;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.ICallNotification;

public class CallNotification implements ICallNotification {
	Logger log = Logger.getLogger(CallNotification.class);
	
	public void process(AGateway gateway, String callerId) {
		log.info("New call detected from Gateway: "+ gateway.getGatewayId() + " : " + callerId);
	}
}
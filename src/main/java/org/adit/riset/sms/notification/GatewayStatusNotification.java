package org.adit.riset.sms.notification;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.IGatewayStatusNotification;
import org.smslib.AGateway.GatewayStatuses;

public class GatewayStatusNotification implements IGatewayStatusNotification {
	Logger log = Logger.getLogger(GatewayStatusNotification.class);
	
	public void process(AGateway gateway, GatewayStatuses oldStatus, GatewayStatuses newStatus) {
		log.info("Gateway Status change for " + gateway.getGatewayId()+ ", OLD: " + oldStatus + " -> NEW: " + newStatus);
	}
}

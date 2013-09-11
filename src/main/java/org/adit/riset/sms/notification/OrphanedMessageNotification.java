package org.adit.riset.sms.notification;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.IOrphanedMessageNotification;
import org.smslib.InboundMessage;

public class OrphanedMessageNotification implements IOrphanedMessageNotification {
	Logger log = Logger.getLogger(OrphanedMessageNotification.class);
	
	public boolean process(AGateway gateway, InboundMessage msg) {
		log.info("Orphaned message part detected from " + gateway.getGatewayId());
		log.info("Orphaned message : "+msg);
		// Since we are just testing, return FALSE and keep the orphaned message
		return false;
	}
}
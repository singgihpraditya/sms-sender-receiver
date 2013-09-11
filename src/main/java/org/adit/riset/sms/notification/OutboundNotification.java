package org.adit.riset.sms.notification;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;

public class OutboundNotification implements IOutboundMessageNotification {
	Logger log = Logger.getLogger(OutboundNotification.class); 
	public void process(AGateway gateway, OutboundMessage msg) {
		log.info("Outbound handler called from Gateway: "+ gateway.getGatewayId());
		log.info("Outbound message : "+msg);
	}
}
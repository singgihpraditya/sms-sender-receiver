package org.adit.riset.sms.util;

import org.adit.riset.sms.notification.CallNotification;
import org.adit.riset.sms.notification.GatewayStatusNotification;
import org.adit.riset.sms.notification.InboundNotification;
import org.adit.riset.sms.notification.OrphanedMessageNotification;
import org.adit.riset.sms.notification.OutboundNotification;
import org.apache.log4j.Logger;
import org.smslib.Service;

public class ServiceFactory {
	private static Service service;

	static Logger log = Logger.getLogger(ServiceFactory.class);
	
	public static Service getServiceInstance() {
		// TODO Auto-generated constructor stub
		if (service == null) {
			log.info("Create new service instance");
			service = Service.getInstance();
			service.setInboundMessageNotification(new InboundNotification());
			service.setOutboundMessageNotification(new OutboundNotification());
			service.setCallNotification(new CallNotification());
			service.setGatewayStatusNotification(new GatewayStatusNotification());
			service.setOrphanedMessageNotification(new OrphanedMessageNotification());
		
		}
		return service;
	}
}

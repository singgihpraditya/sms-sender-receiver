package org.adit.riset.sms.test;


import org.adit.riset.sms.service.SMSService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RetrieveSMSTest {
	private SMSService service;
	
	@Before
	public void initiateSMSService(){
		service = new SMSService();
		service.startService();
	}
	
	@Test
	public void testRetriveAllSMS(){
		service.retrieveAllInboundMessages();
	}
	
//	@Test
	public void testRetriveReadSMS(){
		service.retrieveReadInboundMessages();
	}
	
//	@Test
	public void testRetriveUnreadSMS(){
		service.retrieveUnreadInboundMessages();
	}
	
	
	@After
	public void shutdownSMSService(){
		service.stopService();
	}
}

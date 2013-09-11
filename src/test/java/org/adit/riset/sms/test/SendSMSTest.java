package org.adit.riset.sms.test;

import org.adit.riset.sms.service.SMSService;
import org.junit.Test;

public class SendSMSTest {

	@Test
	public void testSendSMS() {
		SMSService service = new SMSService();
		service.startService();
		service.sendMessage("+6282112405208", "Test");
//		service.stopService();
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
		}
		finally{
			service.stopService();
			
		}
	}

}

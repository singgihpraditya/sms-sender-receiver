package org.adit.riset.sms.test;

import static org.junit.Assert.*;

import org.adit.riset.sms.util.CommPortChecker;
import org.junit.Test;

public class ActivePortTest {

	@Test
	public void testActivePort() {
		CommPortChecker portChecker = new CommPortChecker();
		portChecker.showActiveCommPort();
	}

}

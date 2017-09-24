package com.radoslav.integration.tests.authentication;

import com.radoslav.integration.tests.attributes.RequestAttributes;

public class S2SAuthentication implements Authentication {

	public void configure(RequestAttributes attributes) {
		// change request URL of attributes to the forwarding proxy
	}

}

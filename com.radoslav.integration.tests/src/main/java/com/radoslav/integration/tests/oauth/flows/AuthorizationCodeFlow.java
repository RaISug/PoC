package com.radoslav.integration.tests.oauth.flows;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.oauth.code.AuthorizationCode;

public class AuthorizationCodeFlow implements Flow {

	private final AuthorizationCode code;
	
	public AuthorizationCodeFlow() {
		this(new AuthorizationCode());	
	}
	
	public AuthorizationCodeFlow(AuthorizationCode code) {
		this.code = code;
	}

	public boolean notSupportRenewal() {
		return false;
	}
	
	public void configure(RequestAttributes attributes) throws Exception {
		code.create();

		attributes.setQueryParam("grant_type", "authorization_code");
		attributes.setQueryParam("code", code.value());
	}

	@Override
	public String toString() {
		return "Authorization Code Grant";
	}
	
}
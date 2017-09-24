package com.radoslav.integration.tests.oauth.clients;

import org.apache.commons.codec.binary.Base64;

public class ConfidentialClient extends Client {

	@Override
	public String id() {
		return "confidential-client-id";
	}

	@Override
	public String secret() {
		return System.getProperty("clientSecret");
	}

	@Override
	public boolean isConfidential() {
		return true;
	}

	@Override
	public String authorizationHeader() {
		String credentials = id() + ":" + secret();

		return new String(Base64.encodeBase64(credentials.getBytes()));
	}

	@Override
	public void configure(ClientPayload payload) {
		payload.setSecret(secret());
	}

	@Override
	public String toString() {
		return "Confidential Client";
	}

}
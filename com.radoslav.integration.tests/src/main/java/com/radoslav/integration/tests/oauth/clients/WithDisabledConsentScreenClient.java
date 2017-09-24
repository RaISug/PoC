package com.radoslav.integration.tests.oauth.clients;

public class WithDisabledConsentScreenClient extends Client {

	@Override
	public String id() {
		return "client-with-disabled-consent-screen-id";
	}

	@Override
	public String secret() {
		throw new RuntimeException("Clients with disabled consent screen doesn't have secrets.");
	}

	@Override
	public boolean isConfidential() {
		return false;
	}

	@Override
	public String authorizationHeader() {
		throw new RuntimeException("Authorization header is not supported in clients with disabled consent screen.");
	}

	@Override
	public void configure(ClientPayload payload) {
		payload.disableConsentScreen();
	}

}

package com.radoslav.integration.tests.oauth.clients;

public class SAMLBearerClient extends ConfidentialClient {

	@Override
	public String id() {
		return "saml-bearer-client-id";
	}

	@Override
	public String toString() {
		return "SAML Bearer Client";
	}

}

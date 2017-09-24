package com.radoslav.integration.tests.oauth.flows;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.oauth.clients.Client;
import com.radoslav.integration.tests.oauth.clients.ConfidentialClient;

public class SAMLBearerFlow implements Flow {

	private final Client client;

	public SAMLBearerFlow() {
		this(new ConfidentialClient());
	}

	public SAMLBearerFlow(Client client) {
		this.client = client;
	}

	public boolean notSupportRenewal() {
		return true;
	}

	public void configure(RequestAttributes attributes) throws Exception {
		client.create();

		attributes.setHeader("Authorization", "Basic " + client.authorizationHeader());
		attributes.setQueryParam("grant_type", "urn:ietf:params:oauth:grant-type:saml2-bearer");
	}

	@Override
	public String toString() {
		return "OAuth SAML2 Bearer";
	}

}

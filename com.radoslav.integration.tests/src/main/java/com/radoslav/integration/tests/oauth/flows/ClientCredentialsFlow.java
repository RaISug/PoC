package com.radoslav.integration.tests.oauth.flows;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.oauth.clients.Client;
import com.radoslav.integration.tests.oauth.clients.ConfidentialClient;

public class ClientCredentialsFlow implements Flow {
	
	private final Client client;
	
	public ClientCredentialsFlow() {
		this(new ConfidentialClient());	
	}

	public ClientCredentialsFlow(Client client) {
		this.client = client;
	}

	public boolean notSupportRenewal() {
		return true;
	}

	public void configure(RequestAttributes attributes) throws Exception {
		client.create();

		attributes.setQueryParam("grant_type", "client_credentials");
		attributes.setHeader("Authorization", "Basic " + client.authorizationHeader());
	}

	@Override
	public String toString() {
		return "Client Credentials";
	}
	
}
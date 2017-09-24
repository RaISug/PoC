package com.radoslav.integration.tests.oauth.code;

import java.util.Arrays;
import java.util.List;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.executors.HttpExecutor;
import com.radoslav.integration.tests.oauth.clients.Client;
import com.radoslav.integration.tests.oauth.clients.PublicClient;

public class DefaultMode implements Mode {

	private final Client client;

	public DefaultMode() {
		this(new PublicClient());
	}

	public DefaultMode(Client client) {
		this.client = client;
	}

	public List<HttpExecutor> createExecutors() {
		client.create();

		RequestAttributes codeAttributes = createAuthorizationCodeAttributes();

		if (client.isConfidential()) {
			codeAttributes.setHeader("Authorization", client.authorizationHeader());
		}

		RequestAttributes authorizeAttributes = createAuthorizeAttributes();

		return Arrays.asList(new HttpExecutor(codeAttributes), new HttpExecutor(authorizeAttributes));
	}

	private RequestAttributes createAuthorizationCodeAttributes() {
		return null;
	}

	private RequestAttributes createAuthorizeAttributes() {
		return null;
	}

}

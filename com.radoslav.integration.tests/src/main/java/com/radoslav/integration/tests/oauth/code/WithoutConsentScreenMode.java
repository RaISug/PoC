package com.radoslav.integration.tests.oauth.code;

import java.util.List;

import com.radoslav.integration.tests.executors.HttpExecutor;
import com.radoslav.integration.tests.oauth.clients.Client;
import com.radoslav.integration.tests.oauth.clients.WithDisabledConsentScreenClient;

public class WithoutConsentScreenMode implements Mode {

	private final Client client;

	public WithoutConsentScreenMode() {
		this(new WithDisabledConsentScreenClient());
	}

	public WithoutConsentScreenMode(Client client) {
		this.client = client;
	}

	public List<HttpExecutor> createExecutors() {
		//TODO:
		// use ExecutorBuilder to create the following executors:
		// call authorize endpoint
		
		return null;
	}

}

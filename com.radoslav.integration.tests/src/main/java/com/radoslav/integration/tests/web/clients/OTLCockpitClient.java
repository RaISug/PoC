package com.radoslav.integration.tests.web.clients;

import com.gargoylesoftware.htmlunit.WebClient;

public class OTLCockpitClient {

	private static WebClient client;

	public WebClient get() {
		if (client == null) {
//			client = new AutoLoginSAMLWebClient();
		}

		return client;
	}

}
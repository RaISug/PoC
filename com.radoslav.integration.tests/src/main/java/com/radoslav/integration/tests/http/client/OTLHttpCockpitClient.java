package com.radoslav.integration.tests.http.client;

import org.apache.http.client.HttpClient;

public class OTLHttpCockpitClient {

	private static HttpClient client;

	public HttpClient get() {
		if (client == null) {
			//TODO: create client using logged in http client using login util
		}

		return client;
	}
}

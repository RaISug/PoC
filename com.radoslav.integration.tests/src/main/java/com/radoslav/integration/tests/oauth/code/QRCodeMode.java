package com.radoslav.integration.tests.oauth.code;

import java.util.List;

import com.radoslav.integration.tests.executors.HttpExecutor;
import com.radoslav.integration.tests.oauth.clients.Client;
import com.radoslav.integration.tests.oauth.clients.PublicClient;

public class QRCodeMode implements Mode {

	private Client client;

	public QRCodeMode() {
		this(new PublicClient());
	}

	public QRCodeMode(Client client) {
		this.client = client;
	}

	public List<HttpExecutor> createExecutors() {
		//TODO:
		// use ExecutorBuilder to create the following executors:
		// login to End User UI
		// create authorization code through QR code generation endpoint
		
		return null;
	}

}

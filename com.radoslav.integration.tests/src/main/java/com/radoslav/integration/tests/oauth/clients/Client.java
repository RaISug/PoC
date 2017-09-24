package com.radoslav.integration.tests.oauth.clients;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.radoslav.integration.tests.Subscription;
import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.executors.HttpExecutor;

import net.sourceforge.htmlunit.corejs.javascript.ast.Scope;

public abstract class Client {

	private Subscription subscription;

	public Client() {
		this(new Subscription());
	}

	public Client(Subscription subscription) {
		this.subscription = subscription;
	}

	public abstract String id();

	public abstract String secret();

	public abstract boolean isConfidential();

	public abstract String authorizationHeader();

	public abstract void configure(ClientPayload payload);

	public void create() {
		RequestAttributes attributes = createCreationAttributes();

		HttpResponse response = new HttpExecutor(attributes).execute();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED) {
			throw new RuntimeException("Failed to create public client: " + toString());
		}
	}

	private RequestAttributes createCreationAttributes() {
		return null;
	}

	private ClientPayload createPayload() {
		return null;
	}

	public void delete() {
		RequestAttributes attributes = createDeletionAttributes();

		HttpResponse response = new HttpExecutor(attributes).execute();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
			throw new RuntimeException("Failed to delete public client: " + toString());
		}
	}

	private RequestAttributes createDeletionAttributes() {
		return null;
	}

	class ClientPayload {

		private String secret;
		private boolean disableConsentScreen;

		public void setSecret(String secret) {
			this.secret = secret;
		}

		public String getSecret() {
			return secret;
		}

		public boolean isConsentScreenDisabled() {
			return disableConsentScreen;
		}

		public void disableConsentScreen() {
			this.disableConsentScreen = true;
		}

	}
}
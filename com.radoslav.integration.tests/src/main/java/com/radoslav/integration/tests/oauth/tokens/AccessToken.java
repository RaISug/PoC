package com.radoslav.integration.tests.oauth.tokens;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.attributes.RequestAttributesBuilder;
import com.radoslav.integration.tests.executors.HttpExecutor;
import com.radoslav.integration.tests.oauth.flows.AuthorizationCodeFlow;
import com.radoslav.integration.tests.oauth.flows.Flow;

public class AccessToken {

	private final Flow flow;

	private Entity entity;

	public AccessToken() {
		this(new AuthorizationCodeFlow());
	}

	public AccessToken(Flow flow) {
		this.flow = flow;
	}

	public String value() {
		return entity.getAccessToken();
	}

	public List<String> scopes() {
		return entity.getScopes();
	}

	public void generate() throws Exception {
		RequestAttributes attributes = createGenerationAttributes();

		flow.configure(attributes);

		HttpResponse response = new HttpExecutor(attributes).execute();

		entity = toEntity(response);
	}

	private Entity toEntity(HttpResponse response) throws Exception {
		String responseBody = EntityUtils.toString(response.getEntity());

		return new Gson().fromJson(responseBody, Entity.class);
	}

	public void delete() {
		RequestAttributes attributes = createDeletionAttributes();

		HttpResponse response = new HttpExecutor(attributes).execute();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
			throw new RuntimeException("Failed to delete OAuth token: " + entity);
		}
	}

	private RequestAttributes createDeletionAttributes() {
		return null;
	}

	public void renew() throws Exception {
		if (flow.notSupportRenewal()) {
			throw new RuntimeException("Renew of OAuth token is not supported with " + flow.toString() + " flow");
		}

		RequestAttributes attributes = createRenewalAttributes();

		HttpResponse response = new HttpExecutor(attributes).execute();

		entity = toEntity(response);
	}
	
	private RequestAttributes createRenewalAttributes() {
		if (entity.getRefreshToken() == null) {
			throw new RuntimeException("Refresh token was not generated.");
		}

		return null;
	}

	private RequestAttributes createGenerationAttributes() {
		return new RequestAttributesBuilder()
					.setPath("")
					.build();
	}

	private class Entity {

		private String accessToken;
		private String refreshToken;
		private List<String> scopes;

		public String getAccessToken() {
			return accessToken;
		}

		public String getRefreshToken() {
			return refreshToken;
		}

		public List<String> getScopes() {
			return scopes;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();

			builder.append("Access token: ");
			builder.append(accessToken);
			builder.append("; Refresh token: ");
			builder.append(refreshToken);
			builder.append("; Scopes: ");
			builder.append(scopes);

			return builder.toString();
		}
	}
}
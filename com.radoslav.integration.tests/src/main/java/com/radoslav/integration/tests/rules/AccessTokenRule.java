package com.radoslav.integration.tests.rules;

import org.junit.rules.ExternalResource;

import com.radoslav.integration.tests.oauth.tokens.AccessToken;

public class AccessTokenRule extends ExternalResource {

	private AccessToken token;

	public AccessTokenRule() {
		this(new AccessToken());
	}

	public AccessTokenRule(AccessToken token) {
		this.token = token;
	}

	@Override
	protected void before() throws Throwable {
		token.generate();
	}

	public AccessToken getToken() {
		return token;
	}

	@Override
	protected void after() {
		token.delete();
	}
}

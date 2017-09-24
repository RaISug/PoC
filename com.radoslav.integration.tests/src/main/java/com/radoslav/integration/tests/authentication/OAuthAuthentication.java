package com.radoslav.integration.tests.authentication;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.oauth.tokens.AccessToken;

public class OAuthAuthentication implements Authentication {

	private final AccessToken token;

	public OAuthAuthentication() {
		this(new AccessToken());
	}

	public OAuthAuthentication(AccessToken token) {
		this.token = token;
	}

	public void configure(RequestAttributes attributes) {
		attributes.setHeader("Authorization", token.value());
	}

}
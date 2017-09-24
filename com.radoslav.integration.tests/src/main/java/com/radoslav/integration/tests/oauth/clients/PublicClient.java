package com.radoslav.integration.tests.oauth.clients;

public class PublicClient extends Client {

	@Override
	public String id() {
		return "public-client-id";
	}

	@Override
	public String secret() {
		throw new RuntimeException("Public clients doesn't have secrets.");
	}

	@Override
	public boolean isConfidential() {
		return false;
	}

	@Override
	public String authorizationHeader() {
		throw new RuntimeException("Authorization header is not supported in public clients.");
	}
	
	@Override
	public void configure(ClientPayload payload) {
		//TODO: nothing to do
	}

	@Override
	public String toString() {
		return "Public Client";
	}

}
package com.radoslav.integration.tests.authz.roles;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.attributes.RequestAttributesBuilder;
import com.radoslav.integration.tests.authentication.Authentication;
import com.radoslav.integration.tests.authentication.S2SAuthentication;

public class ApplicationRole extends Role {

	private static final String AUTHORIZATION_API_PATH = "";

	private final String name;

	public ApplicationRole(String name) {
		this(name, new S2SAuthentication());
	}

	public ApplicationRole(String name, Authentication authentication) {
		super(authentication);

		this.name = name;
	}

	protected RequestAttributes createCreationAttributes() {
		return new RequestAttributesBuilder()
			.setPath(AUTHORIZATION_API_PATH)
			.useGETRequest()
			.build();
	}
	
	protected RequestAttributes createDeleteAttributes() {
		return new RequestAttributesBuilder()
			.setPath(AUTHORIZATION_API_PATH)
			.useGETRequest()
			.build();
	}
	
	protected RequestAttributes createFetchAttributes() {
		return new RequestAttributesBuilder()
			.setPath(AUTHORIZATION_API_PATH)
			.useGETRequest()
			.build();
	}

	@Override
	public String toString() {
		return name;	
	}

}
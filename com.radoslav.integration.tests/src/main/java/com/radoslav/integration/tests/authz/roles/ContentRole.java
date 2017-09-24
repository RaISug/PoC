package com.radoslav.integration.tests.authz.roles;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.authentication.Authentication;
import com.radoslav.integration.tests.authentication.S2SAuthentication;

public class ContentRole extends Role {

	private String name;

	public ContentRole(String name) {
		this(name, new S2SAuthentication());
	}

	public ContentRole(String name, Authentication authentication) {
		super(authentication);
		
		this.name = name;
	}

	@Override
	protected RequestAttributes createCreationAttributes() {
		return null;
	}

	@Override
	protected RequestAttributes createDeleteAttributes() {
		return null;
	}

	@Override
	protected RequestAttributes createFetchAttributes() {
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}

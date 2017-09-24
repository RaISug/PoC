package com.radoslav.integration.tests.authz.roles;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.radoslav.integration.tests.attributes.RequestAttributes;
import com.radoslav.integration.tests.authentication.Authentication;
import com.radoslav.integration.tests.executors.HttpExecutor;

public abstract class Role {

	private final Authentication authentication;

	public Role(Authentication authentication) {
		this.authentication =  authentication;
	}

	public void create() {
		RequestAttributes attributes = createCreationAttributes();

		authentication.configure(attributes);

		HttpResponse response = new HttpExecutor(attributes).execute();
	
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new RuntimeException("Failed to create role: " + toString() + " using " + authentication.toString());	
		}
	}
	
	protected abstract RequestAttributes createCreationAttributes();
	
	public void delete() {
		RequestAttributes attributes = createDeleteAttributes();

		authentication.configure(attributes);

		HttpResponse response = new HttpExecutor(attributes).execute();

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
			throw new RuntimeException("Failed to delete role: " + toString() + " using " + authentication.toString());	
		}
	}
	
	protected abstract RequestAttributes createDeleteAttributes();
	
	public Entity fetch() {
		RequestAttributes attributes = createFetchAttributes();

		authentication.configure(attributes);

		HttpResponse response = new HttpExecutor(attributes).execute();

		return convertToRoleEntity(response);
	}
	
	protected abstract RequestAttributes createFetchAttributes();

	private Entity convertToRoleEntity(HttpResponse response) {
		return null;
	}

	public static class Entity {
		
		private String name;
		
		public String name() {
			return name;
		}
		
	}

}

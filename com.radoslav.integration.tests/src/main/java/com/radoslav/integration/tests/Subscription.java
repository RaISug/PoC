package com.radoslav.integration.tests;

public class Subscription {

	private Application application;
	private Tenant tenant;

	public Subscription() {
		this(new Application(), new Tenant());
	}

	public Subscription(Application application, Tenant tenant) {
		this.application = application;
		this.tenant = tenant;
	}
	
}

package com.radoslav.integration.tests.oauth.flows;

import com.radoslav.integration.tests.attributes.RequestAttributes;

public interface Flow {

	public boolean notSupportRenewal();

	public void configure(RequestAttributes attributes) throws Exception;
	
}
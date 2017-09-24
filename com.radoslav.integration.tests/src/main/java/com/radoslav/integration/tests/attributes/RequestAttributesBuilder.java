package com.radoslav.integration.tests.attributes;

public class RequestAttributesBuilder {

	public RequestAttributesBuilder() {
		
	}

	public RequestAttributesBuilder setPath(String path) {
		
		return this;
	}

	public RequestAttributesBuilder useGETRequest() {
		
		return this;
	}

	public RequestAttributes build() {
		return new RequestAttributes();
	}
}

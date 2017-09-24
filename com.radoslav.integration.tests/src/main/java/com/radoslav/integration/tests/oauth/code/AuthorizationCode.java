package com.radoslav.integration.tests.oauth.code;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.radoslav.integration.tests.executors.ChainableExecutor;
import com.radoslav.integration.tests.executors.HttpExecutor;

public class AuthorizationCode {

	private final Mode mode;

	private String code;

	public AuthorizationCode() {
		this(new DefaultMode());
	}

	public AuthorizationCode(Mode mode) {
		this.mode = mode;
	}

	public String value() {
		return code;
	}

	public void create() throws Exception {
		List<HttpExecutor> executors = mode.createExecutors();

		HttpResponse response = new ChainableExecutor<HttpResponse>(executors).execute();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED) {
			throw new RuntimeException("Failed to create authorization code.");
		}

		code = extractCode(response);
	}

	private String extractCode(HttpResponse response) throws Exception {
		Header[] headers = response.getHeaders("Location");
		if (headers == null || headers.length == 0) {
			throw new RuntimeException("Location header was not returned on authorization code creation.");
		}

		String location = headers[0].getValue();

		return location.substring(location.indexOf("code=") + "code=".length());
	}

}

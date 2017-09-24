package com.radoslav.integration.tests.oauth.code;

import java.util.List;

import com.radoslav.integration.tests.executors.HttpExecutor;

public interface Mode {

	public List<HttpExecutor> createExecutors();

}

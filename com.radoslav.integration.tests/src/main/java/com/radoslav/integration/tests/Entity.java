package com.radoslav.integration.tests;

import java.util.List;

import com.radoslav.integration.tests.executors.Executor;

public interface Entity<T> {

	public List<Executor<T>> createExecutors();

}

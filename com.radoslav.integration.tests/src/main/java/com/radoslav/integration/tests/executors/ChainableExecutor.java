package com.radoslav.integration.tests.executors;

import java.util.List;

public class ChainableExecutor<T> implements Executor<T> {

	private List<? extends Executor<T>> executors;

	public ChainableExecutor(List<? extends Executor<T>> executors) {
		this.executors = executors;
	}

	public T execute() {
		T response = null;

		for (Executor<T> executor : executors) {
			response = executor.execute();
		}

		return response;
	}

}

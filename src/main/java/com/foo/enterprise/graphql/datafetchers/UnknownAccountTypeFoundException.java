package com.foo.enterprise.graphql.datafetchers;

public class UnknownAccountTypeFoundException extends RuntimeException {

	public UnknownAccountTypeFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

	private static final long serialVersionUID = 1L;

}

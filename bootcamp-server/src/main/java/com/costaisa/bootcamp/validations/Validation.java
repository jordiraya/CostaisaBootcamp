package com.costaisa.bootcamp.validations;

import java.util.function.Supplier;

public interface Validation {

	boolean matches();
	
	default void requiredMatching() throws Exception {
		if (!this.matches()) {
			throw this.exception().get();
		}
	}
	
	default Supplier<? extends Exception> exception() {
		return () -> new Exception();
	}
}

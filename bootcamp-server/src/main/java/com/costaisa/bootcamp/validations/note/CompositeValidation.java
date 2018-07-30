package com.costaisa.bootcamp.validations.note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.costaisa.bootcamp.validations.Validation;

public class CompositeValidation implements Validation {

	protected List<Validation> validations = new ArrayList<>();
	
	public CompositeValidation add(Validation validation) {
		this.validations.add(validation);		
		return this; // permite add.().add()...
	}
	
	@Override
	public boolean matches() {
		return this.validations.stream().allMatch((validation) -> validation.matches());
	}

	@Override
	public Supplier<? extends Exception> exception() {
		Supplier<? extends Exception> result = () -> new Exception();
		
		Optional<Validation> optValidation = this.validations.stream()
				.filter((validation) -> !validation.matches())
				.findFirst();
		
		if (optValidation.isPresent()) {
			result = optValidation.get().exception();
		}
		
		return result;
	}

}

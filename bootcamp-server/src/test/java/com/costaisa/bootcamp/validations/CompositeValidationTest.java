package com.costaisa.bootcamp.validations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.costaisa.bootcamp.validations.note.CompositeValidation;

public class CompositeValidationTest {
	
	@Test
	public void textMatches() {
		CompositeValidation compositeValidation = new CompositeValidation();
		compositeValidation
			.add(() -> true)
			.add(() -> true)
			.add(() -> true);
		
		CompositeValidation compositeValidationInvalid = new CompositeValidation();
		compositeValidationInvalid
			.add(() -> true)
			.add(() -> false)
			.add(() -> true);		
		
		assertTrue(compositeValidation.matches());
		assertFalse(compositeValidationInvalid.matches());
	}
}

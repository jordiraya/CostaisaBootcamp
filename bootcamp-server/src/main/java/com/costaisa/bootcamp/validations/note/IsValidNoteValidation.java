package com.costaisa.bootcamp.validations.note;

import java.util.function.Supplier;

import com.costaisa.bootcamp.domain.Note;
import com.costaisa.bootcamp.exceptions.InvalidNoteException;
import com.costaisa.bootcamp.validations.Validation;

public class IsValidNoteValidation extends CompositeValidation {

	public IsValidNoteValidation(Note note) {
		this
		.add(new IsTextSet(note))
		.add(new IsDateSet(note));
	}
	
	/*
	@Override
	public boolean matches() {
		return false;
	}

	@Override
	public Supplier<InvalidNoteException> exception() {
		return () -> new InvalidNoteException("");
	}
	*/
}

package com.costaisa.bootcamp.validations.note;

import java.util.function.Supplier;

import com.costaisa.bootcamp.domain.Note;
import com.costaisa.bootcamp.exceptions.InvalidNoteException;
import com.costaisa.bootcamp.validations.Validation;

public class IsTextSet implements Validation {

	private Note note;
	
	public IsTextSet(Note note) {
		this.note = note;
	}
	
	@Override
	public boolean matches() {
		return (this.note.getText() != null && !this.note.getText().equals(""));
	}

	@Override
	public Supplier<? extends Exception> exception() {
		return () -> new InvalidNoteException("Text no es válido");
	}


	
}

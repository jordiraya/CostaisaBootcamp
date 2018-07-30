package com.costaisa.bootcamp.validations.note;

import java.util.function.Supplier;

import com.costaisa.bootcamp.domain.Note;
import com.costaisa.bootcamp.exceptions.InvalidNoteException;
import com.costaisa.bootcamp.validations.Validation;

public class IsDateSet implements Validation {

	private Note note;
	
	public IsDateSet(Note note) {
		this.note = note;
	}
	
	@Override
	public boolean matches() {
		return this.note.getDate() != null;
	}
	
	@Override
	public Supplier<? extends Exception> exception() {
		return () -> new InvalidNoteException("Date no es válido");
	}
	
}
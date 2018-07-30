package com.costaisa.bootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidNoteException extends Exception {
	
	public InvalidNoteException(String message) {
		super(message);
	}

}

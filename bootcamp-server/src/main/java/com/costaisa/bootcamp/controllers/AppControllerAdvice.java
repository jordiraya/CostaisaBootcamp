package com.costaisa.bootcamp.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.costaisa.bootcamp.exceptions.InvalidNoteException;

@ControllerAdvice(basePackages = "com.costaisa.bootcamp.controllers")
public class AppControllerAdvice {
	
	
	@ExceptionHandler(InvalidNoteException.class)
	public ResponseEntity<Object> invalidNoteException(InvalidNoteException ex) {
		
		System.out.println("*** AppControllerAdvice ***");
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	/*
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> manageEntityNotFound(Exception exception) {
		
		System.out.println("*** WARNING se ha intentado referenciar una nota que no existe");
		System.out.println("*** exception: " + exception.getMessage());
		
		// 204 no content
		return ResponseEntity.noContent().build();
	}
	*/

	/*
	@ExceptionHandler(InvalidNoteException.class)
	public ResponseEntity<Object> manageInvalidNote(Exception exception) {
		
		System.out.println("*** ERROR la nota no es válida");
		System.out.println("*** exception: " + exception.getMessage());
		
		// 400 bad request
		return ResponseEntity.badRequest().body("Invalid note");
	}
	*/
	
	
}

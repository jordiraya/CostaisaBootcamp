package com.costaisa.bootcamp.test;

import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import com.costaisa.bootcamp.domain.Note;
import com.costaisa.bootcamp.exceptions.InvalidNoteException;
import com.costaisa.bootcamp.validations.note.IsValidNoteValidation;

//@SpringBootTest()
public class ApplicationTest {
/*
	@Test
	public void notaValida() {
		Note note = new Note();
		note.setId(1);
		note.setText("Hoy hago tests");
		note.setDate(ZonedDateTime.now());
		IsValidNoteValidation noteValidation = new IsValidNoteValidation(note);
		boolean exceptionThrowed = false;
		
		noteValidation = new IsValidNoteValidation(note);
		try {
			noteValidation.requiredMatching();
		} catch (Exception ex) {
			exceptionThrowed = true;			
		}
		assert(!exceptionThrowed);				
	}
	
	@Test(expected = InvalidNoteException.class)
	public void errorSiTextoNull() throws Exception {
		Note note = new Note();
		note.setId(1);
		note.setText(null);		
		note.setDate(ZonedDateTime.now());
		IsValidNoteValidation noteValidation = new IsValidNoteValidation(note);	
		noteValidation.requiredMatching();
	}
	
	@Test(expected = InvalidNoteException.class)
	public void errorSiTextoVacio() throws Exception {
		Note note = new Note();
		note.setId(1);
		note.setText("");		
		note.setDate(ZonedDateTime.now());
		IsValidNoteValidation noteValidation = new IsValidNoteValidation(note);	
		noteValidation.requiredMatching();
	}
	
	@Test(expected = InvalidNoteException.class)
	public void errorSiFechaNull() throws Exception {
		Note note = new Note();
		note.setId(1);
		note.setText("Hoy hago tests");		
		note.setDate(null);
		IsValidNoteValidation noteValidation = new IsValidNoteValidation(note);	
		noteValidation.requiredMatching();
	}	
*/	
}
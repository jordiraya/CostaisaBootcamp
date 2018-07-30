package com.costaisa.bootcamp.validations.note;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.costaisa.bootcamp.domain.Note;
import com.costaisa.bootcamp.exceptions.InvalidNoteException;

public class IsDateSetTest {
	
	@Test
	public void testMatches() {
		Note validNote = new Note();
		Note invalidNote = new Note();
		
		validNote.setDate(ZonedDateTime.now());
		
		IsDateSet valid = new IsDateSet(validNote);
		IsDateSet invalid = new IsDateSet(invalidNote);
		
		assertThat(valid.matches(), is(true));
		assertThat(invalid.matches(), is(false));
	}
	
	@Test(expected = InvalidNoteException.class)
	public void testRequireMatchingWithException() throws Exception {
		Note invalidNote = new Note();
		IsDateSet invalid = new IsDateSet(invalidNote);
		invalid.requiredMatching();
	}
	
	@Test
	public void testRequireMatching() throws Exception {
		Note validNote = new Note();
		validNote.setDate(ZonedDateTime.now());
		IsDateSet valid = new IsDateSet(validNote);
		valid.requiredMatching();
	}	
}

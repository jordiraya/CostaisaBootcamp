package com.costaisa.bootcamp.services;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.costaisa.bootcamp.converters.NoteConverter;
import com.costaisa.bootcamp.domain.Note;
import com.costaisa.bootcamp.dtos.NoteDto;
import com.costaisa.bootcamp.exceptions.InvalidNoteException;
import com.costaisa.bootcamp.repositories.NoteRepository;
import com.costaisa.bootcamp.validations.note.IsValidNoteValidation;

@Service()
public class NotesService {

	private List<NoteDto> notes;
	private int index;
	
	private NoteRepository noteRepository;
	private static final NoteConverter CONVERTER = NoteConverter.INSTANCE;
	
	@Autowired
	public NotesService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;		
		// load();
	}
	
	/*
	public void load() {
		notes = new ArrayList<NoteDto>();
		index = 0;
		
		NoteDto note1 = new NoteDto();
		note1.setId(index);
		note1.setText("Hoy he desayunado al perro");
		note1.setDate(ZonedDateTime.now());		
		notes.add(note1);
		index ++;
		
		NoteDto note2 = new NoteDto();
		note2.setId(index);
		note2.setText("Hoy he paseado la avena");
		note2.setDate(ZonedDateTime.now());		
		notes.add(note2);
		index ++;		
	}
	*/

	
	public ResponseEntity<List<NoteDto>> getAll() {
		List<Note> notes = this.noteRepository.findAll();
		
		// streams (Java 8)
		List<NoteDto> dtos = notes.stream()
				.map(CONVERTER::toDto) // .map((note) -> new NoteDto()) el :: es referencia a método
				.collect(Collectors.toList());
		
		// HTTP 200
		return ResponseEntity.ok(dtos);
	}	
			
	public ResponseEntity<NoteDto> getById(int id) {		
		ResponseEntity<NoteDto> response;
		
		Note note = this.noteRepository.getOne(id);
		response = ResponseEntity.ok(CONVERTER.toDto(note));
		/*
		try {
			Note note = this.noteRepository.getOne(id);
			// HTTP 200 OK
			response = ResponseEntity.ok(CONVERTER.toDto(note));
		} catch (EntityNotFoundException ex) {
			// HTTP 404 not found
			response = ResponseEntity.notFound().build();
		}
		*/
		return response;
	}	

	public ResponseEntity<NoteDto> create(NoteDto noteDto) throws Exception {
		noteDto.setActive(null);
		Note note = CONVERTER.toDomain(noteDto);
		
		//note.validate();
		
		IsValidNoteValidation noteValidation = new IsValidNoteValidation(note);
		noteValidation.requiredMatching();
		
		note = this.noteRepository.save(note);		
		noteDto = CONVERTER.toDto(note);

		// HTTP 201 created y devolvemos en el body el objeto creado
		return ResponseEntity.created(URI.create("/notes/" + noteDto.getId())).body(noteDto);
	}
	
	public ResponseEntity<NoteDto> delete(Integer id) {
		Note note = noteRepository.getOne(id);
		note.setActive(false);
		this.noteRepository.save(note);
		
		// HTTP 204 no content
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<NoteDto> update(NoteDto noteDto) throws InvalidNoteException {		
		Note note = CONVERTER.toDomain(noteDto);
		note.validate();	
		this.noteRepository.save(note);
		
		// HTTP 204 no content
		return ResponseEntity.noContent().build();
	}
	
}

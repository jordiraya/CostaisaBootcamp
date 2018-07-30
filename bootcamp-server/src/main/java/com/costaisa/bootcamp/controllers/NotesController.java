package com.costaisa.bootcamp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.costaisa.bootcamp.dtos.NoteDto;
import com.costaisa.bootcamp.exceptions.InvalidNoteException;
import com.costaisa.bootcamp.repositories.NoteRepository;
import com.costaisa.bootcamp.services.NotesService;

@RestController()
@RequestMapping("/notes")
public class NotesController {

	private NotesService notesService;
	
	@Autowired
	public NotesController(NotesService notesService) {
		this.notesService = notesService;
	}
	
	// por convención en la API REST si no pasamos params devuelve todos los datos
	@GetMapping("") // localhost:8080/notes
	public ResponseEntity<List<NoteDto>> getAll() {
		return this.notesService.getAll();
	}
	
	@GetMapping("/{id}") // localhost:8080/notes/0
	public ResponseEntity<NoteDto> getById(@PathVariable("id") Integer id) {
		return notesService.getById(id);
	}
		
	@PostMapping("")
	public ResponseEntity<NoteDto> create(@RequestBody NoteDto note) throws Exception {
		return this.notesService.create(note);
	}	
	
	@DeleteMapping("/{id}") // localhost:8080/notes/0
	public ResponseEntity<NoteDto> delete(@PathVariable("id") Integer id) {
		return this.notesService.delete(id);
	}	
	
	@PutMapping("/{id}") // localhost:8080/notes/0
	public ResponseEntity<NoteDto> update(@PathVariable("id") Integer id, @RequestBody NoteDto note) throws InvalidNoteException {	
		return this.notesService.update(note);
	}
	
	
	
	/*
	@PostMapping(path = "/save", consumes = "application/json")
	public void save (@RequestBody Note note) {
		this.notesService.save(note);
	}
	
	@GetMapping("/load")
	public void load() {
		this.notesService.load();
	}		
	
	@GetMapping("/add")
	public void add(@RequestParam String text) {
		this.notesService.add(text);
	}
	*/
}


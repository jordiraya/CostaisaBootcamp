package com.costaisa.bootcamp.converters;

import com.costaisa.bootcamp.domain.Note;
import com.costaisa.bootcamp.dtos.NoteDto;

public class NoteConverter implements ModelConverter<NoteDto, Note>{

	public static NoteConverter INSTANCE = new NoteConverter();
	
	private NoteConverter() {
		
	}
	
	@Override
	public NoteDto toDto(Note note) {
		NoteDto noteDto = new NoteDto();
		noteDto.setId(note.getId());		
		noteDto.setText(note.getText());
		noteDto.setDate(note.getDate());
		noteDto.setActive(note.getActive());
		return noteDto;
	}

	@Override
	public Note toDomain(NoteDto noteDto) {
		Note note = new Note();
		note.setId(noteDto.getId());		
		note.setText(noteDto.getText());
		note.setDate(noteDto.getDate());
		
		if (noteDto.getActive() != null) {
			note.setActive(noteDto.getActive());
		}
		
		return note;
	}

	
	
}

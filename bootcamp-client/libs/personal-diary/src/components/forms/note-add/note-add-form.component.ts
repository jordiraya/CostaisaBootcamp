import { NoteService } from '@bcamp/personal-diary/src/providers/note.service';
import { Component } from '@angular/core';
import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Note } from '@bcamp/personal-diary/src/models/note.model';


@Component ({
  selector: 'bcamp-note-add-form',
  templateUrl: 'note-add-form.component.html'
})
export class NoteAddFormComponent {
  @Output()
  noteAdded: EventEmitter<Note> = new EventEmitter<Note>();

  constructor(private noteService: NoteService) {

  }
  saveText(text: string) {
    this.noteService.save(text).subscribe(note => {
      this.noteAdded.emit(note);
    });
  }
}

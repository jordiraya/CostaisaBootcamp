import { Component } from '@angular/core';
import { Note } from '@bcamp/personal-diary/src/models/note.model';

@Component({
  selector: 'bcamp-notes-page',
  templateUrl: 'notes-page.component.html'
})
export class NotesPageComponent {
  showNewNote(note: Note) {
    alert(JSON.stringify(note));
  }
}

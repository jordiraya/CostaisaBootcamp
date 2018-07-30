import { API_PREFIX } from './../../api/src/providers/api-prefix.token';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListsModule } from '@bcamp/ui/lists';
import { TextFieldsModule } from '@bcamp/ui/text-fields/text-fields.module';
import { ButtonsModule } from '@bcamp/ui/buttons/src/buttons.module';
import { ApiModule } from './../../api/src/api.module';
import { NoteService } from './providers/note.service';
import { NoteListComponent } from './components/note-list/note-list.component';
import { NotesPageComponent } from './pages/notes/notes-page.component';
import { NoteAddFormComponent } from './components/forms/note-add/note-add-form.component';

@NgModule({
  imports: [
    CommonModule,
    ApiModule,
    ListsModule,
    TextFieldsModule,
    ButtonsModule
  ],
  providers: [
    { provide: API_PREFIX, useValue: '/api/notes' },
    NoteService
  ],
  declarations: [
    NoteListComponent,
    NotesPageComponent,
    NoteAddFormComponent
  ],
  exports: [
    NotesPageComponent
  ]
})
export class PersonalDiaryModule {}

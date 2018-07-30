import { ApiService } from './../../../api/src/providers/api.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { interval } from 'rxjs/observable/interval';

import { Note } from '../models/note.model';

@Injectable()
export class NoteService {
  i = 0;

  notes: Note[] = [
      {id: 0, text: 'Hoy he desayunado al perro', date: new Date()},
      {id: 1, text: 'Hoy he paseado la avena', date: new Date()}
  ];

  // constructor(private httpClient: HttpClient) {}
  constructor(private apiService: ApiService<Note>) {}

  save(text: string): Observable<Note> {
    /*
    const note: Note = {
      id: this.i++,
      text: text,
      date: new Date()
    };
    this.notes.push(note);

    console.log(this.notes);
    */

    // return this.httpClient.post<Note>('/api/notes', { text: text, date: new Date() } );
    return this.apiService.save({ text: text, date: new Date() } );
  }

  getAll(): Observable<Note[]> {
    // http://localhost:8080/notes
    // return this.httpClient.get<Note[]>('/api/notes'); para devolver de una vez

    // llamada cada 2 segs
    // return interval(2000).pipe(mergeMapTo(this.httpClient.get<Note[]>('/api/notes')));

    // llamada cada 2 segs sin intervalo incial
    // return timer(0, 5000).pipe(mergeMapTo(this.apiService.get<Note[]>('/api/notes')));

    // prueba
    // return of(this.notes);

    // return timer(0, 5000).pipe(mergeMapTo(this.apiService.getAll()));

    // sacamos el timer
    return this.apiService.getAll();
  }
}

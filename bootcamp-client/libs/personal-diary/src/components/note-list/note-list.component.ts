import { Component } from '@angular/core';
import { Input } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { timer } from 'rxjs/observable/timer';
import { merge, mergeMapTo, debounceTime, takeUntil } from 'rxjs/operators';
import { OnDestroy } from '@angular/core';

import { Note } from '@bcamp/personal-diary/src/models/note.model';
import { NoteService } from '@bcamp/personal-diary/src/providers/note.service';



@Component({
  selector: 'bcamp-note-list',
  templateUrl: 'note-list.component.html'
})
export class NoteListComponent implements OnDestroy {

  private _end$ = new Subject<void>();
  private _reload$ = new Subject<void>(); // subject es observable que es emisor y receptor
  private _timer$: Observable<number> = timer(0, 10000);
  private _reloadable = true;

  @Input()
  public get reloadable(): boolean {
    return this._reloadable;
  }
  public set reloadable(value: boolean) {
    this._reloadable = value;
  }

  notes$: Observable<Note[]>;
  constructor(private noteService: NoteService) {
    // this.notes$ = this.noteService.getAll();
    this.notes$ = this._timer$.pipe(
      takeUntil(this._end$),
      merge(this._reload$),
      debounceTime(1000), // para evitar el click compulsivo del usuario
      mergeMapTo(this.noteService.getAll())
    );
  }

  reload() {
    this._reload$.next();
  }

  ngOnDestroy() {
    // evitar memory leaks
    this._reload$.complete();
    this._end$.next();
    this._end$.complete();
  }
}

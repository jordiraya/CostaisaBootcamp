import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ApiService<T> {

  constructor(private urlPrefix: string, private http: HttpClient) {}

  save(entity: T): Observable<T> {
    return this.http.post<T>(this.urlPrefix, entity);
  }

  getAll(): Observable<T[]> {
    return this.http.get<T[]>(this.urlPrefix);
  }
}

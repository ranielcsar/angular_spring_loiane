import { Injectable } from '@angular/core';
import { Course } from '../model/course';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  private readonly API = 'api/courses';

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Course[]>(this.API);
  }

  save(record: Partial<Course>) {
    return this.http.post<Course>(this.API, record);
  }
}

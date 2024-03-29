import { Injectable } from '@angular/core';
import { Course } from '../model/course';
import { HttpClient } from '@angular/common/http';
import { CoursePage } from '../model/course-page';
import { first } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  private readonly API = 'api/courses';

  constructor(private http: HttpClient) {}

  list(page = 0, pageSize = 10) {
    return this.http
      .get<CoursePage>(this.API, { params: { page, pageSize } })
      .pipe(first());
  }

  loadById(id: string) {
    return this.http.get<Course>(`${this.API}/${id}`);
  }

  save(record: Partial<Course>) {
    if (record._id) {
      return this.update(record);
    }

    return this.create(record);
  }

  private create(record: Partial<Course>) {
    return this.http.post<Course>(this.API, record);
  }

  private update(record: Partial<Course>) {
    return this.http.put<Course>(`${this.API}/${record._id}`, record);
  }

  delete(id: string) {
    return this.http.delete(`${this.API}/${id}`);
  }
}

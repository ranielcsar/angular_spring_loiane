import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  courses: Course[] = [
    { _id: '1', category: 'frontend', name: 'Angular' },
    { _id: '2', category: 'backend', name: 'Spring' },
  ];
  displayedColumns = ['name', 'category'];

  constructor() {}

  ngOnInit(): void {}
}

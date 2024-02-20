import { Lesson } from './lesson';

export interface Course {
  _id: string;
  name: string;
  category: CourseCategory;
  lessons: Lesson[];
}

export type CourseCategory = 'Front-end' | 'Back-end' | '';

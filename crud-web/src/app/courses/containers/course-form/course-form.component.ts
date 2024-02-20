import { Component, OnInit } from '@angular/core';
import { FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { CoursesService } from '../../services/courses.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../../model/course';
import { Lesson } from '../../model/lesson';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss'],
})
export class CourseFormComponent implements OnInit {
  form!: FormGroup;

  formTitle = 'Adicionar novo curso';

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const course: Course = this.route.snapshot.data['course'];

    if (course._id !== '') {
      this.formTitle = `Editar curso: ${course.name}`;
    }

    this.form = this.formBuilder.group({
      _id: [course._id],
      name: [
        course.name,
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(100),
        ],
      ],
      category: [course.category, [Validators.required]],
      lessons: this.formBuilder.array(this.retriveLessons(course)),
    });
  }

  private retriveLessons(course: Course) {
    const lessons = [];

    if (course?.lessons) {
      course.lessons.forEach((lesson) => {
        lessons.push(this.createLesson(lesson));
      });
    } else {
      lessons.push(this.createLesson());
    }

    return lessons;
  }

  private createLesson(lesson: Lesson = { id: '', name: '', youtubeUrl: '' }) {
    return this.formBuilder.group({
      id: [lesson.id],
      name: [lesson.name],
      youtubeUrl: [lesson.youtubeUrl],
    });
  }

  getErrorMessage(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
      return `Campo obrigatório`;
    }

    if (field?.hasError('minlength')) {
      const requiredLength = field.errors
        ? field.errors['minlength']['requiredLength']
        : 5;
      return `NOME precisa ter no mínimo ${requiredLength} caracteres.`;
    }

    if (field?.hasError('maxlength')) {
      const requiredLength = field.errors
        ? field.errors['maxlength']['requiredLength']
        : 100;
      return `NOME pode ter no máximo ${requiredLength} caracteres.`;
    }

    return `Campo inválido`;
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(
      () => this.onSuccess(),
      () => this.onError()
    );
  }

  private onSuccess() {
    this.snackBar.open('Curso salvo com sucesso!', 'Close', { duration: 3000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao salvar curso', 'Close', { duration: 3000 });
  }

  onCancel() {
    this.location.back();
  }
}

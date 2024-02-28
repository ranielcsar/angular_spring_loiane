package com.ranielcsar.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.ranielcsar.crudspring.dto.CourseDTO;
import com.ranielcsar.crudspring.dto.LessonDTO;
import com.ranielcsar.crudspring.enums.Category;
import com.ranielcsar.crudspring.model.Course;
import com.ranielcsar.crudspring.model.Lesson;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

  public CourseDTO toDTO(Course course) {
    if (course == null) {
      return null;
    }

    List<LessonDTO> lessons = course.getLessons()
        .stream()
        .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl()))
        .collect(Collectors.toList());

    return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
  }

  public Course toEntity(CourseDTO courseDTO) {
    if (courseDTO == null) {
      return null;
    }

    Course course = new Course();

    if (courseDTO.id() != null) {
      course.setId(courseDTO.id());
    }
    course.setName(courseDTO.name());
    course.setCategory(convertToCategory(courseDTO.category()));

    List<Lesson> lessons = courseDTO.lessons()
        .stream()
        .map(lessonDTO -> {
          Lesson lesson = new Lesson();
          lesson.setId(courseDTO.id());
          lesson.setName(lessonDTO.name());
          lesson.setYoutubeUrl(lessonDTO.youtubeUrl());

          lesson.setCourse(course);

          return lesson;
        })
        .collect(Collectors.toList());

    course.setLessons(lessons);

    return course;
  }

  public Category convertToCategory(String value) {
    if (value == null) {
      return null;
    }

    return switch (value) {
      case "Front-end" -> Category.FRONTEND;
      case "Back-end" -> Category.BACKEND;
      default -> throw new IllegalArgumentException("Categoria inválida: " + value);
    };
  }
}

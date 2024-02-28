package com.ranielcsar.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.ranielcsar.crudspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import com.ranielcsar.crudspring.dto.CourseDTO;
import com.ranielcsar.crudspring.dto.LessonDTO;
import com.ranielcsar.crudspring.dto.mapper.CourseMapper;
import com.ranielcsar.crudspring.exception.RecordNotFoundException;
import com.ranielcsar.crudspring.model.Course;
import com.ranielcsar.crudspring.model.Lesson;

@Validated
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDTO> list() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO) // course -> courseMapper.toDTO(course)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(@NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public CourseDTO create(@Valid @NotNull CourseDTO course) {
        Course newCourse = courseRepository.save(courseMapper.toEntity(course));

        return courseMapper.toDTO(newCourse);
    }

    public CourseDTO update(@NotNull @Positive Long id, @Valid @NotNull CourseDTO course) {
        return courseRepository.findById(id)
                .map(courseFound -> {
                    System.out.println(id);
                    courseFound.setName(course.name());
                    courseFound.setCategory(courseMapper.convertToCategory(course.category()));

                    List<Lesson> lessons = course.lessons()
                            .stream()
                            .map(lessonDTO -> {
                                Lesson lesson = new Lesson();
                                lesson.setId(id);
                                lesson.setName(lessonDTO.name());
                                lesson.setYoutubeUrl(lessonDTO.youtubeUrl());
                                lesson.setCourse(courseMapper.toEntity(course));

                                return lesson;
                            })
                            .collect(Collectors.toList());
                    courseFound.setLessons(lessons);

                    return courseMapper.toDTO(courseRepository.save(courseFound));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        courseRepository.delete(course);
    }

}

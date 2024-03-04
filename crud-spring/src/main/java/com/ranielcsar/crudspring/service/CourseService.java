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

    public CourseDTO update(@NotNull @Positive Long id, @Valid @NotNull CourseDTO courseDTO) {
        return courseRepository.findById(id)
                .map(courseFound -> {
                    Course course = courseMapper.toEntity(courseDTO);

                    courseFound.setName(course.getName());
                    courseFound.setCategory(courseMapper.convertToCategory(courseDTO.category()));
                    courseFound.getLessons().clear();
                    course.getLessons().forEach(courseFound.getLessons()::add);

                    return courseMapper.toDTO(courseRepository.save(courseFound));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        courseRepository.delete(course);
    }

}

package com.ranielcsar.crudspring.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ranielcsar.crudspring.enums.Category;
import com.ranielcsar.crudspring.enums.validation.ValueOfEnum;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
    @JsonProperty("_id") Long id,
    @NotBlank @NotNull @Length(min = 5, max = 100) String name,
    @Length(max = 10) @ValueOfEnum(enumClass = Category.class) @Column(length = 10, nullable = false) String category,
    @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {

}

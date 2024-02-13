package com.ranielcsar.crudspring.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ranielcsar.crudspring.model.Lesson;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5, max = 100) String name,
        @Length(max = 10) @Pattern(regexp = "Back-end|Front-end") @Column(length = 10, nullable = false) String category,
        List<Lesson> lessons) {

}

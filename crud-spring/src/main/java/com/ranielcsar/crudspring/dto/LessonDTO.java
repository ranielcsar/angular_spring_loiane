package com.ranielcsar.crudspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LessonDTO(
        @JsonProperty("_id") Long id,
        String name,
        String youtubeUrl) {

}

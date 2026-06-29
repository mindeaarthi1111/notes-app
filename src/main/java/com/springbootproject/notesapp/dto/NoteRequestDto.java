package com.springbootproject.notesapp.dto;

import lombok.Data;

@Data
public class NoteRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;
}

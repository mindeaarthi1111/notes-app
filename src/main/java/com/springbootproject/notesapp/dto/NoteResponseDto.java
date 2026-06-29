package com.springbootproject.notesapp.dto;

import lombok.Data;

@Data
public class NoteResponseDto {

    private Long id;
    private String title;
    private String content;
}

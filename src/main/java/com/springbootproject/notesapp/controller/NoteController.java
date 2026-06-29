package com.springbootproject.notesapp.controller;

import com.springbootproject.notesapp.dto.NoteRequestDto;
import com.springbootproject.notesapp.dto.NoteResponseDto;
import com.springbootproject.notesapp.model.Note;
import com.springbootproject.notesapp.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    @GetMapping
    public List<Note> getAllNotes()
    {
        return noteService.getAllNotes();
    }

    @PostMapping
    public ResponseEntity<?> createNote(@Valid @RequestBody NoteRequestDto noteRequestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(noteService.createNote(noteRequestDto));
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id)
    {
        noteService.deleteNote(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id,@RequestBody Note note)
    {
        return noteService.updateNote(id,note);
    }

}

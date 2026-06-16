package com.springbootproject.notesapp.controller;

import com.springbootproject.notesapp.model.Note;
import com.springbootproject.notesapp.service.NoteService;
import lombok.RequiredArgsConstructor;
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
    public Note createNote(@RequestBody Note note)
    {
        return noteService.createNote(note);
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

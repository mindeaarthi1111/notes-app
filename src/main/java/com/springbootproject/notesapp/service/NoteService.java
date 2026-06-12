package com.springbootproject.notesapp.service;

import com.springbootproject.notesapp.model.Note;
import com.springbootproject.notesapp.repository.NoteRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public void deleteNote(Long id)
    {
        noteRepository.deleteById(id);
    }

    public Note updateNote(Long id,Note updatedNote)
    {
        Note note = noteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Note not found"));

        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteRepository.save(note);
    }
}

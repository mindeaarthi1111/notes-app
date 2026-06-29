package com.springbootproject.notesapp.service;

import com.springbootproject.notesapp.dto.NoteRequestDto;
import com.springbootproject.notesapp.dto.NoteResponseDto;
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

    public NoteResponseDto createNote(NoteRequestDto noteRequestDto){

        Note note = new Note();
        note.setTitle(noteRequestDto.getTitle());
        note.setContent(noteRequestDto.getContent());
        Note saved = noteRepository.save(note);
        return mapToDto(saved);
    }

    public NoteResponseDto mapToDto(Note note){
        NoteResponseDto noteResponseDto = new NoteResponseDto();
        noteResponseDto.setId(note.getId());
        noteResponseDto.setTitle(note.getTitle());
        noteResponseDto.setContent(note.getContent());

        return noteResponseDto;

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

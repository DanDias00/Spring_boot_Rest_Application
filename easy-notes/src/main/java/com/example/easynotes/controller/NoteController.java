package com.example.easynotes.controller;

import com.example.easynotes.Service.NoteService;

import com.example.easynotes.model.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteService noteService;


    //method to get notes using the GET method
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    //create a new note
    @PostMapping("/notes")
    public ResponseEntity<?>  createNode(@Valid @RequestBody Note note){
        return noteService.createNode(note);

    }

    //getting a single note
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id")Long noteId){
        return noteService.getNoteById(noteId);

    }

    //update a note
    @PutMapping("/notes/{id}")
    public ResponseEntity<?> updateNote(@PathVariable(value = "id")Long noteId, @Valid @RequestBody Note noteDetails){

        return noteService.updateNote(noteId,noteDetails);
    }

    //delete a note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity <?> deleteNote(@PathVariable(value = "id")Long Id){

        return noteService.deleteNote(Id);
    }

    //delete all notes
    @DeleteMapping("/notes")
    public ResponseEntity<?>deleteAllNotes(){
        return noteService.deleteAllNotes();
    }



}
package com.example.easynotes.Service;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class NoteService {

    @Autowired
   private NoteRepository noteRepository;

    // Method to get all notes
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    // Method to create a note
    public ResponseEntity<?> createNode(@Valid @RequestBody Note note){
         noteRepository.save(note);
         return new ResponseEntity<>("Successfully created a  note! ", HttpStatus.OK);
    }

    // Method to get a note by id
    public Note getNoteById(@PathVariable(value = "id")Long noteId){
        return noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","Id",noteId));

    }

    // Method to update a note
    public ResponseEntity<?> updateNote(@PathVariable(value = "id")Long noteId, @Valid @RequestBody Note noteDetails){

        //finding the note to update
        Note note = noteRepository.findById(noteId).orElseThrow();

        //updating fields
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        //adding the updated note
        Note updatedNote = noteRepository.save(note);
        return new ResponseEntity<>("Successfully Updated note " + noteId + "!", HttpStatus.OK);
    }

    // Method to delete a note
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id")Long Id){
        Note note = noteRepository.findById(Id).orElseThrow();

        noteRepository.delete(note);
        return  new ResponseEntity<>("Successfully deleted note " + Id + "!", HttpStatus.OK);
    }

    // Method to delete all notes
    public ResponseEntity<?>deleteAllNotes(){
        noteRepository.deleteAll();
        return  new ResponseEntity<>("Successfully deleted all notes !", HttpStatus.OK);
    }


}

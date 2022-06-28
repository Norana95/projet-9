package com.openclassrooms.notemicroservice.repository;

import com.openclassrooms.notemicroservice.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    public List<Note> findByPatId(Long id);
}

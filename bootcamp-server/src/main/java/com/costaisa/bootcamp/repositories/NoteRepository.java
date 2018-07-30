package com.costaisa.bootcamp.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.costaisa.bootcamp.domain.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}

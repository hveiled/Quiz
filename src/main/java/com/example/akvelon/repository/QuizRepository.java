package com.example.akvelon.repository;

import com.example.akvelon.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Page<Quiz> findAllByNameContainingAndStartAfterAndActive(Pageable page, String name, LocalDate date, boolean active);
    Page<Quiz> findAllByNameContainingAndActive(Pageable page, String name, boolean active);
    Page<Quiz> findAllByStartAfterAndActive(Pageable page, LocalDate date, boolean active);
    Page<Quiz> findAllByActive(Pageable page, boolean active);

}

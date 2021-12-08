package com.example.akvelon.repository;

import com.example.akvelon.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    void deleteAllByQuizId(Long id);
    Set<Question> findAllByQuizId(Long id);
}

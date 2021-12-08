package com.example.akvelon.service;

import com.example.akvelon.model.Question;
import com.example.akvelon.model.Quiz;
import com.example.akvelon.repository.QuestionRepository;
import com.example.akvelon.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
//import java.util.*;


@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepo;
    private final QuestionRepository questionRepo;

    public Map<String, Long> saveQuiz(Quiz quiz) {
        Quiz savedQuiz = quizRepo.save(quiz);
        System.out.println("Hello");
        return Collections.singletonMap("id", savedQuiz.getId());
    }

    public Page<Quiz> getQuizes(String name, String date, boolean activeQuize, Pageable page) {
        if (name == null && date == null && !activeQuize) {
            return quizRepo.findAll(page);
        } else if (name == null && date == null) {
            return quizRepo.findAllByActive(page, activeQuize);
        } else if (name == null && activeQuize) {
            return quizRepo.findAllByStartAfterAndActive(page, LocalDate.parse(date), activeQuize);
        } else if (date == null && activeQuize) {
            return quizRepo.findAllByNameContainingAndActive(page, name, activeQuize);
        } else {
            return quizRepo.findAllByNameContainingAndStartAfterAndActive(page, name, LocalDate.parse(date), activeQuize);
        }
    }

    @Transactional
    public void putQuiz(Long id, Quiz quiz) {
        Quiz foundQuiz = quizRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST));
        foundQuiz.setName(quiz.getName());
        foundQuiz.setActive(quiz.isActive());
        foundQuiz.setStart(quiz.getStart());
        foundQuiz.setStop(quiz.getStop());

        foundQuiz.setQuestions(quiz.getQuestions());    //видимо, это не есть оптимальное решение
        quizRepo.save(foundQuiz);
    }

    public void deleteQuiz(Long id) {
        if (!quizRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        quizRepo.deleteById(id);
    }
}

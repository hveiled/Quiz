package com.example.akvelon.controller;

import com.example.akvelon.model.Quiz;
import com.example.akvelon.service.QuizService;
//import liquibase.pro.packaged.A;
//import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QuizRestController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz")
    public Page<Quiz> getQuiz(@RequestParam(required = false) @Valid String name,
                              @RequestParam(required = false) String date,
                              @RequestParam(required = false) boolean active,
                              @NotNull @RequestParam boolean displayOrder,
                              Pageable page) {
        return quizService.getQuizes(name, date, active, displayOrder, page);
    }

    @PostMapping("/quiz/new")
    public Map<String, Long> createQuiz(@RequestBody @Valid Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @PutMapping("/quiz/{id}")
    public void changeQuiz(@PathVariable @Min(value = 1) Long id,
                           @RequestBody @NotEmpty @Valid Quiz quiz) {
        quizService.putQuiz(id, quiz);
    }

    @DeleteMapping("/quiz/delete/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }
}

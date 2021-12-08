package com.example.akvelon.model;

//import liquibase.pro.packaged.C;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Table(name = "quiz")

public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    @NotBlank
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate start;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate stop;

    @JsonIgnore
    private boolean active;

    @OneToMany(mappedBy = "quiz", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = false)
    @JsonManagedReference

    private Set<Question> questions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;
        Quiz quiz = (Quiz) o;
        return isActive() == quiz.isActive() && Objects.equals(getId(),
                quiz.getId()) && Objects.equals(getName(),
                quiz.getName()) && Objects.equals(getStart(),
                quiz.getStart()) && Objects.equals(getStop(),
                quiz.getStop()) && Objects.equals(getQuestions(),
                quiz.getQuestions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStart(), getStop(), isActive());
    }
}

package com.example.akvelon.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Data
@Embeddable
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "question_id")
    @JsonIgnore
    private Long id;

    @NotBlank
    private String text;

    @JsonIgnore
    @Column(name = "display_order")
    private Integer displayOrder;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonBackReference
    private Quiz quiz;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return getDisplayOrder().equals(question.getDisplayOrder()) && Objects.equals(getId(),
                question.getId()) && Objects.equals(getText(),
                question.getText()) && Objects.equals(getQuiz(),
                question.getQuiz());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getDisplayOrder(), getQuiz());
    }
}

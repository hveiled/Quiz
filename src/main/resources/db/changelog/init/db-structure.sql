-- liquibase formatted sql
-- changeset author:hveiled:create-quiz-table
CREATE TABLE quiz (
    quiz_id SERIAL,
    name    VARCHAR(500) NOT NULL,
    start	DATE NOT NULL,
    stop    DATE NOT NULL,
    active	BOOLEAN,
    PRIMARY KEY (quiz_id)
    );
-- rollback DROP TABLE quiz

-- changeset author:hveiled:create-question-table
CREATE TABLE question (
    question_id     SERIAL PRIMARY KEY,
    text            VARCHAR(500) NOT NULL,
    quiz_id         INTEGER,
    FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id)
    );
-- rollback DROP TABLE question

--changeset nvoxland:2
Select nextval(pg_get_serial_sequence('quiz', 'quiz_id')) as new_id;
Select nextval(pg_get_serial_sequence('quiz', 'quiz_id')) as new_id;
Select nextval(pg_get_serial_sequence('quiz', 'quiz_id')) as new_id;

Select nextval(pg_get_serial_sequence('question', 'question_id')) as new_id;
Select nextval(pg_get_serial_sequence('question', 'question_id')) as new_id;
Select nextval(pg_get_serial_sequence('question', 'question_id')) as new_id;
Select nextval(pg_get_serial_sequence('question', 'question_id')) as new_id;
Select nextval(pg_get_serial_sequence('question', 'question_id')) as new_id;

INSERT INTO quiz (quiz_id, name, start, stop, active)
    VALUES (1,'Java', '2021-12-10', '2021-12-15', false),
           (2,'SQL', '2021-12-20', '2021-12-25', false),
           (3,'IDE', '2021-12-20', '2021-12-24', false);

INSERT INTO question (question_id, text, quiz_id)
    VALUES (1,'What is JVM?', 1),
           (2,'What is JDK?', 1),
           (3,'What is byte?', 2),
           (4,'What is short?', 3),
           (5,'What is boolean?', 2);
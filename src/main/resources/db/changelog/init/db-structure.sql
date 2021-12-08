-- liquibase formatted sql
-- changeset author:hveiled:create-quiz-table
CREATE TABLE quiz (
    quiz_id INTEGER PRIMARY KEY,
    name    VARCHAR(500) NOT NULL,
    start	DATE NOT NULL,
    stop    DATE NOT NULL,
    active	BOOLEAN
    );
-- rollback DROP TABLE quiz

-- changeset author:hveiled:create-question-table
CREATE TABLE question (
    question_id     INTEGER PRIMARY KEY,
    text            VARCHAR(500) NOT NULL,
    quiz_id         INTEGER,
    display_order    INTEGER,
    FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id)
    );
-- rollback DROP TABLE question

--changeset nvoxland:2
INSERT INTO quiz (quiz_id, name, start, stop, active) VALUES (1,'Java', '2021-12-10', '2021-12-15', false);
INSERT INTO quiz (quiz_id, name, start, stop, active) VALUES (2,'SQL', '2021-12-20', '2021-12-25', false);
INSERT INTO quiz (quiz_id, name, start, stop, active) VALUES (3,'IDE', '2021-12-20', '2021-12-24', false);
INSERT INTO question (question_id, text, display_order, quiz_id) VALUES (1,'What is JVM?', 5, 1);
INSERT INTO question (question_id, text, display_order, quiz_id) VALUES (2,'What is JDK?', 6, 1);
INSERT INTO question (question_id, text, display_order, quiz_id) VALUES (3,'What is byte?', 4, 2);
INSERT INTO question (question_id, text, display_order, quiz_id) VALUES (4,'What is short?', 3, 3);
INSERT INTO question (question_id, text, display_order, quiz_id) VALUES (5,'What is boolean?', 1, 2);
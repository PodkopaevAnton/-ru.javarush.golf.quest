package ru.javarush.quest.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.quest.entity.Question;

import java.util.List;

import static java.util.Objects.isNull;

public class QuestionRepository {
    private static final Logger logger = LogManager.getLogger(QuestionRepository.class);

    private final List<Question> questions;

    public QuestionRepository(List<Question> questions) {
        if (isNull(questions)) {
            logger.error("Questions list is null");
            throw new IllegalArgumentException("Questions list cannot be null.");
        } else if (questions.isEmpty()) {
            logger.error("Questions list is empty");
            throw new IllegalArgumentException("Questions list cannot be empty.");
        }
        this.questions = questions;
        logger.debug("Create QuestionRepository");
    }

    public List<Question> getQuestions() {
        return questions;
    }

}


package ru.javarush.quest.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.quest.entity.Answer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class AnswerRepository {
    private final Map<Integer, Answer> answers;
    private static final Logger logger = LogManager.getLogger(AnswerRepository.class);
    public AnswerRepository(Map<Integer,Answer> answers) {
        if (isNull(answers)) {
            logger.error("Answers map cannot be null.");
            throw new IllegalArgumentException("Answers map cannot be null.");
        }else if (answers.isEmpty()) {
            logger.error("Answers map cannot be empty.");
            throw new IllegalArgumentException("Answers map cannot be empty.");
        }
        this.answers = answers;
        logger.debug("Create AnswerRepository");
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public List<Answer> getAnswersById(int id){
        return answers.values().stream()
                .filter(answer -> answer.getId() == id)
                .collect( Collectors.toList() );
    }

}


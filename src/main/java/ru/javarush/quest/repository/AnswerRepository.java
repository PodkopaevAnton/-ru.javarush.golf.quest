package ru.javarush.quest.repository;

import ru.javarush.quest.entity.Answer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnswerRepository {
    private final Map<Integer, Answer> answers;

    public AnswerRepository(Map<Integer,Answer> answers) {
        this.answers = answers;
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

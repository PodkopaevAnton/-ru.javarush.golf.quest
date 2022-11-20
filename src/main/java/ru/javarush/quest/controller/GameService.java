package ru.javarush.quest.controller;

import ru.javarush.quest.entity.Question;
import ru.javarush.quest.repository.AnswerRepository;
import ru.javarush.quest.repository.QuestionRepository;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameService {
    private final QuestionRepository questionRepository = new QuestionRepository();
    private final AnswerRepository answerRepository = new AnswerRepository();

    public String getQuestionById(int id){
        return questionRepository.getQuestions().stream()
                .filter(question -> question.getId()==id).findFirst().map(Question::getText).orElseThrow(RuntimeException::new);
    }

    public Map<String,Integer> getAnswersById(int id){

        return  answerRepository.getAnswersById(id).isEmpty() ? null :
                answerRepository.getAnswers().entrySet().stream()
                        .filter(answer -> answer.getValue().getId()==id)
                        .collect(Collectors.toMap(b->b.getValue().getText(), e->e.getValue().getNextQuestionId()));
    }

    public boolean checkLose(String id){
        return (Objects.equals(id, "0"));
    }

    public boolean checkWin(String id){
        return Objects.equals(id, null);
    }
}


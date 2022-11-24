package ru.javarush.quest.repository;

import ru.javarush.quest.entity.Question;

import java.util.List;

public class QuestionRepository {
    private final List<Question> questions;
    public QuestionRepository(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}

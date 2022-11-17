package ru.javarush.quest.repository;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryTest {
    QuestionRepository questionRepository = new QuestionRepository();

    @Test
    void checkQuestionsList() throws IllegalAccessException, NoSuchFieldException {
        Field field = QuestionRepository.class.getDeclaredField("questions");
        field.setAccessible(true);
        assertEquals(field.get(questionRepository),questionRepository.getQuestions());
    }
}
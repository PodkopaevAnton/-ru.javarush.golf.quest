package ru.javarush.quest.entity;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {
    Quest quest = new Quest();
    @Test
    void getQuestions() throws NoSuchFieldException, IllegalAccessException {
        Field field = Quest.class.getDeclaredField("questions");
        field.setAccessible(true);
        List<Question> questionList = (List<Question>) field.get(quest);
        assertEquals(quest.getQuestions(), questionList);
    }

    @Test
    void getAnswers() throws NoSuchFieldException, IllegalAccessException {
        Field field = Quest.class.getDeclaredField("answers");
        field.setAccessible(true);
        Map<Integer, Answer> answerMap = (Map<Integer, Answer>) field.get(quest);
        assertEquals(quest.getAnswers(), answerMap);
    }
}
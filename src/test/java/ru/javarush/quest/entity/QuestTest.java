package ru.javarush.quest.entity;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;


import static org.junit.jupiter.api.Assertions.*;

class QuestTest {

    @Test
    void getQuestions() throws NoSuchFieldException, IllegalAccessException {
        Quest quest = new Quest();
        Field field = Quest.class.getDeclaredField("questions");
        field.setAccessible(true);
        assertEquals(field.get(quest), quest.getQuestions());
    }

    @Test
    void getAnswers() throws NoSuchFieldException, IllegalAccessException {
        Quest quest = new Quest();
        Field field = Quest.class.getDeclaredField("answers");
        field.setAccessible(true);
        assertEquals(field.get(quest), quest.getAnswers());
    }
}
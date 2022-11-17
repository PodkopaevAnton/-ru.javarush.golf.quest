package ru.javarush.quest.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -123123123, -1, 0, 12735123, Integer.MAX_VALUE})
    void whenIdIsSetGetId(int id) {
        Answer answer = new Answer(id,"text",2);
        Integer actual = answer.getId();
        assertEquals(id,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1asd1", "2222adssd", "12aaa313 qwerjgwe", "zxzxczc", ".,m,.m bmnb iouoi %$%^&&^%%%", "OP[TYUOTYY 2TY[UOTYUTYU"})
    void whenTextIsSetThenGetText(String text) {
        Answer answer = new Answer(1,text,2);
        String actual = answer.getText();
        assertEquals(text,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -123123123, -1, 0, 12735123, Integer.MAX_VALUE})
    void whenNextQuestionIdIsSetGetNextQuestionId(int nextId) {
        Answer answer = new Answer(1,"text",nextId);
        Integer actual = answer.getNextQuestionId();
        assertEquals(nextId,actual);
    }
}
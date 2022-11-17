package ru.javarush.quest.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -123123123, -1, 0, 12735123, Integer.MAX_VALUE})
    void whenIdIsSetThenGetId(int id) {
        Question question = new Question(id,"text");
        Integer actual = question.getId();
        assertEquals(id,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1asd1", "2222adssd", "12aaa313 qwerjgwe", "zxzxczc", ".,m,.m bmnb iouoi %$%^&&^%%%", "OP[TYUOTYY 2TY[UOTYUTYU"})
    void whenTextIsSetThenGetText(String text) {
        Question question = new Question(1,text);
        String actual = question.getText();
        assertEquals(actual,text);
    }
}
package ru.javarush.quest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    GameService gameService = new GameService();
    @Test
    void getQuestionById() {
        System.out.println("get id");
    }

    @Test
    void getAnswersById() {
    }

    @ParameterizedTest
    @CsvSource({" true, 0", "false, 2222adssd", "false, 12aaa313 qwerjgwe", "false, zxzxczc", "false, .,m,.m bmnb iouoi %$%^&&^%%%", "false, OP[TYUOTYY 2TY[UOTYUTYU"})
    void checkLose(Boolean b, String id) {
        assertEquals(b,gameService.checkLose(id));
    }

    @ParameterizedTest
    @NullSource
    void pullNullCheckWin(String id) {
        assertTrue(gameService.checkWin(id));
    }
    @ParameterizedTest
    @CsvSource({" false, 0", "false, 2222adssd", "false, 12aaa313 qwerjgwe", "false, zxzxczc", "false, .,m,.m bmnb iouoi %$%^&&^%%%", "false, OP[TYUOTYY 2TY[UOTYUTYU"})
    void pullStringCheckFalseWin(Boolean b, String id) {
        assertEquals(b,gameService.checkWin(id));
    }
}
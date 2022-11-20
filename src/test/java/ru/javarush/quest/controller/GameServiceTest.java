package ru.javarush.quest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.repository.AnswerRepository;
import ru.javarush.quest.repository.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    GameService gameService = new GameService();
    QuestionRepository questionRepository = new QuestionRepository();
    AnswerRepository answerRepository = new AnswerRepository();
    @Test
    void getAllQuestionsForAllIds() {
        List<Question> questionList = questionRepository.getQuestions();
        for (Question value : questionList) {
            String question = value.getText();
            int id = value.getId();
            assertEquals(question, gameService.getQuestionById(id));
        }
    }

    @Test
    void getRuntimeExceptionForInvalidIdForGetQuestionById(){
        int id = questionRepository.getQuestions().size()+1;
        assertThrows(RuntimeException.class,
                ()->{
                    gameService.getQuestionById(id);
                });
    }

    @Test
    void getAllAnswersForAllIds() {
        Map<String,Integer> checkMap = new HashMap<>();
        int numberOfQuestions = questionRepository.getQuestions().size();
        for (int id = 1 ; id < numberOfQuestions; id++) {
            List<Answer> answers = answerRepository.getAnswersById(id);
            for (Answer answer : answers){
                checkMap.put(answer.getText(), answer.getNextQuestionId());
            }
            assertEquals(checkMap,gameService.getAnswersById(id));
            checkMap.clear();
        }
    }
    @Test
    void getNullForGetAnswersById() {
        int id = answerRepository.getAnswers().size() + 1;
        assertNull(gameService.getAnswersById(id));
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
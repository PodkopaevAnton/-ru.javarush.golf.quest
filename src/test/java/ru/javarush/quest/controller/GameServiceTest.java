package ru.javarush.quest.controller;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mockito;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.repository.AnswerRepository;
import ru.javarush.quest.repository.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void getAllQuestionsForAllIds() {
        int id = 1;
        Question question1 = new Question(id,"question1");
        Question question2 = new Question(5,"question2");
        QuestionRepository questionRepository = new QuestionRepository(List.of(question1,question2));
        GameService gameService = Mockito.spy(new GameService());
        assertEquals(question1.getText(), gameService.getQuestionById(questionRepository,id));
    }
    //
    @Test
    void getRuntimeExceptionForInvalidIdForGetQuestionById(){
        QuestionRepository questionRepository = new QuestionRepository(List.of(new Question(1,"question1")));
        GameService gameService = Mockito.spy(new GameService());
        int id = questionRepository.getQuestions().size()+1;
        assertThrows(RuntimeException.class,
                ()->{
                    gameService.getQuestionById(questionRepository,id);
                });
    }
    @Test
    void getAllAnswersForAllIds() {
        int id = 1;
        Answer rightAnswer1 = new Answer(id, "answer1", 0);
        Answer rightAnswer2 = new Answer(id, "answer2", 1);
        Answer wrongAnswer3 = new Answer(id+1, "answer3", 1);
        Map<String,Integer> answerMapForCurrentId = Map.of(rightAnswer1.getText(),rightAnswer1.getNextQuestionId(),rightAnswer2.getText(),rightAnswer2.getNextQuestionId());
        AnswerRepository answerRepository = new AnswerRepository(Map.of(1,rightAnswer2,2,rightAnswer1,3,wrongAnswer3));
        GameService gameService = Mockito.spy(new GameService());
        assertEquals(answerMapForCurrentId,gameService.getAnswersById(answerRepository,id));
    }

    @Test
    void getNullForGetAnswersById() {
        GameService gameService = Mockito.spy(new GameService());
        AnswerRepository answerRepository = new AnswerRepository(new HashMap<>());
        assertNull(gameService.getAnswersById(answerRepository,1));
    }

    @ParameterizedTest
    @CsvSource({" true, 0", "false, 2222adssd", "false, 12aaa313 qwerjgwe", "false, zxzxczc", "false, .,m,.m bmnb iouoi %$%^&&^%%%", "false, OP[TYUOTYY 2TY[UOTYUTYU"})
    void checkLose(Boolean b, String id) {
        GameService gameService = Mockito.spy(new GameService());
        assertEquals(b,gameService.checkLose(id));
    }

    @ParameterizedTest
    @NullSource
    void pullNullCheckWin(String id) {
        GameService gameService = Mockito.spy(new GameService());
        assertTrue(gameService.checkWin(id));
    }
    @ParameterizedTest
    @CsvSource({" false, 0", "false, 2222adssd", "false, 12aaa313 qwerjgwe", "false, zxzxczc", "false, .,m,.m bmnb iouoi %$%^&&^%%%", "false, OP[TYUOTYY 2TY[UOTYUTYU"})
    void pullStringCheckFalseWin(Boolean b, String id) {
        GameService gameService = Mockito.spy(new GameService());
        assertEquals(b,gameService.checkWin(id));
    }
}
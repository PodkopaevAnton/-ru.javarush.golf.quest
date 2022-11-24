package ru.javarush.quest.repository;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.javarush.quest.entity.Answer;


import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnswerRepositoryTest {



    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void checkMethodGetAnswers(int id){
        Map<Integer,Answer> answerMap = Map.of(1,new Answer(id, "answer1", 0),2,new Answer(id, "answer2", id));
        AnswerRepository answerRepository = Mockito.spy(new AnswerRepository(answerMap));
        assertEquals(answerMap,answerRepository.getAnswers());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void checkMethodGetAnswersById(int id) {
        Answer answer1 = new Answer(id, "answer1", 0);
        Answer answer2 = new Answer(id, "answer2", 1);
        Answer answer3 = new Answer(id+1, "answer3", 1);
        List<Answer> answerList = List.of(answer1,answer2);
        Map<Integer,Answer> answerMap = Map.of(1,answer1,2,answer2,3,answer3);
        AnswerRepository answerRepository = Mockito.spy(new AnswerRepository(answerMap));
        assertTrue(answerList.containsAll(answerRepository.getAnswersById(id)));
    }
}
package ru.javarush.quest.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.javarush.quest.entity.Answer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnswerRepositoryTest {
    AnswerRepository answerRepository = new AnswerRepository();

    @Test
    void checkAnswersMap() throws NoSuchFieldException, IllegalAccessException {
        Field field = AnswerRepository.class.getDeclaredField("answers");
        field.setAccessible(true);
        assertEquals(field.get(answerRepository),answerRepository.getAnswers());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 2, 3 })
    void checkGetAnswersById(int id) {
        List<Answer> answers = new ArrayList<>();
        for (int key : answerRepository.getAnswers().keySet()){
            Answer answer = answerRepository.getAnswers().get(key);
            if(answer.getId() == id){
                answers.add(answer);
            }
        }
        assertEquals(answers,answerRepository.getAnswersById(id));
    }
}
package ru.javarush.quest.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.javarush.quest.entity.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryTest {

    @Test
    void checkConstructorWithNullForExceptionAndMessage(){
        assertThrows(IllegalArgumentException.class,
                ()->{
                    new QuestionRepository(null);
                });
    }

    @Test
    void checkConstructorWithEmptyListForExceptionAndMessage(){
        assertThrows(IllegalArgumentException.class,
                ()->{
                    new QuestionRepository(new ArrayList<>());
                });
    }


    @Test
    void checkQuestionsList(){
        List<Question> questionsList = List.of(new Question(1,"Обернувшись,ты увидел своего друга. Показать ему свою находку?"),(new Question(4,"Ты стал частью братства. Ваш путь очень опасен. По какой дороге вы хотите идти?")));
        QuestionRepository questionRepository = Mockito.spy(new QuestionRepository(questionsList));
        assertEquals(questionsList,questionRepository.getQuestions());
    }
}
package ru.javarush.quest.repository;

import ru.javarush.quest.entity.Answer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnswerRepository {
    private final Map<Integer, Answer> answers = new HashMap<>();

    public AnswerRepository() {
        answers.put(1,new Answer(1,"Нет",0));
        answers.put(2,new Answer(1,"Да",2));
        answers.put(3,new Answer(2,"Да. Я отнесу кольцо",3));
        answers.put(4,new Answer(2,"Нет. Я оставлю его себе!",0));
        answers.put(5,new Answer(3,"Я сам его уничтожу",4));
        answers.put(6,new Answer(3,"Оставлю его себе! Оно мое, мое!",0));
        answers.put(7,new Answer(4,"Врата Рохана",0));
        answers.put(8,new Answer(4,"Мория",5));
        answers.put(9,new Answer(5,"С тяжелым сердцем я последую его совету",6));
        answers.put(10,new Answer(5,"Я останусь рядом с ним!",0)
        );
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public List<Answer> getAnswersById(int id){
        return answers.values().stream()
                .filter(answer -> answer.getId() == id)
                .collect( Collectors.toList() );
    }

}

package ru.javarush.quest.repository;

import ru.javarush.quest.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private final List<Question> questions = new ArrayList<>();

    public QuestionRepository() {
        questions.add(new Question(1,"Обернувшись,ты увидел своего друга. Показать ему свою находку?"));
        questions.add(new Question(2,"Гендальф рассказал тебе про это кольцо. Он предложил тебе отнести его в Ривенделл.Ты согласен?"));
        questions.add(new Question(3,"Путь был тяжелый, но ты справился. С тобой были твои верные друзья. В городе был созван совет. Необходимо уничтожить кольцо. Что ты сделаешь?"));
        questions.add(new Question(4,"Ты стал частью братства. Ваш путь очень опасен. По какой дороге вы хотите идти?"));
        questions.add(new Question(5,"В Мории вы столкнулись с Барлогом. Гендальф требует, чтобы вы продолжали свой путь. Как вы поступите?"));
        questions.add(new Question(6,"Ты сделал правильный выбор и попал в Лотлориен. Там тебе помогли. С победой!!"));
    }

    public List<Question> getQuestions() {
        return questions;
    }

}

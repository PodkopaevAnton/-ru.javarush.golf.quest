package ru.javarush.quest.entity;

import java.util.List;
import java.util.Map;

public class Quest {
    private final Map<Integer, Answer> answers = Map.of(
            1, new Answer(1, "Нет", 0),
            2, new Answer(1, "Да", 2),
            3, new Answer(2, "Да. Я отнесу кольцо", 3),
            4, new Answer(2, "Нет. Я оставлю его себе!", 0),
            5, new Answer(3, "Я сам его уничтожу", 4),
            6, new Answer(3, "Оставлю его себе! Оно мое, мое!", 0),
            7, new Answer(4, "Врата Рохана", 0),
            8, new Answer(4, "Мория", 5),
            9, new Answer(5, "С тяжелым сердцем я последую его совету", 6),
            10, new Answer(5, "Я останусь рядом с ним!", 0));

    private final List<Question> questions = List.of(
            (new Question(1,"Обернувшись,ты увидел своего друга. Показать ему свою находку?")),
            (new Question(2,"Гендальф рассказал тебе про это кольцо. Он предложил тебе отнести его в Ривенделл.Ты согласен?")),
            (new Question(3,"Путь был тяжелый, но ты справился. С тобой были твои верные друзья. В городе был созван совет. Необходимо уничтожить кольцо. Что ты сделаешь?")),
            (new Question(4,"Ты стал частью братства. Ваш путь очень опасен. По какой дороге вы хотите идти?")),
            (new Question(5,"В Мории вы столкнулись с Барлогом. Гендальф требует, чтобы вы продолжали свой путь. Как вы поступите?")),
            (new Question(6,"Ты сделал правильный выбор и попал в Лотлориен. Там тебе помогли. С победой!!")));

    public List<Question> getQuestions() {
        return questions;
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }
}
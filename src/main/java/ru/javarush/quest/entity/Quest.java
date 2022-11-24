package ru.javarush.quest.entity;

import java.util.List;
import java.util.Map;

public class Quest {
    private final Map<Integer, Answer> answers = Map.of(
            1, new Answer(1, "No", 0),
            2, new Answer(1, "Yes", 2),
            3, new Answer(2, "Yes. I will take the ring", 3),
            4, new Answer(2, "No. I will leave it to myself!", 0),
            5, new Answer(3, "I will destroy it", 4),
            6, new Answer(3, "I'll leave it to myself! It's mine, mine!", 0),
            7, new Answer(4, "Gates of Rohan", 0),
            8, new Answer(4, "Moria", 5),
            9, new Answer(5, "With a heavy heart I will follow his advice", 6),
            10, new Answer(5, "I will stay with him!", 0));

    private final List<Question> questions = List.of(
            (new Question(1,"Turning around, you saw your friend. He was a tall old man with a big hat and staff. He introduced himself as Gandalf. Show him your find?")),
            (new Question(2,"Gandalf told you about this ring. He suggested that you take it to Rivindell. Do you agree?")),
            (new Question(3,"The path was hard, but you made it. Your true friends were with you. A council was convened in the city. It turned out to be the ring of the dark lord Sauron. It is necessary to destroy the ring, otherwise it will enslave the whole world. What will you do?")),
            (new Question(4,"You have become part of a brotherhood. Your path is very dangerous. The gates of Rohan are open spaces, while Moria is hidden in the mountains. Which road do you want to take?")),
            (new Question(5,"In Moria, you encountered Barlog. It doesn't work for any of you. Gandalf demands that you continue on your way. How would you do?")),
            (new Question(6,"You made the right choice and ended up in Lothlórien. The mistress of the city Galadriel helped you and gave her blessing. Victory!")));

    public List<Question> getQuestions() {
        return questions;
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }
}
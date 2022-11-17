package ru.javarush.quest.entity;

public class Answer {
    private final int id;
    private final String text;
    private final Integer nextQuestionId;

    public Answer(int id, String text, Integer nextQuestionId) {
        this.id = id;
        this.text = text;
        this.nextQuestionId = nextQuestionId;
    }
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getNextQuestionId(){
        return nextQuestionId;
    }

}


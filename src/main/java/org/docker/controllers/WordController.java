package org.docker.controllers;

import org.docker.words.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordController {
    private final List<Word> dictionary = new ArrayList<>();

    public int add(String valueWord) {
        Word word = new Word(valueWord);
        dictionary.add(word);
        return word.getScore();
    }

    private void sort() {
        dictionary.sort(Word::compareTo);
    }

    public String list() {
        sort();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dictionary.size(); i++) {
            result.append(i+1).append(". ").append(dictionary.get(i).toString()).append('\n');
        }
        return result.toString();
    }


    private int sumScore() {
        int result = 0;
        for (Word word : dictionary) {
            result += word.getScore();
        }
        return result;
    }

    public String rand() {
        String result = null;
        Random rand = new Random();
        int randValue = rand.nextInt(sumScore());
        for (Word word : dictionary) {
            if (word.getScore() < randValue) {
                randValue -= word.getScore();
            } else {
                result = word.getValue();
                break;
            }
        }
        return result;
    }

    private Integer getIndex(String value) {
        Integer i = null;
        for (int j = 0; j < dictionary.size(); j++) {
            if (dictionary.get(j).getValue().equals(value)) {
                i = j;
                break;
            }
        }
        return i;
    }

    public String up(String value) {
        Integer i = getIndex(value);
        if (i != null) {
            int countScore = dictionary.get(i).getScore();
            countScore += 100;
            dictionary.get(i).setScore(countScore);
            return dictionary.get(i).toString();
        }
        return "";
    }

    public String down(String value) {
        Integer i = getIndex(value);
        if (i != null) {
            int countScore = dictionary.get(i).getScore();
            countScore -= 100;
            dictionary.get(i).setScore(countScore);
            return dictionary.get(i).toString();
        }
        return "";
    }

}

package org.docker.words;

public class Word implements Comparable<Word>{
    private int score;
    private String value;

    public Word(int score, String value) {
        this.score = score;
        this.value = value;
    }

    public Word(String value) {
        this.score = getSysScore();
        this.value = value;
    }

    public Word() {
        this.score = getSysScore();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Word other) {
        return other.score - this.score;
    }

    @Override
    public String toString() {
        return value + " (" + score + ")";
    }

    private int getSysScore() {
        int result;
        try {
            result = Integer.parseInt(System.getenv("BASE_RATING"));
        } catch (Exception e) {
            result = 1500;
        }

        return result;
    }
}

package org.docker.controllers;

import org.junit.jupiter.api.Test;

class WordControllerTest {

    @Test
    void sort() {
        WordController control = new WordController();
        control.add("word");
        control.add("aaaaa");
        control.up("word");
        String words = control.list();
        //int scoreFirstElem = words.get(0).getScore();
        //int scoreSecondElem = words.get(1).getScore();
        //assertTrue(scoreFirstElem >= scoreSecondElem);
    }
}
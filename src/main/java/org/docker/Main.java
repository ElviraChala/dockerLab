package org.docker;

import org.docker.controllers.TypeCommands;
import org.docker.controllers.WordController;

public class Main {

    public static void main(String[] args) {
        FileWorker file = new FileWorker();
        WordController wordControl = new WordController();

        while (true) {
            if (file.isExist()) {
                String lineFromRequest = file.readFromFile().trim();
                while (lineFromRequest.contains("  ")) {
                    lineFromRequest = lineFromRequest.replace("  ", " ");
                }

                String[] words = lineFromRequest.split(" ");
                String response = null;
                try {
                    TypeCommands commands = TypeCommands.valueOf(words[0].toUpperCase());

                    switch (commands) {
                        case ADD  -> response = String.valueOf(wordControl.add(words[1]));
                        case LIST -> response = wordControl.list();
                        case RAND -> response = wordControl.rand();
                        case UP   -> response = wordControl.up(words[1]);
                        case DOWN -> response = wordControl.down(words[1]);
                    }

                } catch (Exception ignored) {
                    response = "command not found";
                }
                file.writeInFile(response);
                file.deleteFile();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
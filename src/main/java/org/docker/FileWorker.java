package org.docker;

import java.io.*;

public class FileWorker {
    private final File request = new File("interface/request");
    private final File response = new File("interface/response");

    public String readFromFile() {
        String result;
        try (BufferedReader br = new BufferedReader(new FileReader(request))) {
            result = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void writeInFile(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(response))) {
            bw.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFile() {
        request.delete();
    }

    public boolean isExist() {
        return request.exists();
    }

}

package com.github;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public class Main {

    private static final int NUMBER_OF_FILES = 10000;
    private static File[] createFiles() throws IOException {
        File[] files = new File[NUMBER_OF_FILES];
        Files.createDirectories(Constants.TXT_OUTPUT_FOLDER);
        for (int i = 0; i < NUMBER_OF_FILES; i++) {
            File file = new File(Constants.TXT_OUTPUT_FOLDER + File.separator + "file_" + i + ".txt");
            if (file.createNewFile()) {
                files[i] = file;
            }
            else {
                System.out.println("The file already exists.");
            }
        }
        return files;
    }
    public static void main(String[] args) throws IOException {

        String longLoremIpsum = String.valueOf(Files.readString(Constants.LOREM_FILE));
        File[] files = createFiles();
        PrintStream[] fileWriters = new PrintStream[NUMBER_OF_FILES];

        for (int i = 0; i < NUMBER_OF_FILES; i++) {
            // Not using try-with-resources on purpose
            try {
                fileWriters[i] = new PrintStream(Constants.TXT_OUTPUT_FOLDER + File.separator + files[i].getName());
                fileWriters[i].print(longLoremIpsum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Closing all the opened files at once
        for (int i = 0; i < NUMBER_OF_FILES; i++) {
            fileWriters[i].close();
        }
    }
}

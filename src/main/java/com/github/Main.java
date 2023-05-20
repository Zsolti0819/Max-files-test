package com.github;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public class Main {

    private static File[] createFiles() throws IOException {
        final File[] files = new File[Constants.NUMBER_OF_FILES];
        Files.createDirectories(Constants.TXT_OUTPUT_FOLDER);
        for (int i = 0; i < Constants.NUMBER_OF_FILES; i++) {
            final File file = new File(Constants.TXT_OUTPUT_FOLDER + File.separator + "file_" + i + ".txt");
            if (file.createNewFile()) {
                files[i] = file;
            } else {
                System.out.println("The file already exists.");
            }
        }
        return files;
    }

    public static void main(final String[] args) throws IOException {

        final String longLoremIpsum = String.valueOf(Files.readString(Constants.LOREM_FILE));
        final File[] files = createFiles();
        final PrintStream[] fileWriters = new PrintStream[Constants.NUMBER_OF_FILES];

        for (int i = 0; i < Constants.NUMBER_OF_FILES; i++) {
            // Not using try-with-resources on purpose
            try {
                fileWriters[i] = new PrintStream(Constants.TXT_OUTPUT_FOLDER + File.separator + files[i].getName());
                fileWriters[i].print(longLoremIpsum);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        // Closing all the opened files at once
        for (int i = 0; i < Constants.NUMBER_OF_FILES; i++) {
            fileWriters[i].close();
        }
    }
}

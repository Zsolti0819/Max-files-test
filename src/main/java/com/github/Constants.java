package com.github;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.nio.file.Path;

@UtilityClass
public class Constants {

    private static final String BASE_PATH = System.getProperty("user.dir");
    public static final Path RESOURCES_PATH = Path.of(BASE_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources");
    public static final Path TXT_OUTPUT_FOLDER = Path.of(RESOURCES_PATH + File.separator + "txt");
    public static final Path LOREM_FILE = Path.of(RESOURCES_PATH + File.separator + "lorem.txt");
    public static final int NUMBER_OF_FILES = 1000000;

}

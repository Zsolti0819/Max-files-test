package com.github;

import java.nio.file.Path;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    private static final String BASE_PATH = String.valueOf(Path.of("").toAbsolutePath());
    public static final Path RESOURCES_PATH = Path.of(BASE_PATH, "src", "main", "resources");
    public static final Path TXT_OUTPUT_FOLDER = RESOURCES_PATH.resolve("txt");
    public static final Path LOREM_FILE = RESOURCES_PATH.resolve("lorem.txt");
    public static final int NUMBER_OF_FILES = 1000000;

}

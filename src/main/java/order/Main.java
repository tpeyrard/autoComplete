package order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    private static final String DEFAULT_DICTIONARY_PATH = "/dictionary.txt";
    private static final int DICTIONARY_PATH_PROVIDED = 2;
    private static final int DICTIONARY_PATH_INDEX = 1;

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("Usage: <program> <pattern> [path_to_dictionary]");
        } else {
            final AutoComplete autoComplete = new AutoComplete(providedDictionaryOrDefault(args));

            System.out.println(autoComplete.search(args[0]));
        }
    }

    private static Stream<String> providedDictionaryOrDefault(String[] arguments) throws IOException {
        return arguments.length == DICTIONARY_PATH_PROVIDED
                ? dictionaryFromProvidedPath(arguments)
                : dictionaryFromResources();
    }

    private static Stream<String> dictionaryFromProvidedPath(String[] arguments) throws IOException {
        return Files.lines(Paths.get(arguments[DICTIONARY_PATH_INDEX]));
    }

    private static Stream<String> dictionaryFromResources() {
        return new BufferedReader(
                new InputStreamReader(
                        Main.class.getResourceAsStream(DEFAULT_DICTIONARY_PATH)))
                .lines();
    }

}

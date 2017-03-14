package order;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public final class AutoComplete {

    private static final int MAX_RESULTS = 4;
    private final List<String> dictionary;

    public AutoComplete(String... words) {
        this(Stream.of(words));
    }

    public AutoComplete(Stream<String> lines) {
        this.dictionary = sortedLowerCaseDictionary(lines);
    }

    public List<String> search(String pattern) {
        final String toLowerCase = pattern.toLowerCase(Locale.ENGLISH);
        return dictionary.stream()
                .filter(word -> word.startsWith(toLowerCase))
                .limit(MAX_RESULTS)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private static List<String> sortedLowerCaseDictionary(Stream<String> words) {
        return words
                .map(word -> word.toLowerCase(Locale.ENGLISH))
                .sorted()
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

}

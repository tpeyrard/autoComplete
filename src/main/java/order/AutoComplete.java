package order;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public final class AutoComplete {


    private static final int MAX_RESULTS = 4;
    private static final List<String> DICTIONARY = sortedLowerCaseDictionary("Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv Priceline",
            "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria", "Progesterone",
            "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak",
            "Stamps", "Reprobe");

    public static List<String> search(String pattern) {
        return DICTIONARY.stream()
                .filter(word -> word.startsWith(pattern))
                .limit(MAX_RESULTS)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private static List<String> sortedLowerCaseDictionary(String... words) {
        return Stream.of(words)
                .map(word -> word.toLowerCase(Locale.ENGLISH))
                .sorted()
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

}

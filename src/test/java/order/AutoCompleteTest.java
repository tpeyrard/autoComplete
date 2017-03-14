package order;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class AutoCompleteTest {

    private final AutoComplete autoComplete = new AutoComplete("Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv Priceline",
            "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria", "Progesterone",
            "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak",
            "Stamps", "Reprobe");

    @Test
    public void
    it_returns_empty_list_when_no_match() {
        assertThat(autoComplete.search("z")).isEmpty();
    }

    @Test
    public void
    it_returns_only_four_results_with_one_letter_pattern() {
        assertThat(autoComplete.search("p")).isEqualTo(Arrays.asList("pandora", "paypal", "pg&e", "phone"));
    }

    @Test
    public void
    it_returns_first_four_matching_words() {
        assertThat(autoComplete.search("prog"))
                .isEqualTo(asList("progenex", "progeria", "progesterone", "programming"));
    }

    @Test
    public void
    it_supports_uppercase_input() {
        assertThat(autoComplete.search("PAN"))
                .isEqualTo(singletonList("pandora"));
    }
}

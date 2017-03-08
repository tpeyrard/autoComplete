package order;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AutoCompleteTest {

    @Test
    public void
    it_returns_empty_list_when_no_match() {
        assertThat(AutoComplete.search("z")).isEmpty();
    }

    @Test
    public void
    it_returns_only_four_results_with_one_letter_pattern() {
        assertThat(AutoComplete.search("p")).isEqualTo(Arrays.asList("pandora", "paypal", "pg&e", "phone"));
    }

    @Test
    public void
    it_returns_first_four_matching_words() {
        assertThat(AutoComplete.search("prog"))
                .isEqualTo(asList("progenex", "progeria", "progesterone", "programming"));
    }
}

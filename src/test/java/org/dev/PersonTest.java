package org.dev;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    @Disabled("miriam should be an adult")
    public void miriam_should_be_an_adult() {
        Person miriam = new Person("Miriam", 12);
        assertThat(miriam.age())
                .isGreaterThanOrEqualTo(18);
    }

    @Test
    @DisplayName("describedAs() will display both the passed and the normal assertion error message when failing")
    public void described_as_will_display_both_the_passed_and_the_normal_assertion_error_message_when_failing() throws Exception {
        Person miriam = new Person("Miriam", 12);
        assertThat(miriam.age())
                .describedAs("is an adult")
                .isGreaterThanOrEqualTo(18);
    }
}

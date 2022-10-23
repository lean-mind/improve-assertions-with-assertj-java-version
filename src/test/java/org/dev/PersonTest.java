package org.dev;

import org.assertj.core.api.Condition;
import org.dev.custom.assertions.PersonAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    @DisplayName("Basic Assertion - miriam should be an adult")
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

    @Test
    @DisplayName("withFailMessage() will display only the message passed if the assertion fail without the normal assertion message")
    public void with_fail_message_will_display_only_the_message_passed_if_the_assertion_fail_without_the_normal_assertion_message() throws Exception {
        Person miriam = new Person("Miriam", 12);
        assertThat(miriam.age())
                .withFailMessage("is not an adult")
                .isGreaterThanOrEqualTo(18);
    }

    @Test
    @DisplayName("Use Matches with Predicate - will display the message that you passed when the passed supplier returns false")
    public void will_display_the_message_that_you_passed_when_the_passed_supplier_returns_false() throws Exception {
        Person miriam = new Person("Miriam", 12);
        assertThat(miriam)
                .matches(it -> it.age() > 18, "is an adult");
    }

    private final Condition<Person> anAdult = new Condition<>(it -> it.age() >= 18, "an adult");
    private final Condition<Person> aChild = new Condition<>(it -> it.age() < 18, "a child");

    @Test
    @DisplayName("Use Condition - will display a domain condition message based on the condition passed")
    public void will_display_a_domain_condition_message_based_on_the_condition_passed() throws Exception {
        Person miriam = new Person("Miriam", 12);
        assertThat(miriam).is(anAdult);
    }

    @Test
    @DisplayName("Custom Assert - will display our own assertions and failure messages")
    public void will_display_our_own_assertions_and_failure_messages() throws Exception {
        Person miriam = new Person("Miriam", 12);
        PersonAssert.assertThat(miriam).isAdult();
    }
}

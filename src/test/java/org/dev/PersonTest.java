package org.dev;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest
{
    @Test
    @Disabled("miriam should be an adult")
    public void miriam_should_be_an_adult()
    {
        Person miriam = new Person("Miriam", 12);
        assertThat( miriam.age() ).isGreaterThanOrEqualTo(18);
    }
}

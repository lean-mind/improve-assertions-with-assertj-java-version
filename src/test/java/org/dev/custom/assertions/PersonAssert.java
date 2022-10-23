package org.dev.custom.assertions;

import org.assertj.core.api.AbstractAssert;
import org.dev.Person;

public final class PersonAssert extends AbstractAssert<PersonAssert, Person> {

    private PersonAssert(Person person) {
        super(person, PersonAssert.class);
    }

    public static PersonAssert assertThat(Person actual){
        return new PersonAssert(actual);
    }

    public PersonAssert isChild(){
        isNotNull();
        if (actual.age() >= 18){
            failWithMessage(String.format("Expected <%s> to be a child but was an adult", actual.name()));
        }
        return this;
    }

    public PersonAssert isAdult(){
        isNotNull();
        if (actual.age() < 18){
            failWithMessage(String.format("Expected <%s> to be an adult but was a child", actual.name()));
        }
        return this;
    }
}

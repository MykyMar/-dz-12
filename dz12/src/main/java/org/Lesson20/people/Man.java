package org.Lesson20.people;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Man extends Person {

    private boolean beard;

    public Man(String firstName, String lastName, int age, boolean beard) {
        super(firstName, lastName, age);
        this.beard = beard;
    }

    @Override
    public boolean isRetired(int age) {
        return age >= 65;
    }

}

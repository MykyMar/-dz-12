package org.Lesson20.people;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Woman extends Person {
    private boolean isPregnant = false;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);

    }

    public void changePregnantStatus() {
        if (isPregnant) {
            isPregnant = false;
            children = true;
            if (partner != null) {
                partner.children = true;
            }

        } else isPregnant = true;
    }


}

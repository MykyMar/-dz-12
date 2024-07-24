package org.Lesson20.people;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Person implements Partnership {
    @Setter
    protected String firstName; // можна змінити окремою функцією
    protected String lastName; // можна змінити окремою функцією changeLastName
    @Setter
    protected int age;
    protected Person partner; // можна засетити окремою функцією setPartner
    protected String oldLastName;
    protected boolean isChangedLastName = false;
    protected boolean children = false; // діти зʼявляються тільки через Woman(якщо я все правильно зробила)

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
        this.oldLastName = lastName;
    }


    public boolean isRetired(int age) {
        return age >= 60;
    }


    @Override
    // вирішила зробити цей метод повноцінним шлюбом. Призвище може змінювати будь хто із партнерів, але хтось один.
    public void registerPartnership(Person newPartner, boolean changeLastNamePerson, boolean changeLastNamePartner) {

        if (changeLastNamePerson && changeLastNamePartner) {
            System.out.println("Only one of the partners can change the last name!");
            return;
        }
        setPartner(newPartner);

        if (changeLastNamePerson) {
            changeLastName(this, newPartner.lastName);
        }
        if (changeLastNamePartner) {
            changeLastName(newPartner, this.lastName);
        }


    }

    @Override // тут іде повроціне розлучення
    public void deregisterPartnership(boolean changeLastNamePerson, boolean changeLastNamePartner) {
        if (changeLastNamePerson && isChangedLastName) {
            String name = lastName;
            lastName = oldLastName;
            oldLastName = name;
        }
        if (changeLastNamePartner && partner.isChangedLastName) {
            partner.lastName = partner.oldLastName;
        }
        partner.partner = null;
        partner = null;

    }

    public void changeLastName(Person person, String newLastName) {
        person.oldLastName = person.lastName;
        person.lastName = newLastName;
        person.isChangedLastName = true;
    }

    public void setPartner(Person newPartner) {
        if (newPartner.partner != null || this.partner != null) {
            System.out.println("It's impossible to have more than one partner!");
            return;
        }
        this.partner = newPartner;
        newPartner.partner = this;
    }
}

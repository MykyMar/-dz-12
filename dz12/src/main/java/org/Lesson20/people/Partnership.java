package org.Lesson20.people;

public interface Partnership {

   void registerPartnership(Person partner,  boolean changeLastNamePerson, boolean changeLastNamePartner);

   void deregisterPartnership(boolean changeLastNamePerson, boolean changeLastNamePartner);

}

package People;

import org.Lesson20.people.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PartnershipTest {
    private Person person1;
    private Person person2;
    private final String person1LastName = "Doe";
    private final String person2LastName = "Smith";

    @BeforeMethod
    public void setUp() {
        person1 = new Person("John", person1LastName, 30);
        person2 = new Person("Jane", person2LastName, 28);
    }

    // коментарі додав ChatGPT

    @Test(testName = "Register Partnership", dataProvider = "allStatusProvider", dataProviderClass = DataProviders.class)
    public void registerPartnershipTest(boolean changeLastName1, boolean changeLastName2) {
        person1.registerPartnership(person2, changeLastName1, changeLastName2);

        if (changeLastName1 && changeLastName2) {
            // Both partners try to change their last name
            assertPartnership(false);
            assertLastNames(person1LastName, person2LastName);
        } else {
            // At least one partner's status is false
            assertPartnership(true);

            if (changeLastName1) {
                // Only person1 changes their last name
                assertLastNames(person2LastName, person2LastName);
                assertOldLastName(person1, person1LastName);
            } else if (changeLastName2) {
                // Only person2 changes their last name
                assertLastNames(person1LastName, person1LastName);
                assertOldLastName(person2, person2LastName);
            } else {
                // Neither partner changes their last name
                assertLastNames(person1LastName, person2LastName);
            }
        }
    }
//    public void deregisterPartnership(boolean changeLastNamePerson, boolean changeLastNamePartner) {
//        if (changeLastNamePerson && isChangedLastName) {
//            String name = lastName;
//            lastName = oldLastName;
//            oldLastName = name;
//        }
//        if (changeLastNamePartner && partner.isChangedLastName) {
//            partner.lastName = partner.oldLastName;
//        }
//        partner.partner = null;
//        partner = null;
//
//    }


    @Test(dataProvider = "allStatusProvider", dataProviderClass = DataProviders.class, testName = "Deregister Partnership - No Last Name Change Initially")
    public void deregisterPartnershipNoChangeTest(boolean revertLastName1, boolean revertLastName2) {
        person1.registerPartnership(person2, false, false);
        person1.deregisterPartnership(revertLastName1, revertLastName2);

        // Check that the partnership is deregistered
        assertPartnership(false);

        // Last names should remain the same as initial
        assertLastNames(person1LastName, person2LastName);
    }

    @Test(dataProvider = "allStatusProvider", dataProviderClass = DataProviders.class, testName = "Deregister Partnership - Person1 Changes Last Name Initially")
    public void deregisterPartnershipPerson1ChangesTest(boolean revertLastName1, boolean revertLastName2) {
        person1.registerPartnership(person2, true, false);
        person1.deregisterPartnership(revertLastName1, revertLastName2);

        // Check that the partnership is deregistered
        assertPartnership(false);

        // Determine expected last names after deregistration
        String expectedLastName1 = revertLastName1 ? person1LastName : person2LastName;
        assertLastNames(expectedLastName1, person2LastName);
    }

    @Test(dataProvider = "allStatusProvider", dataProviderClass = DataProviders.class, testName = "Deregister Partnership - Person2 Changes Last Name Initially")
    public void deregisterPartnershipPerson2ChangesTest(boolean revertLastName1, boolean revertLastName2) {
        person1.registerPartnership(person2, false, true);
        person1.deregisterPartnership(revertLastName1, revertLastName2);

        // Check that the partnership is deregistered
        assertPartnership(false);

        // Determine expected last names after deregistration
        String expectedLastName2 = revertLastName2 ? person2LastName : person1LastName;
        assertLastNames(person1LastName, expectedLastName2);
    }


    private void assertPartnership(boolean isRegistered) {
        if (isRegistered) {
            // Verify that the partnership is registered
            Assert.assertNotNull(person1.getPartner(), "Test failed: person1's partner should not be null!");
            Assert.assertNotNull(person2.getPartner(), "Test failed: person2's partner should not be null!");
        } else {
            // Verify that the partnership is not registered
            Assert.assertNull(person1.getPartner(), "Test failed: person1's partner should be null!");
            Assert.assertNull(person2.getPartner(), "Test failed: person2's partner should be null!");
        }
    }

    private void assertLastNames(String expectedLastName1, String expectedLastName2) {
        // Verify that the last names are as expected
        Assert.assertEquals(person1.getLastName(), expectedLastName1, "Test failed: person1's last name is incorrect!");
        Assert.assertEquals(person2.getLastName(), expectedLastName2, "Test failed: person2's last name is incorrect!");
    }

    private void assertOldLastName(Person person, String expectedOldLastName) {
        // Verify that the old last name is saved correctly
        Assert.assertEquals(person.getOldLastName(), expectedOldLastName, "Test failed: person's old last name should be saved!");
    }
}

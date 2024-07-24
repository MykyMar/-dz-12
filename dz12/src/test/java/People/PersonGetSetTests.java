package People;

import org.Lesson20.people.Man;
import org.Lesson20.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonGetSetTests {

    private Woman woman;
    private Man man;
    private final String name = "Maja";
    private final String lastName = "Doe";
    private final int age = 55;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        woman = new Woman(name, lastName, age);
        man = new Man("Jon", "Toe", 45, true);
    }

    @Test(groups = "GetSet", testName = "Get Person name")
    public void getFirstNameTest() {
        Assert.assertEquals(woman.getFirstName(), name, "Test failed: name is incorrect!");
    }

    @Test(groups = "GetSet", testName = "Get Person last name")
    public void getLastNameTest() {
        Assert.assertEquals(woman.getLastName(), lastName, "Test failed: last name is incorrect!");
    }

    @Test(groups = "GetSet", testName = "Get Person age")
    public void getAgeTest() {
        Assert.assertEquals(woman.getAge(), age, "Test failed: age is incorrect!");

    }

    @Test(groups = "GetSet", testName = "Get Person old last name")
    public void getOldLastTest() {
        Assert.assertEquals(woman.getLastName(), lastName, "Test failed: old last name is incorrect!");
    }

    @Test(groups = "GetSet", testName = "Get Person partner")
    public void getPartnerTest() {
        woman.setPartner(man);
        Assert.assertEquals(woman.getPartner(), man, "Test failed: partner is incorrect!");
    }

    @Test(groups = "GetSet", testName = "Is Person changed last name?")
    public void isChangedLastNameTest() {
        Assert.assertFalse(woman.isChangedLastName(), "Test failed: isChangedLastName should be false!");
    }

    @Test(groups = "GetSet", testName = "Get Person Children")
    public void getChildrenTest() {
        Assert.assertFalse(woman.isChildren(), "Test failed: Children should be false!");
    }

    @Test(groups = "GetSet", testName = "Set Person name")
    public void setFirstNameTest() {
        String newName = "Kate";
        woman.setFirstName(newName);
        Assert.assertEquals(woman.getFirstName(), newName, "Test failed: name is incorrect!");
    }

    @Test(groups = "GetSet", testName = "Set Person age")
    public void setAgeTest() {
        int newAge = 43;
        woman.setAge(newAge);
        Assert.assertEquals(woman.getAge(), newAge, "Test failed: age is incorrect!");
    }

}

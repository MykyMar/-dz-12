package People;

import org.Lesson20.people.Man;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManTests {


    private Man man;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        man = new Man("Jon", "Doe", 55, true);
    }


    @Test(testName = "Set/Get Man beard", dataProvider = "statusProvider", dataProviderClass = DataProviders.class, groups = "GetSet")
    public void isBeardTest(boolean setStatus, boolean expectedStatus) {
        man.setBeard(setStatus);
        Assert.assertEquals(man.isBeard(), expectedStatus, "Test failed: man beard status is incorrect! Should be " + expectedStatus);
    }


    @Test(testName = "Man isRetired for 24,64,65,66,96 ages", dataProvider = "agesManProvider", dataProviderClass = DataProviders.class)
    public void isRetiredTest(int age) {

        if (age >= 65) {
            man.setAge(age);
            Assert.assertTrue(man.isRetired(man.getAge()), "Test failed: man aged " + age + " should be retired!");
        } else {
            man.setAge(age);
            Assert.assertFalse(man.isRetired(man.getAge()), "Test failed: man aged " + age + " should not be retired!");
        }
    }
}

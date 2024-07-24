package People;

import org.Lesson20.people.Man;
import org.Lesson20.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomanTests {


    private Woman woman;
    private Man partner;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        woman = new Woman("Maja", "Doe", 55);
        partner = new Man("Jon", "Doe", 55, true);
    }


    @Test(testName = "Set/Get Woman Pregnant Status", dataProvider = "statusProvider", dataProviderClass = DataProviders.class,groups = "GetSet")
    public void isPregnantTest(boolean setStatus, boolean expectedStatus) {
        woman.setPregnant(setStatus);
        Assert.assertEquals(woman.isPregnant(), expectedStatus, "Test failed: pregnant status is incorrect! Should be " + expectedStatus);
    }



    @Test(testName = "Woman can change Pregnant Status From True To False")
    public void changePregnantStatusTest() {
        woman.setPartner(partner);
        woman.setPregnant(true);
        woman.changePregnantStatus();
        Assert.assertFalse(woman.isPregnant(), "Test failed: woman should not be pregnant!");
        Assert.assertTrue(woman.isChildren(), "Test failed: woman should have children!");
        Assert.assertTrue(partner.isChildren(), "Test failed: partner should have children!");
    }

    @Test(testName = "Woman can change Pregnant Status From False To True")
    public void changePregnantStatusTest_FromFalseToTrue() {
        woman.setPartner(partner);
        woman.setPregnant(false);
        woman.changePregnantStatus();
        Assert.assertTrue(woman.isPregnant(), "Test failed: woman should be pregnant!");
        Assert.assertFalse(woman.isChildren(), "Test failed: woman should not have children!");
        Assert.assertFalse(partner.isChildren(), "Test failed: partner should not have children!");
    }


    @Test(testName = "Woman change Pregnant Status Without Partner")
    public void changePregnantStatusTest_WithoutPartner() {
        woman.setPregnant(true);
        woman.changePregnantStatus();
        Assert.assertFalse(woman.isPregnant(), "Test failed: woman should not be pregnant!");
        Assert.assertTrue(woman.isChildren(), "Test failed: woman should have children!");
    }

}



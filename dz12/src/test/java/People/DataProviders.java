package People;

import org.Lesson20.people.Person;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "agesManProvider")
    public Object[][] testDataAgesMan() {
        return new Object[][]{
                {24},
                {64},
                {65},
                {66},
                {96}
        };
    }

    @DataProvider(name = "agesProvider")
    public Object[][] testDataAges() {
        return new Object[][]{
                {24},
                {59},
                {60},
                {61},
                {96}
        };
    }


    @DataProvider(name = "statusProvider")
    public static Object[][] statusProvider() {
        return new Object[][] {
                {true, true},
                {false, false},
        };
    }
    @DataProvider(name = "allStatusProvider")
    public static Object[][] allStatusProvider() {
        return new Object[][] {
                {true, true},
                {false, false},
                {true, false},
                {false, true}
        };
    }
}

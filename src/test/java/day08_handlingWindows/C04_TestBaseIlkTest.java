package day08_handlingWindows;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01()  {
        //amazon'a gidin
        driver.get("https://www.amazon.com");

        //amazon'a gittiginizi test edin

        ReusableMethods.bekleMethodu(3);
    }
}

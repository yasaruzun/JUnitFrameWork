package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TakeScreenShotTumSayfa extends TestBase {

    @Test
    public void test01() throws IOException {

        //amazon'a gidip
        driver.get("https://www.amazon.com");
        //nutella aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //arama sonuclarinin nutella icerdigini test edin
        WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu=aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));


        //tum sayfanin screenshot'ını alin

       ReusableMethods.tumSayfaScreenShotCek(driver);


        ReusableMethods.bekleMethodu(3);


    }
}

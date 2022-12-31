package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;
import java.util.TreeSet;

public class C01_Tekrar extends TestBase {

    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin

        WebElement ciziliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        ReusableMethods.bekleMethodu(3);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHD= driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim



        Set<String> ikiSayfaninWHDSeti = driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD: ikiSayfaninWHDSeti
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD= eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedYenisayfaYazi="Elemental Selenium";
        String actualYeniSayfaYazi= driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYenisayfaYazi,actualYeniSayfaYazi);
        ReusableMethods.bekleMethodu(5);

    }


}

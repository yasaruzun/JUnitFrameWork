package day11_seleniumWaitsAndCookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_WebTable extends TestBase {

    @Test
    public void test01(){

        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);

        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin

        WebElement tumBody= driver.findElement(By.xpath("//tbody"));

        //4.Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement> satirlar=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirlar.size());

        //5.Tum satirlari yazdirin

        for (WebElement eachRow: satirlar
             ) {
            System.out.println(eachRow.getText());
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin

       List<WebElement>birinciSatirSutunListesi= driver.findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertEquals(14,birinciSatirSutunListesi.size());

        //7. 5.sutunu yazdirin


        System.out.println("==================================");
        List<WebElement> besinciSutunListesi=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachElelement: besinciSutunListesi
             ) {
            System.out.println(eachElelement.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

      WebElement istenenDataElementi= getElementMethodu(3,5);
        System.out.println(istenenDataElementi.getText());

        ReusableMethods.bekleMethodu(5);
    }

    private WebElement getElementMethodu(int satir, int sutun) {

     String dinamikXpath="//tbody/tr["+satir+"]/td["+sutun+"]";

     WebElement istenenElement=driver.findElement(By.xpath(dinamikXpath));
     return istenenElement;

    }


}

package day10_fileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_UploadFile extends TestBase {

    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim


        /*
               Bu gorevi yapabilmek icin chooseFile butonuna basildiginda
               acilan bilgisayarimizdaki dosyalarini click yapabilmemiz gerekir
               ancak selenium bilgisayarimizdaki dosyalari clicl yapamaz

               Bunun yerine soyle bir cozum uretilmistir

               1- chooseFile butonunu locate edin
               2- upload edilecek dosyanin dosya yolunun olusturun
               3- chooseFile butonuna sendKeys ile dosya yolunu gonderin

         */


        WebElement chooseFileButonu=driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dosyaYolu="C:/Users/YAŞAR UZUN/OneDrive/Masaüstü/java.docx";

        chooseFileButonu.sendKeys(dosyaYolu);

        //3.Yuklemek istediginiz dosyayi secelim.
        //4.Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadElement=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadElement.isDisplayed());

        ReusableMethods.bekleMethodu(8);

    }
}

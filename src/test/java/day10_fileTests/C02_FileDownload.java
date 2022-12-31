package day10_fileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void test01(){
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim

        driver.findElement(By.xpath("//a[text()='Facebookd.png']")).click();
        ReusableMethods.bekleMethodu(5);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu=System.getProperty("user.home")+"//Downloads//Facebookd.png/";

        //bir dosyanin bilgisayarimizda var oldugunu test etmek icin
        // java'daki Files class'indan yardim alacagiz

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02(){
        String dosyaYolu=System.getProperty("user.home")+"//OneDrive//Masaüstü//java.docx/";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}

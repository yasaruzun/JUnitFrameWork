package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {

    static WebDriver driver;

    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement actualSayfaYazisi=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualSayfaYazisi.isEnabled());
        Thread.sleep(3000);

        // - Text Box’a “Merhaba Dunya!” yazin.
        //normal locate yapip yazdirmayi denedigimizde noSuchElementException verdi, yani elementi bulamadi
        //kontrol ederken istedigimiz webelementin bir IFrame icinde oldugunu gorduk
        //bu durumda once o IFrame'e switchTo yapmaliyiz

        WebElement iframeWebElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframeWebElementi);
        WebElement yaziKutuElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutuElementi.clear();
        yaziKutuElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        //iframe'in icine girdikten sonra oradan cik denilinceye kadar driver iframe'in icinde kalir
        //eger disina cikmak isterseniz

        driver.switchTo().parentFrame();// bulundugu iframe'den bir ust html sayfasina gecer
                                        // bu daha cok icice iframe'ler oldguunda tercih edilir

        driver.switchTo().defaultContent();//ana sayfaya gecis yapar

        WebElement elementalSleniumLinkElementi=driver.findElement(By.xpath("//div[text()='Powered by ']"));
        Assert.assertTrue(elementalSleniumLinkElementi.isDisplayed());

        System.out.println(elementalSleniumLinkElementi.getText());
    }
}

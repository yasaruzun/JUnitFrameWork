package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {

    //gerekli ayarlamalari yapip
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //3 test methodu olusturup her method'da bir JsAlert'e basin
    // ilgili methodlari kullanin

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

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1.alert'e tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //Alert'deki yazinin " I am a JS Alert" oldugunu test edelim

        String actualAlertYazisi= driver.switchTo().alert().getText();
       String expectedAlertYazisi="I am a JS Alert";

        Thread.sleep(5000);
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);


        //OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();



    }

    @Test
    public void test02(){
        //2.Alert'e tiklayalim

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //cancel'a basip cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        driver.switchTo().alert().dismiss();
        String actualAlertYazisi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedAlertYazisi="You clicked: Cancel";

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);



    }

    @Test
    public void test03(){
        //3.Alert'e tiklayalim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        //

        driver.switchTo().alert().sendKeys("abdullah");
        driver.switchTo().alert().accept();

        String actualAlertYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedAlertYazisi="abdullah";

        Assert.assertTrue(actualAlertYazisi.contains(expectedAlertYazisi));
    }
}

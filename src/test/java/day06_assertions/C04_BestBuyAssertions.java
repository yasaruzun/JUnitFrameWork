package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class C04_BestBuyAssertions {
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://www.bestbuy.com");
    }
    @AfterClass
    public static void teardown(){

        driver.close();
    }

    @Test
    public void test01(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void test02(){
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String expectedIcermeyenKelime="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedIcermeyenKelime));

    }
    @Test
    public void test03(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement bestBuyLogo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }
    @Test
    public void test04(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement fransizcaLinki= driver.findElement(By.xpath("//button[@lang='fr']"));

        Assert.assertTrue(fransizcaLinki.isDisplayed());

    }
}

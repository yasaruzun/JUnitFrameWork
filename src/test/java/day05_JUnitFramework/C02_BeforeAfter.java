package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    //3 farkli test methodu olusturun
    //her bir method'un basinda driver'i olusturup
    //1- amazon.com'a
    //2- wisequarter.com'a
    //3-youtube.com'a gidip
    //title'lari yazdirin ve method'dan sonra driver'i kapatin
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup method'u calisti");

    }

    @After
    public void tearDown(){
        System.out.println("teardown method'u calisti");
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {
    driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void test03(){
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
    }


}

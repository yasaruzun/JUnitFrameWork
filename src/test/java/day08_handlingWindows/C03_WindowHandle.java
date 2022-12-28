package day08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin

        driver.get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkini tiklayin
        //linke tikladigimizda yeni sayfa acilacagindan click yapmadan once ilk sayfanin WindowHandleDegerini alip kaydedelim

        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        //click yapinca yeni tab acilir, ancak driver eski tab'da kalir
        //yeni tab a driver i gecirmek icin yeni tab'in windowHandleDegerine ihtiyacimiz var

        Set<String> tumHandleDegerleri=driver.getWindowHandles();
       String ikinciSayfaWindowHandleDegeri="";
        for (String each:tumHandleDegerleri
             ) {
            if(!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }

        //foreach loop bittiginde ikinci sayfanin WHD ini elde etmis olacagiz
        // bu degeri kullnarak driver'i 2.sayfaya gecirebiliriz

        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        String actualBuyukYazi=driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).getText();
        String expectedBuyukYazi="Elemental Selenium";

        Assert.assertEquals(expectedBuyukYazi,actualBuyukYazi);


        // ilk sayfaya geri donup sayfadaki yazinin

        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        Thread.sleep(3000);
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
        String actualAnInframeYazisi=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expectedAnInframeYazisi="An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(expectedAnInframeYazisi,actualAnInframeYazisi);
        Thread.sleep(3000);
    }





}

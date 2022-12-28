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

public class C02_WindowHandle {

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

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualKelime=driver.findElement(By.tagName("h3")).getText();
        String expectedKelime="Opening a new window";

        Assert.assertEquals(expectedKelime,actualKelime);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String actualSayfaBasligi=driver.getTitle();
        String expeectedSayfaBasligi="The Internet";
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        Assert.assertEquals(expeectedSayfaBasligi,actualSayfaBasligi);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
        Thread.sleep(3000);
        /*
            kontrolsuz acilan tab'a gecis yapmak icin
            1- ilk sayfada iken o sayfanin windowhandledegerini alip kaydedin
            2- 2.sayfa acildiktan sonra getWindowHandles kullanarak
                acik olan tum sayfalarin windowHandle degerlerini bir set olarak kaydedin
            3- suanda elimizde 2 elementli set var. elementlerden bir tanesi 1.sayfa'nin WindowHandleDegeri
                1.sayfanin WindowHandleDegerine esit olmayan 2. sayfanin WindowHandleDegeri olur

             4- Bu sekilde 2.sayfanin WindowHandleDegeri elde edildikten sonra
                WindowHandleDegerleri kullanilarak sayfalar arasinda gecis yapilabilir
         */

        Set<String> tumWindowHandleDegerleriSeti=driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";

        for (String each:tumWindowHandleDegerleriSeti
             ) {
            if(!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;

            }
        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        String actualAcilanYeniSayfa=driver.getTitle();
        String expectedAcilanSayfa="New Window";

        Assert.assertEquals(expectedAcilanSayfa,actualAcilanYeniSayfa);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String actualNewWindow=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        String expectedNewWindow="New Window";

        Assert.assertEquals(expectedNewWindow,actualNewWindow);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


        driver.switchTo().window(ilkSayfaHandleDegeri);
        String actualTheInternetSayfasi=driver.getTitle();
        String expectedTheInternetSayfasi="The Internet";

        Assert.assertEquals(expectedTheInternetSayfasi,actualTheInternetSayfasi);

        Thread.sleep(3000);
    }


}

package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropDownMEnu {

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        //ilgili ayarlari yapip
        //amazon anasayfaya gidin
        //arama kutusu yanındaki dropdown menuden book'u secin
        //arama kutusuna java yazdirip aramayi yapin
        //title'in java icerdigini test edin

        driver.get("https://www.amazon.com");
        //dropdown menuden istedigimiz option'i secebilmek icin oncelikle Select class'indan
        //bir obje olusturmaliyiz
        //ancak select objesi olusturmak icin select class'inin constructor'i
        //handle edecegimiz webelementi istediginden
        //1- select objesi olusturmadan once drowdown web elemntini locate etmeliyiz

        WebElement dropDownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));


        //2-select class'indan obje olusturmak
        Select select=new Select(dropDownWebElementi);

        //3- select objesini kulllanarak istedigimiz method veya methodlari

        select.selectByValue("search-alias=stripbooks-intl-ship");

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        aramaKutusu.sendKeys("java"+ Keys.ENTER);

        String expectedKelime="java";
        String actualKelime= driver.getTitle();

        Assert.assertTrue(actualKelime.contains(expectedKelime));



        //dropdown menuden books seceneginin secildigini test edin

        /*locate ettigimiz elementi bulamasa noSuchElementException verir
        sayfa yenilendigi icin var olan bir elementi bulamazsa staleElementException verir
        bu durumda lacete ve secme isemini yeniden yaparsak kodumuz calisir

        */


        dropDownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropDownWebElementi);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        String actualSecilenOption=select.getFirstSelectedOption().getText();
        String expectedSecilecekOptin="Books";

        Assert.assertEquals(expectedSecilecekOptin,actualSecilenOption);

        //Dropdown menudeki secenek sayisinin 24 oldugunu test edin



        List<WebElement> optionsWebElementListesi=select.getOptions();
        int actualOptionSayisi= optionsWebElementListesi.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);





        Thread.sleep(5000);
    }
    @Before
    public void setup()  {
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown(){
        driver.close();
    }
}

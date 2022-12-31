package day11_seleniumWaitsAndCookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {

      @Test
    public void implicitWaitTest(){
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

          driver.get("https://the-internet.herokuapp.com/dynamic_controls");

          //4. Remove butonuna basin.

          driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


          //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
          WebElement itsGoneElementi=driver.findElement(By.xpath("//p[@id='message']"));
          Assert.assertTrue(itsGoneElementi.isDisplayed());

          //6. Add buttonuna basin

          driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

          //7. It’s back mesajinin gorundugunu test edin

          WebElement itsBackElementi=driver.findElement(By.xpath("//p[@id='message']"));
          Assert.assertTrue(itsBackElementi.isDisplayed());



      }
    @Test
    public void explicitWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        //ExplicitlyWait  icin once wait objesi olusturalim
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));

        //bundan sonraki adimi belirlerken
        //islem yapmak istedigimiz elementin locate edilebilir olup olmadigi onemlidir
        //eger locate edilebilebilirse once locate edip, sonra wait objesi ile o webelement bekletilebilir
        //locate edilemiyorsa wait objesine bekleme emri locater olarak verilebilir


        WebElement itsGoneElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));



        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsBackElementi.isDisplayed());


    }

    protected WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

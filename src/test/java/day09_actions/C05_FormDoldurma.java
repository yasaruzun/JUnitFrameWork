package day09_actions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormDoldurma extends TestBase {
    @Test
    public void test01(){
        //facebook.com sayfasina girin
        driver.get("https://www.facebook.com");

        //yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //ilgili alanlari faker kutuphanesinden degerler ile doldurup

        WebElement ilkDoldurulacakYer=driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        Faker faker= new Faker();
        String mailAdresi=faker.internet().emailAddress();

        actions.click(ilkDoldurulacakYer)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Şub")
                .sendKeys(Keys.TAB)
                .sendKeys("1992")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();







        //kaydol butonuna basin
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //kayit olamadiginizi test edin

        WebElement hataMesajiElementi=driver.findElement(By.xpath("//div[@id='reg_error_inner']"));

        Assert.assertTrue(hataMesajiElementi.isDisplayed());


        ReusableMethods.bekleMethodu(25);

    }
}

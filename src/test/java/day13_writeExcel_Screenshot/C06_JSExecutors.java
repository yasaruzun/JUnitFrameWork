package day13_writeExcel_Screenshot;

import com.github.javafaker.Team;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecutors extends TestBase {

    @Test
    public void test01(){

        //amazon ana sayfaya gidin

        driver.get("https://www.amazon.com");

        //sell linkine JS executor kullanarak click yapin

        WebElement sellLinkiElementi= driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click","sell");

        WebElement goToCareerElement=driver.findElement(By.xpath("(//a[@class='elementskit-btn  whitespace--normal'])[5]"));

        jse.executeScript("arguments[0].scrollIntoView();",goToCareerElement);


    }


}

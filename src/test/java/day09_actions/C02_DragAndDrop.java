package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_DragAndDrop extends TestBase {

    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMeElemnti=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement birakilacakAlanElementi=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions=new Actions(driver);

        actions.dragAndDrop(dragMeElemnti,birakilacakAlanElementi).perform();


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

       WebElement dropYaziElementi=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(dropYaziElementi.isDisplayed());

        ReusableMethods.bekleMethodu(3);
    }

}

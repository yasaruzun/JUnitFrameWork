package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekleMethodu(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void tumSayfaScreenShotCek(WebDriver driver )  {

        //1- TakeScreenshot objesi olustur
        TakesScreenshot tss= (TakesScreenshot) driver;

        //2- resmi son olarak kaydedecegimiz dosyayi olustur
        //her resim cektiginde ust uste kaydetmemesi icin
        //resim dosya yoluna tarih ve saat iceren bir ek yapalim
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/tumEkranSS"+tarih+".jpeg";
        File tumSayfaScreenShot=new File(dosyaYolu);

        //3-tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydedelim

        File geciciDosya =tss.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi ana dosyay kopyala

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);
        } catch (IOException e) {

        }
    }

    public static void elementScreenShotCekMethodu(WebElement element) {
        //1- screenshot alacagimiz elementi locate et



        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        //2-kaydedeceğimiz dosyayi olustur
        String dosyaYolu="target/ekranResimleri/IstenenElementSS"+tarih+".jpeg";
        File elementScreenShot=new File(dosyaYolu);

        //3- gecici dosyayi olusturup, element uzerinden screenshot yapalim

        File geciciDosya= element.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi hedef dosyaya kopyala

        try {
            FileUtils.copyFile(geciciDosya,elementScreenShot);
        } catch (IOException e) {

        }
    }
}

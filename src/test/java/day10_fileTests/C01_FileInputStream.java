package day10_fileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String dosyaYolu="C://Users//YAŞAR UZUN//OneDrive//Masaüstü//java.docx/";

        FileInputStream fis=new FileInputStream(dosyaYolu);//

        /*
            File testlerinde genellikle downloads'a indirilecek bir dosyanin
            indirildigini test etmek
            veya masa ustundeki bir dosyanin web'e yuklenlenebildigini test etmek isteriz

            Ancak herkesin bilgisayarinin ismi, kullanici isimleri vb gibi farkliliklar olacagindan testler
            tek bir bilgisayarda calisacak gibi yazilmak zorunda kalinir

            Bu karisikligin onune gecebilmek icin java 2 basit kod blogu sunmus


         */

        System.out.println(System.getProperty("user.dir"));
        //C:\Users\YAŞAR UZUN\OneDrive\Masaüstü\JUnit\com.Team105JUnit
        //o anda calisan dosyanın (c01_FileInputStream) yolunu verir

        System.out.println(System.getProperty("user.home"));
        //kullaniciin path'ini verir
        //C:\Users\YAŞAR UZUN

        //masaustune gitmek istersek
        //C:\Users\YAŞAR UZUN/onedrive/Masaustu

        //downloads'a gitmek istersek
        ////C:\Users\YAŞAR UZUN/indirilenler eklememiz lazim


        //kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        //kullanici adi gibi detaylara takilmamasi icin
        //File testlerinde kullanilacak dosya yolunu
        //user.home ....... temel path'ini calistigi bilgisaardan alacak sekilde olustururuz

        String dinamikDosyaYolu=System.getProperty("user.home")+"//OneDrive//Masaüstü//java.docx/";

    }
}

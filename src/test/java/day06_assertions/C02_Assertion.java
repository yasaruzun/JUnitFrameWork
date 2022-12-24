package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
        JUnit framework'u calistirilan testlerin passed veya failed oldugunu raporlar
        Ancak raporlama'nın dogru sonuc vermesi icin testlerin Assert class'indaki hazir methodlar ile yapilmasi gerekir
        Eger Assert class'i kullanilmazsa JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
        C01'de testleri if-else ile yaptıgımız icin
        test'ler FAILED olsa da kodlar sorunsuz calistigi icin
        testler yesil tik olarak isaretlendi


     */

    int p1Yas=60;
    int p2Yas=66;
    int p3Yas=70;


    @Test
    public void test01(){
        //emekli yasi 65 olduguna gore
        // P2'nin emekli olabilceini test ediniz

        Assert.assertTrue(p2Yas>65);



    }
@Test
    public void test02(){
    //emekli yasi 65 olduguna gore
    // P1'nin emekli olamayacgini test ediniz

    Assert.assertFalse(p1Yas>65);
}
    @Test
    public void test03(){
        //emekli yasi 65 olduguna gore
        // P3'nin emekli olamayacgini test ediniz

        Assert.assertFalse(p3Yas>65);
    }

}

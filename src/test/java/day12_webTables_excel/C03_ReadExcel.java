package day12_webTables_excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        //Ulkeler excelindeki sayfa 1 e gidecek sekilde ayarlari yapalim
        String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));


        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String istenenHucredekiStr=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenenHucredekiStr);

        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

        String actualBaskent= workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedBaskent="Kabil";
        Assert.assertEquals(expectedBaskent,actualBaskent);


        // - Satir sayisini bulalim

        System.out.println("satir sayisi :"+(workbook.getSheet("Sayfa1").getLastRowNum()+1));

        // - Fiziki olarak kullanilan satir sayisini bulun
        //bunun icin sayfa2 deki son satir indexsini ve fiziki kullanilan satir sayisini yazidralim
        System.out.println("2.sayfa son satir indexi :"+(workbook.getSheet("Sayfa2").getLastRowNum()+1));
        System.out.println("2.sayfa fiziki kullanilan satir sayisi :"+workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());


        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        //ulke ismi ingizlizce =>key, geriye kalan 3 bilgi ise birlesirilerek value olsun

        Map<String,String> ulkelerMap=new TreeMap<>();
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
        String key="";
        String value="";

        for (int i = 0; i <=sonSatirIndexi ; i++) {

            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            value=  workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);

    }

}

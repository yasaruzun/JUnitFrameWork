package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {
        //excel dosyasindan kopyaladiginiz wokbook objesi uzerinde degisiklik yapabilririz
        //bunun icin oncelikle excel'in kopyasi olan workbook'u olusturalım

        String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        //5.sutun larak Nufus basligi ile bir sutun olusturalim

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        //3.satirdaki nufüs bilgisini 1500000 yapalım

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        //7 satirdaki nufus bilgisini 3000000 yapalım
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("3000000");


        //yaptigimiz degisikler kopya workbook uzerinde
        //bu degisiklikleri excel dosyasina kaydetmek icin
        //bunun icin FileOtputStream Class'ini kullanmaliyiz

        FileOutputStream fos=new FileOutputStream(dosyaYolu);

        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();
    }
}

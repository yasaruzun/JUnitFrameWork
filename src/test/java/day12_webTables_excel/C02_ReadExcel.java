package day12_webTables_excel;


import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {

        //dosya yolunu olusturalim
    String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";

    //FileInputStream objesi olusturrup, parametre olarak dosya yolunu yazalim

        FileInputStream fis= new FileInputStream(dosyaYolu);
    //kod alanimizda excel'in bir kopyasini olusuturup
        //tum bilgileri ona kopyalicaz


        Workbook workbook= WorkbookFactory.create(fis);

        //workbook icerisinde 1 den fazla sayfa olabilir
        //istedigimiz sayfaya gidelim

        Sheet sheet= workbook.getSheet("Sayfa1");

        //Angola yazdirmak istedigimiz icin 5.satir'a gidelim

        Row row= sheet.getRow(5);

        //5.satirda 2. index'deki datayi alalim

        Cell cell=row.getCell(2);

        System.out.println(cell);
    }
}

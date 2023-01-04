package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        //excel dosyalari bilgisayarimizda oldugu icin
        //java'dan FileInputStream class'i yardimi ile ulasacagiz

        String dosyaDyolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";

        FileInputStream fis=new FileInputStream(dosyaDyolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

        //satir ve sutun bilgisini parametre olarak alip
        //o hucredeki bilgiyi yazdiran bir method olusturun

        dataYazdir(25,2);
    }

    private void dataYazdir(int satir, int sutun) throws IOException {
        String dosyaDyolu="src/test/java/day12_webTables_excel/ulkeler (1).xlsx";

        FileInputStream fis=new FileInputStream(dosyaDyolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));


    }
}

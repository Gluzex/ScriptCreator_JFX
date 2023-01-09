import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class SC_FEx {
    public int type;
    public SC_FEx(File file) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String sheetName = workbook.getSheetName(0);
        if (Objects.equals(sheetName, "REP_FORM")){
            type=1;
        } else if (Objects.equals(sheetName, "REG_REPORT_FORM")){
            type=2;
        } else{
            type=3;
        }
        //System.out.print("type = " + type + "\n");
        new SC_data_checker(workbook, type);
    }
}


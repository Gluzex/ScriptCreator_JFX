import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SC_data_checker {
    public static int check = -1;
    public String cellValue;
    public SC_data_checker(XSSFWorkbook wb, int t) {
        System.out.print("t = " + t + "\n");
        switch (t) {
            case 1:
                //если полный файл с метаданными(но не факт, что заполнены все листы)
                for (int i=0; i<=2; i++){
                    System.out.print("i = " + i + "\n");
                    XSSFSheet sheet = wb.getSheetAt(i);
                    if (sheet.getRow(1).getCell(0) != null){
                        XSSFCell cell = sheet.getRow(1).getCell(0);
                        if(cell.getCellType() != /*cell.getCellTypeEnum().STRING*/CellType.STRING){
                            if(cell.getCellType() != /*cell.getCellTypeEnum().NUMERIC*/CellType.NUMERIC){
                                cellValue = String.valueOf(cell.getNumericCellValue());
                            } else {
                                cellValue= "";
                            }
                        } else {
                            cellValue = cell.getStringCellValue();
                        }

                        String tst = cellValue;
                        if(tst == null || tst.equals("") || tst.equals(" ")){
                            check=0;
                            break;
                        } else
                            check =1;
                    } else
                        check=0;
                }
                System.out.print("check = " + check + "\n");
                new SC_data_miner(wb, check);
                break;
            case 2:
                //если не полный файл (скорее всего 3 главных листа только)
                check=2;
                System.out.print("check = " + check + "\n");
                new SC_data_miner(wb, check);
                break;
            case 3:
                System.out.print("check = " + check + "\n");
                check=-1;      //неизвестная конфишурация файла
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + t);
        }
    }
}

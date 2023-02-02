import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Objects;

public class SC_data_miner {
    public static String[] Form_cd = new String[16];
    public static String[] Form_cd_name = new String[16];
    public static String[] Form_name= new String[16];
    public static String[] Form_okud= new String[16];
    public static String[] Form_okud2= new String[16];
    public static String[] Form_okud3= new String[16];
    public static String[] Form_okud4= new String[16];
    public static String[] Form_okud5= new String[16];
    public static String[] Form_okud6= new String[16];
    public static String[] Form_okud7= new String[16];
    public static String[] Form_okud8= new String[16];
    public static String[] okud_form_cd= new String[16];
    public static String[] Form_cd_cog= new String[16];
    public static String[] Rep_form_cd= new String[16];
    public static String[] Flag_IOD= new String[16];
    public static String[] Flag_PDN= new String[16];
    public static String[] Dep_name= new String[16];
    public static String[] Dep_name2= new String[16];
    public static String[] Dep_name3= new String[16];
    public static String[] Dep_name4= new String[16];
    public static String[] Dep_name5= new String[16];
    public static String[] Dep_name6= new String[16];
    public static String[] Dep_name7= new String[16];
    public static String[] Dep_name8= new String[16];
    public static String[] Dep_u_name= new String[16];
    public static String[] Dep_u_name2= new String[16];
    public static String[] Dep_u_name3= new String[16];
    public static String[] Dep_u_name4= new String[16];
    public static String[] Dep_u_name5= new String[16];
    public static String[] Dep_u_name6= new String[16];
    public static String[] Dep_u_name7= new String[16];
    public static String[] Dep_u_name8= new String[16];
    public static String[] reason= new String[16];
    public static String[] Reg_form_code= new String[16];
    public static String[] System_id= new String[16];
    public static String[] Security_role_name= new String[16];
    public static String[] Security_role_path= new String[16];
    public static String[] Search_path= new String[16];
    public static String[] Search_path_for_ehd_acs= new String[16];
    public static String[] Form_formal_code= new String[16];
    public static String[] Desc= new String[16];
    public static String[] period= new String[16];
    public static String[] period2= new String[16];
    public static String[] period3= new String[16];
    public static String[] period4= new String[16];
    public static String[] period5= new String[16];
    public static String[] period6= new String[16];
    public static String[] period7= new String[16];
    public static String[] period8= new String[16];
    public static String[] rep_subj_type = new String[16];
    public static String[] rep_subj_type2 = new String[16];
    public static String[] rep_subj_type3 = new String[16];
    public static String[] rep_subj_type4 = new String[16];
    public static String[] rep_subj_type5 = new String[16];
    public static String[] rep_subj_type6 = new String[16];
    public static String[] rep_subj_type7 = new String[16];
    public static String[] rep_subj_type8 = new String[16];
    public static String[] p_parent_code_txtf =  new String[16];
    public static String[]p_parent_type_ref_txtf =  new String[16];
    public static String[]p_type_ref_txtf =  new String[16];
    public static String[]p_source_ref_txtf = new String[16];

    public String cellValue;
    public int vid;
    public SC_data_miner(XSSFWorkbook wb, int c) {
        System.out.print("c = " + c + "\n");
        switch(c){
            case -1:
                //что-то пошло не так)
                break;
            case 0:
                //если есть все листы, но заполнены только главные
                for (int f=5; f<=9; f=f+2){
                    XSSFSheet sheet = wb.getSheetAt(f);
                    for (int k=0; k<=3; k++){
                        for(int g=1; g<=9; g++){
                            if(sheet.getRow(g) != null){
                                XSSFCell cell = sheet.getRow(g).getCell(k);
                                if(cell != null) {
                                    if(cell.getCellType() != /*cell.getCellTypeEnum().STRING*/CellType.STRING){
                                        if(cell.getCellType() != /*cell.getCellTypeEnum().NUMERIC*/CellType.NUMERIC){
                                            cellValue = String.valueOf(cell.getNumericCellValue());
                                        } else {
                                            cellValue= "";
                                        }
                                    } else {
                                        cellValue = cell.getStringCellValue();
                                        if (cellValue != null || !Objects.equals(cellValue, "") || !Objects.equals(cellValue, " ")) {
                                            switch (k) {
                                                case 0:
                                                    switch (f) {
                                                        case 5:
                                                            Form_formal_code[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 7:
                                                            okud_form_cd[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 1:
                                                    switch (f) {
                                                        case 5:
                                                            Search_path[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 7:
                                                            Form_okud[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 9:
                                                            rep_subj_type[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 2:
                                                    switch (f) {
                                                        case 5:
                                                            Form_cd[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 7:
                                                            period[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 3:
                                                    switch (f) {
                                                        case 5:
                                                            Desc[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                //если есть все листы и все заполнены
                for (int f=0; f<=9; f++){
                    //System.out.print("f = " + f + "\n");
                    XSSFSheet sheet = wb.getSheetAt(f);
                    XSSFCell cell = null;
                    for (int k=0; k<=4; k++){
                        //System.out.print("k = " + k + "\n");
                        for(int g=1; g<=16; g++){
                            //System.out.print("g = " + g + "\n");
                            if(sheet.getRow(g) != null){
                                cell = sheet.getRow(g).getCell(k);
                                if(cell != null) {
                                    if(cell.getCellType() != /*cell.getCellTypeEnum().STRING*/CellType.STRING){
                                        if(cell.getCellType() != /*cell.getCellTypeEnum().NUMERIC*/CellType.NUMERIC){
                                            cellValue = String.valueOf(cell.getNumericCellValue());
                                        } else {
                                            cellValue= "";
                                        }
                                    } else {
                                        cellValue = cell.getStringCellValue();
                                        if (cellValue != null || !Objects.equals(cellValue, "") || !Objects.equals(cellValue, " ")) {
                                            //System.out.print("cellValue = " + cellValue + "\n");
                                            switch (k) {
                                                case 0:
                                                    switch (f) {
                                                        case 0:
                                                            Form_cd[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 1:
                                                            Form_cd_cog[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 5:
                                                            Form_formal_code[g - 1] = cell.getStringCellValue();
                                                            //System.out.print("\nform_formal_code[" + (g-1) + "] = " +  Form_formal_code[g - 1] + "\n");
                                                            break;
                                                        case 7:
                                                            okud_form_cd[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 1:
                                                    switch (f) {
                                                        case 0:
                                                            Form_name[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 1:
                                                            Rep_form_cd[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 2:
                                                            Flag_IOD[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 3:
                                                            Dep_name[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 4:
                                                            Dep_u_name[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 5:
                                                            Search_path[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 7:
                                                            Form_okud[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 8:
                                                            Reg_form_code[g-1] = cell.getStringCellValue();
                                                            break;
                                                        case 9:
                                                            rep_subj_type[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 2:
                                                    switch (f) {
                                                        case 2:
                                                            Flag_PDN[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 3:
                                                            reason[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 7:
                                                            period[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 3:
                                                    switch (f) {
                                                        case 5:
                                                            Desc[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            //если есть только 3 листа
            case 2:
                for (int f=0; f<=2; f++){
                    XSSFSheet sheet = wb.getSheetAt(f);
                    for (int k=0; k<=3; k++){
                        for(int g=1; g<=6; g++){
                            if(sheet.getRow(g) != null){
                                XSSFCell cell = sheet.getRow(g).getCell(k);
                                if(cell != null){
                                    if(cell.getCellType() != /*cell.getCellTypeEnum().STRING*/CellType.STRING){
                                        if(cell.getCellType() != /*cell.getCellTypeEnum().NUMERIC*/CellType.NUMERIC){
                                            cellValue = String.valueOf(cell.getNumericCellValue());
                                        } else {
                                            cellValue= "";
                                        }
                                    } else {
                                        cellValue = cell.getStringCellValue();
                                        if (cellValue != null || !Objects.equals(cellValue, "") || !Objects.equals(cellValue, " ")) {
                                            switch (k) {
                                                case 0:
                                                    switch (f) {
                                                        case 0:
                                                            Form_formal_code[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 7:
                                                            okud_form_cd[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 1:
                                                    switch (f) {
                                                        case 0:
                                                            Search_path[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 1:
                                                            Form_okud[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 2:
                                                            rep_subj_type[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 2:
                                                    switch (f) {
                                                        case 0:
                                                            Form_cd[g - 1] = cell.getStringCellValue();
                                                            break;
                                                        case 1:
                                                            period[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                                case 3:
                                                    switch (f) {
                                                        case 0:
                                                            Desc[g - 1] = cell.getStringCellValue();
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }

        for (int y=0; y<=Form_cd.length-1; y++){
            Security_role_name[y] = "OAD_" + Form_cd[0];
            //System.out.print("secyrityRoleName[" + y + "] = " + Security_role_name[y] + "\n");
        }
        for (int p=0; p<=Form_cd.length-1; p++){
            System_id[p] = "OAD";
            //System.out.print("System_id[" + p + "] = " + System_id[p] + "\n");
        }

        for(int x=0; x<= Form_formal_code.length-1; x++){
            //System.out.print("Search_path[" + x + "] = " + Search_path[x] + "\n");
            if(Search_path[x] != null){
                if(Search_path[x].contains("Нерегламентированные отчеты")){
                    vid=1;
                    Security_role_path[x] = "CAMID(\":\")/namespaceFolder[@name=''FPS_IAPPR'']/namespaceFolder[@name=''PPK_OAD'']/namespaceFolder[@name=''REP_NR_ROLES'']";
                } else if(Search_path[x].contains("Регламентированные отчеты")){
                    vid=2;
                    Security_role_path[x] = "CAMID(\":\")/namespaceFolder[@name=''FPS_IAPPR'']/namespaceFolder[@name=''PPK_OAD'']/namespaceFolder[@name=''REP_ROLES'']";
                } else
                    Security_role_path[x] = "-";
            } else
                Security_role_path[x] = "-";
            //System.out.print("Security_role_path[" + x + "] = " + Security_role_path[x] + "\n");
        }
        for(int y=0; y<= Form_formal_code.length-1; y++){
            if(Form_cd[y] != null && !Form_cd[y].equals("") && !Form_cd[y].equals(" "))
                Form_cd[y] = Form_cd[y].trim();
            if(Form_name[y] != null && !Form_name[y].equals("") && !Form_name[y].equals(" "))
                Form_name[y] = Form_name[y].trim();
            if(Form_okud[y] != null && !Form_okud[y].equals("") && !Form_okud[y].equals(" "))
                Form_okud[y] = Form_okud[y].trim();
            if(Form_cd_cog[y] != null && !Form_cd_cog[y].equals("") && !Form_cd_cog[y].equals(" "))
                Form_cd_cog[y] = Form_cd_cog[y].trim();
            if(Rep_form_cd[y] != null && !Rep_form_cd[y].equals("") && !Rep_form_cd[y].equals(" "))
                Rep_form_cd[y] = Rep_form_cd[y].trim();
            if(Dep_name[y] != null && !Dep_name[y].equals("") && !Dep_name[y].equals(" "))
                Dep_name[y] = Dep_name[y].trim();
            if(reason[y] != null && !reason[y].equals("") && !reason[y].equals(" "))
                reason[y] = reason[y].trim();
            if(Reg_form_code[y] != null && !Reg_form_code[y].equals("") && !Reg_form_code[y].equals(" "))
                Reg_form_code[y] = Reg_form_code[y].trim();
            if(Form_formal_code[y] != null && !Form_formal_code[y].equals("") && !Form_formal_code[y].equals(" "))
                Form_formal_code[y] = Form_formal_code[y].trim();
            if(period[y] != null && !period[y].equals("") && !period[y].equals(" "))
                period[y] = period[y].trim();
            if(rep_subj_type[y] != null && !rep_subj_type[y].equals("") && !rep_subj_type[y].equals(" "))
                rep_subj_type[y] = rep_subj_type[y].trim();
        }
        //System.out.print("\nForm_cd.length-1 = " + (Form_cd.length-1) + "\n");
        for(int h=0; h<=Form_cd.length-1; h++){
            //System.out.print("h = " + h + "\n");
            if(Search_path[h] != null && !Objects.equals(Search_path[h], "") && !Objects.equals(Search_path[h], " ")){
                if(!Search_path[h].contains("/content/")){
                    int coc = 0;
                    for(int ut = 0; ut<=Search_path[h].lastIndexOf("'");){
                        int u = Search_path[h].indexOf("'", ut);
                        if(u == -1){
                            break;
                        } else {
                            coc++;
                            ut = u;
                            ut++;
                        }
                    }
                    //System.out.print("coc = " + coc + "\n");
                    String[] subs = Search_path[h].split("'");
                    Search_path[h] = subs[0];
                    //System.out.print("Search_path["+ h +"] = " + Search_path[h] + "\n");
                    for(int d =1; d<=coc; d++) {
                        //System.out.print("d = " + d + "\n");
                        Search_path[h] = Search_path[h] + "''" + subs[d];
                    }
                    //System.out.print("Search_path[" + h + "] = " + Search_path[h] + "\n");
                    Search_path_for_ehd_acs[h] = "/content/folder[@name=''Приложение НИКА'']/folder[@name=''КО'']" + Search_path[h];
                    Search_path[h] = "/content/folder[@name=''Приложение НИКА'']/folder[@name=''КО'']" + Search_path[h];
                } else {
                    int coc = 0;
                    for(int ut = 0; ut<=Search_path[h].lastIndexOf("'");){
                        int u = Search_path[h].indexOf("'", ut);
                        if(u == -1){
                            break;
                        } else {
                            coc++;
                            ut = u;
                            ut++;
                        }
                    }
                    //System.out.print("coc = " + coc + "\n");
                    String[] subs = Search_path[h].split("'");
                    Search_path[h] = subs[0];
                    for(int d =1; d<=coc; d++) {
                        //System.out.print("subs[" + d + "] = " + subs[d] + "\n");
                        Search_path[h] = Search_path[h] + "''" + subs[d];
                        //System.out.print("Search_path[" + h + "] = " + Search_path[h] + "\n");
                    }
                    int u = 0;
                    //System.out.print("vid = " + vid + "\n");
                    switch (vid){
                        case 1:
                            u = Search_path[h].indexOf("/folder[@name=''Нерегламентированные");
                            //System.out.print("u = " + u + "\n");
                            break;
                        case 2:
                            u = Search_path[h].indexOf("/folder[@name=''Регламентированные");
                            //System.out.print("u = " + u + "\n");
                            break;
                    }
                    //System.out.print("Search_path[" + h + "] = " + Search_path[h] + "\n");
                    Search_path_for_ehd_acs[h] = "/content/folder[@name=''Приложение НИКА'']/folder[@name=''КО'']" + Search_path[h].substring(u);
                    //System.out.print("Search_path_for_ehd_acs[" + h + "] = " + Search_path_for_ehd_acs[h] + "\n");
                }
            }
            //System.out.print("Search_path_for_ehd_acs[" + h + "] = " + Search_path_for_ehd_acs[h] + "\n");
        }

    }

    public static void SC_data_cleaner (){
        for(int t = 0; t <= Form_cd.length-1; t++){
            Form_cd[t] = null;
            Form_name[t] = null;
            Form_okud[t] = null;
            Form_cd_cog[t] = null;
            Rep_form_cd[t] = null;
            Flag_IOD[t] = null;
            Flag_PDN[t] = null;
            Dep_name[t] = null;
            reason[t] = null;
            Reg_form_code[t] = null;
            System_id[t] = null;
            Security_role_name[t] = null;
            Security_role_path[t] = null;
            Search_path[t] = null;
            Search_path_for_ehd_acs[t] = null;
            Form_formal_code[t] = null;
            Desc[t] = null;
            period[t] = null;
            rep_subj_type[t] = null;
            Form_cd_name[t] = null;
            okud_form_cd[t] = null;
            Dep_u_name[t] = null;
            p_parent_code_txtf[t] = null;
            p_parent_type_ref_txtf[t] = null;
            p_type_ref_txtf[t] = null;
            p_source_ref_txtf[t] = null;
        }
    }
}

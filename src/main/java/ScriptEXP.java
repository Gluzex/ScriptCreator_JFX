import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ScriptEXP {
    String text = "";
    String[] FName_def = new String[12];
    String[] Pid_def = new String[12];
    String[] TR_def = new String[12];
    String[] SR_def = new String[12];
    int count = 0;

    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    public ScriptEXP(int chk, String path) throws IOException {

        Date dateNow = new Date();
        SimpleDateFormat format_sql = new SimpleDateFormat("dd/MM/YY");
        String path2 = path;
        String iod = "";
        String pdn = "";
        String okud_rep_form = "";
        String techdb_code = "";

        for(int u = 0; u<=11; u++){
        FName_def[u] = CreateSc.UFName[0];
        Pid_def[u] = "null";
        TR_def[u] = "cognos";//вопрос.не всегда тайпреф это когнос
        SR_def[u] = "cognos";
        }
        //считаем сколько форм добавляется
        for (int y = 0; y<=SC_data_miner.Form_formal_code.length-1; y++){
            if(SC_data_miner.Form_formal_code[y] == null || Objects.equals(SC_data_miner.Form_formal_code[y], "") || Objects.equals(SC_data_miner.Form_formal_code[y], " ")){
                //кол-во добавляемых форм
                count=y-1;
                break;
    } else {
                count = y;
            }
        }
        if(count == 0){
            if(CreateSc.UFName[0] != null)
                FName_def[0] = CreateSc.UFName[0];
            //if(PreCreateSc.Pid[0] != null)
                //Pid_def[0] = PreCreateSc.Pid[0];
            if(CreateSc.TR[0] != null)
                TR_def[0] = CreateSc.TR[0];
            if(CreateSc.SR[0] != null)
                SR_def[0] = CreateSc.SR[0];
        } else {
            for(int q = 0; q<=count; q++){
                if(CreateSc.UFName[q] != null)
                    FName_def[q] = CreateSc.UFName[q];
                //if(PreCreateSc.Pid[q] != null)
                    //Pid_def[q] = PreCreateSc.Pid[q];
                if(CreateSc.TR[q] != null)
                    TR_def[q] = CreateSc.TR[q];
                if(CreateSc.SR[q] != null)
                    SR_def[q] = CreateSc.SR[q];
            }
        }

        //Все листы есть и все заполнены
        if(chk == 1){
            if(count == 0){
                if(Objects.equals(TR_def[0], "cognos")){
                    techdb_code = SC_data_miner.Form_formal_code[0];
                } else {
                    techdb_code = SC_data_miner.Form_cd[0];
                }
                if(SC_data_miner.Flag_IOD[0] == null){
                    iod = "null as FLAG_IOD";
                } else {
                    iod = "'"+ SC_data_miner.Flag_IOD[0] + "' as FLAG_IOD";
                }
                if(SC_data_miner.Flag_PDN[0] == null){
                    pdn = "null as FLAG_PDN";
                } else {
                    pdn = "'"+ SC_data_miner.Flag_PDN[0] + "' as FLAG_PDN";
                }
                int l = SC_data_miner.Form_cd[0].length();
                System.out.print("\nl = " + l + "\n");

                if(SC_data_miner.Form_cd[0].startsWith("0409")){
                    okud_rep_form = "null as FORM_OKUD";
                    System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                } else {
                    okud_rep_form = "'"+ SC_data_miner.Form_okud[0] + "' as FORM_OKUD";
                    System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                }
                text =  "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_OKI\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, " + iod + ",  " + pdn + " FROM  dual\n" +
                        "minus select * from REP_FORM_OKI;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_DEP_OWNER\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_name[0] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                        "minus select * from REP_FORM_DEP_OWNER;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_DEP_USER\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_u_name[0] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                        "minus select * from REP_FORM_DEP_OWNER;" +
                        "\n" +
                        "\n" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "\n" +
                        "--DM_NIKA_KO\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_OKI\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, " + iod + ",  " + pdn + " FROM  dual\n" +
                        "minus select * from REP_FORM_OKI;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_DEP_OWNER\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_name[0] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                        "minus select * from REP_FORM_DEP_OWNER;" +
                        "\n" +
                        "\n" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "--TechDB_EHD_ACS\n" +
                        "\n" +
                        "MERGE INTO EHD_ACS_OBJECTS O\n" +
                        "   USING (SELECT \n" +
                        "'"+ FName_def[0] +"' as NAME,\n" +
                        "   '"+ techdb_code +"' as CODE,\n" +
                        "  (select t.id from EHD_ACS_OBJECTS t where t.type_ref in ('forms','ko_ao','apl_ao','ko_av') and t.code='"+ SC_data_miner.Form_cd[0] +"') as PARENT_ID,\n" +
                        "  '" + TR_def[0] + "' as TYPE_REF,\n" +
                        "  '" + SR_def[0] + "' as SOURCE_REF,\n" +
                        "  TO_DATE('" + format_sql.format(dateNow) + "', 'DD/MM/YY') as CREATE_DATE,\n" +
                        "  null as UPDATE_DATE,\n" +
                        "  '" + SC_data_miner.Search_path_for_ehd_acs[0] + "' as SEARCH_PATH,\n" +
                        "  null as FLAG_EXP\n" +
                        "FROM dual) S\n" +
                        "   ON (O.CODE = S.CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
                        "                                O.TYPE_REF = S.TYPE_REF,\n" +
                        "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                        "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                        "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                        "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);" ;

            } else{
                if(SC_data_miner.Flag_IOD[0] == null){
                    iod = "null as FLAG_IOD";
                } else {
                    iod = "'"+ SC_data_miner.Flag_IOD[0] + "' as FLAG_IOD";
                }
                if(SC_data_miner.Flag_PDN[0] == null){
                    pdn = "null as FLAG_PDN";
                } else {
                    pdn = "'"+ SC_data_miner.Flag_PDN[0] + "' as FLAG_PDN";
                }
                int l = SC_data_miner.Form_cd[0].length();
                if(SC_data_miner.Form_cd[0].startsWith("0409")){
                    okud_rep_form = "null as FORM_OKUD";
                    System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                } else {
                    okud_rep_form = "'"+ SC_data_miner.Form_okud[0] + "' as FORM_OKUD";
                    System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                }
                text = "--" + FName_def[0] + "\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_OKI\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, " + iod + ",  " + pdn + " FROM  dual\n" +
                        "minus select * from REP_FORM_OKI;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_DEP_OWNER\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_name[0] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                        "minus select * from REP_FORM_DEP_OWNER;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_DEP_USER\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_u_name[0] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                        "minus select * from REP_FORM_DEP_OWNER;" +
                        "\n" +
                        "\n" +
                        "--$" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "--&" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "\n" +
                        "--#\n" +
                        "--DM_NIKA_KO\n" +
                        "\n" +
                        "--" + FName_def[0] + "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_OKI\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, " + iod + ",  " + pdn + " FROM  dual\n" +
                        "minus select * from REP_FORM_OKI;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_DEP_OWNER\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_name[0] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                        "minus select * from REP_FORM_DEP_OWNER;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_DEP_USER\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_u_name[0] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                        "minus select * from REP_FORM_DEP_OWNER;" +
                        "\n" +
                        "\n" +
                        "--$" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "\n" +
                        "--&" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "--#\n" +
                        "--TechDB_EHD_ACS\n" +
                        "\n" +
                        "--" + FName_def[0] + "\n" +
                        "\n" +
                        "MERGE INTO EHD_ACS_OBJECTS O\n" +
                        "   USING (SELECT \n" +
                        "'"+ FName_def[0] +"' as NAME,\n" +
                        "   '"+ SC_data_miner.Form_formal_code[0] +"' as CODE,\n" +
                        "  (select t.id from EHD_ACS_OBJECTS t where t.type_ref in ('forms','ko_ao','apl_ao','ko_av') and t.code='"+ SC_data_miner.Form_cd[0] +"') as PARENT_ID,\n" +
                        "  '" + TR_def[0] + "' as TYPE_REF,\n" +
                        "  '" + SR_def[0] + "' as SOURCE_REF,\n" +
                        "  TO_DATE('" + format_sql.format(dateNow) + "', 'DD/MM/YY') as CREATE_DATE,\n" +
                        "  null as UPDATE_DATE,\n" +
                        "  '" + SC_data_miner.Search_path_for_ehd_acs[0] + "' as SEARCH_PATH,\n" +
                        "  null as FLAG_EXP\n" +
                        "FROM dual) S\n" +
                        "   ON (O.CODE = S.CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
                        "                                O.TYPE_REF = S.TYPE_REF,\n" +
                        "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                        "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                        "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                        "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);" ;
                        String[] textset2;
                        int kol2=0;
                        for(int hj = 0; hj<=SC_data_miner.Form_okud.length-1; hj++){
                            if(SC_data_miner.Form_okud[hj] == null || Objects.equals(SC_data_miner.Form_okud[hj], "") || Objects.equals(SC_data_miner.Form_okud[hj], " ")){
                                //кол-во добавляемых форм
                                kol2 = hj-1;
                                break;
                            } else {
                                kol2 = hj;
                            }
                        }
                        String okud_text = "";

                        if(kol2 !=0){
                            String[][] okud_pair = new String[count][kol2];
                            for(int q = 0; q<=count; q++){
                                okud_pair[q][0] = SC_data_miner.Form_formal_code[q];
                                for(int i = 0; i<=kol2; i++){
                                    if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                        okud_pair[q][i+1] = SC_data_miner.Form_okud[i];
                                    }
                                }
                            }
                            int[] kol3 = new int[10];
                            for(int jh=0; jh<=9; jh++){
                                kol3[jh] = 0;
                            }
                            for(int q = 0; q<=count; q++){
                                for(int i = 0; i<=kol2; i++){
                                    if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                        kol3[count]++;
                                    }
                                }
                            }

                            for(int w = 0; w <= kol3[0]-1; w++){
                                textset2 = text.split("&");
                                text = textset2[0] + "\n" +
                                        "\n" +
                                        "INSERT INTO REPORT_OKUD_CODE \n" +
                                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '" + okud_pair[0][w] + "' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                        "minus select * from REPORT_OKUD_CODE;\n" +
                                        "--&" +
                                        textset2[1] +
                                        "\n" +
                                        "INSERT INTO REPORT_OKUD_CODE \n" +
                                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '" + okud_pair[0][w] + "' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                        "minus select * from REPORT_OKUD_CODE;\n" +
                                        "--&" +
                                        textset2[2];

                            }
                            for(int q = 0; q<=count; q++){
                                for(int i = 0; i<=kol2; i++){
                                    if (i+1 == kol3[q]){
                                     break;
                                    }
                            okud_text = okud_text + "\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[q] +"' as FORM_FORMAL_CODE, '" + okud_pair[q][i+1] + "' as OKUD_CODE, '"+ SC_data_miner.period[i] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n";
                                }
                            }

                        }


                        String[] textset1;
                        int kol=0;
                        for (int t = 0; t<=SC_data_miner.Dep_u_name.length-1; t++){
                         if(SC_data_miner.Dep_u_name[t] == null || Objects.equals(SC_data_miner.Dep_u_name[t], "") || Objects.equals(SC_data_miner.Dep_u_name[t], " ")){
                         //кол-во добавляемых форм
                         kol=t-1;
                         break;
                         } else {
                            kol = t;
                          }
                         }
                        if(kol!=0){
                            for(int h = 1; h<=kol;h++){
                                textset1 = text.split("$");
                                text = textset1[0] + "\n" +
                                        "\n" +
                                        "INSERT INTO REP_FORM_DEP_USER\n" +
                                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_u_name[h] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                                        "minus select * from REP_FORM_DEP_OWNER;" +
                                        "--$" +
                                        textset1[1] +
                                        "\n" +
                                        "INSERT INTO REP_FORM_DEP_USER\n" +
                                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_u_name[h] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                                        "minus select * from REP_FORM_DEP_OWNER;" +
                                        "--$" +
                                        textset1[2];
                            }
                        }
                        String[] textset;
                        for(int n = 1; n<=count; n++){
                            if(kol2==0){
                                okud_text = "\n" +
                                        "INSERT INTO REPORT_OKUD_CODE \n" +
                                        "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[n] +"' as OKUD_CODE, '"+ SC_data_miner.period[n] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                        "minus select * from REPORT_OKUD_CODE;\n" +
                                        "\n";
                            }
                            if (SC_data_miner.Form_cd[n] == null){
                                SC_data_miner.Form_cd[n] = SC_data_miner.Form_cd[0];
                            }
                            textset = text.split("#");
                            text = textset[0] + "\n" +
                                    "\n" +
                                    "--" + FName_def[n] + "\n" +
                                    "\n" +
                                    "MERGE INTO REG_REPORT_FORM R\n" +
                                    "   USING (SELECT \n" +
                                    "'"+ SC_data_miner.System_id[n] +"' as SYSTEM_ID, \n" +
                                    "'"+ SC_data_miner.Security_role_name[n] +"' as SECURITY_ROLE_NAME, \n" +
                                    "'"+ SC_data_miner.Security_role_path[n] +"' as SECURITY_ROLE_PATH, \n" +
                                    "'"+ SC_data_miner.Search_path[n] +"' as SEARCH_PATH, \n" +
                                    "'"+ SC_data_miner.Form_cd[n] +"' as FORM_CODE, \n" +
                                    "'"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, \n" +
                                    "'"+ SC_data_miner.Desc[n] +"' as DESCRIPTION, \n" +
                                    "" + iod + ", \n" +
                                    "" + pdn + "\n" +
                                    "FROM dual) S\n" +
                                    "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                                    "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                                    "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                                    "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                                    "                                R.FORM_CODE = S.FORM_CODE,\n" +
                                    "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                                    "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                                    "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                                    "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                                    "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                                    "\n" +
                                    okud_text +
                                    "INSERT INTO REPORT_FORM_SRC \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                                    "minus select * from REPORT_FORM_SRC;\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_REP_SUBJ_TYPE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                                    "minus select * from REPORT_REP_SUBJ_TYPE;" +
                                    "\n" +
                                    "\n" +
                                    "--#\n" +
                                    textset[1] + "\n" +
                                    "--" + FName_def[n] + "\n" +
                                    "\n" +
                                    "MERGE INTO REG_REPORT_FORM R\n" +
                                    "   USING (SELECT \n" +
                                    "'"+ SC_data_miner.System_id[n] +"' as SYSTEM_ID, \n" +
                                    "'"+ SC_data_miner.Security_role_name[n] +"' as SECURITY_ROLE_NAME, \n" +
                                    "'"+ SC_data_miner.Security_role_path[n] +"' as SECURITY_ROLE_PATH, \n" +
                                    "'"+ SC_data_miner.Search_path[n] +"' as SEARCH_PATH, \n" +
                                    "'"+ SC_data_miner.Form_cd[n] +"' as FORM_CODE, \n" +
                                    "'"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, \n" +
                                    "'"+ SC_data_miner.Desc[n] +"' as DESCRIPTION, \n" +
                                    "" + iod + ", \n" +
                                    "" + pdn + "\n" +
                                    "FROM dual) S\n" +
                                    "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                                    "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                                    "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                                    "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                                    "                                R.FORM_CODE = S.FORM_CODE,\n" +
                                    "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                                    "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                                    "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                                    "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                                    "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                                    "\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[n] +"' as OKUD_CODE, '"+ SC_data_miner.period[n] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n" +
                                    "\n" +
                                    "INSERT INTO  REPORT_FORM_SRC \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                                    "minus select * from REPORT_FORM_SRC;\n" +
                                    "\n" +
                                    "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                                    "minus select * from REPORT_REP_SUBJ_TYPE;" +
                                    "\n" +
                                    "\n" +
                                    "--#\n" +
                                    textset[2] + "\n" +
                                    "\n" +
                                    "--" + FName_def[n] + "\n" +
                                    "\n" +
                                    "MERGE INTO EHD_ACS_OBJECTS O\n" +
                                    "   USING (SELECT \n" +
                                    "'"+ FName_def[n] +"' as NAME,\n" +
                                    "   '"+ SC_data_miner.Form_formal_code[n] +"' as CODE,\n" +
                                    "  (select t.id from EHD_ACS_OBJECTS t where t.type_ref in ('forms','ko_ao','apl_ao','ko_av') and t.code='"+ SC_data_miner.Form_cd[n] +"') as PARENT_ID,\n" +
                                    "  '" + TR_def[n] + "' as TYPE_REF,\n" +
                                    "  '" + SR_def[n] + "' as SOURCE_REF,\n" +
                                    "  TO_DATE('" + format_sql.format(dateNow) + "', 'DD/MM/YY') as CREATE_DATE,\n" +
                                    "  null as UPDATE_DATE,\n" +
                                    "  '" + SC_data_miner.Search_path_for_ehd_acs[n] + "' as SEARCH_PATH,\n" +
                                    "  null as FLAG_EXP\n" +
                                    "FROM dual) S\n" +
                                    "   ON (O.CODE = S.CODE)\n" +
                                    "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                                    "                                O.PARENT_ID = S.PARENT_ID,\n" +
                                    "                                O.TYPE_REF = S.TYPE_REF,\n" +
                                    "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                                    "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                                    "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                                    "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                                    "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);" ;
                        }
            }
        } else if(chk==2 || chk==0){//Есть только 3 листа
            if(count == 0){
                if(SC_data_miner.Flag_IOD[0] == null){
                    iod = "null as FLAG_IOD";
                } else {
                    iod = "'"+ SC_data_miner.Flag_IOD[0] + "' as FLAG_IOD";
                }
                if(SC_data_miner.Flag_PDN[0] == null){
                    pdn = "null as FLAG_PDN";
                } else {
                    pdn = "'"+ SC_data_miner.Flag_PDN[0] + "' as FLAG_PDN";
                }
                System.out.print("\n iod = " + iod + "\n");
                System.out.print("pdn = " + pdn+ "\n");
                text =  "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "\n" +
                        "--DM_NIKA_KO\n" +
                        "\n" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "--TechDB_EHD_ACS\n" +
                        "\n" +
                        "MERGE INTO EHD_ACS_OBJECTS O\n" +
                        "   USING (SELECT \n" +
                        "'"+ FName_def[0] +"' as NAME,\n" +
                        "   '"+ SC_data_miner.Form_formal_code[0] +"' as CODE,\n" +
                        "  (select t.id from EHD_ACS_OBJECTS t where t.type_ref in ('forms','ko_ao','apl_ao','ko_av') and t.code='"+ SC_data_miner.Form_cd[0] +"') as PARENT_ID,\n" +
                        "  '" + TR_def[0] + "' as TYPE_REF,\n" +
                        "  '" + SR_def[0] + "' as SOURCE_REF,\n" +
                        "  TO_DATE('" + format_sql.format(dateNow) + "', 'DD/MM/YY') as CREATE_DATE,\n" +
                        "  null as UPDATE_DATE,\n" +
                        "  '" + SC_data_miner.Search_path_for_ehd_acs[0] + "' as SEARCH_PATH,\n" +
                        "  null as FLAG_EXP\n" +
                        "FROM dual) S\n" +
                        "   ON (O.CODE = S.CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
                        "                                O.TYPE_REF = S.TYPE_REF,\n" +
                        "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                        "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                        "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                        "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);";
            } else {
                if(SC_data_miner.Flag_IOD[0] == null){
                    iod = "null as FLAG_IOD";
                } else {
                    iod = "'"+ SC_data_miner.Flag_IOD[0] + "' as FLAG_IOD";
                }
                if(SC_data_miner.Flag_PDN[0] == null){
                    pdn = "null as FLAG_PDN";
                } else {
                    pdn = "'"+ SC_data_miner.Flag_PDN[0] + "' as FLAG_PDN";
                }
                System.out.print("\n iod = " + iod + "\n");
                System.out.print("pdn = " + pdn+ "\n");
                text ="--" + FName_def[0] +"\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "--#\n" +
                        "--DM_NIKA_KO\n" +
                        "\n" +
                        "MERGE INTO REG_REPORT_FORM R\n" +
                        "   USING (SELECT \n" +
                        "'"+ SC_data_miner.System_id[0] +"' as SYSTEM_ID, \n" +
                        "'"+ SC_data_miner.Security_role_name[0] +"' as SECURITY_ROLE_NAME, \n" +
                        "'"+ SC_data_miner.Security_role_path[0] +"' as SECURITY_ROLE_PATH, \n" +
                        "'"+ SC_data_miner.Search_path[0] +"' as SEARCH_PATH, \n" +
                        "'"+ SC_data_miner.Form_cd[0] +"' as FORM_CODE, \n" +
                        "'"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, \n" +
                        "'"+ SC_data_miner.Desc[0] +"' as DESCRIPTION, \n" +
                        "" + iod + ", \n" +
                        "" + pdn + "\n" +
                        "FROM dual) S\n" +
                        "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                        "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                        "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                R.FORM_CODE = S.FORM_CODE,\n" +
                        "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                        "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                        "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                        "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                        "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REPORT_OKUD_CODE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[0] +"' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                        "minus select * from REPORT_OKUD_CODE;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" +
                        "\n" +
                        "--#\n" +
                        "--TechDB_EHD_ACS\n" +
                        "\n" +
                        "MERGE INTO EHD_ACS_OBJECTS O\n" +
                        "   USING (SELECT \n" +
                        "'"+ FName_def[0] +"' as NAME,\n" +
                        "   '"+ SC_data_miner.Form_formal_code[0] +"' as CODE,\n" +
                        "  (select t.id from EHD_ACS_OBJECTS t where t.type_ref in ('forms','ko_ao','apl_ao','ko_av') and t.code='"+ SC_data_miner.Form_cd[0] +"') as PARENT_ID,\n" +
                        "  '" + TR_def[0] + "' as TYPE_REF,\n" +
                        "  '" + SR_def[0] + "' as SOURCE_REF,\n" +
                        "  TO_DATE('" + format_sql.format(dateNow) + "', 'DD/MM/YY') as CREATE_DATE,\n" +
                        "  null as UPDATE_DATE,\n" +
                        "  '" + SC_data_miner.Search_path_for_ehd_acs[0] + "' as SEARCH_PATH,\n" +
                        "  null as FLAG_EXP\n" +
                        "FROM dual) S\n" +
                        "   ON (O.CODE = S.CODE)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
                        "                                O.TYPE_REF = S.TYPE_REF,\n" +
                        "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                        "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                        "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                        "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);";
                String[] textset;
                for(int n = 1; n<=count; n++){
                    if (SC_data_miner.Form_cd[n] == null){
                        SC_data_miner.Form_cd[n] = SC_data_miner.Form_cd[0];
                    }
                    System.out.print("\n iod = " + iod + "\n");
                    System.out.print("pdn = " + pdn+ "\n");
                    textset = text.split("#");
                    text = textset[0] + "\n" +
                            "\n" +
                            "--" + FName_def[n] +"\n" +
                            "\n" +
                            "MERGE INTO REG_REPORT_FORM R\n" +
                            "   USING (SELECT \n" +
                            "'"+ SC_data_miner.System_id[n] +"' as SYSTEM_ID, \n" +
                            "'"+ SC_data_miner.Security_role_name[n] +"' as SECURITY_ROLE_NAME, \n" +
                            "'"+ SC_data_miner.Security_role_path[n] +"' as SECURITY_ROLE_PATH, \n" +
                            "'"+ SC_data_miner.Search_path[n] +"' as SEARCH_PATH, \n" +
                            "'"+ SC_data_miner.Form_cd[n] +"' as FORM_CODE, \n" +
                            "'"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, \n" +
                            "'"+ SC_data_miner.Desc[n] +"' as DESCRIPTION, \n" +
                            "" + iod + ", \n" +
                            "" + pdn + "\n" +
                            "FROM dual) S\n" +
                            "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                            "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                            "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                            "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                            "                                R.FORM_CODE = S.FORM_CODE,\n" +
                            "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                            "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                            "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                            "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                            "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                            "\n" +
                            "\n" +
                            "INSERT INTO REPORT_OKUD_CODE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[n] +"' as OKUD_CODE, '"+ SC_data_miner.period[n] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                            "minus select * from REPORT_OKUD_CODE;\n" +
                            "\n" +
                            "INSERT INTO  REPORT_FORM_SRC \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                            "minus select * from REPORT_FORM_SRC;\n" +
                            "\n" +
                            "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                            "minus select * from REPORT_REP_SUBJ_TYPE;" +
                            "\n" +
                            "--#\n" +
                            textset[1] + "\n" +
                            "--" + FName_def[n] +"\n" +
                            "\n" +
                            "MERGE INTO REG_REPORT_FORM R\n" +
                            "   USING (SELECT \n" +
                            "'"+ SC_data_miner.System_id[n] +"' as SYSTEM_ID, \n" +
                            "'"+ SC_data_miner.Security_role_name[n] +"' as SECURITY_ROLE_NAME, \n" +
                            "'"+ SC_data_miner.Security_role_path[n] +"' as SECURITY_ROLE_PATH, \n" +
                            "'"+ SC_data_miner.Search_path[n] +"' as SEARCH_PATH, \n" +
                            "'"+ SC_data_miner.Form_cd[n] +"' as FORM_CODE, \n" +
                            "'"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, \n" +
                            "'"+ SC_data_miner.Desc[n] +"' as DESCRIPTION, \n" +
                            "" + iod + ", \n" +
                            "" + pdn + "\n" +
                            "FROM dual) S\n" +
                            "   ON (R.FORM_FORMAL_CODE = S.FORM_FORMAL_CODE)\n" +
                            "   WHEN MATCHED THEN UPDATE SET R.SECURITY_ROLE_NAME = S.SECURITY_ROLE_NAME, \n" +
                            "                                R.SECURITY_ROLE_PATH = S.SECURITY_ROLE_PATH,\n" +
                            "                                R.SEARCH_PATH = S.SEARCH_PATH,\n" +
                            "                                R.FORM_CODE = S.FORM_CODE,\n" +
                            "                                R.DESCRIPTION = S.DESCRIPTION,\n" +
                            "                                R.FLAG_IOD = S.FLAG_IOD,\n" +
                            "                                R.FLAG_PDN = S.FLAG_PDN\n" +
                            "   WHEN NOT MATCHED THEN INSERT (R.SYSTEM_ID, R.SECURITY_ROLE_NAME, R.SECURITY_ROLE_PATH, R.SEARCH_PATH, R.FORM_CODE, R.FORM_FORMAL_CODE, R.DESCRIPTION, R.FLAG_IOD, R.FLAG_PDN)\n" +
                            "   VALUES (S.SYSTEM_ID, S.SECURITY_ROLE_NAME, S.SECURITY_ROLE_PATH, S.SEARCH_PATH, S.FORM_CODE, S.FORM_FORMAL_CODE, S.DESCRIPTION, S.FLAG_IOD, S.FLAG_PDN);\n" +
                            "\n" +
                            "\n" +
                            "INSERT INTO REPORT_OKUD_CODE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Form_okud[n] +"' as OKUD_CODE, '"+ SC_data_miner.period[n] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                            "minus select * from REPORT_OKUD_CODE;\n" +
                            "\n" +
                            "INSERT INTO  REPORT_FORM_SRC \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                            "minus select * from REPORT_FORM_SRC;\n" +
                            "\n" +
                            "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                            "minus select * from REPORT_REP_SUBJ_TYPE;" +
                            "\n" +
                            "--#\n" +
                            textset[2] + "\n" +
                            "\n" +
                            "--" + FName_def[n] +"\n" +
                            "\n" +
                            "MERGE INTO EHD_ACS_OBJECTS O\n" +
                            "   USING (SELECT \n" +
                            "'"+ FName_def[n] +"' as NAME,\n" +
                            "   '"+ SC_data_miner.Form_formal_code[n] +"' as CODE,\n" +
                            "  (select t.id from EHD_ACS_OBJECTS t where t.type_ref in ('forms','ko_ao','apl_ao','ko_av') and t.code='"+ SC_data_miner.Form_cd[n] +"') as PARENT_ID,\n" +
                            "  '" + TR_def[n] + "' as TYPE_REF,\n" +
                            "  '" + SR_def[n] + "' as SOURCE_REF,\n" +
                            "  TO_DATE('" + format_sql.format(dateNow) + "', 'DD/MM/YY') as CREATE_DATE,\n" +
                            "  null as UPDATE_DATE,\n" +
                            "  '" + SC_data_miner.Search_path_for_ehd_acs[n] + "' as SEARCH_PATH,\n" +
                            "  null as FLAG_EXP\n" +
                            "FROM dual) S\n" +
                            "   ON (O.CODE = S.CODE)\n" +
                            "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                            "                                O.PARENT_ID = S.PARENT_ID,\n" +
                            "                                O.TYPE_REF = S.TYPE_REF,\n" +
                            "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                            "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                            "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                            "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                            "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);";
                }
            }
        }

        String fileData = text;
        int j = path2.lastIndexOf("\\");
        path2 = path2.substring(0,j);
        System.out.print("path2 = " + path2);
        String filePath = path2 + "\\reg_Code_SQL.txt";
        File file = new File(filePath);
        if(isFileExists(file)){
            for(int i = 1; i<=50;){
                String filePath2 = path2 + "\\reg_Code_SQL(" + i + ").txt";
                File file2 = new File(filePath2);
                if(isFileExists((file2))){
                    i++;
                } else{
                    FileOutputStream fos = new FileOutputStream(path2 + "\\reg_Code_SQL(" + i + ").txt");
                    fos.write(fileData.getBytes());
                    fos.flush();
                    fos.close();
                    break;
                }
            }
        } else {
            FileOutputStream fos = new FileOutputStream(path2 + "\\reg_Code_SQL.txt");
            fos.write(fileData.getBytes());
            fos.flush();
            fos.close();
        }
    }
}

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ScriptEXP {
    String[] text = new String[4];
    String[] FName_def = new String[12];
    String[] Pid_def = new String[12];
    String[] TR_def = new String[12];
    String[] SR_def = new String[12];
    int count = 0;
    byte type = PreCreateScr.getType();

    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    public ScriptEXP(int chk, String path) throws IOException {
        Date dateNow = new Date();
        SimpleDateFormat format_sql = new SimpleDateFormat("dd/MM/yy");
        String path2 = path;
        String iod = "";
        String pdn = "";
        String okud_rep_form = "";
        String techdb_code = "";

        for(int u = 0; u<=11; u++){
        FName_def[u] = CreateSc.UFName[0];
        TR_def[u] = "cognos";
        SR_def[u] = "cognos";
        if(chk != 3){
            Pid_def[u] = "null";
         }
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
            if(chk!=3){
                if(CreateSc.TR[0] != null)
                    TR_def[0] = CreateSc.TR[0];
                if(CreateSc.SR[0] != null)
                    SR_def[0] = CreateSc.SR[0];
            } else{
                if(SC_data_miner.p_type_ref_txtf[0] != null)
                    TR_def[0] = SC_data_miner.p_type_ref_txtf[0];
                if(SC_data_miner.p_source_ref_txtf[0] != null)
                    SR_def[0] = SC_data_miner.p_source_ref_txtf[0];
            }

        } else {
            for(int q = 0; q<=count; q++){
                if(CreateSc.UFName[q] != null)
                    FName_def[q] = CreateSc.UFName[q];
                //if(PreCreateSc.Pid[q] != null)
                    //Pid_def[q] = PreCreateSc.Pid[q];
                if(chk!=3){
                    if(CreateSc.TR[q] != null)
                        TR_def[q] = CreateSc.TR[q];
                    if(CreateSc.SR[q] != null)
                        SR_def[q] = CreateSc.SR[q];
                } else{
                    if(SC_data_miner.p_type_ref_txtf[q] != null)
                        TR_def[q] = SC_data_miner.p_type_ref_txtf[q];
                    if(SC_data_miner.p_source_ref_txtf[q] != null)
                        SR_def[q] = SC_data_miner.p_source_ref_txtf[q];
                }
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
                //System.out.print("\nl = " + l + "\n");

                if(SC_data_miner.Form_cd[0].startsWith("0409")){
                    okud_rep_form = "null as FORM_OKUD";
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                } else {
                    okud_rep_form = "'"+ SC_data_miner.Form_okud[0] + "' as FORM_OKUD";
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                }
                text[0] =  "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
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
                        "\n" + "commit;";
                text[1] = "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--DM_NIKA_KO\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
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
                        "\n" + "commit;";

                text[2] = "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" + "commit;";
                text[3] = "--" + FName_def[0] +"\n" +
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
                        "   ON (O.CODE = S.CODE AND O.TYPE_REF = S.TYPE_REF)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
                        "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                        "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                        "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                        "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" + "commit;" ;

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
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                } else {
                    okud_rep_form = "'"+ SC_data_miner.Form_okud[0] + "' as FORM_OKUD";
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                }
                text[0] = "--" + FName_def[0] + "\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
                        "\n" +
                        "\n" +
                        "--№\n" +
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
                        "\n" + "commit;";
                text[1] = "--" + FName_def[0] + "\n" +
                        "\n" +
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
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
                        "\n" +
                        "\n" +
                        "--№\n" +
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
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" + "commit;";
                text[2] = "--" + FName_def[0] + "\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" + "commit;";
                text[3] = "--" + FName_def[0] + "\n" +
                        "\n" +"--TechDB_EHD_ACS\n" +
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
                        "   ON (O.CODE = S.CODE AND O.TYPE_REF = S.TYPE_REF)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
                        "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                        "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                        "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                        "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" + "commit;" ;
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
                        String[] okud_text = new String[10];
                        for(int r = 0; r<=9; r++){
                            okud_text[r] = "";
                        }
                        //System.out.print("\nkol2 = " + kol2);
                        if(kol2 !=0){
                            String[][] okud_pair = new String[count+1][kol2+2];
                            for(int q = 0; q<=count; q++){
                                okud_pair[q][0] = SC_data_miner.Form_formal_code[q];
                                //System.out.print("\nokud_pair[" + q + "][0] = " + okud_pair[q][0]);
                                int y = 1;
                                for(int i = 0; i<=kol2; i++){
                                    if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                        okud_pair[q][y] = SC_data_miner.Form_okud[i];
                                        y++;
                                        //System.out.print("\nokud_pair[" + q + "][" + y + "] = " + okud_pair[q][y]);
                                    }
                                }
                            }
                            int[] kol3 = new int[10];
                            for(int jh=0; jh<=9; jh++){
                                kol3[jh] = 0;
                            }
                            for(int q = 0; q<=count; q++){
                                for(int i = 0; i<=kol2; i++){
                                    //System.out.print("\nSC_data_miner.okud_form_cd[" +  i  + "] = " + SC_data_miner.okud_form_cd[i]);
                                    //System.out.print("\nSC_data_miner.Form_formal_code[" +  q  + "] = " + SC_data_miner.Form_formal_code[q]);
                                    if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                        kol3[q]++;
                                    }
                                }
                            }
                            //System.out.print("\nkol3[0] = " + kol3[0]);
                            for(int u = 0; u<=1; u++){
                                for(int w = 2; w <= kol3[0]; w++){
                                    textset2 = text[u].split("&");
                                    //System.out.print("\ntextset2[0] = " + textset2[0]);
                                    //System.out.print("\ntextset2[1] = " + textset2[1]);
                                    text[u] = textset2[0] + "\n" +
                                            "\n" +
                                            "INSERT INTO REPORT_OKUD_CODE \n" +
                                            "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '" + okud_pair[0][w] + "' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                            "minus select * from REPORT_OKUD_CODE;\n" +
                                            "--&" +
                                            textset2[1];

                                }

                            }


                            //System.out.print("\ntext2 = " + text);
                            for(int q = 0; q<=count; q++){
                                for(int i = 0; i<=kol2; i++){
                                    if (i == kol3[q]){
                                     break;
                                    }
                                    okud_text[q] = okud_text[q] + "\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[q] +"' as FORM_FORMAL_CODE, '" + okud_pair[q][i+1] + "' as OKUD_CODE, '"+ SC_data_miner.period[i] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n";
                                }
                                //System.out.print("\nokud_text[" + q + "] = " + okud_text[q]);
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
                            for(int u = 0; u<=1; u++){
                                for(int h = 1; h<=kol;h++){
                                    textset1 = text[u].split("№");
                                    //System.out.print("\ntextset1[0] = " + textset1[0]);
                                    //System.out.print("\ntextset1[1] = " + textset1[1]);
                                    text[u] = textset1[0] + "\n" +
                                            "\n" +
                                            "INSERT INTO REP_FORM_DEP_USER\n" +
                                            "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_u_name[h] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                                            "minus select * from REP_FORM_DEP_USER;\n" +
                                            "--№\n" +
                                            textset1[1];
                                }
                            }

                        }
                        //System.out.print("\ntext3 = " + text);
                        for(int n = 1; n<=count; n++){
                            if (SC_data_miner.Form_cd[n] == null){
                                SC_data_miner.Form_cd[n] = SC_data_miner.Form_cd[0];
                            }
                            //textset = text.split("#");
                            text[0] = text[0] + "\n" +
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
                                    okud_text[n] +
                                    "\n" +
                                    "INSERT INTO REPORT_FORM_SRC \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                                    "minus select * from REPORT_FORM_SRC;\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_REP_SUBJ_TYPE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                                    "minus select * from REPORT_REP_SUBJ_TYPE;" +
                                    "\n" +
                                    "\n" + "commit;";
                            text[1] = text[1] + "\n" +
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
                                    okud_text[n] +
                                    "\n" +
                                    "INSERT INTO  REPORT_FORM_SRC \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                                    "minus select * from REPORT_FORM_SRC;\n" +
                                    "\n" +
                                    "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                                    "minus select * from REPORT_REP_SUBJ_TYPE;" +
                                    "\n" +
                                    "\n" + "commit;";
                            text[3] = text[3] + "\n" +
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
                                    "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" + "commit;";
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
                //System.out.print("\n iod = " + iod + "\n");
                //System.out.print("pdn = " + pdn+ "\n");
                text[0] =  "--" + FName_def[0] +"\n" +
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
                        "\n" + "commit;";
                text[1] = "--" + FName_def[0] +"\n" +
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
                        "\n" + "commit;";
                /*text[2] = "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n";*/
                text[3] = "--" + FName_def[0] +"\n" +
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
                        "   ON (O.CODE = S.CODE AND O.TYPE_REF = S.TYPE_REF)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
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
                //System.out.print("\n iod = " + iod + "\n");
                //System.out.print("pdn = " + pdn+ "\n");
                text[0] = "--" + FName_def[0] +"\n" +
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
                        "--&" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" + "commit;";
                text[1] = "--" + FName_def[0] +"\n" +
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
                        "--&" +
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" + "commit;";
                /*text[2] = "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Rep_form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n";*/
                text[3] = "--" + FName_def[0] +"\n" +
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
                        "   ON (O.CODE = S.CODE AND O.TYPE_REF = S.TYPE_REF)\n" +
                        "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                        "                                O.PARENT_ID = S.PARENT_ID,\n" +
                        "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                        "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                        "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                        "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                        "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" + "commit;";
                String[] textset;
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
                String[] okud_text = new String[10];
                for(int r = 0; r<=9; r++){
                    okud_text[r] = "";
                }
                //System.out.print("\nkol2 = " + kol2);
                if(kol2 !=0){
                    String[][] okud_pair = new String[count+1][kol2+2];
                    for(int q = 0; q<=count; q++){
                        okud_pair[q][0] = SC_data_miner.Form_formal_code[q];
                        //System.out.print("\nokud_pair[" + q + "][0] = " + okud_pair[q][0]);
                        int y = 1;
                        for(int i = 0; i<=kol2; i++){
                            if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                okud_pair[q][y] = SC_data_miner.Form_okud[i];
                                y++;
                                //System.out.print("\nokud_pair[" + q + "][" + (y) + "] = " + okud_pair[q][y]);
                            }
                        }
                    }
                    int[] kol3 = new int[10];
                    for(int jh=0; jh<=9; jh++){
                        kol3[jh] = 0;
                    }
                    for(int q = 0; q<=count; q++){
                        for(int i = 0; i<=kol2; i++){
                            //System.out.print("\nSC_data_miner.okud_form_cd[" +  i  + "] = " + SC_data_miner.okud_form_cd[i]);
                            //System.out.print("\nSC_data_miner.Form_formal_code[" +  q  + "] = " + SC_data_miner.Form_formal_code[q]);
                            if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                kol3[q]++;
                            }
                        }
                    }
                    //System.out.print("\nkol3[0] = " + kol3[0]);
                    for(int u = 0; u<=1; u++){
                        for(int w = 2; w <= kol3[0]; w++){
                            textset = text[u].split("&");
                            text[u] = textset[0] + "\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '" + okud_pair[0][w] + "' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n" +
                                    "--&" +
                                    textset[1] +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '" + okud_pair[0][w] + "' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n" +
                                    "--&" +
                                    textset[2];

                        }

                    }
                    //System.out.print("\ntext2 = " + text);
                    for(int q = 0; q<=count; q++){
                        for(int i = 0; i<=kol2; i++){
                            if (i == kol3[q]){
                                break;
                            }
                            okud_text[q] = okud_text[q] + "\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[q] +"' as FORM_FORMAL_CODE, '" + okud_pair[q][i+1] + "' as OKUD_CODE, '"+ SC_data_miner.period[i] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n";
                        }
                        //System.out.print("\nokud_text[" + q + "] = " + okud_text[q]);
                    }

                }

                for(int n = 1; n<=count; n++){
                    if (SC_data_miner.Form_cd[n] == null){
                        SC_data_miner.Form_cd[n] = SC_data_miner.Form_cd[0];
                    }
                    //System.out.print("\n iod = " + iod + "\n");
                    //System.out.print("pdn = " + pdn+ "\n");
                    //textset = text.split("#");
                    text[0] = text[0] + "\n" +
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
                            okud_text[n] +
                            "\n" +
                            "INSERT INTO  REPORT_FORM_SRC \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                            "minus select * from REPORT_FORM_SRC;\n" +
                            "\n" +
                            "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                            "minus select * from REPORT_REP_SUBJ_TYPE;" +
                            "\n" + "commit;";
                    text[1] = text[1] + "\n" +
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
                            okud_text[n] +
                            "\n" +
                            "INSERT INTO  REPORT_FORM_SRC \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                            "minus select * from REPORT_FORM_SRC;\n" +
                            "\n" +
                            "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                            "minus select * from REPORT_REP_SUBJ_TYPE;" +
                            "\n" + "commit;";
                    text[3] = text[3] + "\n" +
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
                            "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" + "commit;";
                }
            }
        } else if (chk == 3){//Руной режим
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
                //System.out.print("\nl = " + l + "\n");

                if(SC_data_miner.Form_cd[0].startsWith("0409")){
                    okud_rep_form = "null as FORM_OKUD";
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                } else {
                    okud_rep_form = "'"+ SC_data_miner.Form_okud[0] + "' as FORM_OKUD";
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                }
                text[0] =  "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
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
                        "\n" + "commit;";
                text[1] = "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--DM_NIKA_KO\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
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
                        "\n" + "commit;";

                text[2] = "--" + FName_def[0] +"\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\n" + "commit;";

                if(type == 0){
                    text[3] = "--" + FName_def[0] +"\n" +
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
                            "   ON (O.CODE = S.CODE AND O.TYPE_REF = S.TYPE_REF)\n" +
                            "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                            "                                O.PARENT_ID = S.PARENT_ID,\n" +
                            "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                            "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                            "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                            "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                            "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" + "commit;" ;
                } else if(type == 1){
                    text[3] = "--" + FName_def[0] +"\n" +
                            "\n" +
                            "--TechDB_EHD_ACS\n" +
                            "\n" +
                            "begin\n" +
                            "utils.add_object_node\n" +
                            "                            (p_name => '" + SC_data_miner.Form_name[0] + "'\n" +
                            "                            ,p_code => '" + SC_data_miner.Form_cd[0] + "'\n" +
                            "                            ,p_parent_code => '" + SC_data_miner.p_parent_code_txtf[0] + "' --родительский элемент (код доступа)\n" +
                            "                            ,p_parent_type_ref =>'" + SC_data_miner.p_parent_type_ref_txtf[0] + "'\n" +
                            "                            ,p_type_ref => '" + SC_data_miner.p_type_ref_txtf[0] + "'\n" +
                            "                            ,p_source_ref => '" + SC_data_miner.p_source_ref_txtf[0] + "'\n" +
                            "                            ,p_search_path => '" + SC_data_miner.Search_path[0] + "\n" +
                            ");\n" +
                            "                    end;\n" +
                            "/";
                }

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
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                } else {
                    okud_rep_form = "'"+ SC_data_miner.Form_okud[0] + "' as FORM_OKUD";
                    //System.out.print("\nokud_rep_form = " + okud_rep_form + "\n");
                    //System.out.print("SC_data_miner.Form_cd[0].startsWith(\"0409\") = " + SC_data_miner.Form_cd[0].startsWith("0409"));
                }
                text[0] = "--" + FName_def[0] + "\n" +
                        "\n" +
                        "--OAD_SECURITY\n" +
                        "\n" +
                        "INSERT INTO REP_FORM \n" +
                        "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Form_name[0] +"' as FORM_NAME, " + okud_rep_form + " FROM dual\n" +
                        "minus select * from REP_FORM;" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
                        "\n" +
                        "\n" +
                        "--№\n" +
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
                        "\n" + "commit;";
                text[1] = "--" + FName_def[0] + "\n" +
                        "\n" +
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
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
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
                        "minus select * from REP_FORM_DEP_USER;" +
                        "\n" +
                        "\n" +
                        "--№\n" +
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
                        "\n" +
                        "INSERT INTO  REPORT_FORM_SRC \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[0] +"' as REG_FORM_CODE FROM dual\n" +
                        "minus select * from REPORT_FORM_SRC;\n" +
                        "\n" +
                        "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                        "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[0] +"' as REP_SUBJ_TYPE FROM dual\n" +
                        "minus select * from REPORT_REP_SUBJ_TYPE;" +
                        "\n" + "commit;";
                text[2] = "--" + FName_def[0] + "\n" +
                        "\n" +
                        "--DM_NIKA_KO_DATA\n" +
                        "\n" +
                        "\n" +
                        "INSERT INTO REP_FORM_COGNOS\n" +
                        "SELECT '"+ SC_data_miner.Form_cd_cog[0] +"' as FORM_CD, '"+ SC_data_miner.Form_cd[0] + "' as REP_FORM_CD FROM dual\n" +
                        "minus select * from REP_FORM_COGNOS;" +
                        "\ncommit;";
                if(type == 0){
                    text[3] = "--" + FName_def[0] +"\n" +
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
                            "   ON (O.CODE = S.CODE AND O.TYPE_REF = S.TYPE_REF)\n" +
                            "   WHEN MATCHED THEN UPDATE SET O.NAME = S.NAME,\n" +
                            "                                O.PARENT_ID = S.PARENT_ID,\n" +
                            "                                O.SOURCE_REF = S.SOURCE_REF,\n" +
                            "                                O.SEARCH_PATH = S.SEARCH_PATH,\n" +
                            "                                O.FLAG_EXP = S.FLAG_EXP\n" +
                            "   WHEN NOT MATCHED THEN INSERT (O.NAME, O.CODE, O.PARENT_ID, O.TYPE_REF, O.SOURCE_REF, O.CREATE_DATE, O.UPDATE_DATE, O.SEARCH_PATH, O.FLAG_EXP)\n" +
                            "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" +
                    "commit;";
                } else if(type == 1){
                    text[3] = "--" + FName_def[0] +"\n" +
                            "\n" +
                            "--TechDB_EHD_ACS\n" +
                            "\n" +
                            "begin\n" +
                            "utils.add_object_node\n" +
                            "                            (p_name => '" + SC_data_miner.Form_name[0] + "'\n" +
                            "                            ,p_code => '" + SC_data_miner.Form_cd[0] + "'\n" +
                            "                            ,p_parent_code => '" + SC_data_miner.p_parent_code_txtf[0] + "' --родительский элемент (код доступа)\n" +
                            "                            ,p_parent_type_ref =>'" + SC_data_miner.p_parent_type_ref_txtf[0] + "'\n" +
                            "                            ,p_type_ref => '" + SC_data_miner.p_type_ref_txtf[0] + "'\n" +
                            "                            ,p_source_ref => '" + SC_data_miner.p_source_ref_txtf[0] + "'\n" +
                            "                            ,p_search_path => '" + SC_data_miner.Search_path[0] + "\n" +
                            ");\n" +
                            "                    end;\n" +
                            "/";
                }
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
                String[] okud_text = new String[10];
                for(int r = 0; r<=9; r++){
                    okud_text[r] = "";
                }
                //System.out.print("\nkol2 = " + kol2);
                if(kol2 !=0){
                    String[][] okud_pair = new String[count+1][kol2+2];
                    for(int q = 0; q<=count; q++){
                        okud_pair[q][0] = SC_data_miner.Form_formal_code[q];
                        //System.out.print("\nokud_pair[" + q + "][0] = " + okud_pair[q][0]);
                        int y = 1;
                        for(int i = 0; i<=kol2; i++){
                            if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                okud_pair[q][y] = SC_data_miner.Form_okud[i];
                                y++;
                                //System.out.print("\nokud_pair[" + q + "][" + y + "] = " + okud_pair[q][y]);
                            }
                        }
                    }
                    int[] kol3 = new int[10];
                    for(int jh=0; jh<=9; jh++){
                        kol3[jh] = 0;
                    }
                    for(int q = 0; q<=count; q++){
                        for(int i = 0; i<=kol2; i++){
                            //System.out.print("\nSC_data_miner.okud_form_cd[" +  i  + "] = " + SC_data_miner.okud_form_cd[i]);
                            //System.out.print("\nSC_data_miner.Form_formal_code[" +  q  + "] = " + SC_data_miner.Form_formal_code[q]);
                            if(Objects.equals(SC_data_miner.okud_form_cd[i], SC_data_miner.Form_formal_code[q])){
                                kol3[q]++;
                            }
                        }
                    }
                    //System.out.print("\nkol3[0] = " + kol3[0]);
                    for(int u = 0; u<=1; u++){
                        for(int w = 2; w <= kol3[0]; w++){
                            textset2 = text[u].split("&");
                            //System.out.print("\ntextset2[0] = " + textset2[0]);
                            //System.out.print("\ntextset2[1] = " + textset2[1]);
                            text[u] = textset2[0] + "\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[0] +"' as FORM_FORMAL_CODE, '" + okud_pair[0][w] + "' as OKUD_CODE, '"+ SC_data_miner.period[0] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n" +
                                    "--&" +
                                    textset2[1];

                        }

                    }


                    //System.out.print("\ntext2 = " + text);
                    for(int q = 0; q<=count; q++){
                        for(int i = 0; i<=kol2; i++){
                            if (i == kol3[q]){
                                break;
                            }
                            okud_text[q] = okud_text[q] + "\n" +
                                    "\n" +
                                    "INSERT INTO REPORT_OKUD_CODE \n" +
                                    "SELECT '"+ SC_data_miner.Form_formal_code[q] +"' as FORM_FORMAL_CODE, '" + okud_pair[q][i+1] + "' as OKUD_CODE, '"+ SC_data_miner.period[i] +"'as PERIOD, null as FORM_CD FROM dual\n" +
                                    "minus select * from REPORT_OKUD_CODE;\n";
                        }
                        //System.out.print("\nokud_text[" + q + "] = " + okud_text[q]);
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
                    for(int u = 0; u<=1; u++){
                        for(int h = 1; h<=kol;h++){
                            textset1 = text[u].split("№");
                            //System.out.print("\ntextset1[0] = " + textset1[0]);
                            //System.out.print("\ntextset1[1] = " + textset1[1]);
                            text[u] = textset1[0] + "\n" +
                                    "\n" +
                                    "INSERT INTO REP_FORM_DEP_USER\n" +
                                    "SELECT '"+ SC_data_miner.Form_cd[0] +"' as FORM_CD, '"+ SC_data_miner.Dep_u_name[h] +"' as DEP_NAME, '"+ SC_data_miner.reason[0] +"'as REASON FROM dual\n" +
                                    "minus select * from REP_FORM_DEP_USER;\n" +
                                    "--№\n" +
                                    textset1[1];
                        }
                    }

                }
                //System.out.print("\ntext3 = " + text);
                for(int n = 1; n<=count; n++){
                    if (SC_data_miner.Form_cd[n] == null){
                        SC_data_miner.Form_cd[n] = SC_data_miner.Form_cd[0];
                    }
                    //textset = text.split("#");
                    text[0] = text[0] + "\n" +
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
                            okud_text[n] +
                            "\n" +
                            "INSERT INTO REPORT_FORM_SRC \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                            "minus select * from REPORT_FORM_SRC;\n" +
                            "\n" +
                            "INSERT INTO REPORT_REP_SUBJ_TYPE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                            "minus select * from REPORT_REP_SUBJ_TYPE;" +
                            "\n" +
                    "commit;";
                    text[1] = text[1] + "\n" +
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
                            okud_text[n] +
                            "\n" +
                            "INSERT INTO  REPORT_FORM_SRC \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.Reg_form_code[n] +"' as REG_FORM_CODE FROM dual\n" +
                            "minus select * from REPORT_FORM_SRC;\n" +
                            "\n" +
                            "INSERT INTO  REPORT_REP_SUBJ_TYPE \n" +
                            "SELECT '"+ SC_data_miner.Form_formal_code[n] +"' as FORM_FORMAL_CODE, '"+ SC_data_miner.rep_subj_type[n] +"' as REP_SUBJ_TYPE FROM dual\n" +
                            "minus select * from REPORT_REP_SUBJ_TYPE;" +
                            "\n" +
                    "commit;";
                    if(type == 0){
                        text[3] = text[3] + "\n" +
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
                                "   VALUES (S.NAME, S.CODE, S.PARENT_ID, S.TYPE_REF, S.SOURCE_REF, S.CREATE_DATE, S.UPDATE_DATE, S.SEARCH_PATH, S.FLAG_EXP);\n" +
                        "commit;";
                    } else if(type == 1){
                        text[3] = "--" + FName_def[n] +"\n" +
                                "\n" +
                                "--TechDB_EHD_ACS\n" +
                                "\n" +
                                "begin\n" +
                                "utils.add_object_node\n" +
                                "                            (p_name => '" + SC_data_miner.Form_name[n] + "'\n" +
                                "                            ,p_code => '" + SC_data_miner.Form_cd[n] + "'\n" +
                                "                            ,p_parent_code => '" + SC_data_miner.p_parent_code_txtf[n] + "' --родительский элемент (код доступа)\n" +
                                "                            ,p_parent_type_ref =>'" + SC_data_miner.p_parent_type_ref_txtf[n] + "'\n" +
                                "                            ,p_type_ref => '" + SC_data_miner.p_type_ref_txtf[n] + "'\n" +
                                "                            ,p_source_ref => '" + SC_data_miner.p_source_ref_txtf[n] + "'\n" +
                                "                            ,p_search_path => '" + SC_data_miner.Search_path[n] + "\n" +
                                ");\n" +
                                "                    end;\n" +
                                "/";
                    }
                    
                }
            }

        }

        String fileData1 = text[0];
        String fileData2 = text[1];
        String fileData3 = text[2];
        String fileData4 = text[3];
        if(chk !=3){
            int j = path2.lastIndexOf("\\");
            path2 = path2.substring(0,j);
            //System.out.print("path2 = " + path2);
        }
        SimpleDateFormat format_2 = new SimpleDateFormat("yyyyMMdd");
        String filePath1 = path2 + "\\V004_" + format_2.format(dateNow) + "_202000_01__reg_" + SC_data_miner.Form_cd[0] + "_OAD_SECURITY.sql";
        String filePath2 = path2 + "\\V001_" + format_2.format(dateNow) + "_202000_0001__DM_DM_NIKA_KO_sc__reg_meta_" + SC_data_miner.Form_cd[0] + ".sql";
        String filePath3 = path2 + "\\V001_" + format_2.format(dateNow) + "_202000_0002__DM_DM_NIKA_KO_DATA_sc__reg_meta_" + SC_data_miner.Form_cd[0] + ".sql";
        String filePath4 = path2 + "\\V004_" + format_2.format(dateNow) + "_202000_01__reg_" + SC_data_miner.Form_cd[0] + "_TechDB_EHD_ACS.sql";

        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        File file3 = new File(filePath3);
        File file4 = new File(filePath4);
        if(isFileExists(file1)){
            for(int i = 1; i<=50;){
                String filePath12 = path2 + "\\V004_" + format_2.format(dateNow) + "_202000_01__reg_" + SC_data_miner.Form_cd[0] + "_OAD_SECURITY(" + i + ").sql";
                File file12 = new File(filePath12);
                if(isFileExists((file12))){
                    i++;
                } else{
                    FileOutputStream fos = new FileOutputStream(filePath12);
                    fos.write(fileData1.getBytes());
                    fos.flush();
                    fos.close();
                    break;
                }
            }
        } else {
            FileOutputStream fos = new FileOutputStream(filePath1);
            fos.write(fileData1.getBytes());
            fos.flush();
            fos.close();
        }
        if(isFileExists(file2)){
            for(int i = 1; i<=50;){
                String filePath22 = path2 + "\\V001_" + format_2.format(dateNow) + "_202000_0001__DM_DM_NIKA_KO_sc__reg_meta_" + SC_data_miner.Form_cd[0] + "(" + i + ").sql";
                File file22 = new File(filePath22);
                if(isFileExists((file22))){
                    i++;
                } else{
                    FileOutputStream fos = new FileOutputStream(filePath22);
                    fos.write(fileData2.getBytes());
                    fos.flush();
                    fos.close();
                    break;
                }
            }
        } else {
            FileOutputStream fos = new FileOutputStream(filePath2);
            fos.write(fileData2.getBytes());
            fos.flush();
            fos.close();
        }
        if(chk ==1){
            if(isFileExists(file3)){
                for(int i = 1; i<=50;){
                    String filePath32 = path2 + "\\V001_" + format_2.format(dateNow) + "_202000_0002__DM_DM_NIKA_KO_DATA_sc__reg_meta_" + SC_data_miner.Form_cd[0] + "(" + i + ").sql";
                    File file32 = new File(filePath32);
                    if(isFileExists((file32))){
                        i++;
                    } else{
                        FileOutputStream fos = new FileOutputStream(filePath32);
                        fos.write(fileData3.getBytes());
                        fos.flush();
                        fos.close();
                        break;
                    }
                }
            } else {
                FileOutputStream fos = new FileOutputStream(filePath3);
                fos.write(fileData3.getBytes());
                fos.flush();
                fos.close();
            }
        }
        if(isFileExists(file4)){
            for(int i = 1; i<=50;){
                String filePath42 = path2 + "\\V004_" + format_2.format(dateNow) + "_202000_01__reg_" + SC_data_miner.Form_cd[0] + "_TechDB_EHD_ACS(" + i + ").sql";
                File file42 = new File(filePath42);
                if(isFileExists((file42))){
                    i++;
                } else{
                    FileOutputStream fos = new FileOutputStream(filePath42);
                    fos.write(fileData4.getBytes());
                    fos.flush();
                    fos.close();
                    break;
                }
            }
        } else {
            FileOutputStream fos = new FileOutputStream(filePath4);
            fos.write(fileData4.getBytes());
            fos.flush();
            fos.close();
        }
    }
}

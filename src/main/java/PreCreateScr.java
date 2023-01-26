import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PreCreateScr {
    public int count;
    public String path_fld;
    public Stage mnf;
    public AnchorPane main_root;
    public Button resetBtn;
    public TextField[] Form_name_txtf;
    public TextField[] Form_cd_txtf;
    public TextField[] Form_cd_name_txtf;
    public TextField[] Form_okud_txtf;
    public TextField[] Form_cd_cog_txtf;
    public ComboBox<String>[] Flag_IOD_cmbx;
    public ComboBox<String>[] Flag_PDN_cmbx;
    public TextField[] Dep_name_txtf;
    public TextField[] Dep_name2_txtf;
    public TextField[] Dep_name3_txtf;
    public TextField[] Dep_name4_txtf;
    public TextField[] Dep_name5_txtf;
    public TextField[] Dep_name6_txtf;
    public TextField[] Dep_name7_txtf;
    public TextField[] Dep_name8_txtf;
    public TextField[] Dep_u_name_txtf;
    public TextField[] Dep_u_name2_txtf;
    public TextField[] Dep_u_name3_txtf;
    public TextField[] Dep_u_name4_txtf;
    public TextField[] Dep_u_name5_txtf;
    public TextField[] Dep_u_name6_txtf;
    public TextField[] Dep_u_name7_txtf;
    public TextField[] Dep_u_name8_txtf;
    public TextField[] reason_txtf;
    public TextField[] System_id_txtf;
    public TextField[] Security_role_path_txtf;
    public TextField[] Search_path_txtf;
    public TextField[] Form_formal_code_txtf;
    public TextField[] Desc_txtf;
    public ComboBox<String>[] period_cmbx;
    public ComboBox<String>[] rep_subj_type_cmbx;
    public TextField[] p_parent_code_txtf;
    public TextField[] p_parent_type_ref_txtf;
    public TextField[] p_type_ref_txtf;
    public TextField[] p_source_ref_txtf;
    public TextField[] Security_role_name_txtf;
    public static String[] UFName = new String[12];
    private static byte type = 0;

    public PreCreateScr(int count, String path_fld, Stage mnf, AnchorPane main_root, Button resetBtn, TextField[] form_name_txtf, TextField[] form_cd_txtf, TextField[] form_cd_name_txtf, TextField[] form_okud_txtf,
                        TextField[] form_cd_cog_txtf, ComboBox<String>[] flag_iod_cmbx, ComboBox<String>[] flag_pdn_cmbx, TextField[] dep_name_txtf,
                        TextField[] dep_name2_txtf, TextField[] dep_name3_txtf, TextField[] dep_name4_txtf, TextField[] dep_name5_txtf, TextField[] dep_name6_txtf, TextField[] dep_name7_txtf, TextField[] dep_name8_txtf,
                        TextField[] dep_u_name_txtf, TextField[] dep_u_name2_txtf, TextField[] dep_u_name3_txtf, TextField[] dep_u_name4_txtf, TextField[] dep_u_name5_txtf, TextField[] dep_u_name6_txtf, TextField[] dep_u_name7_txtf, TextField[] dep_u_name8_txtf,
                        TextField[] reason_txtf, TextField[] system_id_txtf,
                        TextField[] security_role_path_txtf, TextField[] search_path_txtf, TextField[] form_formal_code_txtf, TextField[] desc_txtf, ComboBox<String>[] period_cmbx, ComboBox<String>[] rep_subj_type_cmbx,
                        TextField[] p_parent_code_txtf, TextField[] p_parent_type_ref_txtf, TextField[] p_type_ref_txtf, TextField[] p_source_ref_txtf, TextField[] security_role_name_txtf) {
        this.count = count-1;
        this.path_fld = path_fld;
        this.mnf = mnf;
        this.main_root = main_root;
        this.resetBtn = resetBtn;
        this.Form_name_txtf = form_name_txtf;
        this.Form_cd_txtf = form_cd_txtf;
        this.Form_cd_name_txtf = form_cd_name_txtf;
        this.Form_okud_txtf = form_okud_txtf;
        this.Form_cd_cog_txtf = form_cd_cog_txtf;
        this.Flag_IOD_cmbx = flag_iod_cmbx;
        this.Flag_PDN_cmbx = flag_pdn_cmbx;
        this.Dep_name_txtf = dep_name_txtf;
        this.Dep_name2_txtf = dep_name2_txtf;
        this.Dep_name3_txtf = dep_name3_txtf;
        this.Dep_name4_txtf = dep_name4_txtf;
        this.Dep_name5_txtf = dep_name5_txtf;
        this.Dep_name6_txtf = dep_name6_txtf;
        this.Dep_name7_txtf = dep_name7_txtf;
        this.Dep_name8_txtf = dep_name8_txtf;
        this.Dep_u_name_txtf = dep_u_name_txtf;
        this.Dep_u_name2_txtf = dep_u_name2_txtf;
        this.Dep_u_name3_txtf = dep_u_name3_txtf;
        this.Dep_u_name4_txtf = dep_u_name4_txtf;
        this.Dep_u_name5_txtf = dep_u_name5_txtf;
        this.Dep_u_name6_txtf = dep_u_name6_txtf;
        this.Dep_u_name7_txtf = dep_u_name7_txtf;
        this.Dep_u_name8_txtf = dep_u_name8_txtf;
        this.reason_txtf = reason_txtf;
        this.System_id_txtf = system_id_txtf;
        this.Security_role_path_txtf = security_role_path_txtf;
        this.Search_path_txtf = search_path_txtf;
        this.Form_formal_code_txtf = form_formal_code_txtf;
        this.Desc_txtf = desc_txtf;
        this.period_cmbx = period_cmbx;
        this.rep_subj_type_cmbx = rep_subj_type_cmbx;
        this.p_parent_code_txtf = p_parent_code_txtf;
        this.p_parent_type_ref_txtf = p_parent_type_ref_txtf;
        this.p_type_ref_txtf = p_type_ref_txtf;
        this.p_source_ref_txtf = p_source_ref_txtf;
        this.Security_role_name_txtf = security_role_name_txtf;
        PreCreateScr_go();
    }
    public void PreCreateScr_go(){
        for(int i=0;i<=count;){
            UFName[i] = Form_name_txtf[i].getText();
            SC_data_miner.Form_cd_name[i] = Form_cd_name_txtf[i].getText();
            SC_data_miner.Form_cd[i] = Form_cd_txtf[i].getText();
            SC_data_miner.Form_name[i] = Form_name_txtf[i].getText();
            SC_data_miner.Form_okud[i] = Form_okud_txtf[i].getText();
            SC_data_miner.okud_form_cd[i] = Form_okud_txtf[i].getText();
            SC_data_miner.Form_cd_cog[i]  = Form_cd_cog_txtf[i].getText();
            //SC_data_miner.Rep_form_cd[i] = Form_cd_txtf[i].getText();
            SC_data_miner.Flag_IOD[i] = Flag_IOD_cmbx[i].getValue();
            SC_data_miner.Flag_PDN[i] = Flag_PDN_cmbx[i].getValue();
            SC_data_miner.Dep_name[i] = Dep_name_txtf[i].getText();
            SC_data_miner.Dep_name2[i] = Dep_name2_txtf[i].getText();
            SC_data_miner.Dep_name3[i] = Dep_name3_txtf[i].getText();
            SC_data_miner.Dep_name4[i] = Dep_name4_txtf[i].getText();
            SC_data_miner.Dep_name5[i] = Dep_name5_txtf[i].getText();
            SC_data_miner.Dep_name6[i] = Dep_name6_txtf[i].getText();
            SC_data_miner.Dep_name7[i] = Dep_name7_txtf[i].getText();
            SC_data_miner.Dep_name8[i] = Dep_name8_txtf[i].getText();
            SC_data_miner.Dep_u_name[i] = Dep_u_name_txtf[i].getText();
            SC_data_miner.Dep_u_name2[i] = Dep_u_name2_txtf[i].getText();
            SC_data_miner.Dep_u_name3[i] = Dep_u_name3_txtf[i].getText();
            SC_data_miner.Dep_u_name4[i] = Dep_u_name4_txtf[i].getText();
            SC_data_miner.Dep_u_name5[i] = Dep_u_name5_txtf[i].getText();
            SC_data_miner.Dep_u_name6[i] = Dep_u_name6_txtf[i].getText();
            SC_data_miner.Dep_u_name7[i] = Dep_u_name7_txtf[i].getText();
            SC_data_miner.Dep_u_name8[i] = Dep_u_name8_txtf[i].getText();
            SC_data_miner.reason[i] = reason_txtf[i].getText();
            //SC_data_miner.Reg_form_code[i] = Form_cd_txtf[i].getText();
            SC_data_miner.Form_formal_code[i] = Form_formal_code_txtf[i].getText();
            SC_data_miner.Desc[i] = Desc_txtf[i].getText();
            SC_data_miner.period[i] = period_cmbx[i].getValue();
            SC_data_miner.rep_subj_type[i] = rep_subj_type_cmbx[i].getValue();
            SC_data_miner.p_parent_code_txtf[i] =  p_parent_code_txtf[i].getText();
            SC_data_miner.p_parent_type_ref_txtf[i] =  p_parent_type_ref_txtf[i].getText();
            SC_data_miner.p_type_ref_txtf[i] =  p_type_ref_txtf[i].getText();
            SC_data_miner.p_source_ref_txtf[i] = p_source_ref_txtf[i].getText();
            SC_data_miner.System_id[i] = System_id_txtf[i].getText();
            SC_data_miner.Security_role_name[i] = Security_role_name_txtf[i].getText();
            SC_data_miner.Security_role_path[i] = Security_role_path_txtf[i].getText();
            SC_data_miner.Search_path[i] = Search_path_txtf[i].getText();
            SC_data_miner.Search_path_for_ehd_acs[i] = Search_path_txtf[i].getText();

            if(SC_data_miner.p_parent_code_txtf[i] != null && SC_data_miner.p_type_ref_txtf[i] != null && SC_data_miner.p_source_ref_txtf[i] != null && SC_data_miner.p_parent_type_ref_txtf[i] != null){
                type = 1;
            } else{
                type = 0;
            }
            i++;
        }

        try {
            new ScriptEXP(3, path_fld);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Скрипты созданы");
        dialog.setHeaderText("SUCCESS!!!");
        DialogPane dialogPane = dialog.getDialogPane();
        //dialog.setGraphic(new ImageView(createImage(16, 16, Color.BLUE)));
        dialog.setContentText("Скрипты успешно созданы и находятся по казанному Вами пути");
        dialogPane.getButtonTypes().add(ButtonType.OK);
        dialog.show();

        resetBtn.setDisable(false);
        resetBtn.setVisible(true);
    }
    public static byte getType(){
        return PreCreateScr.type;
    }
}

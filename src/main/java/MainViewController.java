import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainViewController {
    @FXML
    private Label lab1;
    @FXML
    private Label devlab;
    @FXML
    private TextField txt_fld1;
    @FXML
    private ComboBox<String> cmbx1;
    @FXML
    private Stage primaryStage;
    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtf1;
    @FXML
    private Button Browse;
    @FXML
    private Button ChckBtn1;
    @FXML
    private Button resetBtn;
    @FXML
    private Button ScrBtn3;
    @FXML
    private ComboBox<Integer> countCmbx;
    @FXML
    private Label countLbl;
    @FXML
    private Label pathLbl;
    @FXML
    private TextField pathTxtf;
    @FXML
    private Button fldchs_btn;
    @FXML
    private Button OK_btn;
    @FXML
    private Button createBtn;

    private static byte type = 0;


    public void MainViewController(ActionEvent actionEvent) {
        primaryStage = SCJFXApp.getPrimaryStage();
        root = SCJFXApp.getRoot();
        //txt_fld1.setText("action perfomed");
        if (Objects.equals(cmbx1.getValue(), "Из файла")){
            fromFile();
        }else if(Objects.equals(cmbx1.getValue(), "Ручной(В разработке)")){
            fromManual();
        } else {
            devlab.setVisible(true);
        }
    }
    public void fromFile(){
        devlab.setVisible(false);
        cmbx1.setDisable(true);
        lab1.setVisible(true);
        txtf1.setVisible(true);
        txtf1.setDisable(false);
        Browse.setVisible(true);
        Browse.setDisable(false);
        ChckBtn1.setVisible(true);
        primaryStage.setWidth(1020);
        primaryStage.setHeight(300);
    }
    public void fromManual(){
        cmbx1.setDisable(true);
        countLbl.setVisible(true);
        pathLbl.setVisible(true);
        countCmbx.setVisible(true);
        pathTxtf.setVisible(true);
        fldchs_btn.setVisible(true);
        countCmbx.setDisable(false);
        pathTxtf.setDisable(false);
        fldchs_btn.setDisable(false);
        primaryStage.setWidth(1020);
        primaryStage.setHeight(300);
    }

    public void BrowseClicked(){
        new BrowseAction(txt_fld1, primaryStage, ChckBtn1, txtf1);
        txtf1.setDisable(true);
        resetBtn.setVisible(true);
        resetBtn.setDisable(false);

    }
    public void CheckClicked(){
        Browse.setDisable(true);
        File file1 = BrowseAction.getFile();
        String fname1 = BrowseAction.getFName1();
        String path_u = BrowseAction.getPath_u();
        new CheckAction(file1, fname1, path_u, primaryStage, root, ScrBtn3);
        ChckBtn1.setDisable(true);
        txt_fld1.setDisable(true);
    }
    public void CreateClicked(){
        int count = CheckAction.getCount();
        String path_u1 = CheckAction.getPath_u1();
        Stage mnf = CheckAction.getMnf();
        AnchorPane root = CheckAction.getRoot();

        if(count == 0){
            TextField txtf_Sys_id = CheckAction.getTxtf_Sys_id();
            TextField txtf_Sec_R_N = CheckAction.getTxtf_Sec_R_N();
            TextField txtf_Sec_R_P = CheckAction.getTxtf_Sec_R_P();
            TextField txtf_SearchPath = CheckAction.getTxtf_SearchPath();
            TextField txtf_NAME = CheckAction.getTxtf_NAME();
            TextField txtf_TF = CheckAction.getTxtf_TF();
            TextField txtf_SR = CheckAction.getTxtf_SR();
            TextField txtf_SearchPath2 = CheckAction.getTxtf_SearchPath2();
            new CreateSc(path_u1, mnf, root, txtf_Sys_id, txtf_Sec_R_N, txtf_Sec_R_P, txtf_SearchPath, txtf_SearchPath2,  txtf_NAME, txtf_TF, txtf_SR, resetBtn);
        } else {
            TextField[] txtf_Sys_id_set = CheckAction.getTxtf_Sys_id_set();
            TextField[] txtf_Sec_R_N_set = CheckAction.getTxtf_Sec_R_N_set();
            TextField[] txtf_Sec_R_P_set = CheckAction.getTxtf_Sec_R_P_set();
            TextField[] txtf_SearchPath_set = CheckAction.getTxtf_SearchPath_set();
            TextField[] txtf_NAME_set = CheckAction.getTxtf_NAME_set();
            TextField[] txtf_TF_set = CheckAction.getTxtf_TF_set();
            TextField[] txtf_SR_set = CheckAction.getTxtf_SR_set();
            TextField[] txtf_SearchPath2_set = CheckAction.getTxtf_SearchPath2_set();
            new CreateSc(path_u1, mnf, root, txtf_Sys_id_set, txtf_Sec_R_N_set, txtf_Sec_R_P_set, txtf_SearchPath_set, txtf_SearchPath2_set,  txtf_NAME_set, txtf_TF_set, txtf_SR_set, resetBtn);
        }
    }
    public void CreateClicked2() throws IOException {
        int count = countCmbx.getValue();
        String path_fld = BrowseFldAction.getPath_fld();
        //Stage mnf = primaryStage;
        //AnchorPane main_root = root;
        TextField[] Form_name_txtf = new TextField[12];
        TextField[] Form_cd_txtf = new TextField[12];
        TextField[] Form_cd_name_txtf = new TextField[12];
        TextField[] Form_okud_txtf = new TextField[12];
        TextField[] Form_cd_cog_txtf = new TextField[12];
        TextField[] Flag_IOD_txtf = new TextField[12];
        TextField[] Flag_PDN_txtf = new TextField[12];
        TextField[] Dep_name_txtf = new TextField[12];
        TextField[] Dep_u_name_txtf = new TextField[12];
        TextField[] reason_txtf = new TextField[12];
        TextField[] System_id_txtf = new TextField[12];
        TextField[] Security_role_path_txtf = new TextField[12];
        TextField[] Search_path_txtf = new TextField[12];
        TextField[] Form_formal_code_txtf = new TextField[12];
        TextField[] Desc_txtf = new TextField[12];
        TextField[] period_txtf = new TextField[12];
        TextField[] rep_subj_type_txtf = new TextField[12];
        TextField[] p_parent_code_txtf = new TextField[12];
        TextField[] p_parent_type_ref_txtf = new TextField[12];
        TextField[] p_type_ref_txtf = new TextField[12];
        TextField[] p_source_ref_txtf = new TextField[12];
        TextField[] Security_role_name_txtf = new TextField[12];

        Form_name_txtf = OK_Action.getForm_name_txtf();
        Form_cd_txtf =  OK_Action.getForm_cd_txtf();
        Form_cd_name_txtf =  OK_Action.getForm_cd_name_txtf();
        Form_okud_txtf =  OK_Action.getForm_okud_txtf();
        Form_cd_cog_txtf =  OK_Action.getForm_cd_cog_txtf();
        Flag_IOD_txtf =  OK_Action.getFlag_IOD_txtf();
        Flag_PDN_txtf =  OK_Action.getFlag_PDN_txtf();
        Dep_name_txtf =  OK_Action.getDep_name_txtf();
        Dep_u_name_txtf =  OK_Action.getDep_u_name_txtf();
        reason_txtf =  OK_Action.getReason_txtf();
        System_id_txtf =  OK_Action.getSystem_id_txtf();
        Security_role_path_txtf =  OK_Action.getSecurity_role_path_txtf();
        Search_path_txtf =  OK_Action.getSearch_path_txtf();
        Form_formal_code_txtf =  OK_Action.getForm_formal_code_txtf();
        Desc_txtf =  OK_Action.getDesc_txtf();
        period_txtf =  OK_Action.getPeriod_txtf();
        rep_subj_type_txtf =  OK_Action.getRep_subj_type_txtf();
        p_parent_code_txtf =  OK_Action.getP_parent_code_txtf();
        p_parent_type_ref_txtf =  OK_Action.getP_parent_type_ref_txtf();
        p_type_ref_txtf =  OK_Action.getP_type_ref_txtf();
        p_source_ref_txtf =  OK_Action.getP_source_ref_txtf();
        Security_role_name_txtf =  OK_Action.getSecurity_role_name_txtf();

        if(count == 1){
             CreateSc.UFName[0] = Form_name_txtf[0].getText();
             SC_data_miner.Form_cd[0] = Form_cd_txtf[0].getText();
             SC_data_miner.Form_name[0] = Form_cd_name_txtf[0].getText();
             SC_data_miner.Form_okud[0] = Form_okud_txtf[0].getText();
             SC_data_miner.Form_cd_cog[0] = Form_cd_cog_txtf[0].getText();
             SC_data_miner.Flag_IOD[0] = Flag_IOD_txtf[0].getText();
             SC_data_miner.Flag_PDN[0] = Flag_PDN_txtf[0].getText();
             SC_data_miner.Dep_name[0] = Dep_name_txtf[0].getText();
             SC_data_miner.Dep_u_name[0] = Dep_u_name_txtf[0].getText();
             SC_data_miner.reason[0] = reason_txtf[0].getText();
             SC_data_miner.System_id[0] = System_id_txtf[0].getText();
             SC_data_miner.Security_role_name[0] = Security_role_name_txtf[0].getText();
             SC_data_miner.Security_role_path[0] = Security_role_path_txtf[0].getText();
             SC_data_miner.Search_path[0] = Search_path_txtf[0].getText();
             SC_data_miner.Search_path_for_ehd_acs[0] = Search_path_txtf[0].getText();
             SC_data_miner.Form_formal_code[0] = Form_formal_code_txtf[0].getText();
             SC_data_miner.Desc[0] = Desc_txtf[0].getText();
             SC_data_miner.period[0] = period_txtf[0].getText();
             SC_data_miner.rep_subj_type[0] = rep_subj_type_txtf[0].getText();
             SC_data_miner.p_parent_code_txtf[0] = p_parent_code_txtf[0].getText();
             SC_data_miner.p_type_ref_txtf[0] = p_type_ref_txtf[0].getText();
             SC_data_miner.p_source_ref_txtf[0] = p_source_ref_txtf[0].getText();
             SC_data_miner.p_parent_type_ref_txtf[0] = p_parent_type_ref_txtf[0].getText();
             if(SC_data_miner.p_parent_code_txtf[0] != null && SC_data_miner.p_type_ref_txtf[0] != null && SC_data_miner.p_source_ref_txtf[0] != null && SC_data_miner.p_parent_type_ref_txtf[0] != null){
                 type = 1;
             } else{
                 type = 0;
             }
        } else {
            for(int k=1; k<=count; k++){
                CreateSc.UFName[k] = Form_name_txtf[k].getText();
                SC_data_miner.Form_cd[k] = Form_cd_txtf[k].getText();
                SC_data_miner.Form_name[k] = Form_cd_name_txtf[k].getText();
                SC_data_miner.Form_okud[k] = Form_okud_txtf[k].getText();
                SC_data_miner.Form_cd_cog[k] = Form_cd_cog_txtf[k].getText();
                SC_data_miner.Flag_IOD[k] = Flag_IOD_txtf[k].getText();
                SC_data_miner.Flag_PDN[k] = Flag_PDN_txtf[k].getText();
                SC_data_miner.Dep_name[k] = Dep_name_txtf[k].getText();
                SC_data_miner.Dep_u_name[k] = Dep_u_name_txtf[k].getText();
                SC_data_miner.reason[k] = reason_txtf[k].getText();
                SC_data_miner.System_id[k] = System_id_txtf[k].getText();
                SC_data_miner.Security_role_name[k] = Security_role_name_txtf[k].getText();
                SC_data_miner.Security_role_path[k] = Security_role_path_txtf[k].getText();
                SC_data_miner.Search_path[k] = Search_path_txtf[k].getText();
                SC_data_miner.Search_path_for_ehd_acs[k] = Search_path_txtf[k].getText();
                SC_data_miner.Form_formal_code[k] = Form_formal_code_txtf[k].getText();
                SC_data_miner.Desc[k] = Desc_txtf[k].getText();
                SC_data_miner.period[k] = period_txtf[k].getText();
                SC_data_miner.rep_subj_type[k] = rep_subj_type_txtf[k].getText();
                SC_data_miner.p_parent_code_txtf[k] = p_parent_code_txtf[k].getText();
                SC_data_miner.p_type_ref_txtf[k] = p_type_ref_txtf[k].getText();
                SC_data_miner.p_source_ref_txtf[k] = p_source_ref_txtf[k].getText();
                SC_data_miner.p_parent_type_ref_txtf[k] = p_parent_type_ref_txtf[k].getText();
                if(SC_data_miner.p_parent_code_txtf[k] != null && SC_data_miner.p_type_ref_txtf[k] != null && SC_data_miner.p_source_ref_txtf[k] != null && SC_data_miner.p_parent_type_ref_txtf[k] != null){
                    type = 1;
                } else{
                    type = 0;
                }
            }
        }
        new ScriptEXP(3, path_fld);

    }
    public void ResetClicked(){
        TabPane sp = CheckAction.getSp();
        root.getChildren().remove(sp);
        lab1.setVisible(false);
        txtf1.setVisible(false);
        txtf1.setText("C:");
        txt_fld1.clear();
        Browse.setVisible(false);
        ChckBtn1.setVisible(false);
        resetBtn.setVisible(false);
        resetBtn.setDisable(true);
        ScrBtn3.setVisible(false);
        ScrBtn3.setDisable(true);
        cmbx1.setValue("");
        cmbx1.setDisable(false);
        txt_fld1.setText("");
        txt_fld1.setDisable(false);
        primaryStage.setWidth(520);
        primaryStage.setHeight(240);
        Stage mnf = primaryStage;
        new ResetAction(mnf);
        devlab.setVisible(false);
    }
    public void BrowseFldClicked(){
        new BrowseFldAction (pathTxtf, primaryStage, OK_btn);
        pathTxtf.setDisable(true);
        cmbx1.setDisable(true);
        txt_fld1.setDisable(true);
    }
    public void OKClicked(){
        int count = countCmbx.getValue();
        System.out.print("count = " + count);
        if(count !=0 || pathTxtf.getText() != null || !Objects.equals(pathTxtf.getText(), "")){
            new OK_Action (count, root, primaryStage, createBtn);
            OK_btn.setDisable(true);
            countCmbx.setDisable(true);
            fldchs_btn.setDisable(true);

        } else {
            Dialog<ButtonType> dialog = new Dialog<ButtonType>();
            dialog.setTitle("Ошибка");
            dialog.setHeaderText("ERROR!!!");
            DialogPane dialogPane = dialog.getDialogPane();
            dialog.setContentText("Пожалуйста, проверьте выбранное кол-во и путь для сохранения");
            dialogPane.getButtonTypes().add(ButtonType.OK);
            dialog.show();
        }
    }

    public static byte getType(){
        return MainViewController.type;
    }
}
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
    @FXML
    private Button resetBtn2;
    public void MainViewController(ActionEvent actionEvent) {
        primaryStage = SCJFXApp.getPrimaryStage();
        root = SCJFXApp.getRoot();
        //txt_fld1.setText("action perfomed");
        if (Objects.equals(cmbx1.getValue(), "Из файла")){
            fromFile();
        }else if(Objects.equals(cmbx1.getValue(), "Ручной")){
            fromManual();
        }
    }
    public void fromFile(){
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
    public void ResetClicked(){
        TabPane sp = CheckAction.getSp();
        Stage mnf = primaryStage;
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
        new ResetAction(mnf);
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
    public void BrowseFldClicked(){
        new BrowseFldAction (pathTxtf, primaryStage, OK_btn);
        pathTxtf.setDisable(true);
        cmbx1.setDisable(true);
        txt_fld1.setDisable(true);
    }
    public void OKClicked(){
        int count = countCmbx.getValue();
        System.out.print("count = " + count + "\n");
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
    public void CreateClicked2() throws IOException {
        int count = countCmbx.getValue();
        String path_fld = BrowseFldAction.getPath_fld();
        Stage mnf = primaryStage;
        AnchorPane main_root = root;
        Button resetBtn = resetBtn2;

        TextField[] Form_name_txtf = OK_Action.getForm_name_txtf();
        TextField[] Form_cd_txtf =  OK_Action.getForm_cd_txtf();
        TextField[] Form_cd_name_txtf =  OK_Action.getForm_cd_name_txtf();
        TextField[] Form_okud_txtf =  OK_Action.getForm_okud_txtf();
        TextField[] Form_okud2_txtf =  OK_Action.getForm_okud2_txtf();
        TextField[] Form_okud3_txtf =  OK_Action.getForm_okud3_txtf();
        TextField[] Form_okud4_txtf =  OK_Action.getForm_okud4_txtf();
        TextField[] Form_okud5_txtf =  OK_Action.getForm_okud5_txtf();
        TextField[] Form_okud6_txtf =  OK_Action.getForm_okud6_txtf();
        TextField[] Form_okud7_txtf =  OK_Action.getForm_okud7_txtf();
        TextField[] Form_okud8_txtf =  OK_Action.getForm_okud8_txtf();
        TextField[] Form_cd_cog_txtf =  OK_Action.getForm_cd_cog_txtf();
        ComboBox<String>[] Flag_IOD_cmbx =  OK_Action.getFlag_IOD_cmbx();
        ComboBox<String>[] Flag_PDN_cmbx =  OK_Action.getFlag_PDN_cmbx();
        TextField[] Dep_name_txtf =  OK_Action.getDep_name_txtf();
        TextField[] Dep_name2_txtf =  OK_Action.getDep_name2_txtf();
        TextField[] Dep_name3_txtf =  OK_Action.getDep_name3_txtf();
        TextField[] Dep_name4_txtf =  OK_Action.getDep_name4_txtf();
        TextField[] Dep_name5_txtf =  OK_Action.getDep_name5_txtf();
        TextField[] Dep_name6_txtf =  OK_Action.getDep_name6_txtf();
        TextField[] Dep_name7_txtf =  OK_Action.getDep_name7_txtf();
        TextField[] Dep_name8_txtf =  OK_Action.getDep_name8_txtf();
        TextField[] Dep_u_name_txtf =  OK_Action.getDep_u_name_txtf();
        TextField[] Dep_u_name2_txtf =  OK_Action.getDep_u_name2_txtf();
        TextField[] Dep_u_name3_txtf =  OK_Action.getDep_u_name3_txtf();
        TextField[] Dep_u_name4_txtf =  OK_Action.getDep_u_name4_txtf();
        TextField[] Dep_u_name5_txtf =  OK_Action.getDep_u_name5_txtf();
        TextField[] Dep_u_name6_txtf =  OK_Action.getDep_u_name6_txtf();
        TextField[] Dep_u_name7_txtf =  OK_Action.getDep_u_name7_txtf();
        TextField[] Dep_u_name8_txtf =  OK_Action.getDep_u_name8_txtf();
        TextField[] reason_txtf =  OK_Action.getReason_txtf();
        TextField[] System_id_txtf =  OK_Action.getSystem_id_txtf();
        TextField[] Security_role_path_txtf =  OK_Action.getSecurity_role_path_txtf();
        TextField[] Search_path_txtf =  OK_Action.getSearch_path_txtf();
        TextField[] Form_formal_code_txtf =  OK_Action.getForm_formal_code_txtf();
        TextField[] Desc_txtf =  OK_Action.getDesc_txtf();
        ComboBox<String>[] period_cmbx =  OK_Action.getPeriod_cmbx();
        ComboBox<String>[] period2_cmbx =  OK_Action.getPeriod2_cmbx();
        ComboBox<String>[] period3_cmbx =  OK_Action.getPeriod3_cmbx();
        ComboBox<String>[] period4_cmbx =  OK_Action.getPeriod4_cmbx();
        ComboBox<String>[] period5_cmbx =  OK_Action.getPeriod5_cmbx();
        ComboBox<String>[] period6_cmbx =  OK_Action.getPeriod6_cmbx();
        ComboBox<String>[] period7_cmbx =  OK_Action.getPeriod7_cmbx();
        ComboBox<String>[] period8_cmbx =  OK_Action.getPeriod8_cmbx();
        ComboBox<String>[] rep_subj_type_cmbx =  OK_Action.getRep_subj_type_cmbx();
        ComboBox<String>[] rep_subj_type2_cmbx =  OK_Action.getRep_subj_type2_cmbx();
        ComboBox<String>[] rep_subj_type3_cmbx =  OK_Action.getRep_subj_type3_cmbx();
        ComboBox<String>[] rep_subj_type4_cmbx =  OK_Action.getRep_subj_type4_cmbx();
        ComboBox<String>[] rep_subj_type5_cmbx =  OK_Action.getRep_subj_type5_cmbx();
        ComboBox<String>[] rep_subj_type6_cmbx =  OK_Action.getRep_subj_type6_cmbx();
        ComboBox<String>[] rep_subj_type7_cmbx =  OK_Action.getRep_subj_type7_cmbx();
        ComboBox<String>[] rep_subj_type8_cmbx =  OK_Action.getRep_subj_type8_cmbx();
        TextField[] p_parent_code_txtf =  OK_Action.getP_parent_code_txtf();
        TextField[] p_parent_type_ref_txtf =  OK_Action.getP_parent_type_ref_txtf();
        TextField[] p_type_ref_txtf =  OK_Action.getP_type_ref_txtf();
        TextField[] p_source_ref_txtf =  OK_Action.getP_source_ref_txtf();
        TextField[] Security_role_name_txtf =  OK_Action.getSecurity_role_name_txtf();

        new PreCreateScr(count, path_fld, mnf, main_root, resetBtn, Form_name_txtf, Form_cd_txtf, Form_cd_name_txtf,
                Form_okud_txtf, Form_okud2_txtf, Form_okud3_txtf, Form_okud4_txtf, Form_okud5_txtf, Form_okud6_txtf, Form_okud7_txtf, Form_okud8_txtf,
                Form_cd_cog_txtf, Flag_IOD_cmbx, Flag_PDN_cmbx,
                Dep_name_txtf, Dep_name2_txtf, Dep_name3_txtf, Dep_name4_txtf, Dep_name5_txtf, Dep_name6_txtf, Dep_name7_txtf, Dep_name8_txtf,
                Dep_u_name_txtf, Dep_u_name2_txtf, Dep_u_name3_txtf, Dep_u_name4_txtf, Dep_u_name5_txtf, Dep_u_name6_txtf, Dep_u_name7_txtf, Dep_u_name8_txtf,
                reason_txtf, System_id_txtf, Security_role_path_txtf, Search_path_txtf, Form_formal_code_txtf, Desc_txtf,
                period_cmbx, period2_cmbx, period3_cmbx, period4_cmbx, period5_cmbx, period6_cmbx, period7_cmbx, period8_cmbx,
                rep_subj_type_cmbx, rep_subj_type2_cmbx, rep_subj_type3_cmbx, rep_subj_type4_cmbx, rep_subj_type5_cmbx, rep_subj_type6_cmbx, rep_subj_type7_cmbx, rep_subj_type8_cmbx,
                p_parent_code_txtf, p_parent_type_ref_txtf,
                p_type_ref_txtf, p_source_ref_txtf, Security_role_name_txtf);
    }
    public void ResetClicked2(){
        TabPane sp = OK_Action.getSp();
        Stage mnf = primaryStage;
        root.getChildren().remove(sp);
        createBtn.setVisible(false);
        OK_btn.setVisible(false);
        fldchs_btn.setVisible(false);
        countLbl.setVisible(false);
        pathLbl.setVisible(false);
        countCmbx.setVisible(false);
        pathTxtf.setVisible(false);
        resetBtn2.setVisible(false);
        createBtn.setDisable(true);
        OK_btn.setDisable(true);
        fldchs_btn.setDisable(true);
        countCmbx.setDisable(true);
        pathTxtf.setDisable(true);
        resetBtn2.setDisable(true);
        cmbx1.setDisable(false);
        txt_fld1.setDisable(false);
        cmbx1.setValue("");
        txt_fld1.setText("");
        primaryStage.setWidth(520);
        primaryStage.setHeight(240);
        new ResetAction(mnf);
    }


}
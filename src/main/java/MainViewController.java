import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
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
    public Button ScrBtn3;
    @FXML
    private Label form_cd_lbl;
    @FXML
    private Label form_cd_name_lbl;
    @FXML
    private Label OKUD_lbl;
    @FXML
    private Label form_cd_cog_lbl;
    @FXML
    private Label Flag_IOD_lbl;
    @FXML
    private Label Flag_PDN_lbl;
    @FXML
    private Label Dep_name_lbl;
    @FXML
    private Label Dep_u_name_lbl;
    @FXML
    private Label reason_lbl;
    @FXML
    private Label System_id_lbl;
    @FXML
    private Label Security_role_path_lbl;
    @FXML
    private Label Search_path_lbl;
    @FXML
    private Label Form_formal_code_lbl;
    @FXML
    private Label Desc_lbl;
    @FXML
    private Label period_lbl;
    @FXML
    private Label rep_subj_type_lbl;
    @FXML
    private Label p_parent_code_lbl;
    @FXML
    private Label p_parent_type_ref_lbl;
    @FXML
    private Label p_type_ref_lbl;
    @FXML
    private Label p_source_ref_lbl;
    @FXML
    private Label Security_role_name_lbl;
    @FXML
    private TextField Form_cd_txtf;
    @FXML
    private TextField Form_cd_name_txtf;
    @FXML
    private TextField Form_okud_txtf;
    @FXML
    private TextField Form_cd_cog_txtf;
    @FXML
    private TextField Flag_IOD_txtf;
    @FXML
    private TextField Flag_PDN_txtf;
    @FXML
    private TextField Dep_name_txtf;
    @FXML
    private TextField Dep_u_name_txtf;
    @FXML
    private TextField reason_txtf;
    @FXML
    private TextField System_id_txtf;
    @FXML
    private TextField Security_role_path_txtf;
    @FXML
    private TextField Search_path_txtf;
    @FXML
    private TextField Form_formal_code_txtf;
    @FXML
    private TextField Desc_txtf;
    @FXML
    private TextField period_txtf;
    @FXML
    private TextField rep_subj_type_txtf;
    @FXML
    private TextField p_parent_code_txtf;
    @FXML
    private TextField p_parent_type_ref_txtf;
    @FXML
    private TextField p_type_ref_txtf;
    @FXML
    private TextField p_source_ref_txtf;
    @FXML
    private TextField Security_role_name_txtf;


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
    public void fromManual(){
        cmbx1.setDisable(true);
        form_cd_lbl.setVisible(true);
        form_cd_name_lbl.setVisible(true);
        OKUD_lbl.setVisible(true);
        form_cd_cog_lbl.setVisible(true);
        Flag_IOD_lbl.setVisible(true);
        Flag_PDN_lbl.setVisible(true);
        Dep_name_lbl.setVisible(true);
        Dep_u_name_lbl.setVisible(true);
        reason_lbl.setVisible(true);
        System_id_lbl.setVisible(true);
        Security_role_path_lbl.setVisible(true);
        Search_path_lbl.setVisible(true);
        Form_formal_code_lbl.setVisible(true);
        Desc_lbl.setVisible(true);
        period_lbl.setVisible(true);
        rep_subj_type_lbl.setVisible(true);
        p_parent_code_lbl.setVisible(true);
        p_parent_type_ref_lbl.setVisible(true);
        p_type_ref_lbl.setVisible(true);
        p_source_ref_lbl.setVisible(true);
        Security_role_name_lbl.setVisible(true);
        Form_cd_txtf.setVisible(true);
        Form_cd_name_txtf.setVisible(true);
        Form_okud_txtf.setVisible(true);
        Form_cd_cog_txtf.setVisible(true);
        Flag_IOD_txtf.setVisible(true);
        Flag_PDN_txtf.setVisible(true);
        Dep_name_txtf.setVisible(true);
        Dep_u_name_txtf.setVisible(true);
        reason_txtf.setVisible(true);
        System_id_txtf.setVisible(true);
        Security_role_path_txtf.setVisible(true);
        Search_path_txtf.setVisible(true);
        Form_formal_code_txtf.setVisible(true);
        Desc_txtf.setVisible(true);
        period_txtf.setVisible(true);
        rep_subj_type_txtf.setVisible(true);
        p_parent_code_txtf.setVisible(true);
        p_parent_type_ref_txtf.setVisible(true);
        p_type_ref_txtf.setVisible(true);
        p_source_ref_txtf.setVisible(true);
        Security_role_name_txtf.setVisible(true);
        Form_cd_txtf.setDisable(false);
        Form_cd_name_txtf.setDisable(false);
        Form_okud_txtf.setDisable(false);
        Form_cd_cog_txtf.setDisable(false);
        Flag_IOD_txtf.setDisable(false);
        Flag_PDN_txtf.setDisable(false);
        Dep_name_txtf.setDisable(false);
        Dep_u_name_txtf.setDisable(false);
        reason_txtf.setDisable(false);
        System_id_txtf.setDisable(false);
        Security_role_path_txtf.setDisable(false);
        Search_path_txtf.setDisable(false);
        Form_formal_code_txtf.setDisable(false);
        Desc_txtf.setDisable(false);
        period_txtf.setDisable(false);
        rep_subj_type_txtf.setDisable(false);
        p_parent_code_txtf.setDisable(false);
        p_parent_type_ref_txtf.setDisable(false);
        p_type_ref_txtf.setDisable(false);
        p_source_ref_txtf.setDisable(false);
        Security_role_name_txtf.setDisable(false);
        primaryStage.setWidth(1020);
        primaryStage.setHeight(700);
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
        }
        else {
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
    }
    /*public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }*/
}
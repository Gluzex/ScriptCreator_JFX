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
    public void CreateClicked2(){
        int count = countCmbx.getValue();
        String path_fld = BrowseFldAction.getPath_fld();
        Stage mnf = primaryStage;
        AnchorPane main_root = root;

        if(count == 1){
            //SC_data_miner.Form_cd =;

        } else {
            for(int k=1; k<=count; k++){

            }
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
        if(count !=0 || pathTxtf.getText() != null || pathTxtf.getText() != ""){
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
}
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class MainViewController {
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

    public void MainViewController(ActionEvent actionEvent) {
        primaryStage = SCJFXApp.getPrimaryStage();
        root = SCJFXApp.getRoot();
        //txt_fld1.setText("action perfomed");
        if (Objects.equals(cmbx1.getValue(), "Из файла")){
            System.out.print("if is ok");
            fromFile();
        }
    }
    public void fromFile(){
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

    }
    public void CheckClicked(){
        File file1 = BrowseAction.getFile();
        String fname1 = BrowseAction.getFName1();
        String path_u = BrowseAction.getPath_u();
        new CheckAction(file1, fname1, path_u, primaryStage, root);
    }
    public void CreateClicked(){
        int count = CheckAction.getCount();
        String path_u1 = CheckAction.getPath_u1();
        Stage mnf = CheckAction.getMnf();
        AnchorPane root = CheckAction.getRoot();
        if(count == 0){
            //ScrBtn2.addActionListener(new ButtonListener3(path_u1, mnf, cp2, txtf_Sys_id, txtf_Sec_R_N, txtf_Sec_R_P, txtf_SearchPath, txtf_SearchPath2,  txtf_NAME /*, txtf_Pid*/, txtf_TF, txtf_SR));
        } else {
            //ScrBtn2.addActionListener(new ButtonListener3(path_u1, mnf, cp2, txtf_Sys_id_set, txtf_Sec_R_N_set, txtf_Sec_R_P_set, txtf_SearchPath_set, txtf_SearchPath2_set,  txtf_NAME_set /*, txtf_Pid_set*/, txtf_TF_set, txtf_SR_set));
        }
        if(count == 0){
            TextField txtf_Sys_id = CheckAction.getTxtf_Sys_id();
            TextField txtf_Sec_R_N = CheckAction.getTxtf_Sec_R_N();
            TextField txtf_Sec_R_P = CheckAction.getTxtf_Sec_R_P();
            TextField txtf_SearchPath = CheckAction.getTxtf_SearchPath();
            TextField txtf_NAME = CheckAction.getTxtf_NAME();
            TextField txtf_TF = CheckAction.getTxtf_TF();
            TextField txtf_SR = CheckAction.getTxtf_SR();
            TextField txtf_SearchPath2 = CheckAction.getTxtf_SearchPath2();
            new PreCreateSc(path_u1, mnf, root, txtf_Sys_id, txtf_Sec_R_N, txtf_Sec_R_P, txtf_SearchPath, txtf_SearchPath2,  txtf_NAME, txtf_TF, txtf_SR);
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
            new PreCreateSc(path_u1, mnf, root, txtf_Sys_id_set, txtf_Sec_R_N_set, txtf_Sec_R_P_set, txtf_SearchPath_set, txtf_SearchPath2_set,  txtf_NAME_set, txtf_TF_set, txtf_SR_set);
        }

    }

    /*public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }*/
}
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class CreateSc {
    public String path_u2;
    public Stage mnf;
    public AnchorPane root;
    public Button resetBtn;
    public TextField txtf_Sys_id;
    public TextField txtf_Sec_R_N;
    public TextField txtf_Sec_R_P;
    public TextField txtf_SearchPath;
    public TextField txtf_SearchPath2;
    public TextField txtf_NAME;
    public TextField txtf_TF;
    public TextField txtf_SR;
    public TextField[] txtf_Sys_id_set;
    public TextField[] txtf_Sec_R_N_set;
    public TextField[] txtf_Sec_R_P_set;
    public TextField[] txtf_SearchPath_set;
    public TextField[] txtf_SearchPath2_set;
    public TextField[] txtf_NAME_set;
    public TextField[] txtf_TF_set;
    public TextField[] txtf_SR_set;
    public static String[] UFName = new String[16];
    public static String[] TR = new String[16];
    public static String[] SR = new String[16];
    public int p;
    public CreateSc(String path_u2, Stage mnf, AnchorPane root, TextField txtf_sys_id, TextField txtf_sec_r_n, TextField txtf_sec_r_p, TextField txtf_searchPath, TextField txtf_searchPath2, TextField txtf_name, TextField txtf_tf, TextField txtf_sr, Button resetBtn) {
        this.path_u2 = path_u2;
        this.mnf = mnf;
        this.root = root;
        this.resetBtn = resetBtn;
        this.txtf_Sys_id = txtf_sys_id;
        this.txtf_Sec_R_N = txtf_sec_r_n;
        this.txtf_Sec_R_P = txtf_sec_r_p;
        this.txtf_SearchPath = txtf_searchPath;
        this.txtf_SearchPath2 = txtf_searchPath2;
        this.txtf_NAME = txtf_name;
        this.txtf_TF = txtf_tf;
        this.txtf_SR = txtf_sr;
        p=0;
        PreCreateSc_go();
    }

    public CreateSc(String path_u2, Stage mnf, AnchorPane root, TextField[] txtf_sys_id_set, TextField[] txtf_sec_r_n_set, TextField[] txtf_sec_r_p_set, TextField[] txtf_searchPath_set, TextField[] txtf_searchPath2_set, TextField[] txtf_name_set, TextField[] txtf_tf_set, TextField[] txtf_sr_set, Button resetBtn){
        this.path_u2 = path_u2;
        this.mnf = mnf;
        this.root = root;
        this.resetBtn = resetBtn;
        this.txtf_Sys_id_set = txtf_sys_id_set;
        this.txtf_Sec_R_N_set = txtf_sec_r_n_set;
        this.txtf_Sec_R_P_set = txtf_sec_r_p_set;
        this.txtf_SearchPath_set = txtf_searchPath_set;
        this.txtf_SearchPath2_set = txtf_searchPath2_set;
        this.txtf_NAME_set = txtf_name_set;
        this.txtf_TF_set = txtf_tf_set;
        this.txtf_SR_set = txtf_sr_set;
        p=1;
        PreCreateSc_go();
    }

    public void PreCreateSc_go(){
        if(p==0){
            UFName[0] = txtf_NAME.getText();
            //Pid[0] = txtf_Pid.getText();
            TR[0] = txtf_TF.getText();
            SR[0] = txtf_SR.getText();
            SC_data_miner.System_id[0] = txtf_Sys_id.getText();
            SC_data_miner.Security_role_name[0] = txtf_Sec_R_N.getText();
            SC_data_miner.Security_role_path[0] = txtf_Sec_R_P.getText();
            SC_data_miner.Search_path[0] = txtf_SearchPath.getText();
            SC_data_miner.Search_path_for_ehd_acs[0] = txtf_SearchPath2.getText();
        } else {
            for(int n = 0; n<=5; n++){
                UFName[n] = txtf_NAME_set[n].getText();
                //Pid[n] = txtf_Pid_set[n].getText();
                TR[n] = txtf_TF_set[n].getText();
                SR[n] = txtf_SR_set[n].getText();
                SC_data_miner.System_id[n] = txtf_Sys_id_set[n].getText();
                SC_data_miner.Security_role_name[n] = txtf_Sec_R_N_set[n].getText();
                SC_data_miner.Security_role_path[n] = txtf_Sec_R_P_set[n].getText();
                SC_data_miner.Search_path[n] = txtf_SearchPath_set[n].getText();
                SC_data_miner.Search_path_for_ehd_acs[n] = txtf_SearchPath2_set[n].getText();
            }
        }

        try {
            new ScriptEXP(SC_data_checker.check, path_u2, 0);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Скрипты созданы");
        dialog.setHeaderText("SUCCESS!!!");
        DialogPane dialogPane = dialog.getDialogPane();
        //dialog.setGraphic(new ImageView(createImage(16, 16, Color.BLUE)));
        dialog.setContentText("Скрипты успешно созданы и находятся по пути исходного Excel файла");
        dialogPane.getButtonTypes().add(ButtonType.OK);
        dialog.show();

        resetBtn.setDisable(false);
        resetBtn.setVisible(true);
    }
}




import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class CheckAction {
    public File file11;
    public String path_u1;
    public String FName2;
    public Stage mnf;
    public AnchorPane root;
    public Button ScrBtn2;
    public Label Label_sys_id;
    public Label LabelRN;
    public Label LabelRP;
    public Label LabelSP;
    public Label Label_Name;
    //public Label LabelPid;
    public Label LabelTF;
    public Label LabelSR;
    public Label LabelSP2;
    public TextField txtf_Sys_id;
    public TextField txtf_Sec_R_N;
    public TextField txtf_Sec_R_P;
    public TextField txtf_SearchPath;
    public TextField txtf_NAME;
    //public TextField txtf_Pid;
    public TextField txtf_TF;
    public TextField txtf_SR;
    public TextField txtf_SearchPath2;
    public TabPane sp;

    TextField[] txtf_Sys_id_set = new TextField[12];
    TextField[] txtf_Sec_R_N_set = new TextField[12];
    TextField[] txtf_Sec_R_P_set = new TextField[12];
    TextField[] txtf_SearchPath_set = new TextField[12];
    TextField[] txtf_NAME_set = new TextField[12];
    //TextField[] txtf_Pid_set = new TextField[12];
    TextField[] txtf_TF_set = new TextField[12];
    TextField[] txtf_SR_set = new TextField[12];
    TextField[] txtf_SearchPath2_set = new TextField[12];
    public CheckAction(File file1, String fname1, String path_u, Stage primaryStage, AnchorPane root) {
        this.file11 = file1;
        this.path_u1 = path_u;
        this.FName2 = fname1;
        this.mnf = primaryStage;
        this.root = root;

        new SC_FEx(file11);

        int count = 0;
        for (int y = 0; y<= SC_data_miner.Form_formal_code.length-1; y++) {
            if (SC_data_miner.Form_formal_code[y] == null || Objects.equals(SC_data_miner.Form_formal_code[y], "") || Objects.equals(SC_data_miner.Form_formal_code[y], " ")) {
                count = y - 1;
                break;
            } else {
                count = y;
            }
        }

        HBox exjp1 = new HBox(15.0);
        HBox exjp2 = new HBox(15.0);
        HBox exjp3 = new HBox(15.0);
        HBox exjp4 = new HBox(15.0);
        HBox exjp5 = new HBox(15.0);
        HBox exjp6 = new HBox(15.0);
        HBox exjp7 = new HBox(15.0);
        HBox exjp8 = new HBox(15.0);
        HBox exjp9 = new HBox(15.0);
        HBox exjp10 = new HBox(15.0);

        Label_sys_id = new Label("System_id");
        LabelRN = new Label("Security_Role_Name");
        LabelRP = new Label("Security_role_path");
        LabelSP = new Label("Search_path");
        Label_Name = new Label("NAME(для EHD_ACS)");
        //LabelPid = new Label("PARENT_ID(для EHD_ACS)");
        LabelTF = new Label("TYPE_REF(для EHD_ACS)");
        LabelSR = new Label("SOURCE_REF(для EHD_ACS)");
        LabelSP2 = new Label("Search_path(для EHD_ACS)");

        if(count == 0){
            txtf_Sys_id = new TextField(SC_data_miner.System_id[0]);
            txtf_Sec_R_N = new TextField(SC_data_miner.Security_role_name[0]);
            txtf_Sec_R_P = new TextField(SC_data_miner.Security_role_path[0]);
            txtf_SearchPath = new TextField(SC_data_miner.Search_path[0]);
            txtf_NAME = new TextField(FName2);
            //txtf_Pid = new TextField("Введите parent_id");
            txtf_TF = new TextField("cognos");
            txtf_SR = new TextField("cognos");
            txtf_SearchPath2 = new TextField(SC_data_miner.Search_path_for_ehd_acs[0]);

            exjp1.getChildren().addAll(Label_sys_id, txtf_Sys_id);
            exjp2.getChildren().addAll(LabelRN, txtf_Sec_R_N);
            exjp3.getChildren().addAll(LabelRP, txtf_Sec_R_P);
            exjp4.getChildren().addAll(LabelSP, txtf_SearchPath);
            exjp5.getChildren().addAll(LabelSP2, txtf_SearchPath2);
            exjp7.getChildren().addAll(Label_Name, txtf_NAME);
            //exjp8.add(LabelPid);
            //exjp8.add(txtf_Pid);
            exjp9.getChildren().addAll(LabelTF, txtf_TF);
            exjp10.getChildren().addAll(LabelSR, txtf_SR);

            root.getChildren().addAll(exjp1, exjp2, exjp3, exjp4, exjp5, exjp7, exjp8, exjp9, exjp10);
            
        } else {
            sp = new TabPane();
            VBox[] PanelSet = new VBox[12];
            HBox[] exjp1_set = new HBox[12];
            HBox[] exjp2_set = new HBox[12];
            HBox[] exjp3_set = new HBox[12];
            HBox[] exjp4_set = new HBox[12];
            HBox[] exjp5_set = new HBox[12];
            HBox[] exjp7_set= new HBox[12];
            HBox[] exjp8_set = new HBox[12];
            HBox[] exjp9_set = new HBox[12];
            HBox[] exjp10_set = new HBox[12];

            Label[] Label_sys_id_set = new Label[12];
            Label[] LabelRN_set = new Label[12];
            Label[] Label_RP_set = new Label[12];
            Label[] Label_SP_set = new Label[12];
            Label[] Label_Name_set = new Label[12];
            //Label[] LabelPid_set = new Label[12];
            Label[] LabelTF_set = new Label[12];
            Label[] LabelSR_set = new Label[12];
            Label[] LabelSP2_set = new Label[12];

            for(int t = 0; t<=11; t++){
                PanelSet[t] = new VBox(15.0);
                PanelSet[t].setPadding(new Insets(10.0));
                exjp1_set[t] = new HBox(15.0);
                exjp2_set[t] = new HBox(15.0);
                exjp3_set[t] = new HBox(15.0);
                exjp4_set[t] = new HBox(15.0);
                exjp5_set[t] = new HBox(15.0);
                exjp7_set[t] = new HBox(15.0);
                exjp8_set[t] = new HBox(15.0);
                exjp9_set[t] = new HBox(15.0);
                exjp10_set[t] = new HBox(15.0);

                txtf_Sys_id_set[t] = new TextField();
                txtf_Sec_R_N_set[t] = new TextField();
                txtf_Sec_R_P_set[t] = new TextField();
                txtf_SearchPath_set[t] = new TextField();
                txtf_NAME_set[t] = new TextField();
                //txtf_Pid_set[t] = new TextField();
                txtf_TF_set[t] = new TextField();
                txtf_SR_set[t] = new TextField();
                txtf_SearchPath2_set[t] = new TextField();

                Label_sys_id_set[t] = new Label("System_id");
                LabelRN_set[t] = new Label("Security_Role_Name");
                Label_RP_set[t] = new Label("Security_role_path");
                Label_SP_set[t] = new Label("Search_path");
                Label_Name_set[t] = new Label("NAME(для EHD_ACS)");
                //LabelPid_set[t] = new Label("PARENT_ID(для EHD_ACS)");
                LabelTF_set[t] = new Label("TYPE_REF(для EHD_ACS)");
                LabelSR_set[t] = new Label("SOURCE_REF(для EHD_ACS)");
                LabelSP2_set[t] = new Label("Search_path(для EHD_ACS)");
            }

            for(int o = 0; o <= count; o++){
                System.out.print("o = " + o );
                txtf_Sys_id_set[o].setText(SC_data_miner.System_id[o]);
                txtf_Sec_R_N_set[o].setText(SC_data_miner.Security_role_name[o]);
                txtf_Sec_R_P_set[o].setText(SC_data_miner.Security_role_path[o]);
                txtf_Sec_R_P_set[o].setMinWidth(75.0);
                txtf_Sec_R_P_set[o].setPrefColumnCount(125);
                txtf_SearchPath_set[o].setText(SC_data_miner.Search_path[o]);
                txtf_SearchPath_set[o].setMinWidth(75.0);
                txtf_SearchPath_set[o].setPrefColumnCount(125);
                txtf_NAME_set[o].setText(FName2);
                //txtf_Pid_set[o].setText("Введите parent_id");
                txtf_TF_set[o].setText("cognos");
                txtf_SR_set[o].setText("cognos");
                txtf_SearchPath2_set[o].setText(SC_data_miner.Search_path_for_ehd_acs[o]);

                exjp1_set[o].getChildren().addAll(Label_sys_id_set[o], txtf_Sys_id_set[o]);
                exjp2_set[o].getChildren().addAll(LabelRN_set[o], txtf_Sec_R_N_set[o]);
                exjp3_set[o].getChildren().addAll(Label_RP_set[o], txtf_Sec_R_P_set[o]);
                exjp4_set[o].getChildren().addAll(Label_SP_set[o], txtf_SearchPath_set[o]);
                exjp5_set[o].getChildren().addAll(LabelSP2_set[o], txtf_SearchPath2_set[o]);
                exjp7_set[o].getChildren().addAll(Label_Name_set[o], txtf_NAME_set[o]);
                //exjp8_set[o]..getChildren().addAll(LabelPid_set[o]);
                //exjp8_set[o]..getChildren().addAll(txtf_Pid_set[o]);
                exjp9_set[o].getChildren().addAll(LabelTF_set[o],txtf_TF_set[o]);
                exjp10_set[o].getChildren().addAll(LabelSR_set[o], txtf_SR_set[o]);

                PanelSet[o].getChildren().addAll(exjp1_set[o], exjp2_set[o], exjp3_set[o], exjp4_set[o], exjp5_set[o], exjp7_set[o], exjp8_set[o], exjp9_set[o], exjp10_set[o]);
                sp.getTabs().add(new Tab("Форма " + (o+1), PanelSet[o]));
            }
            root.getChildren().add(sp);
            sp.setLayoutX(15);
            sp.setLayoutY(140);
        }

        mnf.setWidth(1720);
        mnf.setHeight(600);


        ScrBtn2 = new Button("Создать скрипт");
        exjp6.getChildren().add(ScrBtn2);

        root.getChildren().add(exjp6);
        exjp6.setLayoutY(95);
        exjp6.setLayoutX(140);

        if(count == 0){
            //ScrBtn2.addActionListener(new ButtonListener3(path_u1, mnf, cp2, txtf_Sys_id, txtf_Sec_R_N, txtf_Sec_R_P, txtf_SearchPath, txtf_SearchPath2,  txtf_NAME /*, txtf_Pid*/, txtf_TF, txtf_SR));
        } else {
            //ScrBtn2.addActionListener(new ButtonListener3(path_u1, mnf, cp2, txtf_Sys_id_set, txtf_Sec_R_N_set, txtf_Sec_R_P_set, txtf_SearchPath_set, txtf_SearchPath2_set,  txtf_NAME_set /*, txtf_Pid_set*/, txtf_TF_set, txtf_SR_set));
        }
    }

}


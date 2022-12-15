import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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

       /* Panel exjp1 = new Panel();
        exjp1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp2 = new Panel();
        exjp2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp3 = new Panel();
        exjp3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp4 = new Panel();
        exjp4.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp5 = new Panel();
        exjp5.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp6 = new Panel();
        exjp6.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp7 = new Panel();
        exjp7.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp8 = new Panel();
        exjp8.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp9 = new Panel();
        exjp9.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Panel exjp10 = new Panel();
        exjp10.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));*/

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

           /* exjp1.add(Label_sys_id);
            exjp1.add(txtf_Sys_id);
            exjp2.add(LabelRN);
            exjp2.add(txtf_Sec_R_N);
            exjp3.add(LabelRP);
            exjp3.add(txtf_Sec_R_P);
            exjp4.add(LabelSP);
            exjp4.add(txtf_SearchPath);
            exjp5.add(LabelSP2);
            exjp5.add(txtf_SearchPath2);
            exjp7.add(Label_Name);
            exjp7.add(txtf_NAME);
            //exjp8.add(LabelPid);
            //exjp8.add(txtf_Pid);
            exjp9.add(LabelTF);
            exjp9.add(txtf_TF);
            exjp10.add(LabelSR);
            exjp10.add(txtf_SR);*/

            /*cp2.add(exjp1);
            cp2.add(exjp2);
            cp2.add(exjp3);
            cp2.add(exjp4);
            cp2.add(exjp5);
            cp2.add(exjp7);
            cp2.add(exjp8);
            cp2.add(exjp9);
            cp2.add(exjp10);*/
        } else {
            /*Panel[] PanelSet = new Panel[12];
            Panel[] exjp1_set = new Panel[12];
            exjp1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp2_set = new Panel[12];
            exjp2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp3_set = new Panel[12];
            exjp3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp4_set = new Panel[12];
            exjp4.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp5_set = new Panel[12];
            exjp5.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp7_set= new Panel[12];
            exjp7.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp8_set = new Panel[12];
            exjp8.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp9_set = new Panel[12];
            exjp9.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            Panel[] exjp10_set = new Panel[12];
            exjp10.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));*/

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
                /*PanelSet[t] = new Panel();
                exjp1_set[t] = new Panel();
                exjp2_set[t] = new Panel();
                exjp3_set[t] = new Panel();
                exjp4_set[t] = new Panel();
                exjp5_set[t] = new Panel();
                exjp7_set[t] = new Panel();
                exjp8_set[t] = new Panel();
                exjp9_set[t] = new Panel();
                exjp10_set[t] = new Panel();*/

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
            //JTabbedPane sp = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
            //sp.setPreferredSize(new Dimension(2000, 400));

            for(int o = 0; o <= count; o++){
                System.out.print("o = " + o );
                txtf_Sys_id_set[o].setText(SC_data_miner.System_id[o]);
                txtf_Sec_R_N_set[o].setText(SC_data_miner.Security_role_name[o]);
                txtf_Sec_R_P_set[o].setText(SC_data_miner.Security_role_path[o]);
                txtf_SearchPath_set[o].setText(SC_data_miner.Search_path[o]);
                txtf_NAME_set[o].setText(FName2);
                //txtf_Pid_set[o].setText("Введите parent_id");
                txtf_TF_set[o].setText("cognos");
                txtf_SR_set[o].setText("cognos");
                txtf_SearchPath2_set[o].setText(SC_data_miner.Search_path_for_ehd_acs[o]);

                /*exjp1_set[o].add(Label_sys_id_set[o]);
                exjp1_set[o].add(txtf_Sys_id_set[o]);
                exjp2_set[o].add(LabelRN_set[o]);
                exjp2_set[o].add(txtf_Sec_R_N_set[o]);
                exjp3_set[o].add(Label_RP_set[o]);
                exjp3_set[o].add(txtf_Sec_R_P_set[o]);
                exjp4_set[o].add(Label_SP_set[o]);
                exjp4_set[o].add(txtf_SearchPath_set[o]);
                exjp5_set[o].add(LabelSP2_set[o]);
                exjp5_set[o].add(txtf_SearchPath2_set[o]);
                exjp7_set[o].add(Label_Name_set[o]);
                exjp7_set[o].add(txtf_NAME_set[o]);
                //exjp8_set[o].add(LabelPid_set[o]);
                //exjp8_set[o].add(txtf_Pid_set[o]);
                exjp9_set[o].add(LabelTF_set[o]);
                exjp9_set[o].add(txtf_TF_set[o]);
                exjp10_set[o].add(LabelSR_set[o]);
                exjp10_set[o].add(txtf_SR_set[o]);

                PanelSet[o].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

                PanelSet[o].add(exjp1_set[o]);
                PanelSet[o].add(exjp2_set[o]);
                PanelSet[o].add(exjp3_set[o]);
                PanelSet[o].add(exjp4_set[o]);
                PanelSet[o].add(exjp5_set[o]);
                PanelSet[o].add(exjp7_set[o]);
                PanelSet[o].add(exjp8_set[o]);
                PanelSet[o].add(exjp9_set[o]);
                PanelSet[o].add(exjp10_set[o]);

                sp.addTab("Форма " + (o+1), PanelSet[o]);*/
            }
            //cp2.add(sp);
        }

        mnf.setWidth(2020);
        mnf.setHeight(600);


        ScrBtn2 = new Button("Создать скрипт");
        //exjp6.add(ScrBtn2);

        //cp2.add(exjp6);

        if(count == 0){
            //ScrBtn2.addActionListener(new ButtonListener3(path_u1, mnf, cp2, txtf_Sys_id, txtf_Sec_R_N, txtf_Sec_R_P, txtf_SearchPath, txtf_SearchPath2,  txtf_NAME /*, txtf_Pid*/, txtf_TF, txtf_SR));
        } else {
            //ScrBtn2.addActionListener(new ButtonListener3(path_u1, mnf, cp2, txtf_Sys_id_set, txtf_Sec_R_N_set, txtf_Sec_R_P_set, txtf_SearchPath_set, txtf_SearchPath2_set,  txtf_NAME_set /*, txtf_Pid_set*/, txtf_TF_set, txtf_SR_set));
        }
    }

}


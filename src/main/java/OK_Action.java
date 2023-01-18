import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OK_Action {
    private static TabPane sp;
    private Stage mnf;
    private static TextField[] Form_name_txtf = new TextField[12];
    private static TextField[] Form_cd_txtf = new TextField[12];
    private static TextField[] Form_cd_name_txtf = new TextField[12];
    private static TextField[] Form_okud_txtf = new TextField[12];
    private static TextField[] Form_cd_cog_txtf = new TextField[12];
    private static TextField[] Flag_IOD_txtf = new TextField[12];
    private static TextField[] Flag_PDN_txtf = new TextField[12];
    private static TextField[] Dep_name_txtf = new TextField[12];
    private static TextField[] Dep_u_name_txtf = new TextField[12];
    private static TextField[] reason_txtf = new TextField[12];
    private static TextField[] System_id_txtf = new TextField[12];
    private static TextField[] Security_role_path_txtf = new TextField[12];
    private static TextField[] Search_path_txtf = new TextField[12];
    private static TextField[] Form_formal_code_txtf = new TextField[12];
    private static TextField[] Desc_txtf = new TextField[12];
    private static TextField[] period_txtf = new TextField[12];
    private static TextField[] rep_subj_type_txtf = new TextField[12];
    private static TextField[] p_parent_code_txtf = new TextField[12];
    private static TextField[] p_parent_type_ref_txtf = new TextField[12];
    private static TextField[] p_type_ref_txtf = new TextField[12];
    private static TextField[] p_source_ref_txtf = new TextField[12];
    private static TextField[] Security_role_name_txtf = new TextField[12];

    public OK_Action(int count, AnchorPane root, Stage primaryStage, Button apruvBtn){
        this.mnf = primaryStage;
        sp = new TabPane();
        VBox[] PanelSet = new VBox[12];
        HBox[] exjp0_set = new HBox[12];
        HBox[] exjp1_set = new HBox[12];
        HBox[] exjp2_set = new HBox[12];
        HBox[] exjp3_set = new HBox[12];
        HBox[] exjp4_set = new HBox[12];
        HBox[] exjp5_set = new HBox[12];
        HBox[] exjp6_set = new HBox[12];
        HBox[] exjp7_set= new HBox[12];
        HBox[] exjp8_set = new HBox[12];
        HBox[] exjp9_set = new HBox[12];
        HBox[] exjp10_set = new HBox[12];
        HBox[] exjp11_set = new HBox[12];
        HBox[] exjp12_set = new HBox[12];
        HBox[] exjp13_set = new HBox[12];
        HBox[] exjp14_set = new HBox[12];
        HBox[] exjp15_set = new HBox[12];
        HBox[] exjp16_set = new HBox[12];
        HBox[] exjp17_set = new HBox[12];
        HBox[] exjp18_set = new HBox[12];
        HBox[] exjp19_set = new HBox[12];
        HBox[] exjp20_set = new HBox[12];
        HBox[] exjp21_set = new HBox[12];
        HBox[] exjp22_set = new HBox[12];

        Label[] form_name_lbl = new Label[12];
        Label[] form_cd_lbl = new Label[12];
        Label[] form_cd_name_lbl = new Label[12];
        Label[] OKUD_lbl = new Label[12];
        Label[] form_cd_cog_lbl = new Label[12];
        Label[] Flag_IOD_lbl = new Label[12];
        Label[] Flag_PDN_lbl = new Label[12];
        Label[] Dep_name_lbl = new Label[12];
        Label[] Dep_u_name_lbl = new Label[12];
        Label[] reason_lbl = new Label[12];
        Label[] System_id_lbl = new Label[12];
        Label[] Security_role_path_lbl = new Label[12];
        Label[] Search_path_lbl = new Label[12];
        Label[] Form_formal_code_lbl = new Label[12];
        Label[] Desc_lbl = new Label[12];
        Label[] period_lbl = new Label[12];
        Label[] rep_subj_type_lbl = new Label[12];
        Label[] p_parent_code_lbl = new Label[12];
        Label[] p_parent_type_ref_lbl = new Label[12];
        Label[] p_type_ref_lbl = new Label[12];
        Label[] p_source_ref_lbl = new Label[12];
        Label[] Security_role_name_lbl = new Label[12];

        for(int t = 0; t<=11; t++){
            PanelSet[t] = new VBox(5.0);
            PanelSet[t].setPadding(new Insets(10.0));
            exjp0_set[t] = new HBox(15.0);
            exjp1_set[t] = new HBox(15.0);
            exjp2_set[t] = new HBox(15.0);
            exjp3_set[t] = new HBox(15.0);
            exjp4_set[t] = new HBox(15.0);
            exjp5_set[t] = new HBox(15.0);
            exjp6_set[t] = new HBox(15.0);
            exjp7_set[t] = new HBox(15.0);
            exjp8_set[t] = new HBox(15.0);
            exjp9_set[t] = new HBox(15.0);
            exjp10_set[t] = new HBox(15.0);
            exjp11_set[t] = new HBox(15.0);
            exjp12_set[t] = new HBox(15.0);
            exjp13_set[t] = new HBox(15.0);
            exjp14_set[t] = new HBox(15.0);
            exjp15_set[t] = new HBox(15.0);
            exjp16_set[t] = new HBox(15.0);
            exjp17_set[t] = new HBox(15.0);
            exjp18_set[t] = new HBox(15.0);
            exjp19_set[t] = new HBox(15.0);
            exjp20_set[t] = new HBox(15.0);
            exjp21_set[t] = new HBox(15.0);
            exjp22_set[t] = new HBox(15.0);

            Form_name_txtf[t] = new TextField();
            Form_cd_txtf[t] =  new TextField();
            Form_cd_name_txtf[t] =  new TextField();
            Form_okud_txtf[t] =  new TextField();
            Form_cd_cog_txtf[t] =  new TextField();
            Flag_IOD_txtf[t] =  new TextField();
            Flag_PDN_txtf[t] =  new TextField();
            Dep_name_txtf[t] =  new TextField();
            Dep_u_name_txtf[t] =  new TextField();
            reason_txtf[t] =  new TextField();
            System_id_txtf[t] =  new TextField();
            Security_role_path_txtf[t] =  new TextField();
            Search_path_txtf[t] =  new TextField();
            Form_formal_code_txtf[t] =  new TextField();
            Desc_txtf[t] =  new TextField();
            period_txtf[t] =  new TextField();
            rep_subj_type_txtf[t] =  new TextField();
            p_parent_code_txtf[t] =  new TextField();
            p_parent_type_ref_txtf[t] =  new TextField();
            p_type_ref_txtf[t] =  new TextField();
            p_source_ref_txtf[t] =  new TextField();
            Security_role_name_txtf[t] =  new TextField();

            form_name_lbl[t] = new Label("Имя формы: ");
            form_cd_lbl[t] = new Label("Код доступа: ");
            form_cd_name_lbl[t] = new Label("Наименование кода доступа: ");
            OKUD_lbl[t] = new Label("ОКУД: ");
            form_cd_cog_lbl[t] = new Label("Код потока(Когнос): ");
            Flag_IOD_lbl[t] = new Label("Флаг ИОД: ");
            Flag_PDN_lbl[t] = new Label("Флаг ПДН: ");
            Dep_name_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_u_name_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            reason_lbl[t] = new Label("Документ-основание: ");
            System_id_lbl[t] = new Label("System_id: ");
            Security_role_path_lbl[t] = new Label("Security_role_path: ");
            Search_path_lbl[t] = new Label("Search_path: ");
            Form_formal_code_lbl[t] = new Label("Уникальный код отчета: ");
            Desc_lbl[t] = new Label("Описание: ");
            period_lbl[t] = new Label("Период: ");
            rep_subj_type_lbl[t] = new Label("Разрез: ");
            p_parent_code_lbl[t] = new Label("p_parent_code: ");
            p_parent_type_ref_lbl[t] = new Label("p_parent_type_ref: ");
            p_type_ref_lbl[t] = new Label("p_type_ref: ");
            p_source_ref_lbl[t] = new Label("p_source_ref: ");
            Security_role_name_lbl[t] = new Label("Security_role_name: ");
        }
        for(int o = 1; o <= count; o++){

            //System.out.print("o = " + o );

            exjp0_set[o].getChildren().addAll(form_name_lbl[o], Form_name_txtf[o]);
            exjp1_set[o].getChildren().addAll(form_cd_lbl[o], Form_cd_txtf[o]);
            exjp2_set[o].getChildren().addAll(form_cd_name_lbl[o], Form_cd_name_txtf[o]);
            exjp3_set[o].getChildren().addAll(OKUD_lbl[o], Form_okud_txtf[o]);
            exjp4_set[o].getChildren().addAll(form_cd_cog_lbl[o], Form_cd_cog_txtf[o]);
            exjp5_set[o].getChildren().addAll(Flag_IOD_lbl[o], Flag_IOD_txtf[o]);
            exjp6_set[o].getChildren().addAll(Flag_PDN_lbl[o], Flag_PDN_txtf[o]);
            exjp7_set[o].getChildren().addAll(Dep_name_lbl[o], Dep_name_txtf[o]);
            exjp9_set[o].getChildren().addAll(Dep_u_name_lbl[o], Dep_u_name_txtf[o]);
            exjp10_set[o].getChildren().addAll(reason_lbl[o], reason_txtf[o]);
            exjp11_set[o].getChildren().addAll(System_id_lbl[o], System_id_txtf[o]);
            exjp12_set[o].getChildren().addAll(Security_role_path_lbl[o], Security_role_path_txtf[o]);
            exjp13_set[o].getChildren().addAll(Search_path_lbl[o], Search_path_txtf[o]);
            exjp14_set[o].getChildren().addAll(Form_formal_code_lbl[o], Form_formal_code_txtf[o]);
            exjp15_set[o].getChildren().addAll(Desc_lbl[o], Desc_txtf[o]);
            exjp16_set[o].getChildren().addAll(period_lbl[o], period_txtf[o]);
            exjp17_set[o].getChildren().addAll(rep_subj_type_lbl[o], rep_subj_type_txtf[o]);
            exjp18_set[o].getChildren().addAll(p_parent_code_lbl[o], p_parent_code_txtf[o]);
            exjp19_set[o].getChildren().addAll(p_parent_type_ref_lbl[o], p_parent_type_ref_txtf[o]);
            exjp20_set[o].getChildren().addAll(p_type_ref_lbl[o], p_type_ref_txtf[o]);
            exjp21_set[o].getChildren().addAll(p_source_ref_lbl[o], p_source_ref_txtf[o]);
            exjp22_set[o].getChildren().addAll(Security_role_name_lbl[o], Security_role_name_txtf[o]);

            PanelSet[o].getChildren().addAll(exjp0_set[o], exjp1_set[o], exjp2_set[o], exjp3_set[o], exjp4_set[o], exjp5_set[o], exjp7_set[o], exjp8_set[o], exjp9_set[o],
                    exjp10_set[o], exjp11_set[o], exjp12_set[o], exjp13_set[o], exjp14_set[o], exjp15_set[o], exjp16_set[o], exjp17_set[o], exjp18_set[o], exjp19_set[o],
                    exjp20_set[o], exjp21_set[o], exjp22_set[o]);
            sp.getTabs().add(new Tab("Форма " + (o), PanelSet[o]));
        }
        root.getChildren().add(sp);
        sp.setLayoutX(15);
        sp.setLayoutY(160);

        mnf.setWidth(1720);
        mnf.setHeight(880);
        mnf.centerOnScreen();

        apruvBtn.setVisible(true);
        apruvBtn.setDisable(false);
        }

    public static void GetValues(){
        /*System.out.print("Form_name_txtf[0].getText() = " + Form_name_txtf[0].getText() + "\n");
        System.out.print("Form_cd_txtf[0].getText() = " + Form_cd_txtf[0].getText() + "\n");
        System.out.print("Form_cd_name_txtf[0].getText() = " + Form_cd_name_txtf[0].getText() + "\n");
        System.out.print("Form_okud_txtf[0].getText() = " + Form_okud_txtf[0].getText() + "\n");
        System.out.print("Dep_u_name_txtf[0].getText() = " + Dep_u_name_txtf[0].getText() + "\n");
        for(int h = 0; h<=11; h++){
            Form_name_txtf[h].setText(OK_Action.Form_name_txtf[h].getText());
            Form_cd_txtf[h].setText(OK_Action.Form_cd_txtf[h].getText());
            Form_cd_name_txtf[h].setText(OK_Action.Form_cd_name_txtf[h].getText());
            Form_okud_txtf[h].setText(OK_Action.Form_okud_txtf[h].getText());
            Form_cd_cog_txtf[h].setText(OK_Action.Form_cd_cog_txtf[h].getText());
            Flag_IOD_txtf[h].setText(OK_Action.Flag_IOD_txtf[h].getText());
            Flag_PDN_txtf[h].setText(OK_Action.Flag_PDN_txtf[h].getText());
            Dep_name_txtf[h].setText(OK_Action.Dep_name_txtf[h].getText());
            Dep_u_name_txtf[h].setText(OK_Action.Dep_u_name_txtf[h].getText());
            reason_txtf[h].setText(OK_Action.reason_txtf[h].getText());
            System_id_txtf[h].setText(OK_Action.System_id_txtf[h].getText());
            Security_role_path_txtf[h].setText(OK_Action.Security_role_path_txtf[h].getText());
            Search_path_txtf[h].setText(OK_Action.Search_path_txtf[h].getText());
            Form_formal_code_txtf[h].setText(OK_Action.Form_formal_code_txtf[h].getText());
            Desc_txtf[h].setText(OK_Action.Desc_txtf[h].getText());
            period_txtf[h].setText(OK_Action.period_txtf[h].getText());
            rep_subj_type_txtf[h].setText(OK_Action.rep_subj_type_txtf[h].getText());
            p_parent_code_txtf[h].setText(OK_Action.p_parent_code_txtf[h].getText());
            p_parent_type_ref_txtf[h].setText(OK_Action.p_parent_type_ref_txtf[h].getText());
            p_type_ref_txtf[h].setText(OK_Action.p_type_ref_txtf[h].getText());
            p_source_ref_txtf[h].setText(OK_Action.p_source_ref_txtf[h].getText());
            Security_role_name_txtf[h].setText(OK_Action.Security_role_name_txtf[h].getText());
        }*/
    }
    public static TextField[] getForm_name_txtf(){
            return OK_Action.Form_name_txtf;
    }
    public static TextField[] getForm_cd_txtf(){
            return OK_Action.Form_cd_txtf;
    }
    public static TextField[] getForm_cd_name_txtf(){
            return OK_Action.Form_cd_name_txtf;
    }
    public static TextField[] getForm_okud_txtf(){
            return OK_Action.Form_okud_txtf;
    }
    public static TextField[] getForm_cd_cog_txtf(){
            return OK_Action.Form_cd_cog_txtf;
    }
    public static TextField[] getFlag_IOD_txtf(){
            return OK_Action.Flag_IOD_txtf;
    }
    public static TextField[] getFlag_PDN_txtf(){
            return OK_Action.Flag_PDN_txtf;
    }
    public static TextField[] getDep_name_txtf(){
            return OK_Action.Dep_name_txtf;
    }
    public static TextField[] getDep_u_name_txtf(){
            return OK_Action.Dep_u_name_txtf;
    }
    public static TextField[] getReason_txtf(){
            return OK_Action.reason_txtf;
    }
    public static TextField[] getSystem_id_txtf(){
            return OK_Action.System_id_txtf;
    }
    public static TextField[] getSecurity_role_path_txtf(){
            return OK_Action.Security_role_path_txtf;
    }
    public static TextField[] getSearch_path_txtf(){
            return OK_Action.Search_path_txtf;
    }
    public static TextField[] getForm_formal_code_txtf(){
            return OK_Action.Form_formal_code_txtf;
    }
    public static TextField[] getDesc_txtf(){
            return OK_Action.Desc_txtf;
    }
    public static TextField[] getPeriod_txtf(){
            return OK_Action.period_txtf;
    }
    public static TextField[] getRep_subj_type_txtf(){
            return OK_Action.rep_subj_type_txtf;
    }
    public static TextField[] getP_parent_code_txtf(){
            return OK_Action.p_parent_code_txtf;
    }
    public static TextField[] getP_parent_type_ref_txtf(){
            return OK_Action.p_parent_type_ref_txtf;
    }
    public static TextField[] getP_type_ref_txtf(){
            return OK_Action.p_type_ref_txtf;
    }
    public static TextField[] getP_source_ref_txtf(){
            return OK_Action.p_source_ref_txtf;
    }
    public static TextField[] getSecurity_role_name_txtf(){
        return OK_Action.Security_role_name_txtf;
    }
    /*public static String[] getForm_name_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Form_name_txtf[0].getText();
        }
        return result;
    }
    public static String[] getForm_cd_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Form_cd_txtf[0].getText();
        }
        return result;
    }
    public static String[] getForm_cd_name_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Form_cd_name_txtf[0].getText();
        }
        return result;
    }
    public static String[] getForm_okud_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Form_okud_txtf[0].getText();
        }
        return result;
    }
    public static String[] getForm_cd_cog_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Form_cd_cog_txtf[0].getText();
        }
        return result;
    }
    public static String[] getFlag_IOD_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Flag_IOD_txtf[0].getText();
        }
        return result;
    }
    public static String[] getFlag_PDN_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Flag_PDN_txtf[0].getText();
        }
        return result;
    }
    public static String[] getDep_name_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Dep_name_txtf[0].getText();
        }
        return result;
    }
    public static String[] getDep_u_name_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Dep_u_name_txtf[0].getText();
        }
        return result;
    }
    public static String[] getReason_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.reason_txtf[0].getText();
        }
        return result;
    }
    public static String[] getSystem_id_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.System_id_txtf[0].getText();
        }
        return result;
    }
    public static String[] getSecurity_role_path_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Security_role_path_txtf[0].getText();
        }
        return result;
    }
    public static String[] getSearch_path_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Search_path_txtf[0].getText();
        }
        return result;
    }
    public static String[] getForm_formal_code_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Form_formal_code_txtf[0].getText();
        }
        return result;
    }
    public static String[] getDesc_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Desc_txtf[0].getText();
        }
        return result;
    }
    public static String[] getPeriod_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.period_txtf[0].getText();
        }
        return result;
    }
    public static String[] getRep_subj_type_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.rep_subj_type_txtf[0].getText();
        }
        return result;
    }
    public static String[] getP_parent_code_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.p_parent_code_txtf[0].getText();
        }
        return result;
    }
    public static String[] getP_parent_type_ref_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.p_parent_type_ref_txtf[0].getText();
        }
        return result;
    }
    public static String[] getP_type_ref_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.p_type_ref_txtf[0].getText();
        }
        return result;
    }
    public static String[] getP_source_ref_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.p_source_ref_txtf[0].getText();
        }
        return result;
    }
    public static String[] getSecurity_role_name_txtf(){
        String[] result = new String[12];
        for(int l = 0; l<=11; l++){
            result[l] = OK_Action.Security_role_name_txtf[0].getText();
        }
        return result;
    }*/
    }


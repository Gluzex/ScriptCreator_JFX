import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OK_Action {
    private static TabPane sp;
    private Stage mnf;
    private static TextField[] Form_name_txtf = new TextField[12];
    private static TextField[] Form_cd_txtf = new TextField[12];
    private static TextField[] Form_cd_name_txtf = new TextField[12];
    private static TextField[] Form_okud_txtf = new TextField[12];
    private static TextField[] Form_cd_cog_txtf = new TextField[12];
    private static ComboBox<String>[] Flag_IOD_cmbx = new ComboBox[12];
    private static ComboBox<String>[] Flag_PDN_cmbx = new ComboBox[12];
    private static TextField[] Dep_name_txtf = new TextField[12];
    private static TextField[] Dep_u_name_txtf = new TextField[12];
    private static TextField[] reason_txtf = new TextField[12];
    private static TextField[] System_id_txtf = new TextField[12];
    private static TextField[] Security_role_path_txtf = new TextField[12];
    private static TextField[] Search_path_txtf = new TextField[12];
    private static TextField[] Form_formal_code_txtf = new TextField[12];
    private static TextField[] Desc_txtf = new TextField[12];
    private static ComboBox<String>[] period_cmbx = new ComboBox[12];
    private static ComboBox<String>[] rep_subj_type_cmbx = new ComboBox[12];
    private static TextField[] p_parent_code_txtf = new TextField[12];
    private static TextField[] p_parent_type_ref_txtf = new TextField[12];
    private static TextField[] p_type_ref_txtf = new TextField[12];
    private static TextField[] p_source_ref_txtf = new TextField[12];
    private static TextField[] Security_role_name_txtf = new TextField[12];

    public OK_Action(int count, AnchorPane root, Stage primaryStage, Button createBtn){
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
        //HBox[] exjp8_set = new HBox[12];
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
        VBox[] p_tbl_1 = new VBox[12];
        VBox[] p_tbl_2 = new VBox[12];
        VBox[] p_tbl_3 = new VBox[12];
        VBox[] p_tbl_4 = new VBox[12];
        //VBox[] p_tbl_5 = new VBox[12];
        VBox[] p_tbl_6 = new VBox[12];
        VBox[] p_tbl_7 = new VBox[12];
        //VBox[] p_tbl_8 = new VBox[12];
        VBox[] p_tbl_9 = new VBox[12];
        VBox[] p_tbl_10 = new VBox[12];

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
        Label[] tbl1_lbl = new Label[12];
        Label[] tbl2_lbl = new Label[12];
        Label[] tbl3_lbl = new Label[12];
        Label[] tbl4_lbl = new Label[12];
        //Label[] tbl5_lbl = new Label[12];
        Label[] tbl6_lbl = new Label[12];
        Label[] tbl7_lbl = new Label[12];
        //Label[] tbl8_lbl = new Label[12];
        Label[] tbl9_lbl = new Label[12];
        Label[] tbl10_lbl = new Label[12];

        Tooltip tooltip1 = new Tooltip ("Флаг (Y/N) - признак наличия данных категории ИОД в отчетах доступных по данному коду, принимает значения \"Y\" или \"N\"");
        tooltip1.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip1_1 = new Tooltip ("Флаг (Y/N) - признак наличия данных категории ПДН в отчетах доступных по данному коду, принимает значения \"Y\" или \"N\"");
        tooltip1_1.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip2 = new Tooltip ("Период сбора регламентированной формы");
        tooltip2.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip3 = new Tooltip ("Разрез, в котором представлены данные отчета");
        tooltip3.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip4 = new Tooltip ("Код доступа - технический код доступа к отчету/папке/группе отчетов/витрине");
        tooltip4.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip5 = new Tooltip ("Наименование кода доступа - наименование для данного кода доступа, видимое пользователю");
        tooltip5.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip6 = new Tooltip ("Код потока - Код, поставленный в соответсвие коду доступа (form_cd таблицы rep и других таблиц, на которые наложены политики по коду потока)");
        tooltip6.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip7 = new Tooltip ("Сокращенное наименование департамента-владельца для отчетов, доступных по данному коду доступа");
        tooltip7.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip8 = new Tooltip ("Документ-основание - на основе какого документа тот или иной департамент является владельцем");
        tooltip8.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip9 = new Tooltip ("Уникальный код отчета - уникальный буквенно-цифровой код присвоенный отчету в задаче на разработку, однозначно определяющий его");
        tooltip9.setShowDuration(Duration.seconds(8.0));
        Tooltip tooltip10 = new Tooltip ("ОКУД всех регламентированных форм-источников данного отчета");
        tooltip10.setShowDuration(Duration.seconds(8.0));
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
            //exjp8_set[t] = new HBox(15.0);
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
            p_tbl_1[t] = new VBox(15.0);
            p_tbl_2[t] = new VBox(15.0);
            p_tbl_3[t] = new VBox(15.0);
            p_tbl_4[t] = new VBox(15.0);
            //p_tbl_5[t] = new VBox(15.0);
            p_tbl_6[t] = new VBox(15.0);
            p_tbl_7[t] = new VBox(15.0);
            //p_tbl_8[t] = new VBox(15.0);
            p_tbl_9[t] = new VBox(15.0);
            p_tbl_10[t] = new VBox(15.0);
            p_tbl_1[t].setPadding(new Insets(10.0));
            p_tbl_2[t].setPadding(new Insets(10.0));
            p_tbl_3[t].setPadding(new Insets(10.0));
            p_tbl_4[t].setPadding(new Insets(10.0));
            //p_tbl_5[t].setPadding(new Insets(10.0));
            p_tbl_6[t].setPadding(new Insets(10.0));
            p_tbl_7[t].setPadding(new Insets(10.0));
            //p_tbl_8[t].setPadding(new Insets(10.0));
            p_tbl_9[t].setPadding(new Insets(10.0));
            p_tbl_10[t].setPadding(new Insets(10.0));

            Form_name_txtf[t] = new TextField();
            Form_cd_txtf[t] =  new TextField();
            Form_cd_txtf[t].setTooltip(tooltip4);
            Form_cd_name_txtf[t] =  new TextField();
            Form_cd_name_txtf[t].setTooltip(tooltip5);
            Form_okud_txtf[t] =  new TextField();
            Form_okud_txtf[t].setTooltip(tooltip10);
            Form_cd_cog_txtf[t] =  new TextField();
            Form_cd_cog_txtf[t].setTooltip(tooltip6);
            Flag_IOD_cmbx[t] =  new ComboBox<String>();
            Flag_IOD_cmbx[t].getItems().addAll("Y", "N");
            Flag_IOD_cmbx[t].setTooltip(tooltip1);
            Flag_PDN_cmbx[t] =  new ComboBox<String>();
            Flag_PDN_cmbx[t].getItems().addAll("Y", "N");
            Flag_PDN_cmbx[t].setTooltip(tooltip1_1);
            Dep_name_txtf[t] =  new TextField();
            Dep_name_txtf[t].setTooltip(tooltip7);
            Dep_u_name_txtf[t] =  new TextField();
            Dep_u_name_txtf[t].setTooltip(tooltip7);
            reason_txtf[t] =  new TextField();
            reason_txtf[t].setTooltip(tooltip8);
            System_id_txtf[t] =  new TextField();
            Security_role_path_txtf[t] =  new TextField();
            Search_path_txtf[t] =  new TextField();
            Form_formal_code_txtf[t] =  new TextField();
            Form_formal_code_txtf[t].setTooltip(tooltip9);
            Desc_txtf[t] =  new TextField();
            period_cmbx[t] =  new ComboBox<String>();
            period_cmbx[t].getItems().addAll("квартальная", "месячная", "нерегулярная");
            period_cmbx[t].setTooltip(tooltip2);
            rep_subj_type_cmbx[t] =  new ComboBox<String>();
            rep_subj_type_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР");
            rep_subj_type_cmbx[t].setTooltip(tooltip3);
            p_parent_code_txtf[t] =  new TextField();
            p_parent_type_ref_txtf[t] =  new TextField();
            p_type_ref_txtf[t] =  new TextField();
            p_source_ref_txtf[t] =  new TextField();
            Security_role_name_txtf[t] =  new TextField();

            reason_txtf[t].setMinWidth(50.0);
            reason_txtf[t].setPrefColumnCount(70);
            Security_role_path_txtf[t].setMinWidth(75.0);
            Security_role_path_txtf[t].setPrefColumnCount(100);
            Search_path_txtf[t].setMinWidth(75.0);
            Search_path_txtf[t].setPrefColumnCount(125);
            Desc_txtf[t].setMinWidth(75.0);
            Desc_txtf[t].setPrefColumnCount(125);

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
            Search_path_lbl[t] = new Label("Полный путь отчета/папки(Search_path): ");
            Form_formal_code_lbl[t] = new Label("Уникальный код отчета: ");
            Desc_lbl[t] = new Label("Описание: ");
            period_lbl[t] = new Label("Период сбора: ");
            rep_subj_type_lbl[t] = new Label("Разрез: ");
            p_parent_code_lbl[t] = new Label("p_parent_code: ");
            p_parent_type_ref_lbl[t] = new Label("p_parent_type_ref: ");
            p_type_ref_lbl[t] = new Label("p_type_ref: ");
            p_source_ref_lbl[t] = new Label("p_source_ref: ");
            Security_role_name_lbl[t] = new Label("Security_role_name: ");
            tbl1_lbl[t] = new Label("---Данные для таблицы REP_FORM---");
            tbl2_lbl[t] = new Label("---Данные для таблицы REP_FORM_COGNOS---");
            tbl3_lbl[t] = new Label("---Данные для таблицы REP_FORM_OKI---");
            tbl4_lbl[t] = new Label("---Данные для таблиц REP_FORM_DEP_OWNER и REP_FORM_DEP_USER---");
            //tbl5_lbl[t] = new Label("---Данные для таблицы REP_FORM_DEP_USER---");
            tbl6_lbl[t] = new Label("---Данные для таблицы REG_REPORT_FORM---");
            tbl7_lbl[t] = new Label("---Данные для таблицы REPORT_OKUD_CODE---");
            //tbl8_lbl[t] = new Label("---Данные для таблицы REPORT_FORM_SRC---");
            tbl9_lbl[t] = new Label("---Данные для таблицы REPORT_REP_SUBJ_TYPE---");
            tbl10_lbl[t] = new Label("---Данные для таблицы EHD_ACS_OBJECTS---");
        }
        for(int o = 0; o <= count-1;){

            //System.out.print("o = " + o );

            exjp0_set[o].getChildren().addAll(form_name_lbl[o], Form_name_txtf[o]);
            exjp1_set[o].getChildren().addAll(form_cd_lbl[o], Form_cd_txtf[o]);
            exjp2_set[o].getChildren().addAll(form_cd_name_lbl[o], Form_cd_name_txtf[o]);
            exjp3_set[o].getChildren().addAll(OKUD_lbl[o], Form_okud_txtf[o]);
            exjp4_set[o].getChildren().addAll(form_cd_cog_lbl[o], Form_cd_cog_txtf[o]);
            exjp5_set[o].getChildren().addAll(Flag_IOD_lbl[o], Flag_IOD_cmbx[o]);
            exjp6_set[o].getChildren().addAll(Flag_PDN_lbl[o], Flag_PDN_cmbx[o]);
            exjp7_set[o].getChildren().addAll(Dep_name_lbl[o], Dep_name_txtf[o]);
            exjp9_set[o].getChildren().addAll(Dep_u_name_lbl[o], Dep_u_name_txtf[o]);
            exjp10_set[o].getChildren().addAll(reason_lbl[o], reason_txtf[o]);
            exjp11_set[o].getChildren().addAll(System_id_lbl[o], System_id_txtf[o]);
            exjp12_set[o].getChildren().addAll(Security_role_path_lbl[o], Security_role_path_txtf[o]);
            exjp13_set[o].getChildren().addAll(Search_path_lbl[o], Search_path_txtf[o]);
            exjp14_set[o].getChildren().addAll(Form_formal_code_lbl[o], Form_formal_code_txtf[o]);
            exjp15_set[o].getChildren().addAll(Desc_lbl[o], Desc_txtf[o]);
            exjp16_set[o].getChildren().addAll(period_lbl[o], period_cmbx[o]);
            exjp17_set[o].getChildren().addAll(rep_subj_type_lbl[o], rep_subj_type_cmbx[o]);
            exjp18_set[o].getChildren().addAll(p_parent_code_lbl[o], p_parent_code_txtf[o]);
            exjp19_set[o].getChildren().addAll(p_parent_type_ref_lbl[o], p_parent_type_ref_txtf[o]);
            exjp20_set[o].getChildren().addAll(p_type_ref_lbl[o], p_type_ref_txtf[o]);
            exjp21_set[o].getChildren().addAll(p_source_ref_lbl[o], p_source_ref_txtf[o]);
            exjp22_set[o].getChildren().addAll(Security_role_name_lbl[o], Security_role_name_txtf[o]);
            p_tbl_1[o].getChildren().addAll(tbl1_lbl[o]);
            p_tbl_2[o].getChildren().addAll(tbl2_lbl[o]);
            p_tbl_3[o].getChildren().addAll(tbl3_lbl[o]);
            p_tbl_4[o].getChildren().addAll(tbl4_lbl[o]);
            //p_tbl_5[o].getChildren().addAll(tbl5_lbl[o]);
            p_tbl_6[o].getChildren().addAll(tbl6_lbl[o]);
            p_tbl_7[o].getChildren().addAll(tbl7_lbl[o]);
            //p_tbl_8[o].getChildren().addAll(tbl8_lbl[o]);
            p_tbl_9[o].getChildren().addAll(tbl9_lbl[o]);
            p_tbl_10[o].getChildren().addAll(tbl10_lbl[o]);

            PanelSet[o].getChildren().addAll(p_tbl_1[o], exjp1_set[o], exjp2_set[o], p_tbl_2[o], exjp4_set[o], p_tbl_3[o], exjp5_set[o], exjp6_set[o], p_tbl_4[o], exjp7_set[o], exjp9_set[o], exjp10_set[o], p_tbl_6[o],
                    exjp13_set[o], exjp14_set[o], exjp15_set[o], exjp11_set[o], exjp22_set[o], exjp12_set[o], p_tbl_7[o], exjp3_set[o], exjp16_set[o], p_tbl_9[o], exjp17_set[o], p_tbl_10[o], exjp0_set[o], exjp18_set[o],
                    exjp19_set[o], exjp20_set[o], exjp21_set[o]);
            sp.getTabs().add(new Tab("Форма " + (o+1), PanelSet[o]));
            o++;
        }
        root.getChildren().add(sp);
        sp.setLayoutX(15);
        sp.setLayoutY(160);

        mnf.setWidth(1720);
        mnf.setHeight(1270);
        mnf.centerOnScreen();

        createBtn.setVisible(true);
        createBtn.setDisable(false);
        }

   public static TabPane getSp(){
        return OK_Action.sp;
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
    public static ComboBox<String>[] getFlag_IOD_cmbx(){
            return OK_Action.Flag_IOD_cmbx;
    }
    public static ComboBox<String>[] getFlag_PDN_cmbx(){
            return OK_Action.Flag_PDN_cmbx;
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
    public static ComboBox<String>[] getPeriod_txtf(){
            return OK_Action.period_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type_txtf(){
            return OK_Action.rep_subj_type_cmbx;
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
}


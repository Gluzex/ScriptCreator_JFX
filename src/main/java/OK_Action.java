import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OK_Action {
    private static TabPane sp;
    private Tab[] tabs = new Tab[16];
    private Stage mnf;
    private static TextField[] Form_name_txtf = new TextField[16];
    private static TextField[] Form_cd_txtf = new TextField[16];
    private static TextField[] Form_cd_name_txtf = new TextField[16];
    private static TextField[] Form_okud_txtf = new TextField[16];
    private static TextField[] Form_okud2_txtf = new TextField[16];
    private static TextField[] Form_okud3_txtf = new TextField[16];
    private static TextField[] Form_okud4_txtf = new TextField[16];
    private static TextField[] Form_okud5_txtf = new TextField[16];
    private static TextField[] Form_okud6_txtf = new TextField[16];
    private static TextField[] Form_okud7_txtf = new TextField[16];
    private static TextField[] Form_okud8_txtf = new TextField[16];
    private static TextField[] Form_cd_cog_txtf = new TextField[16];
    private static ComboBox<String>[] Flag_IOD_cmbx = new ComboBox[16];
    private static ComboBox<String>[] Flag_PDN_cmbx = new ComboBox[16];
    private static TextField[] Dep_name_txtf = new TextField[16];
    private static TextField[] Dep_name2_txtf = new TextField[16];
    private static TextField[] Dep_name3_txtf = new TextField[16];
    private static TextField[] Dep_name4_txtf = new TextField[16];
    private static TextField[] Dep_name5_txtf = new TextField[16];
    private static TextField[] Dep_name6_txtf = new TextField[16];
    private static TextField[] Dep_name7_txtf = new TextField[16];
    private static TextField[] Dep_name8_txtf = new TextField[16];
    private static TextField[] Dep_u_name_txtf = new TextField[16];
    private static TextField[] Dep_u_name2_txtf = new TextField[16];
    private static TextField[] Dep_u_name3_txtf = new TextField[16];
    private static TextField[] Dep_u_name4_txtf = new TextField[16];
    private static TextField[] Dep_u_name5_txtf = new TextField[16];
    private static TextField[] Dep_u_name6_txtf = new TextField[16];
    private static TextField[] Dep_u_name7_txtf = new TextField[16];
    private static TextField[] Dep_u_name8_txtf = new TextField[16];
    private static TextField[] reason_txtf = new TextField[16];
    private static TextField[] System_id_txtf = new TextField[16];
    private static TextField[] Security_role_path_txtf = new TextField[16];
    private static TextField[] Search_path_txtf = new TextField[16];
    private static TextField[] Form_formal_code_txtf = new TextField[16];
    private static TextField[] Desc_txtf = new TextField[16];
    private static ComboBox<String>[] period_cmbx = new ComboBox[16];
    private static ComboBox<String>[] period2_cmbx = new ComboBox[16];
    private static ComboBox<String>[] period3_cmbx = new ComboBox[16];
    private static ComboBox<String>[] period4_cmbx = new ComboBox[16];
    private static ComboBox<String>[] period5_cmbx = new ComboBox[16];
    private static ComboBox<String>[] period6_cmbx = new ComboBox[16];
    private static ComboBox<String>[] period7_cmbx = new ComboBox[16];
    private static ComboBox<String>[] period8_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type2_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type3_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type4_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type5_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type6_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type7_cmbx = new ComboBox[16];
    private static ComboBox<String>[] rep_subj_type8_cmbx = new ComboBox[16];
    private static TextField[] p_parent_code_txtf = new TextField[16];
    private static TextField[] p_parent_type_ref_txtf = new TextField[16];
    private static TextField[] p_type_ref_txtf = new TextField[16];
    private static TextField[] p_source_ref_txtf = new TextField[16];
    private static TextField[] Security_role_name_txtf = new TextField[16];
    private static int[] dep_count = new int[16];
    private static int[] dep_u_count = new int[16];
    private static int[] okud_count = new int[16];
    private static int[] subj_count = new int[16];
    private static byte[] rep_or_code = new byte[16];
    private ScrollPane[] PanelScroll = new ScrollPane[16];
    private VBox[] PanelSet = new VBox[16];
    private VBox PanelNull = new VBox();
    private HBox[] exjp0_set = new HBox[16];
    private HBox[] exjp1_set = new HBox[16];
    private HBox[] exjp2_set = new HBox[16];
    private VBox[] exjp3_V_set= new VBox[16];
    private HBox[] exjp3_set = new HBox[16];
    private HBox[] exjp3_2_set = new HBox[16];
    private HBox[] exjp3_3_set = new HBox[16];
    private HBox[] exjp3_4_set = new HBox[16];
    private HBox[] exjp3_5_set = new HBox[16];
    private HBox[] exjp3_6_set = new HBox[16];
    private HBox[] exjp3_7_set = new HBox[16];
    private HBox[] exjp3_8_set = new HBox[16];
    private HBox[] exjp4_set = new HBox[16];
    private HBox[] exjp5_set = new HBox[16];
    private HBox[] exjp6_set = new HBox[16];
    private VBox[] exjp7_V_set= new VBox[16];
    private HBox[] exjp7_set= new HBox[16];
    private HBox[] exjp7_2_set= new HBox[16];
    private HBox[] exjp7_3_set= new HBox[16];
    private HBox[] exjp7_4_set= new HBox[16];
    private HBox[] exjp7_5_set= new HBox[16];
    private HBox[] exjp7_6_set= new HBox[16];
    private HBox[] exjp7_7_set= new HBox[16];
    private HBox[] exjp7_8_set= new HBox[16];
    //HBox[] exjp8_set = new HBox[16];
    private VBox[] exjp9_V_set= new VBox[16];
    private HBox[] exjp9_set = new HBox[16];
    private HBox[] exjp9_2_set = new HBox[16];
    private HBox[] exjp9_3_set = new HBox[16];
    private HBox[] exjp9_4_set = new HBox[16];
    private HBox[] exjp9_5_set = new HBox[16];
    private HBox[] exjp9_6_set = new HBox[16];
    private HBox[] exjp9_7_set = new HBox[16];
    private HBox[] exjp9_8_set = new HBox[16];
    private HBox[] exjp10_set = new HBox[16];
    private HBox[] exjp11_set = new HBox[16];
    private HBox[] exjp12_set = new HBox[16];
    private HBox[] exjp13_set = new HBox[16];
    private HBox[] exjp14_set = new HBox[16];
    private HBox[] exjp15_set = new HBox[16];
    private HBox[] exjp16_set = new HBox[16];
    private HBox[] exjp16_2_set = new HBox[16];
    private HBox[] exjp16_3_set = new HBox[16];
    private HBox[] exjp16_4_set = new HBox[16];
    private HBox[] exjp16_5_set = new HBox[16];
    private HBox[] exjp16_6_set = new HBox[16];
    private HBox[] exjp16_7_set = new HBox[16];
    private HBox[] exjp16_8_set = new HBox[16];
    private VBox[] exjp17_V_set= new VBox[16];
    private HBox[] exjp17_set = new HBox[16];
    private HBox[] exjp17_2_set = new HBox[16];
    private HBox[] exjp17_3_set = new HBox[16];
    private HBox[] exjp17_4_set = new HBox[16];
    private HBox[] exjp17_5_set = new HBox[16];
    private HBox[] exjp17_6_set = new HBox[16];
    private HBox[] exjp17_7_set = new HBox[16];
    private HBox[] exjp17_8_set = new HBox[16];
    private HBox[] exjp18_set = new HBox[16];
    private HBox[] exjp19_set = new HBox[16];
    private HBox[] exjp20_set = new HBox[16];
    private HBox[] exjp21_set = new HBox[16];
    private HBox[] exjp22_set = new HBox[16];
    private HBox[] radioBtn_set = new HBox[16];
    private HBox[] radioBtn_set_2 = new HBox[16];
    private VBox[] p_tbl_1 = new VBox[16];
    private VBox[] p_tbl_2 = new VBox[16];
    private VBox[] p_tbl_3 = new VBox[16];
    private VBox[] p_tbl_4 = new VBox[16];
    //VBox[] p_tbl_5 = new VBox[16];
    private VBox[] p_tbl_6 = new VBox[16];
    private VBox[] p_tbl_7 = new VBox[16];
    //VBox[] p_tbl_8 = new VBox[16];
    private VBox[] p_tbl_9 = new VBox[16];
    private VBox[] p_tbl_10 = new VBox[16];
    private HBox[] p_cmbx_dep_1 = new HBox[16];
    private HBox[] p_cmbx_dep_2 = new HBox[16];
    private HBox[] p_cmbx_okud = new HBox[16];
    private HBox[] p_cmbx_subj = new HBox[16];
    private HBox[] p_okud_repform_lbl = new HBox[16];

    private Label[] form_name_lbl = new Label[16];
    private Label[] form_cd_lbl = new Label[16];
    private Label[] form_cd_name_lbl = new Label[16];
    private Label[] OKUD_lbl = new Label[16];
    private Label[] OKUD2_lbl = new Label[16];
    private Label[] OKUD3_lbl = new Label[16];
    private Label[] OKUD4_lbl = new Label[16];
    private Label[] OKUD5_lbl = new Label[16];
    private Label[] OKUD6_lbl = new Label[16];
    private Label[] OKUD7_lbl = new Label[16];
    private Label[] OKUD8_lbl = new Label[16];
    private Label[] form_cd_cog_lbl = new Label[16];
    private Label[] Flag_IOD_lbl = new Label[16];
    private Label[] Flag_PDN_lbl = new Label[16];
    private Label[] Dep_name_lbl = new Label[16];
    private Label[] Dep_name2_lbl = new Label[16];
    private Label[] Dep_name3_lbl = new Label[16];
    private Label[] Dep_name4_lbl = new Label[16];
    private Label[] Dep_name5_lbl = new Label[16];
    private Label[] Dep_name6_lbl = new Label[16];
    private Label[] Dep_name7_lbl = new Label[16];
    private Label[] Dep_name8_lbl = new Label[16];
    private Label[] Dep_u_name_lbl = new Label[16];
    private Label[] Dep_u_name2_lbl = new Label[16];
    private Label[] Dep_u_name3_lbl = new Label[16];
    private Label[] Dep_u_name4_lbl = new Label[16];
    private Label[] Dep_u_name5_lbl = new Label[16];
    private Label[] Dep_u_name6_lbl = new Label[16];
    private Label[] Dep_u_name7_lbl = new Label[16];
    private Label[] Dep_u_name8_lbl = new Label[16];
    private Label[] reason_lbl = new Label[16];
    private Label[] System_id_lbl = new Label[16];
    private Label[] Security_role_path_lbl = new Label[16];
    private Label[] Search_path_lbl = new Label[16];
    private Label[] Form_formal_code_lbl = new Label[16];
    private Label[] Desc_lbl = new Label[16];
    private Label[] period_lbl = new Label[16];
    private Label[] period2_lbl = new Label[16];
    private Label[] period3_lbl = new Label[16];
    private Label[] period4_lbl = new Label[16];
    private Label[] period5_lbl = new Label[16];
    private Label[] period6_lbl = new Label[16];
    private Label[] period7_lbl = new Label[16];
    private Label[] period8_lbl = new Label[16];
    private Label[] rep_subj_type_lbl = new Label[16];
    private Label[] rep_subj_type2_lbl = new Label[16];
    private Label[] rep_subj_type3_lbl = new Label[16];
    private Label[] rep_subj_type4_lbl = new Label[16];
    private Label[] rep_subj_type5_lbl = new Label[16];
    private Label[] rep_subj_type6_lbl = new Label[16];
    private Label[] rep_subj_type7_lbl = new Label[16];
    private Label[] rep_subj_type8_lbl = new Label[16];
    private Label[] p_parent_code_lbl = new Label[16];
    private Label[] p_parent_type_ref_lbl = new Label[16];
    private Label[] p_type_ref_lbl = new Label[16];
    private Label[] p_source_ref_lbl = new Label[16];
    private Label[] Security_role_name_lbl = new Label[16];
    private Label[] tbl1_lbl = new Label[16];
    private Label[] tbl2_lbl = new Label[16];
    private Label[] tbl3_lbl = new Label[16];
    private Label[] tbl4_lbl = new Label[16];
    //Label[] tbl5_lbl = new Label[16];
    private Label[] tbl6_lbl = new Label[16];
    private Label[] tbl7_lbl = new Label[16];
    //Label[] tbl8_lbl = new Label[16];
    private Label[] tbl9_lbl = new Label[16];
    private Label[] tbl10_lbl = new Label[16];
    private Label[] cmbx_dep_1_lbl = new Label[16];
    private Label[] cmbx_dep_2_lbl = new Label[16];
    private Label[] cmbx_okud_lbl = new Label[16];
    private Label[] cmbx_subj_lbl = new Label[16];

    private Tooltip tooltip1 = new Tooltip ("Флаг (Y/N) - признак наличия данных категории ИОД в отчетах доступных по данному коду, принимает значения \"Y\" или \"N\"");
    private Tooltip tooltip1_1 = new Tooltip ("Флаг (Y/N) - признак наличия данных категории ПДН в отчетах доступных по данному коду, принимает значения \"Y\" или \"N\"");
    private Tooltip tooltip2 = new Tooltip ("Период сбора регламентированной формы");
    private Tooltip tooltip3 = new Tooltip ("Разрез, в котором представлены данные отчета");
    private Tooltip tooltip4 = new Tooltip ("Код доступа - технический код доступа к отчету/папке/группе отчетов/витрине");
    private Tooltip tooltip5 = new Tooltip ("Наименование кода доступа - наименование для данного кода доступа, видимое пользователю");
    private Tooltip tooltip6 = new Tooltip ("Код потока - Код, поставленный в соответсвие коду доступа (form_cd таблицы rep и других таблиц, на которые наложены политики по коду потока)");
    private Tooltip tooltip7 = new Tooltip ("Сокращенное наименование департамента-владельца для отчетов, доступных по данному коду доступа");
    private Tooltip tooltip7_2 = new Tooltip ("Сокращенное наименование департамента-пользователя для отчетов, доступных по данному коду доступа");
    private Tooltip tooltip8 = new Tooltip ("Документ-основание - на основе какого документа тот или иной департамент является владельцем");
    private Tooltip tooltip9 = new Tooltip ("Уникальный код отчета - уникальный буквенно-цифровой код присвоенный отчету в задаче на разработку, однозначно определяющий его");
    private Tooltip tooltip10 = new Tooltip ("ОКУД всех регламентированных форм-источников данного отчета");
    private int count;
    private RadioButton[] caseReport = new RadioButton[16];
    private RadioButton[] caseCode = new RadioButton[16];
    private RadioButton[] caseR = new RadioButton[16];
    private RadioButton[] caseNR = new RadioButton[16];
    private ComboBox<Integer>[] Cmbx_dep_1 = new ComboBox[16];
    private ComboBox<Integer>[] Cmbx_dep_2 = new ComboBox[16];
    private ComboBox<Integer>[] Cmbx_okud = new ComboBox[16];
    private ComboBox<Integer>[] Cmbx_subj = new ComboBox[16];
    private Label[] okud_repform_lbl = new Label[16];

    public OK_Action(int count, AnchorPane root, Stage primaryStage, Button createBtn){
        this.mnf = primaryStage;
        this.count = count;
        sp = new TabPane();
        sp.setPrefSize(1680, 700);
        /*tooltip1.setShowDuration(Duration.seconds(8.0));
        tooltip1_1.setShowDuration(Duration.seconds(8.0));
        tooltip2.setShowDuration(Duration.seconds(8.0));
        tooltip3.setShowDuration(Duration.seconds(8.0));
        tooltip4.setShowDuration(Duration.seconds(8.0));
        tooltip5.setShowDuration(Duration.seconds(8.0));
        tooltip6.setShowDuration(Duration.seconds(8.0));
        tooltip7.setShowDuration(Duration.seconds(8.0));
        tooltip7_2.setShowDuration(Duration.seconds(8.0));
        tooltip8.setShowDuration(Duration.seconds(8.0));
        tooltip9.setShowDuration(Duration.seconds(8.0));
        tooltip10.setShowDuration(Duration.seconds(8.0));*/
        for(int t = 0; t<=15; t++){
            PanelSet[t] = new VBox(7.0);
            PanelSet[t].setPadding(new Insets(10.0));
            exjp0_set[t] = new HBox(15.0);
            exjp1_set[t] = new HBox(15.0);
            exjp2_set[t] = new HBox(15.0);
            exjp3_V_set[t] = new VBox(15.0);
            exjp3_set[t] = new HBox(15.0);
            exjp3_2_set[t] = new HBox(15.0);
            exjp3_3_set[t] = new HBox(15.0);
            exjp3_4_set[t] = new HBox(15.0);
            exjp3_5_set[t] = new HBox(15.0);
            exjp3_6_set[t] = new HBox(15.0);
            exjp3_7_set[t] = new HBox(15.0);
            exjp3_8_set[t] = new HBox(15.0);
            exjp4_set[t] = new HBox(15.0);
            exjp5_set[t] = new HBox(15.0);
            exjp6_set[t] = new HBox(15.0);
            exjp7_V_set[t] = new VBox(15.0);
            exjp7_set[t] = new HBox(15.0);
            exjp7_2_set[t] = new HBox(15.0);
            exjp7_3_set[t] = new HBox(15.0);
            exjp7_4_set[t] = new HBox(15.0);
            exjp7_5_set[t] = new HBox(15.0);
            exjp7_6_set[t] = new HBox(15.0);
            exjp7_7_set[t] = new HBox(15.0);
            exjp7_8_set[t] = new HBox(15.0);
            //exjp8_set[t] = new HBox(15.0);
            exjp9_V_set[t] = new VBox(15.0);
            exjp9_set[t] = new HBox(15.0);
            exjp9_2_set[t] = new HBox(15.0);
            exjp9_3_set[t] = new HBox(15.0);
            exjp9_4_set[t] = new HBox(15.0);
            exjp9_5_set[t] = new HBox(15.0);
            exjp9_6_set[t] = new HBox(15.0);
            exjp9_7_set[t] = new HBox(15.0);
            exjp9_8_set[t] = new HBox(15.0);
            exjp10_set[t] = new HBox(15.0);
            exjp11_set[t] = new HBox(15.0);
            exjp12_set[t] = new HBox(15.0);
            exjp13_set[t] = new HBox(15.0);
            exjp14_set[t] = new HBox(15.0);
            exjp15_set[t] = new HBox(15.0);
            exjp16_set[t] = new HBox(15.0);
            exjp16_2_set[t] = new HBox(15.0);
            exjp16_3_set[t] = new HBox(15.0);
            exjp16_4_set[t] = new HBox(15.0);
            exjp16_5_set[t] = new HBox(15.0);
            exjp16_6_set[t] = new HBox(15.0);
            exjp16_7_set[t] = new HBox(15.0);
            exjp16_8_set[t] = new HBox(15.0);
            exjp17_V_set[t] = new VBox(15.0);
            exjp17_set[t] = new HBox(15.0);
            exjp17_2_set[t] = new HBox(15.0);
            exjp17_3_set[t] = new HBox(15.0);
            exjp17_4_set[t] = new HBox(15.0);
            exjp17_5_set[t] = new HBox(15.0);
            exjp17_6_set[t] = new HBox(15.0);
            exjp17_7_set[t] = new HBox(15.0);
            exjp17_8_set[t] = new HBox(15.0);
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
            radioBtn_set[t] = new HBox(25.0);
            radioBtn_set_2[t] = new HBox(25.0);
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
            p_cmbx_dep_1[t] = new HBox(15.0);
            p_cmbx_dep_2[t] = new HBox(15.0);
            p_cmbx_okud[t] = new HBox(15.0);
            p_cmbx_subj[t] = new HBox(15.0);
            p_okud_repform_lbl[t] = new HBox(15.0);
            Form_name_txtf[t] = new TextField();
            Form_cd_txtf[t] =  new TextField();
            Form_cd_txtf[t].setTooltip(tooltip4);
            Form_cd_name_txtf[t] =  new TextField();
            Form_cd_name_txtf[t].setTooltip(tooltip5);
            Form_okud_txtf[t] =  new TextField();
            Form_okud_txtf[t].setTooltip(tooltip10);
            Form_okud2_txtf[t] =  new TextField();
            Form_okud2_txtf[t].setTooltip(tooltip10);
            Form_okud3_txtf[t] =  new TextField();
            Form_okud3_txtf[t].setTooltip(tooltip10);
            Form_okud4_txtf[t] =  new TextField();
            Form_okud4_txtf[t].setTooltip(tooltip10);
            Form_okud5_txtf[t] =  new TextField();
            Form_okud5_txtf[t].setTooltip(tooltip10);
            Form_okud6_txtf[t] =  new TextField();
            Form_okud6_txtf[t].setTooltip(tooltip10);
            Form_okud7_txtf[t] =  new TextField();
            Form_okud7_txtf[t].setTooltip(tooltip10);
            Form_okud8_txtf[t] =  new TextField();
            Form_okud8_txtf[t].setTooltip(tooltip10);
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
            Dep_name2_txtf[t] =  new TextField();
            Dep_name2_txtf[t].setTooltip(tooltip7);
            Dep_name3_txtf[t] =  new TextField();
            Dep_name3_txtf[t].setTooltip(tooltip7);
            Dep_name4_txtf[t] =  new TextField();
            Dep_name4_txtf[t].setTooltip(tooltip7);
            Dep_name5_txtf[t] =  new TextField();
            Dep_name5_txtf[t].setTooltip(tooltip7);
            Dep_name6_txtf[t] =  new TextField();
            Dep_name6_txtf[t].setTooltip(tooltip7);
            Dep_name7_txtf[t] =  new TextField();
            Dep_name7_txtf[t].setTooltip(tooltip7);
            Dep_name8_txtf[t] =  new TextField();
            Dep_name8_txtf[t].setTooltip(tooltip7);
            Dep_u_name_txtf[t] =  new TextField();
            Dep_u_name_txtf[t].setTooltip(tooltip7_2);
            Dep_u_name2_txtf[t] =  new TextField();
            Dep_u_name2_txtf[t].setTooltip(tooltip7_2);
            Dep_u_name3_txtf[t] =  new TextField();
            Dep_u_name3_txtf[t].setTooltip(tooltip7_2);
            Dep_u_name4_txtf[t] =  new TextField();
            Dep_u_name4_txtf[t].setTooltip(tooltip7_2);
            Dep_u_name5_txtf[t] =  new TextField();
            Dep_u_name5_txtf[t].setTooltip(tooltip7_2);
            Dep_u_name6_txtf[t] =  new TextField();
            Dep_u_name6_txtf[t].setTooltip(tooltip7_2);
            Dep_u_name7_txtf[t] =  new TextField();
            Dep_u_name7_txtf[t].setTooltip(tooltip7_2);
            Dep_u_name8_txtf[t] =  new TextField();
            Dep_u_name8_txtf[t].setTooltip(tooltip7_2);
            reason_txtf[t] =  new TextField();
            reason_txtf[t].setTooltip(tooltip8);
            System_id_txtf[t] =  new TextField();
            Security_role_path_txtf[t] =  new TextField();
            Search_path_txtf[t] =  new TextField();
            Form_formal_code_txtf[t] =  new TextField();
            Form_formal_code_txtf[t].setTooltip(tooltip9);
            Desc_txtf[t] =  new TextField();
            period_cmbx[t] =  new ComboBox<String>();
            period_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period_cmbx[t].setTooltip(tooltip2);
            period2_cmbx[t] =  new ComboBox<String>();
            period2_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period2_cmbx[t].setTooltip(tooltip2);
            period3_cmbx[t] =  new ComboBox<String>();
            period3_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period3_cmbx[t].setTooltip(tooltip2);
            period4_cmbx[t] =  new ComboBox<String>();
            period4_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period4_cmbx[t].setTooltip(tooltip2);
            period5_cmbx[t] =  new ComboBox<String>();
            period5_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period5_cmbx[t].setTooltip(tooltip2);
            period6_cmbx[t] =  new ComboBox<String>();
            period6_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period6_cmbx[t].setTooltip(tooltip2);
            period7_cmbx[t] =  new ComboBox<String>();
            period7_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period7_cmbx[t].setTooltip(tooltip2);
            period8_cmbx[t] =  new ComboBox<String>();
            period8_cmbx[t].getItems().addAll("годовая", "квартальная", "месячная", "суточная", "нерегулярная");
            period8_cmbx[t].setTooltip(tooltip2);
            rep_subj_type_cmbx[t] =  new ComboBox<String>();
            rep_subj_type_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type_cmbx[t].setTooltip(tooltip3);
            rep_subj_type2_cmbx[t] =  new ComboBox<String>();
            rep_subj_type2_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type2_cmbx[t].setTooltip(tooltip3);
            rep_subj_type3_cmbx[t] =  new ComboBox<String>();
            rep_subj_type3_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type3_cmbx[t].setTooltip(tooltip3);
            rep_subj_type4_cmbx[t] =  new ComboBox<String>();
            rep_subj_type4_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type4_cmbx[t].setTooltip(tooltip3);
            rep_subj_type5_cmbx[t] =  new ComboBox<String>();
            rep_subj_type5_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type5_cmbx[t].setTooltip(tooltip3);
            rep_subj_type6_cmbx[t] =  new ComboBox<String>();
            rep_subj_type6_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type6_cmbx[t].setTooltip(tooltip3);
            rep_subj_type7_cmbx[t] =  new ComboBox<String>();
            rep_subj_type7_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type7_cmbx[t].setTooltip(tooltip3);
            rep_subj_type8_cmbx[t] =  new ComboBox<String>();
            rep_subj_type8_cmbx[t].getItems().addAll("КО", "ОПДС", "ОПС", "ТУ", "Холдинги", "БГ", "Филиалы КО", "СП БР", "Свод по РФ", "ТОФК");
            rep_subj_type8_cmbx[t].setTooltip(tooltip3);
            p_parent_code_txtf[t] =  new TextField();
            p_parent_type_ref_txtf[t] =  new TextField();
            p_type_ref_txtf[t] =  new TextField();
            p_source_ref_txtf[t] =  new TextField();
            Security_role_name_txtf[t] =  new TextField();

            Form_name_txtf[t].setMinWidth(50.0);
            Form_name_txtf[t].setPrefColumnCount(70);
            reason_txtf[t].setMinWidth(50.0);
            reason_txtf[t].setPrefColumnCount(70);
            Security_role_path_txtf[t].setMinWidth(75.0);
            Security_role_path_txtf[t].setPrefColumnCount(100);
            Search_path_txtf[t].setMinWidth(75.0);
            Search_path_txtf[t].setPrefColumnCount(125);
            Desc_txtf[t].setMinWidth(75.0);
            Desc_txtf[t].setPrefColumnCount(125);

            form_name_lbl[t] = new Label("Имя отчета(или кода доступа): ");
            form_cd_lbl[t] = new Label("Код доступа: ");
            form_cd_name_lbl[t] = new Label("Наименование кода доступа: ");
            OKUD_lbl[t] = new Label("ОКУД: ");
            OKUD2_lbl[t] = new Label("ОКУД: ");
            OKUD3_lbl[t] = new Label("ОКУД: ");
            OKUD4_lbl[t] = new Label("ОКУД: ");
            OKUD5_lbl[t] = new Label("ОКУД: ");
            OKUD6_lbl[t] = new Label("ОКУД: ");
            OKUD7_lbl[t] = new Label("ОКУД: ");
            OKUD8_lbl[t] = new Label("ОКУД: ");
            form_cd_cog_lbl[t] = new Label("Код потока(Когнос): ");
            Flag_IOD_lbl[t] = new Label("Флаг ИОД: ");
            Flag_PDN_lbl[t] = new Label("Флаг ПДН: ");
            Dep_name_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_name2_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_name3_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_name4_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_name5_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_name6_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_name7_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_name8_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_OWNER: ");
            Dep_u_name_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            Dep_u_name2_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            Dep_u_name3_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            Dep_u_name4_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            Dep_u_name5_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            Dep_u_name6_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            Dep_u_name7_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            Dep_u_name8_lbl[t] = new Label("Сокращенное наименование департамента для REP_FORM_DEP_USER: ");
            reason_lbl[t] = new Label("Документ-основание: ");
            System_id_lbl[t] = new Label("System_id: ");
            Security_role_path_lbl[t] = new Label("Security_role_path: ");
            Search_path_lbl[t] = new Label("Полный путь отчета/папки(Search_path): ");
            Form_formal_code_lbl[t] = new Label("Уникальный код отчета: ");
            Desc_lbl[t] = new Label("Описание: ");
            period_lbl[t] = new Label("Период сбора: ");
            period2_lbl[t] = new Label("Период сбора: ");
            period3_lbl[t] = new Label("Период сбора: ");
            period4_lbl[t] = new Label("Период сбора: ");
            period5_lbl[t] = new Label("Период сбора: ");
            period6_lbl[t] = new Label("Период сбора: ");
            period7_lbl[t] = new Label("Период сбора: ");
            period8_lbl[t] = new Label("Период сбора: ");
            rep_subj_type_lbl[t] = new Label("Разрез: ");
            rep_subj_type2_lbl[t] = new Label("Разрез: ");
            rep_subj_type3_lbl[t] = new Label("Разрез: ");
            rep_subj_type4_lbl[t] = new Label("Разрез: ");
            rep_subj_type5_lbl[t] = new Label("Разрез: ");
            rep_subj_type6_lbl[t] = new Label("Разрез: ");
            rep_subj_type7_lbl[t] = new Label("Разрез: ");
            rep_subj_type8_lbl[t] = new Label("Разрез: ");
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
            cmbx_dep_1_lbl[t] = new Label("Кол-во департаментов-владельцев для кода доступа");
            cmbx_dep_2_lbl[t] = new Label("Кол-во департаментов-пользователей для кода доступа");
            cmbx_okud_lbl[t] = new Label("Кол-во ОКУД для данного отчета");
            cmbx_subj_lbl[t] = new Label("Кол-во разрезов для данного отчета");
            okud_repform_lbl[t] = new Label("Для регламентированных кодов доступа заполнение ОКУД обязательно!");

            caseCode[t] = new RadioButton("Код доступа");
            //caseCode[t].setOnAction(this::onChoose1);
            int fT = t;
            caseCode[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Case_code(fT);
                    //caseCode[fT].setDisable(true);
                    caseCode[fT].setSelected(true);
                    caseReport[fT].setSelected(false);
                    //caseReport[fT].setDisable(true);
                }
            });
            caseReport[t] = new RadioButton("Отчёт");
            caseReport[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Case_report(fT);
                    //caseReport[fT].setDisable(true);
                    caseReport[fT].setSelected(true);
                    caseCode[fT].setSelected(false);
                    //caseCode[fT].setDisable(true);
                }
            });
            caseR[t] = new RadioButton("Регламентированный");
            caseR[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Case_RNR(fT, true);
                    //caseCode[fT].setDisable(true);
                    caseR[fT].setSelected(true);
                    caseNR[fT].setSelected(false);
                    //caseReport[fT].setDisable(true);
                }
            });
            caseNR[t] = new RadioButton("Нерегламентированный");
            caseNR[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Case_RNR(fT, false);
                    //caseCode[fT].setDisable(true);
                    caseNR[fT].setSelected(true);
                    caseR[fT].setSelected(false);
                    //caseReport[fT].setDisable(true);
                }
            });
            caseReport[t].setSelected(true);
            tabs[t] = new Tab();

            Cmbx_dep_1[t] = new ComboBox<Integer>();
            Cmbx_dep_1[t].getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
            Cmbx_dep_1[t].setValue(1);
            dep_count[t] = 1;
            Cmbx_dep_1[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dep_count[fT] = Cmbx_dep_1[fT].getValue();
                    Dep_count(fT);
                }
            });

            Cmbx_dep_2[t] = new ComboBox<Integer>();
            Cmbx_dep_2[t].getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
            Cmbx_dep_2[t].setValue(1);
            dep_u_count[t] = 1;
            Cmbx_dep_2[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dep_u_count[fT] = Cmbx_dep_2[fT].getValue();
                    Dep_u_count(fT);
                }
            });
            Cmbx_okud[t] = new ComboBox<Integer>();
            Cmbx_okud[t].getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
            Cmbx_okud[t].setValue(1);
            okud_count[t] = 1;
            Cmbx_okud[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    okud_count[fT] = Cmbx_okud[fT].getValue();
                    Okud_count(fT);
                }
            });

            Cmbx_subj[t] = new ComboBox<Integer>();
            Cmbx_subj[t].getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
            Cmbx_subj[t].setValue(1);
            subj_count[t] = 1;
            Cmbx_subj[t].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    subj_count[fT] = Cmbx_subj[fT].getValue();
                    Subj_count(fT);
                }
            });

            rep_or_code[t] = 0;
        }
        for(int o = 0; o <= count-1;){
            //System.out.print("o = " + o );
            exjp0_set[o].getChildren().addAll(form_name_lbl[o], Form_name_txtf[o]);
            exjp1_set[o].getChildren().addAll(form_cd_lbl[o], Form_cd_txtf[o]);
            exjp2_set[o].getChildren().addAll(form_cd_name_lbl[o], Form_cd_name_txtf[o]);
            exjp3_set[o].getChildren().addAll(OKUD_lbl[o], Form_okud_txtf[o]);
            exjp3_2_set[o].getChildren().addAll(OKUD2_lbl[o], Form_okud2_txtf[o]);
            exjp3_3_set[o].getChildren().addAll(OKUD3_lbl[o], Form_okud3_txtf[o]);
            exjp3_4_set[o].getChildren().addAll(OKUD4_lbl[o], Form_okud4_txtf[o]);
            exjp3_5_set[o].getChildren().addAll(OKUD5_lbl[o], Form_okud5_txtf[o]);
            exjp3_6_set[o].getChildren().addAll(OKUD6_lbl[o], Form_okud6_txtf[o]);
            exjp3_7_set[o].getChildren().addAll(OKUD7_lbl[o], Form_okud7_txtf[o]);
            exjp3_8_set[o].getChildren().addAll(OKUD8_lbl[o], Form_okud8_txtf[o]);
            exjp4_set[o].getChildren().addAll(form_cd_cog_lbl[o], Form_cd_cog_txtf[o]);
            exjp5_set[o].getChildren().addAll(Flag_IOD_lbl[o], Flag_IOD_cmbx[o]);
            exjp6_set[o].getChildren().addAll(Flag_PDN_lbl[o], Flag_PDN_cmbx[o]);
            exjp7_set[o].getChildren().addAll(Dep_name_lbl[o], Dep_name_txtf[o]);
            exjp7_2_set[o].getChildren().addAll(Dep_name2_lbl[o], Dep_name2_txtf[o]);
            exjp7_3_set[o].getChildren().addAll(Dep_name3_lbl[o], Dep_name3_txtf[o]);
            exjp7_4_set[o].getChildren().addAll(Dep_name4_lbl[o], Dep_name4_txtf[o]);
            exjp7_5_set[o].getChildren().addAll(Dep_name5_lbl[o], Dep_name5_txtf[o]);
            exjp7_6_set[o].getChildren().addAll(Dep_name6_lbl[o], Dep_name6_txtf[o]);
            exjp7_7_set[o].getChildren().addAll(Dep_name7_lbl[o], Dep_name7_txtf[o]);
            exjp7_8_set[o].getChildren().addAll(Dep_name8_lbl[o], Dep_name8_txtf[o]);
            exjp9_set[o].getChildren().addAll(Dep_u_name_lbl[o], Dep_u_name_txtf[o]);
            exjp9_2_set[o].getChildren().addAll(Dep_u_name2_lbl[o], Dep_u_name2_txtf[o]);
            exjp9_3_set[o].getChildren().addAll(Dep_u_name3_lbl[o], Dep_u_name3_txtf[o]);
            exjp9_4_set[o].getChildren().addAll(Dep_u_name4_lbl[o], Dep_u_name4_txtf[o]);
            exjp9_5_set[o].getChildren().addAll(Dep_u_name5_lbl[o], Dep_u_name5_txtf[o]);
            exjp9_6_set[o].getChildren().addAll(Dep_u_name6_lbl[o], Dep_u_name6_txtf[o]);
            exjp9_7_set[o].getChildren().addAll(Dep_u_name7_lbl[o], Dep_u_name7_txtf[o]);
            exjp9_8_set[o].getChildren().addAll(Dep_u_name8_lbl[o], Dep_u_name8_txtf[o]);
            exjp10_set[o].getChildren().addAll(reason_lbl[o], reason_txtf[o]);
            exjp11_set[o].getChildren().addAll(System_id_lbl[o], System_id_txtf[o]);
            exjp12_set[o].getChildren().addAll(Security_role_path_lbl[o], Security_role_path_txtf[o]);
            exjp13_set[o].getChildren().addAll(Search_path_lbl[o], Search_path_txtf[o]);
            exjp14_set[o].getChildren().addAll(Form_formal_code_lbl[o], Form_formal_code_txtf[o]);
            exjp15_set[o].getChildren().addAll(Desc_lbl[o], Desc_txtf[o]);
            exjp16_set[o].getChildren().addAll(period_lbl[o], period_cmbx[o]);
            exjp16_2_set[o].getChildren().addAll(period2_lbl[o], period2_cmbx[o]);
            exjp16_3_set[o].getChildren().addAll(period3_lbl[o], period3_cmbx[o]);
            exjp16_4_set[o].getChildren().addAll(period4_lbl[o], period4_cmbx[o]);
            exjp16_5_set[o].getChildren().addAll(period5_lbl[o], period5_cmbx[o]);
            exjp16_6_set[o].getChildren().addAll(period6_lbl[o], period6_cmbx[o]);
            exjp16_7_set[o].getChildren().addAll(period7_lbl[o], period7_cmbx[o]);
            exjp16_8_set[o].getChildren().addAll(period8_lbl[o], period8_cmbx[o]);
            exjp17_set[o].getChildren().addAll(rep_subj_type_lbl[o], rep_subj_type_cmbx[o]);
            exjp17_2_set[o].getChildren().addAll(rep_subj_type2_lbl[o], rep_subj_type2_cmbx[o]);
            exjp17_3_set[o].getChildren().addAll(rep_subj_type3_lbl[o], rep_subj_type3_cmbx[o]);
            exjp17_4_set[o].getChildren().addAll(rep_subj_type4_lbl[o], rep_subj_type4_cmbx[o]);
            exjp17_5_set[o].getChildren().addAll(rep_subj_type5_lbl[o], rep_subj_type5_cmbx[o]);
            exjp17_6_set[o].getChildren().addAll(rep_subj_type6_lbl[o], rep_subj_type6_cmbx[o]);
            exjp17_7_set[o].getChildren().addAll(rep_subj_type7_lbl[o], rep_subj_type7_cmbx[o]);
            exjp17_8_set[o].getChildren().addAll(rep_subj_type8_lbl[o], rep_subj_type8_cmbx[o]);
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
            radioBtn_set[o].getChildren().addAll(caseReport[o], caseCode[o]);
            radioBtn_set_2[o].getChildren().addAll(caseR[o], caseNR[o]);
            p_cmbx_dep_1[o].getChildren().addAll(cmbx_dep_1_lbl[o], Cmbx_dep_1[o]);
            p_cmbx_dep_2[o].getChildren().addAll(cmbx_dep_2_lbl[o], Cmbx_dep_2[o]);
            p_cmbx_okud[o].getChildren().addAll(cmbx_okud_lbl[o], Cmbx_okud[o]);
            p_cmbx_subj[o].getChildren().addAll(cmbx_subj_lbl[o], Cmbx_subj[o]);
            exjp3_V_set[o].getChildren().addAll(exjp3_set[o], exjp16_set[o]);
            exjp7_V_set[o].getChildren().addAll(exjp7_set[o]);
            exjp9_V_set[o].getChildren().addAll(exjp9_set[o]);
            exjp17_V_set[o].getChildren().addAll(exjp17_set[o]);
            p_okud_repform_lbl[o].getChildren().addAll(okud_repform_lbl[o]);

            form_cd_lbl[o].setText("Код доступа для отчета: ");
            p_type_ref_txtf[o].setText("cognos");
            p_source_ref_txtf[o].setText("cognos");
            PanelSet[o].getChildren().addAll(radioBtn_set[o], exjp1_set[o], radioBtn_set_2[o], p_tbl_6[o], exjp13_set[o], exjp14_set[o], exjp15_set[o], exjp11_set[o], exjp22_set[o], exjp12_set[o],
                    p_tbl_7[o], p_cmbx_okud[o], exjp3_V_set[o],
                    p_tbl_9[o], p_cmbx_subj[o], exjp17_V_set[o],
                    p_tbl_10[o], exjp0_set[o]/*, exjp18_set[o], exjp19_set[o], exjp20_set[o], exjp21_set[o]*/);
            PanelScroll[o] = new ScrollPane(PanelSet[o]);
            tabs[o].setText("Форма " + (o+1));
            tabs[o].setContent(PanelScroll[o]);
            sp.getTabs().add(tabs[o]);
            o++;
        }

        root.getChildren().add(sp);
        sp.setLayoutX(15);
        sp.setLayoutY(160);

        mnf.setWidth(1720);
        mnf.setHeight(920);
        mnf.centerOnScreen();

        createBtn.setVisible(true);
        createBtn.setDisable(false);
    }

    public void Case_report(int t){
        rep_or_code[t] = 0;
        Cmbx_okud[t].setValue(1);
        Cmbx_subj[t].setValue(1);
        PanelScroll[t] = new ScrollPane(PanelNull);
        tabs[t].setContent(PanelScroll[t]);
        form_cd_lbl[t].setText("Код доступа для отчета: ");
        tbl10_lbl[t].setText("---Данные для таблицы EHD_ACS_OBJECTS---");
        p_type_ref_txtf[t].setText("cognos");
        p_source_ref_txtf[t].setText("cognos");

        PanelSet[t].getChildren().removeAll(radioBtn_set[t], radioBtn_set_2[t], p_tbl_1[t], exjp1_set[t], exjp2_set[t], exjp3_set[t], p_okud_repform_lbl[t], p_tbl_2[t], exjp4_set[t], p_tbl_3[t], exjp5_set[t], exjp6_set[t], p_tbl_4[t], p_cmbx_dep_1[t],
                exjp7_V_set[t],
                p_cmbx_dep_2[t], exjp9_V_set[t],
                exjp10_set[t], p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);
        PanelScroll[t] = new ScrollPane(PanelSet[t]);

        PanelSet[t].getChildren().addAll(radioBtn_set[t], exjp1_set[t], radioBtn_set_2[t], p_tbl_6[t], exjp13_set[t], exjp14_set[t], exjp15_set[t], exjp11_set[t], exjp22_set[t], exjp12_set[t],
                p_tbl_7[t], p_cmbx_okud[t], exjp3_V_set[t],
                p_tbl_9[t], p_cmbx_subj[t], exjp17_V_set[t],
                p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);
        tabs[t].setContent(PanelScroll[t]);
        //sp.getTabs().add(new Tab("Форма " + (o+1), PanelSet[t]));
        
    }
    public void Case_code(int t){
        rep_or_code[t] = 1;
        Cmbx_dep_1[t].setValue(1);
        Cmbx_dep_2[t].setValue(1);
        PanelScroll[t] = new ScrollPane(PanelNull);
        tabs[t].setContent(PanelScroll[t]);
        form_cd_lbl[t].setText("Код доступа: ");
        tbl10_lbl[t].setText("---Данные для таблицы EHD_ACS_OBJECTS--- обязательно к заполнению, если код доступа ранее не был зарегистрирован");
        p_type_ref_txtf[t].clear();//setText("");
        p_source_ref_txtf[t].clear();//setText("");
        PanelSet[t].getChildren().removeAll(radioBtn_set[t], exjp1_set[t], radioBtn_set_2[t], p_tbl_6[t], exjp13_set[t], exjp14_set[t], exjp15_set[t], exjp11_set[t], exjp22_set[t], exjp12_set[t],
                p_tbl_7[t], p_cmbx_okud[t], exjp3_V_set[t],
                p_tbl_9[t], p_cmbx_subj[t], exjp17_V_set[t],
                p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);

        PanelSet[t].getChildren().addAll(radioBtn_set[t], radioBtn_set_2[t], p_tbl_1[t], exjp1_set[t], exjp2_set[t], exjp3_set[t], p_okud_repform_lbl[t],  p_tbl_2[t], exjp4_set[t], p_tbl_3[t], exjp5_set[t], exjp6_set[t], p_tbl_4[t], p_cmbx_dep_1[t], exjp7_V_set[t],
                p_cmbx_dep_2[t], exjp9_V_set[t], exjp10_set[t], p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);
        PanelScroll[t] = new ScrollPane(PanelSet[t]);
        tabs[t].setContent(PanelScroll[t]);
    }
    public void Case_RNR(int t, boolean reg){
        if(reg){
            System_id_txtf[t].setText("OAD");
            Security_role_name_txtf[t].setText("OAD_" + Form_cd_txtf[t].getText());
            Security_role_path_txtf[t].setText("CAMID(\":\")/namespaceFolder[@name=''FPS_IAPPR'']/namespaceFolder[@name=''PPK_OAD'']/namespaceFolder[@name=''REP_ROLES'']");
            Search_path_txtf[t].setText("/content/folder[@name='Приложение НИКА']/folder[@name='КО']/folder[@name='Регламентированные отчеты']/...");
            p_parent_code_txtf[t].setText("OAD_FORMS");
            p_parent_type_ref_txtf[t].setText("forms");
            if(rep_or_code[t] == 1){
                p_type_ref_txtf[t].setText("forms");
                p_source_ref_txtf[t].setText("system");
                PanelScroll[t] = new ScrollPane(PanelNull);
                tabs[t].setContent(PanelScroll[t]);
                PanelSet[t].getChildren().removeAll(radioBtn_set[t], radioBtn_set_2[t], p_tbl_1[t], exjp1_set[t], exjp2_set[t]/*, exjp3_set[t], p_okud_repform_lbl[t]*/,  p_tbl_2[t], exjp4_set[t], p_tbl_3[t], exjp5_set[t], exjp6_set[t], p_tbl_4[t], p_cmbx_dep_1[t], exjp7_V_set[t],
                        p_cmbx_dep_2[t], exjp9_V_set[t], exjp10_set[t], p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);
                PanelScroll[t] = new ScrollPane(PanelSet[t]);
                tabs[t].setContent(PanelScroll[t]);

                PanelSet[t].getChildren().addAll(radioBtn_set[t], radioBtn_set_2[t], p_tbl_1[t], exjp1_set[t], exjp2_set[t], exjp3_set[t], p_okud_repform_lbl[t],  p_tbl_2[t], exjp4_set[t], p_tbl_3[t], exjp5_set[t], exjp6_set[t], p_tbl_4[t], p_cmbx_dep_1[t], exjp7_V_set[t],
                        p_cmbx_dep_2[t], exjp9_V_set[t], exjp10_set[t], p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);
                PanelScroll[t] = new ScrollPane(PanelSet[t]);
                tabs[t].setContent(PanelScroll[t]);
            } else{
                p_type_ref_txtf[t].setText("cognos");
                p_source_ref_txtf[t].setText("cognos");
            }
        } else{
            System_id_txtf[t].setText("OAD");
            Security_role_name_txtf[t].setText("OAD_" + Form_cd_txtf[t].getText());
            Security_role_path_txtf[t].setText("CAMID(\":\")/namespaceFolder[@name=''FPS_IAPPR'']/namespaceFolder[@name=''PPK_OAD'']/namespaceFolder[@name=''REP_NR_ROLES'']");
            Search_path_txtf[t].setText("/content/folder[@name='Приложение НИКА']/folder[@name='КО']/folder[@name='Нерегламентированные отчеты']/...");
            p_parent_code_txtf[t].setText("OAD_AO");
            p_parent_type_ref_txtf[t].setText("ko_ao");
            if(rep_or_code[t] == 1){
                p_type_ref_txtf[t].setText("ko_ao");
                p_source_ref_txtf[t].setText("system");
                PanelScroll[t] = new ScrollPane(PanelNull);
                tabs[t].setContent(PanelScroll[t]);
                PanelSet[t].getChildren().removeAll(radioBtn_set[t], radioBtn_set_2[t], p_tbl_1[t], exjp1_set[t], exjp2_set[t], exjp3_set[t], p_okud_repform_lbl[t],  p_tbl_2[t], exjp4_set[t], p_tbl_3[t], exjp5_set[t], exjp6_set[t], p_tbl_4[t], p_cmbx_dep_1[t], exjp7_V_set[t],
                        p_cmbx_dep_2[t], exjp9_V_set[t], exjp10_set[t], p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);
                PanelScroll[t] = new ScrollPane(PanelSet[t]);
                tabs[t].setContent(PanelScroll[t]);

                PanelSet[t].getChildren().addAll(radioBtn_set[t], radioBtn_set_2[t], p_tbl_1[t], exjp1_set[t], exjp2_set[t]/*, exjp3_set[t], p_okud_repform_lbl[t]*/,  p_tbl_2[t], exjp4_set[t], p_tbl_3[t], exjp5_set[t], exjp6_set[t], p_tbl_4[t], p_cmbx_dep_1[t], exjp7_V_set[t],
                        p_cmbx_dep_2[t], exjp9_V_set[t], exjp10_set[t], p_tbl_10[t], exjp0_set[t]/*, exjp18_set[t], exjp19_set[t], exjp20_set[t], exjp21_set[t]*/);
                PanelScroll[t] = new ScrollPane(PanelSet[t]);
                tabs[t].setContent(PanelScroll[t]);
            } else{
                p_type_ref_txtf[t].setText("cognos");
                p_source_ref_txtf[t].setText("cognos");
            }
        }
        System.out.print("p_parent_code_txtf[" + t + "].getText() = " + p_parent_code_txtf[t].getText() + "\n");
        System.out.print("p_parent_type_ref_txtf[" + t + "].getText() = " + p_parent_type_ref_txtf[t].getText() + "\n");

    }
    public void Dep_count(int t){
        int c = dep_count[t];
        exjp7_V_set[t].getChildren().removeAll(exjp7_set[t], exjp7_2_set[t], exjp7_3_set[t], exjp7_4_set[t], exjp7_5_set[t], exjp7_6_set[t], exjp7_7_set[t], exjp7_8_set[t]);
        switch (c){
            case 1:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t]);
                break;
            case 2:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t], exjp7_2_set[t]);
                break;
            case 3:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t], exjp7_2_set[t], exjp7_3_set[t]);
                break;
            case 4:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t], exjp7_2_set[t], exjp7_3_set[t], exjp7_4_set[t]);
                break;
            case 5:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t], exjp7_2_set[t], exjp7_3_set[t], exjp7_4_set[t], exjp7_5_set[t]);
                break;
            case 6:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t], exjp7_2_set[t], exjp7_3_set[t], exjp7_4_set[t], exjp7_5_set[t], exjp7_6_set[t]);
                break;
            case 7:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t], exjp7_2_set[t], exjp7_3_set[t], exjp7_4_set[t], exjp7_5_set[t], exjp7_6_set[t], exjp7_7_set[t]);
                break;
            case 8:
                exjp7_V_set[t].getChildren().addAll(exjp7_set[t], exjp7_2_set[t], exjp7_3_set[t], exjp7_4_set[t], exjp7_5_set[t], exjp7_6_set[t], exjp7_7_set[t], exjp7_8_set[t]);
                break;
        }
    }
    public void Dep_u_count(int t){
        int c = dep_u_count[t];
        exjp9_V_set[t].getChildren().removeAll(exjp9_set[t], exjp9_2_set[t], exjp9_3_set[t], exjp9_4_set[t], exjp9_5_set[t], exjp9_6_set[t], exjp9_7_set[t], exjp9_8_set[t]);
        switch (c) {
            case 1:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t]);
                break;
            case 2:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t], exjp9_2_set[t]);
                break;
            case 3:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t], exjp9_2_set[t], exjp9_3_set[t]);
                break;
            case 4:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t], exjp9_2_set[t], exjp9_3_set[t], exjp9_4_set[t]);
                break;
            case 5:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t], exjp9_2_set[t], exjp9_3_set[t], exjp9_4_set[t], exjp9_5_set[t]);
                break;
            case 6:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t], exjp9_2_set[t], exjp9_3_set[t], exjp9_4_set[t], exjp9_5_set[t], exjp9_6_set[t]);
                break;
            case 7:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t], exjp9_2_set[t], exjp9_3_set[t], exjp9_4_set[t], exjp9_5_set[t], exjp9_6_set[t], exjp9_7_set[t]);
                break;
            case 8:
                exjp9_V_set[t].getChildren().addAll(exjp9_set[t], exjp9_2_set[t], exjp9_3_set[t], exjp9_4_set[t], exjp9_5_set[t], exjp9_6_set[t], exjp9_7_set[t], exjp9_8_set[t]);
                break;
        }
    }
    public void Okud_count(int t){
        int c = okud_count[t];
        exjp3_V_set[t].getChildren().removeAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t], exjp3_3_set[t], exjp16_3_set[t], exjp3_4_set[t], exjp16_4_set[t], 
                exjp3_5_set[t], exjp16_5_set[t], exjp3_6_set[t], exjp16_6_set[t], exjp3_7_set[t], exjp16_7_set[t], exjp3_8_set[t], exjp16_8_set[t]);
        switch (c) {
            case 1:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t]);
                break;
            case 2:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t]);
                break;
            case 3:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t], exjp3_3_set[t], exjp16_3_set[t]);
                break;
            case 4:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t], exjp3_3_set[t], exjp16_3_set[t], exjp3_4_set[t], exjp16_4_set[t]);
                break;
            case 5:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t], exjp3_3_set[t], exjp16_3_set[t], exjp3_4_set[t], exjp16_4_set[t],
                        exjp3_5_set[t], exjp16_5_set[t]);
                break;
            case 6:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t], exjp3_3_set[t], exjp16_3_set[t], exjp3_4_set[t], exjp16_4_set[t],
                        exjp3_5_set[t], exjp16_5_set[t], exjp3_6_set[t], exjp16_6_set[t]);
                break;
            case 7:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t], exjp3_3_set[t], exjp16_3_set[t], exjp3_4_set[t], exjp16_4_set[t],
                        exjp3_5_set[t], exjp16_5_set[t], exjp3_6_set[t], exjp16_6_set[t], exjp3_7_set[t], exjp16_7_set[t]);
                break;
            case 8:
                exjp3_V_set[t].getChildren().addAll(exjp3_set[t], exjp16_set[t], exjp3_2_set[t], exjp16_2_set[t], exjp3_3_set[t], exjp16_3_set[t], exjp3_4_set[t], exjp16_4_set[t],
                        exjp3_5_set[t], exjp16_5_set[t], exjp3_6_set[t], exjp16_6_set[t], exjp3_7_set[t], exjp16_7_set[t], exjp3_8_set[t], exjp16_8_set[t]);
                break;
        }
        
    }
    public void Subj_count(int t){
        int c = subj_count[t];
        exjp17_V_set[t].getChildren().removeAll(exjp17_set[t], exjp17_2_set[t], exjp17_3_set[t], exjp17_4_set[t], exjp17_5_set[t], exjp17_6_set[t], exjp17_7_set[t], exjp17_8_set[t]);
        switch (c) {
            case 1:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t]);
                break;
            case 2:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t], exjp17_2_set[t]);
                break;
            case 3:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t], exjp17_2_set[t], exjp17_3_set[t]);
                break;
            case 4:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t], exjp17_2_set[t], exjp17_3_set[t], exjp17_4_set[t]);
                break;
            case 5:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t], exjp17_2_set[t], exjp17_3_set[t], exjp17_4_set[t], exjp17_5_set[t]);
                break;
            case 6:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t], exjp17_2_set[t], exjp17_3_set[t], exjp17_4_set[t], exjp17_5_set[t], exjp17_6_set[t]);
                break;
            case 7:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t], exjp17_2_set[t], exjp17_3_set[t], exjp17_4_set[t], exjp17_5_set[t], exjp17_6_set[t], exjp17_7_set[t]);
                break;
            case 8:
                exjp17_V_set[t].getChildren().addAll(exjp17_set[t], exjp17_2_set[t], exjp17_3_set[t], exjp17_4_set[t], exjp17_5_set[t], exjp17_6_set[t], exjp17_7_set[t], exjp17_8_set[t]);
                break;
        }
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
    public static TextField[] getForm_okud2_txtf(){
        return OK_Action.Form_okud2_txtf;
    }
    public static TextField[] getForm_okud3_txtf(){
        return OK_Action.Form_okud3_txtf;
    }
    public static TextField[] getForm_okud4_txtf(){
        return OK_Action.Form_okud4_txtf;
    }
    public static TextField[] getForm_okud5_txtf(){
        return OK_Action.Form_okud5_txtf;
    }
    public static TextField[] getForm_okud6_txtf(){
        return OK_Action.Form_okud6_txtf;
    }
    public static TextField[] getForm_okud7_txtf(){
        return OK_Action.Form_okud7_txtf;
    }
    public static TextField[] getForm_okud8_txtf(){
        return OK_Action.Form_okud8_txtf;
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
    public static TextField[] getDep_name2_txtf(){
        return OK_Action.Dep_name2_txtf;
    }
    public static TextField[] getDep_name3_txtf(){
        return OK_Action.Dep_name3_txtf;
    }
    public static TextField[] getDep_name4_txtf(){
        return OK_Action.Dep_name4_txtf;
    }
    public static TextField[] getDep_name5_txtf(){
        return OK_Action.Dep_name5_txtf;
    }
    public static TextField[] getDep_name6_txtf(){
        return OK_Action.Dep_name6_txtf;
    }
    public static TextField[] getDep_name7_txtf(){
        return OK_Action.Dep_name7_txtf;
    }
    public static TextField[] getDep_name8_txtf(){
        return OK_Action.Dep_name8_txtf;
    }
    public static TextField[] getDep_u_name_txtf(){
            return OK_Action.Dep_u_name_txtf;
    }
    public static TextField[] getDep_u_name2_txtf(){
        return OK_Action.Dep_u_name2_txtf;
    }
    public static TextField[] getDep_u_name3_txtf(){
        return OK_Action.Dep_u_name3_txtf;
    }
    public static TextField[] getDep_u_name4_txtf(){
        return OK_Action.Dep_u_name4_txtf;
    }
    public static TextField[] getDep_u_name5_txtf(){
        return OK_Action.Dep_u_name5_txtf;
    }
    public static TextField[] getDep_u_name6_txtf(){
        return OK_Action.Dep_u_name6_txtf;
    }
    public static TextField[] getDep_u_name7_txtf(){
        return OK_Action.Dep_u_name7_txtf;
    }
    public static TextField[] getDep_u_name8_txtf(){
        return OK_Action.Dep_u_name8_txtf;
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
    public static ComboBox<String>[] getPeriod_cmbx(){
            return OK_Action.period_cmbx;
    }
    public static ComboBox<String>[] getPeriod2_cmbx(){
        return OK_Action.period2_cmbx;
    }
    public static ComboBox<String>[] getPeriod3_cmbx(){
        return OK_Action.period3_cmbx;
    }
    public static ComboBox<String>[] getPeriod4_cmbx(){
        return OK_Action.period4_cmbx;
    }
    public static ComboBox<String>[] getPeriod5_cmbx(){
        return OK_Action.period5_cmbx;
    }
    public static ComboBox<String>[] getPeriod6_cmbx(){
        return OK_Action.period6_cmbx;
    }
    public static ComboBox<String>[] getPeriod7_cmbx(){
        return OK_Action.period7_cmbx;
    }
    public static ComboBox<String>[] getPeriod8_cmbx(){
        return OK_Action.period8_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type_cmbx(){
            return OK_Action.rep_subj_type_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type2_cmbx(){
        return OK_Action.rep_subj_type2_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type3_cmbx(){
        return OK_Action.rep_subj_type3_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type4_cmbx(){
        return OK_Action.rep_subj_type4_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type5_cmbx(){
        return OK_Action.rep_subj_type5_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type6_cmbx(){
        return OK_Action.rep_subj_type6_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type7_cmbx(){
        return OK_Action.rep_subj_type7_cmbx;
    }
    public static ComboBox<String>[] getRep_subj_type8_cmbx(){
        return OK_Action.rep_subj_type8_cmbx;
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
    public static int getDep_count(int y){
        return OK_Action.dep_count[y];
    }
    public static int getDep_u_count(int y){
        return OK_Action.dep_u_count[y];
    }
    public static int getOkud_count(int y){
        return OK_Action.okud_count[y];
    }
    public static int getSubj_count(int y){
        return OK_Action.subj_count[y];
    }
    public static byte[] getRep_or_code(){
        return rep_or_code;
    }
}


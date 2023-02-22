import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SCJFXApp extends Application {
    private static Stage pStage;
    private static AnchorPane root;
    private static VBox Vbox1 = new VBox(25.0);
    private static VBox Vbox2 = new VBox(25.0);
    private static VBox Vbox3 = new VBox(25.0);
    private HBox box1 = new HBox(25.0);
    private HBox box2 = new HBox(10.0);
    private HBox box3 = new HBox(10.0);
    private HBox p_path = new HBox(10.0);
    private HBox p_btns = new HBox(10.0);
    private HBox p_count = new HBox(10.0);
    private HBox p_path2 = new HBox(10.0);
    private HBox p_btns2 = new HBox(10.0);
    private static Label lbl1 = new Label("Имя формы: ");
    private static TextField txt_fld1;
    private static Label lbl2 = new Label("Режим: ");
    private static ComboBox<String> cmbx1;
    private static Label lab1 = new Label(" Путь к файлу: ");
    private static TextField txtf1 = new TextField();
    private static Button Browse = new Button("Обзор");
    private static Button ChckBtn1 = new Button("Проверить файл");
    private static Button ScrBtn3 = new Button("Создать скрипты");
    private static Button resetBtn = new Button("Сброс");

    private static ComboBox<Integer> countCmbx;
    private static Label countLbl = new Label("Количество форм заполнения (кол-во кодов доступа + кол-во отчетов):");
    private static Label pathLbl = new Label("Путь для сохранения скриптов:");
    private static TextField pathTxtf = new TextField("C:\\");
    private static Button fldchs_btn = new Button("Выбор папки");
    private static Button OK_btn = new Button("OK");
    private static Button createBtn = new Button("Создать скрипты");
    private static Button resetBtn2 = new Button("Сброс");
    @Override
    public void start(Stage stage) throws IOException {
        SCJFXApp.pStage = stage;
        //FXMLLoader fxmlLoader = new FXMLLoader();
        //fxmlLoader.setLocation(getClass().getResource("main-view.fxml"));
        root = new AnchorPane();
       // root = fxmlLoader.load();
        txt_fld1 = new TextField();
        txt_fld1.setPromptText("Например, 106");
        cmbx1 = new ComboBox<String>();
        cmbx1.getItems().addAll("Из файла", "Ручной") ;
        cmbx1.setPrefWidth(160.0);
        cmbx1.setPrefHeight(25.0);
        cmbx1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.MainViewController(event);
            }
        });
        lab1.setVisible(false);
        txtf1.setDisable(true);
        txtf1.setVisible(false);
        txtf1.setText("C:\\");
        txtf1.setPrefHeight(25.0);
        txtf1.setPrefWidth(528.0);
        Browse.setDisable(true);
        Browse.setVisible(false);
        Browse.setMnemonicParsing(false);
        Browse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.BrowseClicked();
            }
        });

        ChckBtn1.setDisable(true);
        ChckBtn1.setVisible(false);
        ChckBtn1.setMnemonicParsing(false);
        ChckBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.CheckClicked();
            }
        });

        ScrBtn3.setDisable(true);
        ScrBtn3.setVisible(false);
        ScrBtn3.setMnemonicParsing(false);
        ScrBtn3.setPrefHeight(25.0);
        ScrBtn3.setPrefWidth(114.0);
        ScrBtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.CreateClicked();
            }
        });

        resetBtn.setDisable(true);
        resetBtn.setVisible(false);
        resetBtn.setMnemonicParsing(false);
        resetBtn.setPrefHeight(25.0);
        resetBtn.setPrefWidth(81.0);
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.ResetClicked();
            }
        });

        countCmbx = new ComboBox<Integer>();
        countCmbx.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        countCmbx.setDisable(true);
        countCmbx.setVisible(false);
        countCmbx.setPrefWidth(58.0);
        countCmbx.setPrefHeight(25.0);
        countCmbx.setValue(0);
        countLbl.setVisible(false);
        pathLbl.setVisible(false);
        pathTxtf.setDisable(true);
        pathTxtf.setVisible(false);
        pathTxtf.setPrefWidth(473.0);
        pathTxtf.setPrefHeight(25.0);
        fldchs_btn.setDisable(true);
        fldchs_btn.setVisible(false);
        fldchs_btn.setMnemonicParsing(false);
        fldchs_btn.setPrefWidth(108.0);
        fldchs_btn.setPrefHeight(25.0);
        fldchs_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.BrowseFldClicked();
            }
        });

        OK_btn.setDisable(true);
        OK_btn.setVisible(false);
        OK_btn.setMnemonicParsing(false);
        OK_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.OKClicked();
            }
        });

        createBtn.setDisable(true);
        createBtn.setVisible(false);
        createBtn.setMnemonicParsing(false);
        createBtn.setPrefWidth(114.0);
        createBtn.setPrefHeight(25.0);
        createBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    MainViewController.CreateClicked2();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        resetBtn2.setDisable(true);
        resetBtn2.setVisible(false);
        resetBtn2.setMnemonicParsing(false);
        resetBtn2.setPrefWidth(52.0);
        resetBtn2.setPrefHeight(25.0);
        resetBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainViewController.ResetClicked2();
            }
        });

        Vbox1.setPadding(new Insets(17.0));
        //box1.setPadding(new Insets(17.0));
        box2.getChildren().addAll(lbl1, txt_fld1);
        box3.getChildren().addAll(lbl2, cmbx1);
        box1.getChildren().addAll(box2, box3);
        p_path.getChildren().addAll(lab1, txtf1, Browse);
        p_btns.getChildren().addAll(ChckBtn1, ScrBtn3, resetBtn);
        p_count.getChildren().addAll(countLbl, countCmbx);
        p_path2.getChildren().addAll(pathLbl, pathTxtf);
        p_btns2.getChildren().addAll(fldchs_btn, OK_btn, createBtn, resetBtn2);
        Vbox2.getChildren().addAll(p_path, p_btns);
        Vbox3.getChildren().addAll(p_count, p_path2, p_btns2);
        Vbox1.getChildren().addAll(box1);
        root.getChildren().addAll(Vbox1);
        Scene scene = new Scene(root, 570, 240);
        stage.setTitle("Script Creator");
        stage.setScene(scene);
        stage.widthProperty().addListener((obj, oldValue, newValue) ->{
            //111;
        });
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    public static Stage getPrimaryStage(){
        return SCJFXApp.pStage;
    }
    public static AnchorPane getRoot(){
        return SCJFXApp.root;
    }
    public static VBox getVbox1(){
        return SCJFXApp.Vbox1;
    }
    public static VBox getVbox2(){
        return SCJFXApp.Vbox2;
    }
    public static VBox getVbox3(){
        return SCJFXApp.Vbox3;
    }
    public static Label getLab1(){
        return  SCJFXApp.lab1;
    }
    public static TextField getTxt_fld1(){
        return  SCJFXApp.txt_fld1;
    }
    public static ComboBox<String> getCmbx1(){
        return  SCJFXApp.cmbx1;
    }
    public static TextField getTxtf1(){
        return  SCJFXApp.txtf1;
    }
    public static Button getBrowse(){
        return  SCJFXApp.Browse;
    }
    public static Button getChckBtn1(){
        return  SCJFXApp.ChckBtn1;
    }
    public static Button getScrBtn3(){
        return  SCJFXApp.ScrBtn3;
    }
    public static Button getResetBtn(){
        return  SCJFXApp.resetBtn;
    }
    public static ComboBox<Integer> getCountCmbx(){
        return  SCJFXApp.countCmbx;
    }
    public static Label getCountLbl(){
        return  SCJFXApp.countLbl;
    }
    public static Label getPathLbl(){
        return  SCJFXApp.pathLbl;
    }
    public static TextField getPathTxtf(){
        return  SCJFXApp.pathTxtf;
    }
    public static Button getFldchs_btn(){
        return  SCJFXApp.fldchs_btn;
    }
    public static Button getCreateBtn(){
        return  SCJFXApp.createBtn;
    }
    public static Button getResetBtn2(){
        return  SCJFXApp.resetBtn2;
    }
    public static Button getOK_btn(){
        return  SCJFXApp.OK_btn;
    }
}
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

    /*public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }*/
}
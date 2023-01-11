import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class BrowseAction {
    private static String FName1;
    private static File file1;
    private static String path_u;

    public BrowseAction(TextField txt_fld1, Stage primaryStage, Button chckBtn1, TextField txtf1) {
        FName1 = txt_fld1.getText();
        FileChooser fch = new FileChooser();
        fch.setTitle("Выбор файла");
        fch.setInitialDirectory(new File("C:\\Users\\"));
        fch.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel файлы", "*.xlsx"),
                new FileChooser.ExtensionFilter("Все файлы", "*.*")
        );
        file1 = fch.showOpenDialog(primaryStage);


        path_u = file1.getPath();
        chckBtn1.setDisable(false);
        txtf1.setText(path_u);
    }
    public static File getFile(){
        return BrowseAction.file1;
    }
    public static String getPath_u(){
        return BrowseAction.path_u;
    }
    public static String getFName1(){
        return BrowseAction.FName1;
    }

}


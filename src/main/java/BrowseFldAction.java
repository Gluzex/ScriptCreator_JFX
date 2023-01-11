import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class BrowseFldAction {
    private static String path_fld;
    private static File folder;

    public BrowseFldAction(TextField pathTxtf, Stage primaryStage, Button OK_btn){
        DirectoryChooser dch = new DirectoryChooser();
        dch.setTitle("Выбор папки");
        dch.setInitialDirectory(new File("C:\\Users\\"));

        folder = dch.showDialog(primaryStage);

        path_fld = folder.getPath();
        OK_btn.setVisible(true);
        OK_btn.setDisable(false);
        pathTxtf.setText(path_fld);
    }
    public static File getFolder(){
        return BrowseFldAction.folder;
    }
    public static String getPath_fld(){
        return BrowseFldAction.path_fld;
    }
}

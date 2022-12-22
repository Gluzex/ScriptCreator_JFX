import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SCJFXApp extends Application {
    private static Stage pStage;
    private static AnchorPane root;
    @Override
    public void start(Stage stage) throws IOException {
        SCJFXApp.pStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("main-view.fxml"));
        root = new AnchorPane();
        root = fxmlLoader.load();
        Scene scene = new Scene(root, 520, 240);
        stage.setTitle("Script Creator");
        stage.setScene(scene);
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
}
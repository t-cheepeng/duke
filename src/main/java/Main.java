import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Duke duke;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            primaryStage.setScene(scene);
            MainWindow window = fxmlLoader.<MainWindow>getController();
            duke = new Duke();
            window.setDuke(duke);
            window.welcome();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

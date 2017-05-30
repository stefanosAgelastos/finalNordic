package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ADMIN on 16-05-2017.
 */
public class SceneManager {
    private static SceneManager instance;

    private SceneManager(){}

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    private Stage primaryStage;
    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void loadLoginScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/sample.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
    }

    void loadSalesmanScene() throws IOException{
        Parent salesmanRoot = FXMLLoader.load(getClass().getResource("/view/salesman.fxml"));
        Scene salesmanScene = new Scene(salesmanRoot, 900, 575);
        primaryStage.setScene(salesmanScene);
    }

    void loadBookkeeperScene() throws IOException{
        Parent bookkeeperRoot = FXMLLoader.load(getClass().getResource("/view/bookkeeper.fxml"));
        Scene bookkeeperScene = new Scene(bookkeeperRoot, 900, 575);
        primaryStage.setScene(bookkeeperScene);
    }

    void loadMechanicScene() throws IOException{
        Parent mechanicRoot = FXMLLoader.load(getClass().getResource("/view/mechanic.fxml"));
        Scene mechanicScene = new Scene(mechanicRoot, 900, 575);
        primaryStage.setScene(mechanicScene);
    }
}

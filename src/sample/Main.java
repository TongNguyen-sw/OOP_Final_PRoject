package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage currentStage=null;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/MainMenu.fxml"));
        primaryStage.setTitle("Horse Race Chess");
        Scene scene = new Scene(root,970,720);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        currentStage=primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

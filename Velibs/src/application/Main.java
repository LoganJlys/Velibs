package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML
        Parent root = FXMLLoader.load(getClass().getResource("Fenetre.fxml"));
        
        // Créer la scène
        Scene scene = new Scene(root);
        
        // Définir le titre de la fenêtre
        primaryStage.setTitle("Vélib");
        
        // Définir la scène
        primaryStage.setScene(scene);
        
        // Afficher la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

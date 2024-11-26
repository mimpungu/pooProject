package fr.ubx.poo.patrimoine;

import fr.ubx.poo.patrimoine.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainView mainView = new MainView(primaryStage); // Afficher la page d'accueil
    }

    public static void main(String[] args) {
        launch(args);
    }
}

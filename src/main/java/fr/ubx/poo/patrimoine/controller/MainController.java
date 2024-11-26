package fr.ubx.poo.patrimoine.controller;

import fr.ubx.poo.patrimoine.view.LocataireView;
import fr.ubx.poo.patrimoine.view.MainView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fr.ubx.poo.patrimoine.view.BienImmobilierView;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public void handleGestionBiens() {
        // Passer à la vue de gestion des biens immobiliers
        Stage stage = (Stage) mainView.getPrimaryStage().getScene().getWindow();
        BienImmobilierView bienImmobilierView = new BienImmobilierView(stage);
    }

    public void handleGestionLocataires(Stage primaryStage) {
        // Créer une nouvelle scène pour la gestion des locataires
        LocataireView locataireView = new LocataireView(primaryStage, primaryStage.getScene());
        Scene locataireScene = new Scene((Parent) locataireView.getView(), 400, 400); // Ajustez la taille si nécessaire
        primaryStage.setScene(locataireScene);
    }
}

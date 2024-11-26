package fr.ubx.poo.patrimoine.view;

import fr.ubx.poo.patrimoine.controller.MainController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
    private Stage primaryStage;
    private MainController controller;

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.controller = new MainController(this);
        initializeUI();
    }

    private void initializeUI() {
        primaryStage.setTitle("Page d'Accueil");

        // Créer le layout principal
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("vbox"); // Ajout de la classe CSS

        // Titre de la page d'accueil
        Label titleLabel = new Label("Bienvenue dans l'application de Gestion des Biens Immobiliers");
        titleLabel.getStyleClass().add("title"); // Ajout de la classe CSS pour le titre

        // Boutons de navigation pour les biens
        Button gestionBiensButton = new Button("Gérer les Biens Immobiliers");
        gestionBiensButton.getStyleClass().add("button"); // Ajout de la classe CSS pour le bouton
        gestionBiensButton.setOnAction(e -> controller.handleGestionBiens());

        // Boutons de navigation pour les locataires
        Button gestionLocatairesButton = new Button("Gérer les Locataires");
        gestionLocatairesButton.getStyleClass().add("button");
        gestionLocatairesButton.setOnAction(e -> controller.handleGestionLocataires(primaryStage));

        Button quitterButton = new Button("Quitter");
        quitterButton.getStyleClass().add("button"); // Ajout de la classe CSS pour le bouton
        quitterButton.setOnAction(e -> primaryStage.close()); // Ferme l'application

        // Ajouter les éléments au layout
        layout.getChildren().addAll(titleLabel, gestionBiensButton, gestionLocatairesButton, quitterButton);

        // Configurer la scène
        Scene scene = new Scene(layout, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm()); // Ajouter le fichier CSS
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage; // Retourne le stage principal
    }
}

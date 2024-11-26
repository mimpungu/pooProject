package fr.ubx.poo.patrimoine.view;

import fr.ubx.poo.patrimoine.controller.LocataireController;
import fr.ubx.poo.patrimoine.model.Locataire;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class LocataireView {
    private LocataireController locataireController;
    private TextField nomField;
    private TextField prenomField;
    private TextField addressField;
    private TextField telephoneField;
    private ListView<Locataire> locataireListView;
    private Stage primaryStage; // Pour la navigation
    private Scene mainScene; // Référence à la scène principale

    public LocataireView(Stage primaryStage, Scene mainScene) {
        this.primaryStage = primaryStage; // Initialisation du stage
        this.mainScene = mainScene; // Conserve la scène principale
        this.locataireController = new LocataireController();
        this.nomField = new TextField();
        this.prenomField = new TextField();
        this.addressField = new TextField();
        this.telephoneField = new TextField();
        this.locataireListView = new ListView<>();

    }

    // Méthode pour obtenir la vue de locataire
    public Node getView() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);

        // Appliquez le style CSS
        vbox.getStyleClass().add("vbox");

        // Créer les boutons
        Button ajouterButton = new Button("Ajouter Locataire");
        Button modifierButton = new Button("Modifier Locataire");
        Button supprimerButton = new Button("Supprimer Locataire");
        Button quitterButton = new Button("Quitter");
        Button retourButton = new Button("Retour");

        // Actions pour les boutons
        ajouterButton.setOnAction(event -> ajouterLocataire()); // Appelle la méthode pour ajouter un locataire
        modifierButton.setOnAction(event -> modifierLocataire()); // Appelle la méthode pour modifier un locataire
        supprimerButton.setOnAction(event -> supprimerLocataire()); // Appelle la méthode pour supprimer un locataire
        quitterButton.setOnAction(event -> primaryStage.close()); // Ferme l'application
        retourButton.setOnAction(event -> primaryStage.setScene(mainScene)); // Retour à la scène principale

        // Ajouter un écouteur de sélection sur la ListView
        locataireListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nomField.setText(newSelection.getNom());
                prenomField.setText(newSelection.getPrenom());
                addressField.setText(newSelection.getAddress());
                telephoneField.setText(newSelection.getTelephone());
            }
        });

        // Mise en page avec un GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        gridPane.add(new Label("Nom:"), 0, 0);
        gridPane.add(nomField, 1, 0);
        gridPane.add(new Label("Prénom:"), 0, 1);
        gridPane.add(prenomField, 1, 1);
        gridPane.add(new Label("Email:"), 0, 2);
        gridPane.add(addressField, 1, 2);
        gridPane.add(new Label("Téléphone:"), 0, 3);
        gridPane.add(telephoneField, 1, 3);
        gridPane.add(ajouterButton, 0, 4);
        gridPane.add(modifierButton, 1, 4);
        gridPane.add(supprimerButton, 0, 5);
        gridPane.add(quitterButton, 1, 5);
        gridPane.add(retourButton, 0, 6);
        gridPane.add(locataireListView, 0, 7, 2, 1);

        vbox.getChildren().add(gridPane);
        return vbox; // Retourne le VBox contenant la vue
    }

    private void ajouterLocataire() {
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();
        String email = addressField.getText().trim();
        String telephone = telephoneField.getText().trim();

        // Vérification que tous les champs sont remplis
        if (!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !telephone.isEmpty()) {
            Locataire locataire = new Locataire(nom, prenom, email, telephone);
            locataireController.enregistrerLocataire(locataire); // Enregistrer le locataire via le contrôleur
            updateLocataireList(); // Mettre à jour la liste des locataires
            clearFields(); // Effacer les champs de texte
        } else {
            showAlert("Erreur", "Tous les champs doivent être remplis."); // Alerte si des champs sont vides
        }
    }

    private void modifierLocataire() {
        Locataire selectedLocataire = locataireListView.getSelectionModel().getSelectedItem();
        if (selectedLocataire != null) {
            // Récupérer les nouvelles valeurs des champs
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String address = addressField.getText();
            String telephone = telephoneField.getText();

            // Appeler la méthode de modification dans le contrôleur
            locataireController.modifierLocataire(selectedLocataire, nom, prenom, address, telephone);

            // Mettez à jour la liste
            updateLocataireList();
            clearFields();
        } else {
            showAlert("Erreur", "Veuillez sélectionner un locataire à modifier.");
        }
    }

    private void supprimerLocataire() {
        Locataire selectedLocataire = locataireListView.getSelectionModel().getSelectedItem();
        if (selectedLocataire != null) {
            locataireController.supprimerLocataire(selectedLocataire);
            updateLocataireList();
        } else {
            showAlert("Erreur", "Veuillez sélectionner un locataire à supprimer.");
        }
    }

    private void updateLocataireList() {
        locataireListView.getItems().clear();
        List<Locataire> locataires = locataireController.listerLocataires();
        locataireListView.getItems().addAll(locataires);
    }

    private void clearFields() {
        nomField.clear();
        prenomField.clear();
        addressField.clear();
        telephoneField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

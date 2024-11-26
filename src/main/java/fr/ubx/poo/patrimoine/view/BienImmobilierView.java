package fr.ubx.poo.patrimoine.view;

import fr.ubx.poo.patrimoine.model.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BienImmobilierView {
    private TableView<BienImmobilier> tableView;
    private TextField adresseField, prixField, superficieField, loyerField, typeCommerceField;
    private CheckBox constructibleField;
    private ComboBox<String> typeBienBox, etatBienBox;
    private Button ajouterButton, modifierButton, supprimerButton;

    public BienImmobilierView(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Biens Immobiliers");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));


        // Titre principal
        Label titleLabel = new Label("Gestion des Biens Immobiliers");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;"); // Style du titre
        vbox.getChildren().add(titleLabel); // Ajout du titre au VBox


        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER); // Centre le titre
        vbox.getChildren().add(titleBox); // Ajout du HBox au VBox

        // Créez la scène après avoir ajouté tous les éléments
        javafx.scene.Scene scene = new javafx.scene.Scene(vbox, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm()); // Ajouter le fichier CSS
        primaryStage.setScene(scene);
        primaryStage.show();

        tableView = new TableView<>();
        setupTableView();

        // Initialisation des champs du formulaire
        adresseField = new TextField();
        prixField = new TextField();
        superficieField = new TextField();
        loyerField = new TextField();
        typeCommerceField = new TextField();
        constructibleField = new CheckBox("Constructible");

        // ComboBox pour le type de bien
        typeBienBox = new ComboBox<>();
        typeBienBox.getItems().addAll("Bureau", "Commerce", "Terrain", "Appartement");

        // ComboBox pour l'état du bien
        etatBienBox = new ComboBox<>();
        etatBienBox.getItems().addAll("Disponible", "Louée", "En Maintenance");

        // Boutons d'action
        ajouterButton = new Button("Ajouter");
        modifierButton = new Button("Modifier");
        supprimerButton = new Button("Supprimer");

        // Configuration des boutons
        configureButtons();

        // Mettre en place le formulaire
        vbox.getChildren().addAll(new Label("Type de bien :"), typeBienBox, setupForm(),
                new Label("État du bien :"), etatBienBox,
                createButtonBox(), // Ajout de l'HBox contenant les boutons
                tableView);
        primaryStage.setScene(new javafx.scene.Scene(vbox, 800, 500));
        primaryStage.show();
    }

    private HBox createButtonBox() {
        HBox buttonBox = new HBox(10); // Espace de 10 entre les boutons
        buttonBox.getChildren().addAll(ajouterButton, modifierButton, supprimerButton);
        return buttonBox;
    }

    private GridPane setupForm() {
        GridPane inputPane = new GridPane();
        inputPane.setHgap(10);
        inputPane.setVgap(10);

        // Ajout des champs et labels dans le GridPane
        inputPane.add(new Label("Type de bien :"), 0, 0); // Label pour ComboBox
        inputPane.add(typeBienBox, 1, 0); // ComboBox pour le type de bien
        inputPane.add(new Label("Adresse :"), 0, 1);
        inputPane.add(adresseField, 1, 1);
        inputPane.add(new Label("Prix :"), 0, 2);
        inputPane.add(prixField, 1, 2);
        inputPane.add(new Label("Superficie :"), 0, 3);
        inputPane.add(superficieField, 1, 3);
        inputPane.add(new Label("Loyer :"), 0, 4);
        inputPane.add(loyerField, 1, 4);
        inputPane.add(new Label("Type Commerce :"), 0, 5);
        inputPane.add(typeCommerceField, 1, 5);
        inputPane.add(new Label("État du bien :"), 0, 6); // Label pour ComboBox
        inputPane.add(etatBienBox, 1, 6); // ComboBox pour l'état du bien
        inputPane.add(constructibleField, 0, 7); // CheckBox sur une nouvelle ligne

        // Masquer les champs en fonction du type de bien
        typeBienBox.setOnAction(e -> updateFormFields());
        return inputPane;
    }

    private void updateFormFields() {
        String type = typeBienBox.getValue();
        superficieField.setVisible("Bureau".equals(type) || "Terrain".equals(type));
        loyerField.setVisible("Bureau".equals(type) || "Appartement".equals(type));
        typeCommerceField.setVisible("Commerce".equals(type));
        constructibleField.setVisible("Terrain".equals(type));
    }

    private void setupTableView() {
        TableColumn<BienImmobilier, String> adresseColumn = new TableColumn<>("Adresse");
        adresseColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdresse()));

        TableColumn<BienImmobilier, Double> prixColumn = new TableColumn<>("Prix");
        prixColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrix()).asObject());

        TableColumn<BienImmobilier, String> etatColumn = new TableColumn<>("État");
        etatColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEtat().getNomEtat()));

        TableColumn<BienImmobilier, String> typeColumn = new TableColumn<>("Type de bien");
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));

        TableColumn<BienImmobilier, Double> loyerColumn = new TableColumn<>("Loyer");
        loyerColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getLoyer()).asObject());

        TableColumn<BienImmobilier, String> typeCommerceColumn = new TableColumn<>("Type Commerce");
        typeCommerceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));

        tableView.getColumns().addAll(adresseColumn, prixColumn, etatColumn, typeColumn, loyerColumn, typeCommerceColumn);
    }

    private void configureButtons() {
        ajouterButton.setOnAction(e -> addBien());
        modifierButton.setOnAction(e -> modifyBien());
        supprimerButton.setOnAction(e -> deleteBien());
    }

    private void addBien() {
        BienImmobilier bien = getBienFromInput();
        if (bien != null) {
            tableView.getItems().add(bien);
            clearInputFields();
        }
    }

    private void modifyBien() {
        int selectedIndex = getSelectedIndex();
        if (selectedIndex >= 0) {
            BienImmobilier bien = getBienFromInput();
            if (bien != null) {
                tableView.getItems().set(selectedIndex, bien);
                clearInputFields();
            } else {
                showAlert("Erreur", "Aucun bien à modifier.");
            }
        } else {
            showAlert("Erreur", "Veuillez sélectionner un bien à modifier.");
        }
    }

    private void deleteBien() {
        int selectedIndex = getSelectedIndex();
        if (selectedIndex >= 0) {
            tableView.getItems().remove(selectedIndex);
            clearInputFields();
        } else {
            showAlert("Erreur", "Veuillez sélectionner un bien à supprimer.");
        }
    }

    public BienImmobilier getBienFromInput() {
        String adresse = adresseField.getText();
        double prix;
        try {
            prix = Double.parseDouble(prixField.getText());
        } catch (NumberFormatException e) {
            showAlert("Prix invalide", "Veuillez entrer un prix valide.");
            return null; // Retourne null si le prix est invalide
        }

        double superficie = 0;
        if (superficieField.isVisible()) {
            try {
                superficie = Double.parseDouble(superficieField.getText());
            } catch (NumberFormatException e) {
                showAlert("Superficie invalide", "Veuillez entrer une superficie valide.");
                return null; // Retourne null si la superficie est invalide
            }
        }

        switch (typeBienBox.getValue()) {
            case "Bureau":
                double loyerBureau;
                try {
                    loyerBureau = Double.parseDouble(loyerField.getText());
                } catch (NumberFormatException e) {
                    showAlert("Loyer invalide", "Veuillez entrer un loyer valide.");
                    return null; // Retourne null si le loyer est invalide
                }
                return new Bureau(adresse, prix, superficie, loyerBureau);
            case "Commerce":
                return new Commerce(adresse, prix, typeCommerceField.getText());
            case "Terrain":
                return new Terrain(adresse, prix, superficie, constructibleField.isSelected());
            case "Appartement":
                double loyerAppartement;
                try {
                    loyerAppartement = Double.parseDouble(loyerField.getText());
                } catch (NumberFormatException e) {
                    showAlert("Loyer invalide", "Veuillez entrer un loyer valide.");
                    return null; // Retourne null si le loyer est invalide
                }
                return new Appartement(adresse, prix, superficie, loyerAppartement);
            default:
                showAlert("Erreur", "Type de bien non sélectionné");
                return null; // Retourne null si aucun type n'est sélectionné
        }
    }


    public void clearInputFields() {
        adresseField.clear();
        prixField.clear();
        superficieField.clear();
        loyerField.clear();
        typeCommerceField.clear();  // Assurez-vous que le champ est vidé après l'ajout ou la modification
        constructibleField.setSelected(false);
        etatBienBox.getSelectionModel().clearSelection();
        typeBienBox.getSelectionModel().clearSelection();
        updateFormFields(); // Reset visibility of form fields
    }

    public int getSelectedIndex() {
        return tableView.getSelectionModel().getSelectedIndex();
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getModifierButton() {
        return modifierButton;
    }

    public Button getSupprimerButton() {
        return supprimerButton;
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setBienData(ObservableList<BienImmobilier> biensList) {
        tableView.setItems(biensList);
    }


}


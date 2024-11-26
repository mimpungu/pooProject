package fr.ubx.poo.patrimoine.controller;

import fr.ubx.poo.patrimoine.model.*;
import fr.ubx.poo.patrimoine.view.BienImmobilierView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BienImmobilierController {
    private final BienImmobilierView view;
    private final ObservableList<BienImmobilier> biensList;

    public BienImmobilierController(BienImmobilierView view) {
        this.view = view;
        this.biensList = FXCollections.observableArrayList();
        this.view.setBienData(biensList);
        initialize();
    }

    private void initialize() {
        view.getAjouterButton().setOnAction(e -> ajouterBien());
        view.getModifierButton().setOnAction(e -> modifierBien());
        view.getSupprimerButton().setOnAction(e -> supprimerBien());

    }

    private void ajouterBien() {
        BienImmobilier bien = view.getBienFromInput();
        if (bien != null) {
            biensList.add(bien);
            view.clearInputFields();
        }
    }

    private void modifierBien() {
        int selectedIndex = view.getSelectedIndex();
        if (selectedIndex >= 0) {
            BienImmobilier bien = view.getBienFromInput();
            if (bien != null) {
                biensList.set(selectedIndex, bien);
                view.clearInputFields();
            }
        }
    }

    private void supprimerBien() {
        int selectedIndex = view.getSelectedIndex();
        if (selectedIndex >= 0) {
            biensList.remove(selectedIndex);
            view.clearInputFields();
        }
    }

    public double calculerValeurTotale() {
        double total = 0;
        for (BienImmobilier bien : biensList) {
            total += bien.getPrix();
        }
        return total;
    }

    public void louerBien() {
        int selectedIndex = view.getSelectedIndex();
        if (selectedIndex >= 0) {
            BienImmobilier bien = biensList.get(selectedIndex);
            bien.louer();
        }
    }

    public void libererBien() {
        int selectedIndex = view.getSelectedIndex();
        if (selectedIndex >= 0) {
            BienImmobilier bien = biensList.get(selectedIndex);
            bien.liberer();
        }
    }

    public void mettreEnMaintenance() {
        int selectedIndex = view.getSelectedIndex();
        if (selectedIndex >= 0) {
            BienImmobilier bien = biensList.get(selectedIndex);
            bien.mettreEnMaintenance();
        }
    }

    public ObservableList<BienImmobilier> listerBiens() {
        return biensList;
    }
}

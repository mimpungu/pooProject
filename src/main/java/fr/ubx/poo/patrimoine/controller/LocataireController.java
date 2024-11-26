package fr.ubx.poo.patrimoine.controller;

import fr.ubx.poo.patrimoine.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocataireController {
    private List<Locataire> locataires;
    private List<Contrat> contrats;

    public LocataireController() {
        this.locataires = new ArrayList<>();
        this.contrats = new ArrayList<>();
    }

    // Enregistrer un locataire
    public void enregistrerLocataire(Locataire locataire) {
        locataires.add(locataire);
    }

    // Supprimer un locataire
    public boolean supprimerLocataire(Locataire locataire) {
        return locataires.remove(locataire);
    }

    // Lister tous les locataires
    public List<Locataire> listerLocataires() {
        return new ArrayList<>(locataires);
    }

    // Créer un contrat de location
    public void creerContrat(Locataire locataire, BienImmobilier bien, LocalDate dateDebut, LocalDate dateFin, double loyer) {
        Contrat contrat = new Contrat(locataire, bien, dateDebut, dateFin, loyer);
        contrats.add(contrat);
        bien.setEtat(new EtatLouee());
    }

    // Annuler un contrat
    public boolean annulerContrat(Contrat contrat) {
        if (contrats.remove(contrat)) {
            contrat.getBienImmobilier().setEtat(new EtatDisponible());
            return true;
        }
        return false;
    }

    // Lister tous les contrats de location
    public List<Contrat> listerContrats() {
        return new ArrayList<>(contrats);
    }

    // Vérifier les contrats actifs
    public List<Contrat> listerContratsActifs() {
        List<Contrat> actifs = new ArrayList<>();
        LocalDate aujourdHui = LocalDate.now();
        for (Contrat contrat : contrats) {
            if (!aujourdHui.isBefore(contrat.getDateDebut()) && !aujourdHui.isAfter(contrat.getDateFin())) {
                actifs.add(contrat);
            }
        }
        return actifs;
    }

    // Vérifier les contrats expirés
    public List<Contrat> listerContratsExpirés() {
        List<Contrat> expires = new ArrayList<>();
        LocalDate aujourdHui = LocalDate.now();
        for (Contrat contrat : contrats) {
            if (aujourdHui.isAfter(contrat.getDateFin())) {
                expires.add(contrat);
            }
        }
        return expires;
    }

    public void modifierLocataire(Locataire selectedLocataire, String nom, String prenom, String address, String telephone) {
        // Vérification des nouvelles valeurs
        if (selectedLocataire != null) {
            // Mise à jour des attributs du locataire
            selectedLocataire.setNom(nom);
            selectedLocataire.setPrenom(prenom);
            selectedLocataire.setAddress(address); // Assurez-vous d'avoir une méthode pour modifier l'email
            selectedLocataire.setTelephone(telephone);
        }
    }
}

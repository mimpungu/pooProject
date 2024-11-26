package fr.ubx.poo.patrimoine.controller;

import fr.ubx.poo.patrimoine.model.Contrat;
import fr.ubx.poo.patrimoine.model.Sujet;

import java.util.ArrayList;
import java.util.List;

public class ContratController extends Sujet {
    private List<Contrat> contrats = new ArrayList<>();

    public void creerContrat(Contrat contrat) {
        contrats.add(contrat);
        notifierObservateurs("Nouveau contrat créé pour le locataire : " + contrat.getLocataire().getNom());
    }

    public void terminerContrat(Contrat contrat) {
        contrats.remove(contrat);
        notifierObservateurs("Le contrat pour le locataire " + contrat.getLocataire().getNom() + " a été terminé.");
    }

    public List<Contrat> getContrats() {
        return contrats;
    }
}

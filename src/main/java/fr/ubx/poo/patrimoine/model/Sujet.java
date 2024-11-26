package fr.ubx.poo.patrimoine.model;


import java.util.ArrayList;
import java.util.List;

public class Sujet {
    private List<Observateur> observateurs = new ArrayList<>();

    public void ajouterObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    public void supprimerObservateur(Observateur observateur) {
        observateurs.remove(observateur);
    }

    public void notifierObservateurs(String message) {
        for (Observateur observateur : observateurs) {
            observateur.mettreAJour(message);
        }
    }
}

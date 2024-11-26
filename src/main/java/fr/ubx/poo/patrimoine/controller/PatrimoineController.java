package fr.ubx.poo.patrimoine.controller;

import fr.ubx.poo.patrimoine.model.*;
import fr.ubx.poo.patrimoine.view.BienImmobilierView;

import java.util.List;

public class PatrimoineController extends Sujet {
    private BienImmobilierController gestionnaireBiens;
    private LocataireController gestionnaireLocataires;
    private TransactionController gestionnaireTransactions;

    public PatrimoineController(BienImmobilierView view) {
        this.gestionnaireBiens = new BienImmobilierController(view); // Passez la vue
        this.gestionnaireLocataires = new LocataireController();
        this.gestionnaireTransactions = new TransactionController(gestionnaireLocataires); // Modifiez pour passer gestionnaireLocataires
    }

    public void afficherEtatPatrimoine() {
        double valeurTotale = gestionnaireBiens.calculerValeurTotale();
        System.out.println("Valeur totale des biens : " + valeurTotale);

        double revenusGeneres = gestionnaireTransactions.calculerTotalPaiementsLoyer();
        System.out.println("Revenus générés : " + revenusGeneres);

        System.out.println("Contrats de location en cours :");
        List<Contrat> contratsActifs = gestionnaireLocataires.listerContratsActifs();
        if (contratsActifs.isEmpty()) {
            System.out.println("Aucun contrat actif.");
        } else {
            for (Contrat contrat : contratsActifs) {
                System.out.println(contrat);
            }
        }

        System.out.println("Locations disponibles :");
        List<BienImmobilier> biensDisponibles = gestionnaireBiens.listerBiens();
        if (biensDisponibles.isEmpty()) {
            System.out.println("Aucune location disponible.");
        } else {
            for (BienImmobilier bien : biensDisponibles) {
                System.out.println(bien);
            }
        }
    }

    public void notifierContratsEtLoyers() {
        System.out.println("Vérifiez les contrats de location et les loyers impayés !");
        List<Contrat> contratsExpires = gestionnaireLocataires.listerContratsExpirés();
        if (contratsExpires.isEmpty()) {
            System.out.println("Aucun contrat expiré.");
        } else {
            for (Contrat contrat : contratsExpires) {
                System.out.println("Contrat expiré : " + contrat);
            }
        }

        double totalLoyersImpayes = gestionnaireTransactions.calculerTotalLoyersImpayes();
        if (totalLoyersImpayes > 0) {
            notifierObservateurs("Alerte : Loyers impayés totalisant " + totalLoyersImpayes);
        }
    }

    public void ajouterObservateur(Observateur observateur) {
        super.ajouterObservateur(observateur);
    }

    public void supprimerObservateur(Observateur observateur) {
        super.supprimerObservateur(observateur);
    }
}

package fr.ubx.poo.patrimoine.model;

// Classe abstraite pour centraliser le comportement commun
abstract class EtatBienAbstrait implements EtatBien {
    @Override
    public void louer(BienImmobilier bien) {
        System.out.println("Action non autorisée dans l'état actuel: " + getNomEtat());
    }

    @Override
    public void liberer(BienImmobilier bien) {
        System.out.println("Action non autorisée dans l'état actuel: " + getNomEtat());
    }

    @Override
    public void mettreEnMaintenance(BienImmobilier bien) {
        System.out.println("Action non autorisée dans l'état actuel: " + getNomEtat());
    }

    // Nom de l'état en chaîne de caractères, pour un retour plus lisible
    @Override
    public abstract String getNomEtat();
}

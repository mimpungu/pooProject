// EtatLouee.java
package fr.ubx.poo.patrimoine.model;

public class EtatLouee extends EtatBienAbstrait {
    @Override
    public void liberer(BienImmobilier bien) {
        bien.setEtat(new EtatDisponible());
        System.out.println("Le bien est maintenant disponible.");
    }

    @Override
    public void mettreEnMaintenance(BienImmobilier bien) {
        bien.setEtat(new EtatEnMaintenance());
        System.out.println("Le bien loué est maintenant en maintenance.");
    }

    @Override
    public String getNomEtat() {
        return "Louée";
    }
}
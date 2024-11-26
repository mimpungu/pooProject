// EtatDisponible.java
package fr.ubx.poo.patrimoine.model;

public class EtatDisponible extends EtatBienAbstrait {
    @Override
    public void louer(BienImmobilier bien) {
        bien.setEtat(new EtatLouee());
        System.out.println("Le bien est maintenant loué.");
    }

    @Override
    public void mettreEnMaintenance(BienImmobilier bien) {
        bien.setEtat(new EtatEnMaintenance());
        System.out.println("Le bien est maintenant en maintenance.");
    }

    @Override
    public String getNomEtat() {
        return "Disponible";
    }
}
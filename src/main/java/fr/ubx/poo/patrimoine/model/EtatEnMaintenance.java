// EtatEnMaintenance.java
package fr.ubx.poo.patrimoine.model;

public class EtatEnMaintenance extends EtatBienAbstrait {
    @Override
    public void liberer(BienImmobilier bien) {
        bien.setEtat(new EtatDisponible());
        System.out.println("Le bien est libéré de la maintenance et est maintenant disponible.");
    }

    @Override
    public String getNomEtat() {
        return "En Maintenance";
    }
}

package fr.ubx.poo.patrimoine.model;

// EtatBien.java

public interface EtatBien {
    void louer(BienImmobilier bien);
    void liberer(BienImmobilier bien);
    void mettreEnMaintenance(BienImmobilier bien);

    String getNomEtat();
}

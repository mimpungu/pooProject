package fr.ubx.poo.patrimoine.model;

import java.time.LocalDate;

public class Contrat {
    private Locataire locataire;
    private BienImmobilier bienImmobilier; // Bien associé
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double loyer;

    public Contrat(Locataire locataire, BienImmobilier bienImmobilier, LocalDate dateDebut, LocalDate dateFin, double loyer) {
        this.locataire = locataire;
        this.bienImmobilier = bienImmobilier;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.loyer = loyer;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public BienImmobilier getBienImmobilier() {
        return bienImmobilier;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public double getLoyer() {
        return loyer;
    }


    @Override
    public String toString() {
        return "Contrat{" +
                "locataire=" + locataire.getNom() + " " + locataire.getPrenom() +
                ", bienImmobilier=" + bienImmobilier.getAdresse() +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", loyer=" + loyer +
                '}';
    }
}

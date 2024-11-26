package fr.ubx.poo.patrimoine.model;

public class Appartement extends BienImmobilier {
    private int nombreChambres;
    private double superficie;
    private double loyer;

    public Appartement(String adresse, double prix, double superficie, double loyer) {
        super(adresse, prix, superficie, "Disponible"); // Provide a default state
        this.nombreChambres = 0; // Set to a default value or use a parameter
        this.superficie = superficie;
        this.loyer = loyer;
    }

    public int getNombreChambres() {
        return nombreChambres;
    }

    public void setNombreChambres(int nombreChambres) {
        this.nombreChambres = nombreChambres;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    @Override
    public String getType() {
        return "Appartement";
    }

    @Override
    public String toString() {
        return "Appartement{" +
                "adresse='" + getAdresse() + '\'' +
                ", prix=" + getPrix() +
                ", nombreChambres=" + nombreChambres +
                ", superficie=" + superficie +
                ", loyer=" + getLoyer() + // Include loyer in toString
                '}';
    }
}

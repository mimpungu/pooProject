package fr.ubx.poo.patrimoine.model;

public class Bureau extends BienImmobilier {
    private double superficie;
    private double loyer;

    public Bureau(String adresse, double prix, double superficie, double loyer) {
        super(adresse, prix, superficie, "Disponible"); // Provide a default state
        this.superficie = superficie;
        this.loyer = loyer;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    @Override
    public String getType() {
        return "Bureau";
    }

    @Override
    public String toString() {
        return "Bureau{" +
                "superficie=" + superficie +
                ", loyer=" + getLoyer() + // Include loyer in toString
                ", adresse='" + getAdresse() + '\'' +
                ", prix=" + getPrix() +
                ", état=" + getEtat().getClass().getSimpleName() +
                '}';
    }
}

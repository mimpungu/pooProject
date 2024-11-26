package fr.ubx.poo.patrimoine.model;

public class Terrain extends BienImmobilier {
    private double superficie;
    private boolean constructible;

    public Terrain(String adresse, double prix, double superficie, boolean constructible) {
        super(adresse, prix, superficie, "Disponible"); // Provide a default state
        this.superficie = superficie;
        this.constructible = constructible;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public boolean isConstructible() {
        return constructible;
    }

    public void setConstructible(boolean constructible) {
        this.constructible = constructible;
    }

    @Override
    public String getType() {
        return "Terrain";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", superficie=" + superficie +
                ", constructible=" + (constructible ? "Oui" : "Non");
    }
}

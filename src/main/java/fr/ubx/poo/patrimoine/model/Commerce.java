package fr.ubx.poo.patrimoine.model;

public class Commerce extends BienImmobilier {
    private String typeCommerce;

    public Commerce(String adresse, double prix, String typeCommerce) {
        super(adresse, prix, 0, "Disponible"); // Assuming superficie is not needed for Commerce
        this.typeCommerce = typeCommerce;
    }

    public String getTypeCommerce() {
        return typeCommerce;
    }

    public void setTypeCommerce(String typeCommerce) {
        this.typeCommerce = typeCommerce;
    }

    @Override
    public String getType() {
        return "Commerce - " + typeCommerce;
    }

    @Override
    public String toString() {
        return "Commerce{" +
                "type='" + typeCommerce + '\'' +
                ", adresse='" + getAdresse() + '\'' +
                ", prix=" + getPrix() +
                ", loyer=" + getLoyer() + // Include loyer in toString
                ", état=" + getEtat().getClass().getSimpleName() +
                '}';
    }
}

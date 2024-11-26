package fr.ubx.poo.patrimoine.model;

public abstract class BienImmobilier extends Sujet {
    private String adresse;
    private double prix;
    private double loyer; // Added loyer field
    private String type; // Added type field
    private EtatBien etat;

    // Updated constructor to include loyer and type
    public BienImmobilier(String adresse, double prix, double loyer, String type) {
        this.adresse = adresse;
        this.prix = prix;
        this.loyer = loyer; // Initialize loyer
        this.type = type;   // Initialize type
        this.etat = new EtatDisponible(); // État initial
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getLoyer() { // Getter for loyer
        return loyer;
    }

    public void setLoyer(double loyer) { // Setter for loyer
        this.loyer = loyer;
    }

    public String getType() { // Getter for type
        return type;
    }

    public void setType(String type) { // Setter for type
        this.type = type;
    }

    public EtatBien getEtat() {
        return etat;
    }

    public void setEtat(EtatBien etat) {
        this.etat = etat;
    }

    public void louer() {
        etat.louer(this);
        notifierObservateurs("Le bien " + adresse + " est maintenant loué.");
    }

    public void liberer() {
        etat.liberer(this);
        notifierObservateurs("Le bien " + adresse + " est maintenant disponible.");
    }

    public void mettreEnMaintenance() {
        etat.mettreEnMaintenance(this);
        notifierObservateurs("Le bien " + adresse + " est maintenant en maintenance.");
    }

    @Override
    public String toString() {
        return "BienImmobilier{" +
                "adresse='" + adresse + '\'' +
                ", prix=" + prix +
                ", loyer=" + loyer + // Include loyer in toString
                ", type='" + type + '\'' + // Include type in toString
                ", etat=" + etat.getClass().getSimpleName() +
                '}';
    }
}

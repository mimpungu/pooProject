// Locataire.java
package fr.ubx.poo.patrimoine.model;

public class Locataire {
    private String nom;
    private String prenom;
    private String address; // Optionnel, pour notifications par email
    private String telephone; // Nouveau champ pour le numéro de téléphone

    public Locataire(String nom, String prenom, String address, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.telephone = telephone; // Initialisation du téléphone
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone; // Méthode pour obtenir le numéro de téléphone
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone; // Méthode pour mettre à jour le numéro de téléphone
    }

    @Override
    public String toString() {
        return "Locataire{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + address + '\'' +
                ", telephone='" + telephone + '\'' + // Ajout du téléphone à la représentation
                '}';
    }
}

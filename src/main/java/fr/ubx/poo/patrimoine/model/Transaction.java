package fr.ubx.poo.patrimoine.model;

import java.time.LocalDate;

public class Transaction {
    public enum TypeTransaction {
        PAIEMENT_LOYER, REMBOURSEMENT, DEPENSE
    }

    private Locataire locataire;
    private double montant;
    private LocalDate dateTransaction;
    private TypeTransaction typeTransaction;

    public Transaction(Locataire locataire, double montant, LocalDate dateTransaction, TypeTransaction typeTransaction) {
        this.locataire = locataire;
        this.montant = montant;
        this.dateTransaction = dateTransaction;
        this.typeTransaction = typeTransaction;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public double getMontant() {
        return montant;
    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "locataire=" + locataire +
                ", montant=" + montant +
                ", dateTransaction=" + dateTransaction +
                ", typeTransaction=" + typeTransaction +
                '}';
    }
}

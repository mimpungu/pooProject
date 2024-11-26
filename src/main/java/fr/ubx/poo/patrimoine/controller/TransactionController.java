package fr.ubx.poo.patrimoine.controller;

import fr.ubx.poo.patrimoine.model.Contrat;
import fr.ubx.poo.patrimoine.model.Locataire;
import fr.ubx.poo.patrimoine.model.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionController {
    private List<Transaction> transactions;
    private LocataireController gestionnaireLocataires; // Utilisation de LocataireController

    public TransactionController(LocataireController gestionnaireLocataires) { // Constructeur modifié
        this.transactions = new ArrayList<>();
        this.gestionnaireLocataires = gestionnaireLocataires; // Initialisation correcte
    }

    // Ajouter une nouvelle transaction
    public void ajouterTransaction(Locataire locataire, double montant, Transaction.TypeTransaction typeTransaction) {
        Transaction transaction = new Transaction(locataire, montant, LocalDate.now(), typeTransaction);
        transactions.add(transaction);
    }

    // Annuler une transaction
    public boolean annulerTransaction(Transaction transaction) {
        return transactions.remove(transaction);
    }

    // Lister toutes les transactions
    public List<Transaction> listerTransactions() {
        return new ArrayList<>(transactions);
    }

    // Lister les transactions par locataire
    public List<Transaction> listerTransactionsParLocataire(Locataire locataire) {
        List<Transaction> resultats = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getLocataire().equals(locataire)) {
                resultats.add(transaction);
            }
        }
        return resultats;
    }

    // Calculer le total des paiements de loyer
    public double calculerTotalPaiementsLoyer() {
        double total = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getTypeTransaction() == Transaction.TypeTransaction.PAIEMENT_LOYER) {
                total += transaction.getMontant();
            }
        }
        return total;
    }

    // Calculer le total des loyers impayés
    public double calculerTotalLoyersImpayes() {
        double totalImpayes = 0.0;
        LocalDate aujourdHui = LocalDate.now();

        // Utiliser LocataireController pour obtenir les contrats
        for (Contrat contrat : gestionnaireLocataires.listerContrats()) { // Appel à listerContrats de LocataireController
            boolean loyerPaye = false;
            for (Transaction transaction : transactions) {
                if (transaction.getLocataire().equals(contrat.getLocataire()) &&
                        transaction.getTypeTransaction() == Transaction.TypeTransaction.PAIEMENT_LOYER) {
                    loyerPaye = true;
                    break; // Sortir dès qu'un paiement est trouvé
                }
            }
            // Si aucun loyer n'a été payé et que le contrat est actif
            if (!loyerPaye && aujourdHui.isAfter(contrat.getDateDebut()) && aujourdHui.isBefore(contrat.getDateFin())) {
                totalImpayes += contrat.getLoyer(); // Ajouter le loyer du contrat impayé
            }
        }
        return totalImpayes;
    }

    // Afficher toutes les transactions
    public void afficherTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

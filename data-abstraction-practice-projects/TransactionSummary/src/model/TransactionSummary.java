package model;

import java.util.ArrayList;
import java.util.List;

public class TransactionSummary {

    private String name;
    private List<Transaction> transactions;

    public TransactionSummary(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getNumTransactions() {
        return transactions.size();
    }

    // REQUIRES: t is not already within transactions
    // MODIFIES: this
    // EFFECTS: adds the given transaction t to the list of transactions
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: computes the average amount of money spent on a transaction
    public double averageTransactionCost() {
        double totalAmount = 0.0;
        for (Transaction t : transactions) {
            totalAmount += t.getAmount();
        }
        return (totalAmount / (double) getNumTransactions());
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS:  returns the average cost of all transactions of type specificType in this
    //           TransactionSummary
    public double specificTypeAverage(TransactionType specificType) {
        double totalAmount = 0.0;
        int numTypeTransactions = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals(specificType)) {
                totalAmount += t.getAmount();
                numTypeTransactions++;
            }
        }
        return (totalAmount / (double) numTypeTransactions);
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: returns the largest transaction (in terms of cost) in this TransactionSummary
    public Transaction largestTransaction() {
        Transaction largest = null;
        for (Transaction t : transactions) {
            if (largest == null || (t.getAmount() > largest.getAmount())) {
                largest = t;
            }
        }
        return largest;
    }

    // EFFECTS: returns true if the given transaction is contained within the list of transactions
    public boolean contains(Transaction t) {
        for (Transaction cur : transactions) {
            if (cur.equals(t)) {
                return true;
            }
        }
        return false;
    }


}

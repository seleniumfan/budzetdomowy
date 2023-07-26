package org.example;

import java.util.List;

public class BudgetReadExpense {
    private static final TransactionDao TRANSACTION_DAO = new TransactionDao();

    public static void main(String[] args) {
        System.out.println("Wyświetlanie wszystkich wydatków:");
        List<Transaction> expenses = TRANSACTION_DAO.findByType("wydatek");
        System.out.println(expenses);
    }
}

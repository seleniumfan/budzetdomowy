package org.example;

import java.util.List;

public class BudgetReadIncome {
    private static final TransactionDao TRANSACTION_DAO = new TransactionDao();

    public static void main(String[] args) {
        System.out.println("Wyświetlanie wszystkich przychodów:");
        List<Transaction> incomes = TRANSACTION_DAO.findByType("przychód");
        System.out.println(incomes);
    }
}

package org.example;

import java.util.Scanner;

public class BudgetDelete {
    private static final TransactionDao TRANSACTION_DAO = new TransactionDao();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id usuwanej transakcji");
        int id = scanner.nextInt();
        scanner.nextLine();

        TRANSACTION_DAO.deleteTransaction(id);
    }
}

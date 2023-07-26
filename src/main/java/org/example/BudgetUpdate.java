package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class BudgetUpdate {
    private static final TransactionDao TRANSACTION_DAO = new TransactionDao();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id modyfikowanej transakcji");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj typ transakcji [wydatek / przychód]:");
        String type = scanner.nextLine();

        System.out.println("Podaj opis transakcji:");
        String description = scanner.nextLine();

        System.out.println("Podaj kwotę transakcji:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj datę transakcji w postaci YYYY-MM-DD ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        Transaction transaction = new Transaction(id, type, description, amount, date);
        TRANSACTION_DAO.updateTransaction(transaction);
    }
}

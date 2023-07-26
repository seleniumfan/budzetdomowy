package org.example;

import java.util.Scanner;

public class BudgetApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWybierz jedną z opcji");
            System.out.println("1. Dodawanie transakcji");
            System.out.println("2. Modyfikacja transakcji");
            System.out.println("3. Usuwanie transakcji");
            System.out.println("4. Wyświetlanie wszytkich przychodów");
            System.out.println("4. Wyświetlanie wszytkich wydatków");
            System.out.println("0. Koniec");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1" -> BudgetAdd.main(new String[0]);
                case "2" -> BudgetUpdate.main(new String[0]);
                case "3" -> BudgetDelete.main(new String[0]);
                case "4" -> BudgetReadIncome.main(new String[0]);
                case "5" -> BudgetReadExpense.main(new String[0]);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Błędny wybór!");
            }
        }
    }
}
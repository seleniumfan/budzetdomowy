package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    private final Connection connection;

    public TransactionDao() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions_db?serverTimezone=UTC", "root", "admin");
        } catch (SQLException e) {
            throw new RuntimeException("Nie można połączyć się z bazą danych", e);
        }
    }

    void addTransaction(Transaction transaction) {
        final String sql = "INSERT INTO transaction(type, description, amount, date) VALUES(?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            int addedRows = preparedStatement.executeUpdate();
            System.out.println("Dodano " + addedRows + " transakcję.");
        } catch (SQLException e) {
            throw new RuntimeException("Niepowodzenie podczas zapisu do bazy: ", e);
        }
    }

    public void updateTransaction(Transaction transaction) {
        final String sql = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            preparedStatement.setInt(5, transaction.getId());
            int addedRows = preparedStatement.executeUpdate();
            System.out.println("Zaktualizowano " + addedRows + " transakcję.");
        } catch (SQLException e) {
            throw new RuntimeException("Niepowodzenie podczas zapisu do bazy: ", e);
        }
    }

    public void deleteTransaction(int id) {
        final String sql = "DELETE FROM transaction WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int addedRows = preparedStatement.executeUpdate();
            System.out.println("Usunięto " + addedRows + " transakcję.");
        } catch (SQLException e) {
            throw new RuntimeException("Niepowodzenie podczas usuwania z bazy: ", e);
        }
    }

    List<Transaction> findByType(String type) {
        List<Transaction> transactions = new ArrayList<>();
        final String sql = "SELECT * FROM transaction WHERE type=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                Transaction transaction = new Transaction(id, type, description, amount, date);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println();
            throw new RuntimeException("Niepowodzenie podczas usuwania z bazy: ", e);
        }
        return transactions;
    }
}

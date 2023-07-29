CREATE DATABASE IF NOT EXISTS transactions_db;
USE transactions_db;
DROP TABLE IF EXISTS transactions;
CREATE TABLE transaction (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(30),
    description VARCHAR(200),
    amount DECIMAL(10, 2),
    date DATE
);

INSERT INTO transaction (type, description, amount, date) 
VALUES 
('wydatek', 'Zakup artykułów spożywczych', 150.00, '2023-07-01'),
('przychód', 'Wynagrodzenie za pracę', 5000.00, '2023-07-01'),
('wydatek', 'Opłata za wynajem', 2000.00, '2023-07-02'),
('wydatek', 'Zakup ubrań', 300.00, '2023-07-03'),
('przychód', 'Zwrot podatku', 500.00, '2023-07-04'),
('wydatek', 'Opłata za Internet', 50.00, '2023-07-05'),
('przychód', 'Wynagrodzenie za dodatkowe zlecenie', 2000.00, '2023-07-06'),
('wydatek', 'Zakup sprzętu komputerowego', 2500.00, '2023-07-07'),
('wydatek', 'Opłata za energię', 200.00, '2023-07-08'),
('przychód', 'Premia roczna', 10000.00, '2023-07-09');

SELECT * FROM transaction;
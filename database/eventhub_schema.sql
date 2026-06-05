CREATE DATABASE IF NOT EXISTS eventhub;

USE eventhub;

CREATE TABLE users (
user_id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(100) NOT NULL,
role VARCHAR(20) NOT NULL,
wallet_balance DOUBLE DEFAULT 0
);

CREATE TABLE events (
event_id INT AUTO_INCREMENT PRIMARY KEY,
event_name VARCHAR(200) NOT NULL,
event_date DATE NOT NULL,
venue VARCHAR(200) NOT NULL,
ticket_price DOUBLE NOT NULL,
total_seats INT NOT NULL,
available_seats INT NOT NULL
);

CREATE TABLE bookings (
booking_id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
event_id INT NOT NULL,
tickets_booked INT NOT NULL,
total_amount DOUBLE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(user_id),
FOREIGN KEY (event_id) REFERENCES events(event_id)
);

CREATE TABLE transactions (
transaction_id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
amount DOUBLE NOT NULL,
transaction_type VARCHAR(100) NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(user_id)
);

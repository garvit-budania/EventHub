USE eventhub;

INSERT INTO users (
username,
password,
role,
wallet_balance
)
VALUES
('admin', 'admin123', 'ADMIN', 0),
('demo_user', '123', 'CUSTOMER', 5000);

INSERT INTO events (
event_name,
event_date,
venue,
ticket_price,
total_seats,
available_seats
)
VALUES
(
'Tech Fest 2026',
'2026-10-24',
'BITS Pilani',
1000,
500,
500
),
(
'Cultural Night',
'2026-11-15',
'Open Air Theatre',
300,
1000,
1000
);

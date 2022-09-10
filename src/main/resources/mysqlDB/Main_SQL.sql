USE IT_Company;

INSERT INTO Country (country)
VALUES ('Ukraine'), ('Poland'), ('USA'), ('Canada'), ('United Kingdom'), ('Estonia'), ("France");

INSERT INTO City (city, country_id)
VALUES ('Kyiv', 1), ('Kharkiv', 1), ("Warsaw", 2), ("Krakiv", 2), ("Washington", 3), ("New York", 3),
("Ottawa", 4), ("London", 5), ("Tallinn", 6), ("Paris", 7), ("Marcel", 7);

INSERT INTO Addresses (address, district, postal_code, city_id)
VALUES ("Nezalezhnosti 22", "Shevchenkivskii", 01213, 1), ("Svobody 33", "Darnytskii", 01411, 1),
("Pravdy 48", "Kharkivskii", 31211, 2), ("Viry 25", "Kyivskii", 30112, 2),
("Zlotiy 11", "Warsawskii", 04414, 3), ("Korolevskii 441", "Krakivskii", 30112, 4),
("Long Street 314", "Washington's 10th congressional district", 05515, 5), ("American 95", "New York's 26th congressional district", 30112, 6),
("Eastman 22", "West Carleton", 11231, 7), ("Johnson 351", "Albany Park", "DA14", 8), 
("Valdeku 13", "Nomme", 11621, 9);

INSERT INTO Employee_contacts (phone_number, email, address_id)
VALUES ("+380960123190", "pavlo.ivanenko@gmail.com", 1), ("+380989432564", "mykyta.kozhumyaka@ukr.net", 2),
("+380991114115", "velikiydenys@gmail.com", 3), ("+380950908980", "work.dave@gmail.com", 4),
("+48228253144", "fatima.galyckii@gmail.com", 5), ("+4824123653", "kama.rozumniy@gmail.com", 6),
("+18009316279", "johndavidson@gmail.com", 7), ("+17248614100", "olivercamp@gmail.com", 8),
("+17054827143", "victorcameron@gmail.com", 9);

INSERT INTO Positions (position)
VALUES ('Manager'), ('QA'), ('Developer'), ('Designer');

INSERT INTO Teams (team_name)
VALUES ("Java lovers"), ("Top communicators"), ("Mega productive team"), ("Best team");

INSERT INTO Employees (first_name, last_name, position_id, contact_id, team_id)
VALUES ("Pavlo", "Ivanenko", 3, 1, 3), ("Mykyta", "Kozhumyaka", 2, 2, 1),
("Denys", "Velikiy", 1, 3, 3), ("Dave", "Petrenko", 2, 4, 2),
("Fatima", "Galyckii", 3, 5, 2), ("Kama", "Rozumniy", 3, 6, 1),
("John", "Davidson", 1, 7, 2), ("Oliver", "Camp", 2, 8, 1),
("Victor", "Cameron", 4, 9, 3);

INSERT INTO Customer_types (customer_type)
VALUES ("Commercial company"), ("Government agency"), ("Individual"), ("Private Company");

INSERT INTO Customer_contacts (responsible_person_name, phone_number, email, address_id)
VALUES ("Tommy Bond", "+442045771972", "bond1972@gmail.com", 10), ("Antony Eshly", "+3723929929", "eshly@gmail.com" , 11);

INSERT INTO Customers (customer_name, customer_type_id, customer_contact_id)
VALUES ("Intelligence Inc.", 1, 1), ("Tallinn IT Government", 2, 2);

INSERT INTO Services (service_name, lead_time)
VALUES ("Custom Software Development", "from 2 to 6 months"), ("Technology Consulting", "from 1 to 3 weeks"), 
("Technology Advisory", "from 1 to 2 weeks"), ("Modernization", "from 1 to 4 months");

INSERT INTO Categories (category_name)
VALUES ("Banking and Finance"), ("Retail and Distribution"),
("Media and Entertainment"), ("Software and Hi-Tech"),
("Healthcare and Wellness");

INSERT INTO Service_category(service_id, category_id)
VALUES (1,1), (1,2), (1,3), (1,4), (1,5),
(2,1), (2,2), (2,3), (2,4), (2,5),
(3,1), (3,2), (3,3), (3,4), (3,5),
(4,1), (4,2), (4,3), (4,4), (4,5);

INSERT INTO Discount (discount_name, discount_success)
VALUES ("Your_Giftcode", true), ("Private_GIFT", true), ("PASSGift", true);

INSERT INTO Orders (price, date_creation, payment_type, date_payment, customer_id, team_id, discount_id, service_category_id)
VALUES (10044.21, "2022-08-31 09:34:21", "VISA card", "2022-08-31 19:51:47", 1, 3, 1, 12), (59981.31, "2022-07-22 12:11:51", "Cash", "2022-07-25 11:41:45", 2, 2, 2, 16);



UPDATE Employee_contacts
SET phone_number="+380998675443"
WHERE id = 1;

UPDATE Addresses
SET postal_code="49831"
WHERE district = "Krakivskii";

UPDATE Discount
SET discount_success = false
WHERE id = 3;

UPDATE Country
SET country = "Italy"
WHERE id=7;

UPDATE City
SET city = "Rome"
WHERE id=10;

UPDATE City
SET city = "Milan"
WHERE id=11;



DELETE FROM City
WHERE country_id = 7;

DELETE FROM Country
WHERE country="Italy";

DELETE FROM Discount
WHERE discount_name = "PASSGift";

DELETE FROM Customer_types
WHERE customer_type="Private Company";

DELETE FROM Teams
WHERE id = 4;



SELECT * 
FROM Employees
WHERE team_id = 3 AND position_id = 3;

SELECT * 
FROM City
WHERE city="Tallinn" OR country_id = 6;

SELECT * 
FROM Employees
WHERE position_id IN (1, 4);

SELECT *
FROM Orders
WHERE price BETWEEN 5000 AND 15000;

SELECT * 
FROM Addresses
ORDER BY address ASC;

SELECT COUNT(id), position_id 
FROM Employees
GROUP BY position_id;




SELECT Addresses.address, Addresses.district, City.city
FROM Addresses
INNER JOIN City ON Addresses.city_id = City.id
ORDER BY city ASC;

SELECT Country.country, City.city
FROM Country
RIGHT JOIN City ON Country.id = City.country_id
ORDER BY country ASC;

SELECT Employees.first_name, Employees.last_name, Positions.position
FROM Employees
LEFT JOIN Positions ON Employees.position_id=Positions.id
ORDER BY position ASC;
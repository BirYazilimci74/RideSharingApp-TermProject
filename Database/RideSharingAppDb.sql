-- Creating Database
CREATE DATABASE rideshareapp;

-- Using rideshareapp Database
USE rideshareapp;

-- Creating Table
CREATE TABLE rides (
    id INT AUTO_INCREMENT PRIMARY KEY,
    driverName VARCHAR(255) NOT NULL,
    target VARCHAR(255) NOT NULL,
    plate VARCHAR(255) NOT NULL,
    latitude DECIMAL(9,6) NOT NULL,
    longitude DECIMAL(9,6) NOT NULL
);

-- Sample Datas
INSERT INTO rides (driverName, target, plate, latitude, longitude) VALUES 
('Harun Yahya Ünal', 'Bağcılar', '34hk45', 40.9158418, 29.2507073),
('Harun Yahya Ünal', 'Adalar', '34bjs017', 40.9258418, 29.2607073),
('Harun Yahya Ünal', 'Esenler', '45bhj45', 40.9358418, 29.2707073),
('Harun Yahya Ünal', 'Bahçelievler', '45fgh34', 40.9458418, 29.2807073),
('Muhammet Ali Ünal', 'Adalar', '34gs1905', 40.9558418, 29.2907073),
('Muhammet Ali Ünal', 'Ataşehir', '23dk342', 40.9658418, 29.3007073),
('Harun Yahya Ünal', 'Kadıköy', '61Ern61', 40.9758418, 29.3107073),
('Harun Yahya Ünal', 'Pendik', '34gs1905', 40.9858418, 29.3207073),
('Esma Şen', 'Adalar', '34dr457', 40.9958418, 29.3307073);

CREATE DATABASE noleggio_auto;

USE noleggio_auto;

CREATE TABLE prenotazioni (
    id INT AUTO_INCREMENT PRIMARY KEY,
    auto VARCHAR(50) not null,
    data_inizio DATE not null,
    data_fine DATE not null,
    costo_totale DOUBLE
);
CREATE TABLE auto_disponibili(
	id INT AUTO_INCREMENT PRIMARY KEY,
    marca varchar(30) not null,
    modello varchar(30) not null,
    prezzo int not null
);

INSERT INTO auto_disponibili(marca, modello, prezzo)
VALUES 
("Fiat", "500", 30),
("Audi", "A3", 50),
("BMW", "X1", 70),
("Mercedes Benz", "Classe A", 90),
("Tesla", "Model3", 100);

DROP TABLE IF EXISTS Personne;
 
CREATE TABLE Personne (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  prenom VARCHAR(255) NOT NULL,
  nom VARCHAR(255) NOT NULL,
  age INT DEFAULT 0
);
 
INSERT INTO Personne (nom, prenom, age) VALUES
  ('Legrand', 'Anne', 42),
  ('Lemoyen', 'Marc', 35),
  ('Lepetit', 'Hedgar', 65);
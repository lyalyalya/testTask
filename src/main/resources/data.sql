CREATE TABLE IF NOT EXISTS clients (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS addresses (
  id        INT AUTO_INCREMENT PRIMARY KEY,
  name      VARCHAR(250) NOT NULL,
  client_id INT          NOT NULL REFERENCES clients (id)
);


INSERT INTO clients (id, name)
VALUES (1, 'Aliko'),
       (2, 'Bill'),
       (3, 'Folrunsho');

INSERT INTO addresses (name, client_id)
VALUES ('Moscow', 3),
       ('Spb', 2),
       ('Kazan', 2),
       ('Samara', 2);
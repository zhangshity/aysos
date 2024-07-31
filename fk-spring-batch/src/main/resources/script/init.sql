CREATE TABLE person (
                        id BIGINT PRIMARY KEY,
                        first_name VARCHAR(50),
                        last_name VARCHAR(50)
);

INSERT INTO person (id, first_name, last_name) VALUES (1, 'John', 'Doe');
INSERT INTO person (id, first_name, last_name) VALUES (2, 'Jane', 'Doe');
INSERT INTO person (id, first_name, last_name) VALUES (3, 'Max', 'Mustermann');

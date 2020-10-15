DROP DATABASE IF EXISTS alpha_com_shop;
CREATE DATABASE alpha_com_shop;
USE alpha_com_shop;

CREATE TABLE login(
    tp INT(10) NOT NULL,
    pw VARCHAR(4) NOT NULL,
    CONSTRAINT PRIMARY KEY (tp)
);

INSERT INTO login VALUES
('0764184020','1234');

DESC login;
SELECT * FROM login;

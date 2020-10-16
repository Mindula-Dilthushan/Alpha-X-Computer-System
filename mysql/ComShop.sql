DROP DATABASE IF EXISTS alpha_com_shop;
CREATE DATABASE alpha_com_shop;
USE alpha_com_shop;

CREATE TABLE login(
    tp INT(10) NOT NULL,
    pw VARCHAR(4) NOT NULL,
    CONSTRAINT PRIMARY KEY (tp)
);
CREATE TABLE product(
    pid VARCHAR(5) NOT NULL,
    pbrand VARCHAR(25) NOT NULL,
    pname VARCHAR (25) NOT NULL,
    pdesc VARCHAR (40) NOT NULL,
    pqty INT (10) NOT NULL,
    pprice DOUBLE (10,2) NOT NULL,
    CONSTRAINT PRIMARY KEY (pid)
);

INSERT INTO login VALUES
('0764184020','1234');

INSERT INTO product VALUES
('P001','ACER','ASPIRE 5','CORE I5 10TH GEN','10','118000');

DESC login;
DESC product;
SELECT * FROM login;
SELECT * FROM product;

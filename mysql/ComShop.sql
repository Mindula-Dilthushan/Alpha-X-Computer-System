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
CREATE TABLE supplier(
    sid VARCHAR(5)NOT NULL,
    sname VARCHAR(30)NOT NULL,
    saddress VARCHAR(35)NOT NULL,
    scontact INT(10)NOT NULL,
    semail VARCHAR(30)NOT NULL,
    CONSTRAINT PRIMARY KEY(sid)
);
CREATE TABLE customer(
    cid VARCHAR(5)NOT NULL,
    cname VARCHAR(30)NOT NULL,
    caddress VARCHAR(35)NOT NULL,
    ccontact INT(10)NOT NULL,
    cemail VARCHAR(30)NOT NULL,
    CONSTRAINT PRIMARY KEY(cid)
);


SHOW TABLES;

INSERT INTO login VALUES
(0764184020,'1234');
INSERT INTO product VALUES
('P001','ACER','ASPIRE 5','CORE I5 10TH GEN',10,118000);
INSERT INTO supplier VALUES
('S001','SAHAN','MATARA',0702498385,'sahan@gmail.com');
INSERT INTO customer VALUES
('C001','DILTHUSHAN','WALGAMA',0712345678,'dilthushan@gmail.com');

DESC login;
DESC product;
DESC supplier;
DESC customer;

SELECT * FROM login;
SELECT * FROM product;
SELECT * FROM supplier;
SELECT * FROM customer;

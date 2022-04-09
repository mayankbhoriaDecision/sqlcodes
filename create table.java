CREATE TABLE building(
    id INT PRIMARY KEY,
    owner_name VARCHAR2 (100) NOT NULL,
  	address VARCHAR2 (100) NOT NULL,
  	building_type_id INT,
  	contact_number VARCHAR2 (100) NOT NULL,
  	email_address VARCHAR2 (100) NOT NULL
); 

CREATE TABLE station(
    id INT PRIMARY KEY,
    name VARCHAR2 (100) NOT NULL,
  	locality VARCHAR2 (100) NOT NULL,
  	is_interchange INT
); 


ALTER TABLE building RENAME COLUMN email_address TO email;

ALTER TABLE station RENAME COLUMN locality TO station_locality;

ALTER TABLE department ADD( user_id  NUMBER(20) NOT NULL);
 ALTER TABLE building ADD( description varchar(255) NOT NULL);
Alter TABLE building drop COLUMN address;

alter table building MODIFY owner_name varchar(500);



INSERT INTO building
(ID,owner_name,NAME,address,contact_number,email_address,building_type_id,CONNECTION_TYPE_ID)
VALUES (1,'Alexander','ShoppingMall','delhi','123','abc',1, 2);





UPDATE building
SET owner_name = 'Alexander'
WHERE owner_name = 'Nicholas';


DELETE FROM building
WHERE owner_name = 'Ron Sim'



INSERT INTO building
(building_type_id,ID,owner_name,NAME,address,contact_number,email_address,CONNECTION_TYPE_ID)
VALUES (1,1,'Alexander','ShoppingMall','delhi','123','abc', 2);



SELECT *
FROM electricity_connection_type
ORDER BY connection_name ASC;


SELECT owner_name,contact_number
FROM building
ORDER BY owner_name ASC;


SELECT *
FROM bill
Where total_units>10000
ORDER BY total_units DESC;


SELECT rate
FROM slab
Where from_unit=2001 and to_unit=4500;


SELECT owner_name,address,contact_number
FROM building
where email_address IS NULL
ORDER BY owner_name ASC;

SELECT *
FROM station
where is_interchange=0
ORDER BY name ASC;

SELECT *
FROM travel_card
where person_name='Michael';
 

ALTER TABLE department
ADD CONSTRAINT ABC FOREIGN KEY (user_id)
REFERENCES users(id);


RENAME department To departments;    










DELETE FROM building_type WHERE name='Shopping Mall';
DELETE FROM building_type WHERE name='Hotel';

INSERT INTO building_type
(id,name,connection_type_id)
VALUES (1,'Shopping Mall',2);



INSERT INTO building_type
(id,name,connection_type_id)
VALUES (2,'Hotel',2);



INSERT INTO station
(id,name,locality,is_interchange)
VALUES (1,'a','del',0);



SELECT AVG(TOTAL_UNITS) AS AVERAGE_UNITS_OF_ELECTRICITY
FROM electricity_reading;

SELECT SUM(PAYABLE_AMOUNT) AS SUM_PAYABLE_AMOUNT
FROM bill;


SELECT owner_name,LENGTH(owner_name) as NAME_LENGTH
FROM building
ORDER BY owner_name ASC;

SELECT owner_name, COALESCE(contact_number,'-',email_address) as CONTACT_DETAILS
FROM building
ORDER BY owner_name DESC;


SELECT owner_name,(contact_number || '-'|| email_address) CONTACT_DETAILS
FROM building 
ORDER BY owner_name DESC;


SELECT substr(meter_number, 1, 3) as METER_CODE
FROM meter
ORDER BY meter_code DESC;



 SELECT * FROM department WHERE NAME LIKE 'R%';






SELECT *
FROM building
where building_type_id=14
ORDER BY owner_name ASC;




SELECT contact_number
FROM building
where building_type_id=8
ORDER BY contact_number ASC;

SELECT name
FROM building_type
WHERE id IN 
(
  SELECT id
  FROM meter
  where meter_number='SG734652');

SELECT meter_number
FROM meter
WHERE id IN 
(SELECT id
  FROM building_type
  where name='College')
ORDER BY meter_number ASC;


SELECT meter_number
FROM meter
WHERE id IN 
(SELECT id
  FROM building_type
  where name='College')
ORDER BY meter_number ASC;


SELECT UPPER(name)
FROM building_type
WHERE id IN 
(
  SELECT id
  FROM meter
  where meter_number='SG824012');




CREATE VIEW  building_details AS
SELECT *
FROM building;


CREATE SYNONYM electricity_bill 
FOR bill;



CREATE UNIQUE INDEX building_idx 
ON building (owner_name );


CREATE VIEW  travel_card_details AS
SELECT *
FROM travel_card;


CREATE   INDEX due_datex 
ON bill(due_date );

SELECT  meter_number
FROM meter
WHERE id IN 
(
  SELECT id
  FROM building
  where id IN
  (
    SELECT id 
    From building_type
    where name='College'
    )
);

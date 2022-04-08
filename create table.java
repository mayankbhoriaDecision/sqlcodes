CREATE TABLE building(
    id INT PRIMARY KEY,
    owner_name VARCHAR2 (100) NOT NULL,
  	address VARCHAR2 (100) NOT NULL,
  	building_type_id INT,
  	contact_number VARCHAR2 (100) NOT NULL,
  	email_address VARCHAR2 (100) NOT NULL
); 



ALTER TABLE building RENAME COLUMN email_address TO email;


 ALTER TABLE building ADD( description varchar(255) NOT NULL);
Alter TABLE building drop COLUMN address;

alter table building MODIFY owner_name varchar(500);

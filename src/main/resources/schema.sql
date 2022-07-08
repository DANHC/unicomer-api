DROP TABLE IF EXISTS CLIENT;  

CREATE TABLE CLIENT (  
	id 				INT AUTO_INCREMENT  PRIMARY KEY,  
	first_name 		VARCHAR(50) NOT NULL,  
	last_name 		VARCHAR(50) NOT NULL,  
	birthday 		DATE NOT NULL,  
	gender			VARCHAR(10) NOT NULL,
	cell_phone 		VARCHAR(25) NOT NULL,
	home_phone 		VARCHAR(25) NOT NULL,
	address_home 	VARCHAR(250) NOT NULL,
	profession 		VARCHAR(250) NOT NULL,
	incomes 		NUMERIC(10,2) NOT NULL
); 


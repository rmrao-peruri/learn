CREATE TABLE payment (
	payment_id   INT NOT NULL,
	ccy	         VARCHAR(3) NOT NULL,
	dbtr_name	 VARCHAR(35),
	dbtr_ac_id   VARCHAR(35),
	PRIMARY KEY (payment_id) );
	
CREATE TABLE payment_addl_dtl (
	payment_id   INT NOT NULL,
	vpa	         VARCHAR(35), 
	PRIMARY KEY (payment_id) );
USE vgb;

INSERT INTO customers 
	(id, password, name, gender, email, birthday)
    VALUES('A123456789', '123456','張三豐','M','test@uuu.com.tw', '2000-01-05');
    
/*
DELETE FROM `vgb`.`customers` WHERE id` = 'A123456798';
*/

INSERT INTO customers 
	(id, password, name, gender, email, birthday, phone, address, married)
    VALUES('A223456781', '123456', '林梅莉', 'F', 'test02@uuu.com.tw', '1979-05-23', '0987654321', '台北市復興北路99號14F', true);
    
INSERT INTO customers 
    (id, password, name, gender, email, birthday, phone, address, married)
    VALUES(?,?,?,?,?,?,?,?,?);
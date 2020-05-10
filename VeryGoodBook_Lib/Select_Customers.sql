USE vgb;
SELECT id, password, name, gender, email, birthday, phone, address, married FROM customers;

SELECT id, password, name, gender, email, birthday,
 phone, address, married FROM customers WHERE id='A123456789' AND password='123456';
 
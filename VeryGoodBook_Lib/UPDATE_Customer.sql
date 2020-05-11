UPDATE
	customers
SET
	password=?, name=?, gender=?, email=?, birthday=?, phone=?, address=?, married=?, discount=?, class_name=?
WHERE
	id = ?;
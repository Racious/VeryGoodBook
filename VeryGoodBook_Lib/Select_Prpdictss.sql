SELECT
	id, name, unit_price, stock, photo_url, discount, class_name, category
FROM
products
where unit_price>200;

SELECT
	id, name, unit_price, stock, photo_url, discount, class_name, category
FROM
products
where name like '%Java%';

SELECT
	id, name, unit_price, stock, photo_url, discount, class_name, category
FROM
products
where category='書籍';

/*DISTINCT 一樣的只顯示一筆*/
SELECT DISTINCT
	category
FROM
	products;
    
SELECT count(*)
	category
FROM
	products
where category="書籍";
    
SELECT DISTINCT
	id, name, unit_price, stock, photo_url, description, discount, class_name, category
FROM
	products
where 
	id=1;
    
SELECT count(*)
	category
FROM
	products
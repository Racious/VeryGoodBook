SELECT 
	*
FROM
	vgb.customers
where
	birthday between '1980-01-01' and date_add("2030-04-05",interval 1 Month);
    /*between 時間點 and date_add(時間點,interval +-? DAY/MONTH/YEAR) 之間
      between and 常用在查詢時間 EX:每個月最後一天=下個月第一天減一天
    */
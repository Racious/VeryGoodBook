SELECT 
		/*傳回欄位 會員名稱、產品名稱、產品價格、購買時間*/
		m.name,
        p.name,
        p.price,
        r.date
FROM 
		/*會員資料表、產品資料表、購買紀錄*/
		mydb.member m,
        mydb.pruduct p,
        mydb.record r
where 
	/*購買帳號與會員帳號相同、購買產品與產品編號相同，且會員帳號為"?"*/
	m.account=r.member_account 
    AND p.id=r.pruduct_id 
    AND r.member_account="test001"
    /*排序 新到舊*/
ORDER BY date DESC;
SELECT mydb.member.name, mydb.pruduct.name,mydb.pruduct.price,mydb.record.date
FROM mydb.record
INNER JOIN mydb.member ON mydb.record.member_account=mydb.member.account
INNER JOIN mydb.pruduct ON mydb.record.pruduct_id=mydb.pruduct.id
where mydb.member.account="test001"
ORDER BY date DESC;
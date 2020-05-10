- TINYINT 1byte
- SMALLINT 2byte
- MEDIUMINT 3byte
- INT 4byte
- BIGNET 8byte

byte  
short

int  
long  
|MySQL|BYTE|JAVA|BYTE|
|---|---|---|---|
|TINYINT|1byte|byte|1byte|
|SMALLINT|1byte|short|1byte|
|MEDIUMINT|3byte|||
|INT|4byte|int|4byte|
|BIGNET|8byte|long|8byte|

## 浮點數

近似值，不可用來精密計算

- FLOAT 4byte
- DOUBLE 8byte

* 可指定數字個數(Precision)及小數個數(Scale)
* FLOAT(P,S)

  123.45  
   FLOAT(5,2) 五位數 小數點兩位

## 定點數

- 精確數值
- 種類
  - DECIMAL
- 可指定數字個數(Precision)及小數個數(Scale)
- FLOAT(P,S)

JAVA BigDecimal

兩個情況不用寫 import

1. 要用的類別同一個不用寫 import
2. java.lang.不用寫

## 位元

- 以位元寬度來存放數值
  - 1 至 64bits  
    通常用在指定固定數值

## 字元資料

- 用於存放文字或二進位資料
- 使用上有許多的因素需要考量
- 支援字元集(character set)
- 比較方式
  - 文字:CHAR、VARCHAR、TEXT
  - 整數:ENUM、SET

public enum 列舉  
限定範圍適合用列舉  
ex:血型、性別...。

## 文字類型

- CHAR
  - 固定長度字串
- VARCHAR
  - 可變長度字串
- TEXT
  - 可變長度

CHAR:速度較快 較占空間
VARCHAR:速度較慢 可省空間

| Data Type             | Max bytes  |
| --------------------- | ---------- |
| CHAR(M)M<255          | 765        |
| VARCHAR(M) M<=65533\* | 65533      |
| TINYTEXT              | 255        |
| TEXT                  | 65535      |
| MEDIUMTEXT            | 16777215   |
| LONGTEXT              | 4294967295 |

| 編碼     | 大小  |
| -------- | ----- |
| LATIN1   | 1byte |
| big5     | 2byte |
| UTF-8    | 3byte |
| UTF-8mb4 | 4byte |

資料庫用 UTF-8mb4 編碼

VARCHAR 必要 2byte 去紀錄長度，可再選是否減去 1 個 byte 做 NULL (可設定要不要放 NULL)
EX:CHAR(255)乘上編碼大小
EX:VARCHAR(65535)除上編碼大小

## 二進化資料型態

- 不能指定編碼

## 日期時間

TIMESTAMP 4byte  
時間戳記 可自動填  
例如寫入資料時紀錄寫入時間

DATETIME 8byte  
1000-01-01  
9999-12-31

TIME 3byte

YEAR 1byte
最大值 2155 年

TIME 3byte
時:分:秒  
-838 小時 59:59~838 小時 59:59  
例如經過了 30 個小時(等同 1 天又 6 小時)
紀錄長度用

NULL 需用 is 去判斷  
[x]select _ from t1 where c2 = NULL;  
[o]select _ from t1 where c2 is NULL;

## 常數欄位屬性

- zerofill (配合寬度)會補滿 0
- unsigned 加上後只會有正的
- auto_increment 自動遞增
  - 只能放在整數

ex:unsigned 有無加上
沒有加:-2^31-1~2^31-1  
加上後:2^31-1

只會從最大值往後加，且也可直接指定數值

## 字元欄位

deprecated 過時的

## 通用屬性

- null、not null
- default 預設值  
  int default 12345 需要符合型態，避免放入 full

## 資料表正規化介紹

## 資料庫

遵循 ANSI 規範

- DCL
- DDL
  - CREATE
  - ALTER
- DML 程式設計師常用指令
  - SELECT
  - INSERT
  - UPDATE
  - DELETE

## 資料庫部分

- 建立資料庫
  - CREATE DATABASE db_name  
    關鍵字大寫，自己的識別值小寫
  - CHARACTER SET charset  
    建議資料表的預設編碼:LATIN1
    Server characterset:預設

status 顯示資料庫資訊
use db1 切換資料庫 db1

alter database db2 character set big5;
切換編碼，更改後原資料不影響，新寫入的才會變

create database db1 character set utf8
建議資料庫 編碼 uft8

drop database db1;
刪除資料庫 db1

create table db.name(
col.name TYPE(length) attr1 attr2...,(第一個欄位跟第二個欄位逗號隔開)
INT NOT NULL DEFAULT 3
不能 NULL 預設值 3
CHAR() CHARACTER SET chared 寫在前面

在此資料庫建立資料表，不同資料庫可取相同名稱資料表

所有欄位定位完後才能定 PRIMARY KEY
PRIMARY KEY (col.name,...逗號隔開)

)CHARACTER SET charset 編碼

顯示資料表資訊
show columns from t11(table 名稱)
desc t11(table 名稱)
describe t11(table 名稱)

alter table t11(table 名稱) and column c3 int;
多新增 c3 欄位

資料表注意事項
特別針對 MySQL
資料型態的選取
文字編碼
資料表引擎的選用

INSERT INTO tb_name(cd.name,...) (新增到什麼欄位)
VALUES(V1,....),(...),
(需跟上方的欄位數相同 新增欄位資料)
日期、時間、文字資料用'單引號'括起來

insert into t11 (c1,c3) values (3,4),(5,6)

select \* from t11

update t11 set c3 =20,c2='hello',where X=''

select \* from 表格名稱\G
直列出顯示

## 查詢資料

SELECT 後面不一定要接資料表
EX: SELECT now()、SELECT 5+8
SELECT now() as hello;取別名

SELECT columns
SELECT col.name, FROM tb.name(完整名稱寫法:db.name.tb.name)

SELECT c1, c2,FROM t21
資料庫名稱.資料表名稱.欄位名稱
需要什麼欄位就把他一個個列出來
這樣才會照自己想要的順序排列出來

create table t21(c1 int,c2 int)
insert into t21(1,2)

where id=5(< = >)
ex:id>5 and <20
id between 5 and 20
id in(1,3,5) 只要是 1 或 3 或 5
id is null
id <=> null 同等=但可用在 null 跟一般
id <=> 1
id like 'tai%' 'tai\_'
% 0~\* 0 到多個任意字元
\_ 一個字元
\_\_ 兩個字元
where 欄位=什麼 條件式尋找

countrycode 分組
SELECT countrycode,count(\*) from Country

SUM(col) 綜合
AVG(col) 平均
MAX(col) 最大
MIN(col) 最小
COUNT(col) 計算筆數

group by column 再過濾需用 having

having count(_) >30 order by count(_) desc
asc;升冪排序
desc;降冪排序

limit 0,10
limit 起始,幾筆

## 資料表 join

- 概念上透過 join 可以將兩個資料表內容依據需要結合起來
- MySQL join 類型
  - inner join 兩邊資料都要符合的
  - left join 兩邊相符的會出現，其他右邊會 null
  - right join
  - outer join 兩邊資料都不要符合的

create table t31(c1 int,c2 varchar(10),primary key(c1))

select \* from t31,t32 ;逗點 inner join
select \* from t31 left join t32

正規化目的

目的
刪除重複資料
保護資料
增加存取彈性

REFERENCES tb_name(key_part)

VIEW 就是 SELECT

CREATE VIEW 自訂名子 as select \* from t31
select \* from 自訂名子

建議虛擬的資料表 VIEW

show tables 顯示所有資料表
show full tables 顯示所有資料表 並顯示資料表類型
show create view hello\G 顯示 hello 的資料表的資訊

---

utf8mb4_0900_ai_ci
ForeignKeys
文字跟文字建立關聯，且編碼需要一致  
整數跟整數建立關聯，signed 與 unsigned 需一致  
浮點數跟浮點數建立關聯，但浮點數不適合當主鍵值  
因已有舊資料，需先給預設值跟類別名稱相同'Customer'  
若舊 Table 有資料，要加新表格且設定 not null，那需要給預設值否則會出錯。

workbench youtube 備份

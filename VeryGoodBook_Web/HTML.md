context root:網址名稱，可自訂
content directory:網路須放在的資料夾名稱

後端抓的到，前端抓不到，網頁不要放在這
/WEB-INF
/META-INF

Properties Resource UTF-8

```
root tag <html></html>
系統底層設定 瀏覽器設定<meta>，放在<head>內
```

有開始和結束的標籤:標準標籤 例:html  
只有開始沒有結束的標籤:空標籤 例:meta  
標籤裡面包著標籤:巢狀標籤

http 通訊協定  
html 交換的通訊協定  
http request  
https 加密後的通訊協定  
localhost(127.0.0.1) 可換成 hostname
(前提 web server 跟使用者電腦需同一台)  
若有不同作業系統僅能只用 ip address
localhost:8080/vgb
ip address:port/context root/
網路上的編碼跟作業系統編碼對應不起來 404 錯誤
port80 context root 空字串 則可省略

絕對路徑，從第一個斜線開始寫起

```
/vgb/index.html
```

可送出的表單，必須加上 name 屬性

```
<input><select><textarea>
```

from action='' 裡面放網址，資訊將會交給後端這個元件處理，空字串預設送給自己
from method='' 表單送資料出去 沒寫的話預設 GET 請求
GET:請求沒有第三段，會將資料塞到網址列後面傳送 xxx.html?name=value id="" 表單資料不要用
POST:表單用 POST 請求，不會將資訊顯示在網址列
HTML layout
CSS3 vh vw，百分比

```
web 專案右鍵 屬性
A.加入專案資料夾
Java Build Path > projects
B.部屬到伺服器
Deployment Assembly>ADD>project >專案名稱
C.將 MySQL 的外掛程式庫 jar 複製到 Web 專案
複製 lib 到 web 專案
D.安裝外掛程式庫 jar
右鍵 build path
E.部屬外掛程式庫
再到 Deployment Assembly>ADD>path >mysql
```

安裝 Tomcat 伺服器
window>preference>server
server.xml
port -1 改成 8005

專案右鍵 屬性
Project Facets
右邊 Runtimes 切換伺服器(家裡 or 教室)

package:因為是 controller 故取名資料夾
class name:習慣 功能名稱+Servlet
superclass:系統自帶，由廠商公司提供 父類別

(Servlet 伺服器建立 不用 new)
Servlet 類別需要設定假網址，左邊一定要加/(例如:/LoginServlet)
則網址為:http://localhost:port/context root/LoginServlet
習慣命名為功能.do [.衍生檔名 可自定義但不要重複](例如/login.html => /login.do)

冪等 若重複進行運算仍為本身的值

GET
查詢用的欄位
不是 sensitive data
資料在後端屬於 idempotent 運算

POST
新增/修改/刪除用的欄位
是 sensitive data
資料在後端屬於 non-idempotent 運算

HTTP 8 種請求

| HTTP   | DB     |
| ------ | ------ |
| PUT    | INSERT |
| POST   | UPDATE |
| DELETE | DELETE |
| GET    | SELECT |

POST 對應 INSERT、UPDATE、DELETE

非同步請求 img
ajax js 非同步請求

同步請求
(超連結、送出表單)
請求送出，回應回來前都不做事
回應回來後整個頁面同步更新，
前一個頁面將記錄在歷史區
單一執行序

非同步
部分更新
多執行序

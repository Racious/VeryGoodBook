<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>產品清單</title>
    <style>
      .liType {
        display: inline-table;
        /* display: flex; */
        width: 200px;
        /* border: 1px solid gray; */
        /*box-shadow: 1px 1px gray;*/
        padding: 20px;
        height: 250px;
        
      }
      .liType img {
		margin: auto;
        display:block;
        width: 150px;
        margin-bottom: 20px;

      }
      .space {
        line-height: 17px;
        overflow: hidden;
        width: 150px;
        height: 35px;
        margin: auto;
        margin-top: 10px;
        }
    </style>
  </head>
  <body>
    <header>
      <h1><a href="index.html">非常好書</a><sub>產品清單</sub></h1>
    </header>
    <nav>
      <a href="login.html">登入</a>
      <a href="register.html">註冊</a>
      <a href="search.html">查詢</a>
      <a href="product_list.html">產品清單</a>
      <a href="99table.jsp">99乘法表</a>
      <hr />
    </nav>
    <%
		ProductService ps=new ProductService();  
    	List<Product> list= ps.searchAllProducts();
    	//out.println(list);	
    %>
    <article style="min-height: 75vh; width: 70%; margin: auto;">
      <form action="#" method="GET">
        <label>搜尋：</label>
        <input
          type="search"
          name="search"
          id=""
          required
          placeholder="請輸入部分產品名稱..."
        />
        <input type="submit" value="搜尋" />
      </form>
      <ul>
      <% for(int i=0;i<list.size();i++){ 
      	Product p =list.get(i);
      %>
      
        <li class="liType">
          <img
            src="<%=p.getPhotoUrl()%>">
          <h4 class="space"><%=p.getName() %></h4>
          <div class="space">優惠價:<%=p instanceof Outlet ?100-((Outlet)p).getDiscount():"" %>折，<%=p.getUnitPrice() %>元</div>
        </li>
      <% }%>
      </ul>
    </article>

    <footer style="text-align: center;">
      <hr />
      非常好書&copy;版權所有 2020~
    </footer>
  </body>
</html>

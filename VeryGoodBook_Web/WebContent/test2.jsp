<%@page import="java.util.List"%>
<%@page import="uuu.vgb.entity.testproduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>

	<table border="1" align="center">
		<tr>
			<th>id</th>
			<th>名稱</th>
			<th>價格</th>
			<th>上架時間</th>
		</tr>
		<%
			//取得查詢的內容
			List<testproduct> tp = (List<testproduct>) request.getAttribute("testproduct");
		%>
		<%
			for (testproduct book : tp) {
		%>
		<tr>
			<%--顯示產品--%>
			<td><%=book.getId()%></td>
			<td><%=book.getName()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getReleasedate()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
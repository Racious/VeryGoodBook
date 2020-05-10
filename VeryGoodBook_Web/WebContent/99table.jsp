<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>99乘法表</title>
</head>
<body>
<div align="center">99乘法表</div><br> 
	<table border="1" align="center">

		<%
			for (int i = 1; i < 10; i++) {
				out.println("<tr>");
				for (int j = 1; j < 10; j++) {
					out.println("<td>");
					out.println(j + "×" + i + "=" + i * j);
					out.println("</td>");
				}
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page import="uuu.vgb.service.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		CustomerService service = new CustomerService();
		Customer c = service.login("A123456789", "123456");
		System.out.println(c);
		out.println(c);
		
	%>
</body>
</html>

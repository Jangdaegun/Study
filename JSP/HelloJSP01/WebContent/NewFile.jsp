<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�ȳ��ϼ���.</h1>
	<%
		System.out.println("hello");
	%>
	<%!int sum = 0;%>
	<%
		for (int i = 0; i < 10; i++)
		sum += i;
	%>
	<h1>
		<%=sum%></h1>
</body>
</html>
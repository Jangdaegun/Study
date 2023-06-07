<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration enumeration = session.getAttributeNames();

	while(enumeration.hasMoreElements()) {
		String sName = enumeration.nextElement().toString();
		String sValue = (String)session.getAttribute(sName);
		if(sValue.equals("admin")) {
			out.println("hi admin!!");
		}
	}
%>
<a href="logout_session.jsp">Logout</a>
<a href="session_test.jsp">Session Test Page</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
String name, pw, major, protocol;
String[] hobbys;
%>	
<%! public String korMajor(String major) {
	if(major.equals("eng"))
		return "영어";
	else if(major.equals("math"))
		return "수학";
	else if(major.equals("kor"))
		return "국어";
	else
		return major;
}
%>
<%! public String korHobby(String[] hobbys) {
	if(hobbys ==null)
		return "취미없음";
	String hobby = "";
	for(int i = 0; i<hobbys.length; i++) {
		switch(hobbys[i]) {
		case "cook":
			hobby+="요리";
			break;
		case "run":
			hobby+="달리기";
			break;
		case "swim":
			hobby+="수영";
			break;
		case "sleep":
			hobby+="잠자기";
			break;
		}
		if(i != hobbys.length-1)
			hobby+=",";
	}
	return hobby;
}

%>

<%
	request.setCharacterEncoding("UTF-8");
	name = request.getParameter("name");
	pw = request.getParameter("pw");
	major = request.getParameter("major");
	protocol = request.getParameter("protocol");
	hobbys = request.getParameterValues("hobby");
%>

이름 : <%= name %><br>
비밀번호 : <%= pw %><br>
전공 : <%= korMajor(major) %><br>
프로토콜 : <%= protocol %><br>
취미 : <%= korHobby(hobbys) %><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Student</h1>
	<form action="practice" method="get">
		이름 : <input type="text" name="name"><br> 
		나이 : <input type="text" name="age"> <br>
		번호 : <input type="text" name="number"><br>
		<input type="submit" value="이동">
	</form>
	<h1>Animal</h1>
	<form action="practice" method="post">
		종류 : <input type="text" name="kinds"><br> 
		이름 : <input type="text" name="name"><br> 
		나이 : <input type="text" name="age"> <br> 
		번호 : <input type="text" name="number"><br>
		<input type="submit" value="이동">
	</form>
</body>
</html>
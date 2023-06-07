<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=2>
		<thead>

			<%String[] arrs = {"X","2","3","4","5","6","7","8","9"}; 
			
			for(String item : arrs) {
				%>
			<th><%out.println(item);%>
			</th>
			<%} %>
		</thead>
		<tbody>
			<%for(int i = 1; i<=9; i++) {%>
			<tr> <%for(int j = 1; j<=9; j++) { %>
					<td><% out.println(i*j);%></td>
				<%} %>
			<%} %>
		</tbody>
	</table>
</body>
</html>







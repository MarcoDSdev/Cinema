<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/AggiungiGenereServlet" method="POST" >
       <div>
        <input type="text" name="NomeGenere">
       </div>
       <div>
       <button type="submit">Invia</button>
       </div>
</body>
</html>
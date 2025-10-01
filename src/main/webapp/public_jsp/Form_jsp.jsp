<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/AggiungiSalaServlet" method="POST" >
       <div>
        <input type="number" name="numeroPosti">
       </div>
       <div>
        <input type="text" name="nomeSala">
       </div>
        <button type="submit">Invia</button>
    </form>
</body>
</html>
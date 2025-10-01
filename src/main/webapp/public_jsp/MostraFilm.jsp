<%@page import="org.elis.model.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Film</title>
</head>
<body>
	<% List <Film> filmList = (List<Film>)request.getAttribute("ListaFilm");
	
		if(filmList!=null)for (int i = 0; i < filmList.size(); i++) {%>
			
			
			<h1><%= filmList.get(i).getTitolo() %></h1>
			<p><%= filmList.get(i).getDurata() %> </p>
			<p> <%= filmList.get(i).getGenere().getNome() %> </p> 
		<%}
	%>
</body>
</html>
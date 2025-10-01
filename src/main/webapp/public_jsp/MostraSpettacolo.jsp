<%@page import="org.elis.model.Film"%>
<%@page import="java.util.List"%>
<%@page import="org.elis.model.Sala"%>
<%@page import="org.elis.model.Spettacolo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostra spettacolo</title>
</head>
<body>
<% List <Spettacolo> spettacoloList = (List<Spettacolo>)request.getAttribute("ListaSpettacolo");

if(spettacoloList!=null)for (int i = 0; i < spettacoloList.size(); i++) {%>


<h1><%= spettacoloList.get(i).getFilm().getTitolo() %></h1>
<p><%= spettacoloList.get(i).getData() %> </p>
<p> <%= spettacoloList.get(i).getSala().getNome() %> </p>

<%}
	%>
</body>
</html>
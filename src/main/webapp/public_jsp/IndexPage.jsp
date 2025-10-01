<%@page import="java.util.List"%>
<%@page import="org.elis.model.Ruolo"%>
<%@page import="org.elis.model.Utente"%>
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
Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");
if (utenteLoggato != null && utenteLoggato.getRuolo() == Ruolo.ADMIN) { 
%>
<a href="<%= request.getContextPath() %>/public_jsp/Form_jsp.jsp">Aggiungi sala</a>
<a href ="<%= request.getContextPath() %>/public_jsp/AggiungiGenereForm.jsp" > Aggiungi Genere</a>
<a href = "<%=request.getContextPath() %>/MostraGenereFilmServlet" > Aggiungi Film</a>
<a href = "<%=request.getContextPath() %>/AggiungiSpettacoloServlet" > Aggiungi Spettacolo</a>
<a href ="<%= request.getContextPath() %>/MostraSale" > Mostra Sale</a>
<a href = "<%=request.getContextPath() %>/MostraFilmServlet" > Mostra Film</a>
<a href = "<%=request.getContextPath() %>/MostraSpettacoloServlet" > Mostra Spettacolo</a>
<% } %>
<%if (utenteLoggato != null && utenteLoggato.getRuolo() == Ruolo.BASE) { 
%>
<a href ="<%= request.getContextPath() %>/MostraSale" > Mostra Sale</a>
<a href = "<%=request.getContextPath() %>/MostraFilmServlet" > Mostra Film</a>
<a href = "<%=request.getContextPath() %>/MostraSpettacoloServlet" > Mostra Spettacolo</a>
<% } %>

<% if (utenteLoggato == null) {%>
	
<a href="LoginUtente.jsp">Login</a> 
<a href="RegistrazioneUtente.jsp">Registrazione</a>

<% } %>


</body>
</html>



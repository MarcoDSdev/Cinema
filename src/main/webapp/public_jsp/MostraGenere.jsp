<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    <%@page import="org.elis.model.Genere"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genere</title>
</head>
<body>
<% List <Genere> genereList = (List<Genere>)request.getAttribute("ListaGenere");
if(genereList!=null) for (int i = 0; i < genereList.size(); i++ ) {%>
<h1><%=genereList.get(i).getNome() %></h1>

<%}
 %>
</body>
</html>
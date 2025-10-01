<%@page import="org.elis.model.Sala"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista sale</title>
</head>
<body>
	<% List <Sala> saleList = (List<Sala>)request.getAttribute("ListaSale");
	
		if(saleList!=null)for (int i = 0; i < saleList.size(); i++) {%>
			
			
			<h1><%= saleList.get(i).getNome() %></h1>
			<p><%= saleList.get(i).getNumeroPosti() %> </p> 
		<%}
	%>
</body>
</html>
	
	
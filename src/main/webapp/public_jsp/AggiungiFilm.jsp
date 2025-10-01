<%@page import="org.elis.model.Genere"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/AggiungiFilm" method="POST" >
       <div>
        <input type="text" name="titoloFilm">
       </div>
       <div>
        <input type="number" name="durata">
       </div>
       <select name = "genere">
      
       <%List<Genere> genereList = (List<Genere>)request.getAttribute("ListaGenere");
       if(genereList!=null) for (int i = 0; i < genereList.size(); i++ ) {%>
       
       
       	<option value = "<%=  genereList.get(i).getNome() %>" > <%=genereList.get(i).getNome()%></option>
       	
       	<%}
       	
       	%>
       
       
       </select>
        <button type="submit">Invia</button>
    </form>
</body>
</body>
</html>
<%@page import="org.elis.model.Sala"%>
<%@page import="org.elis.model.Film"%>
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
	<form action="<%= request.getContextPath()%>/AggiungiSpettacoloServlet" method="POST" >
       
       <div>
        <select name = "Sala">
      
       <%List<Sala> salaList = (List<Sala>)request.getAttribute("ListaSala");
       if(salaList!=null) for (int i = 0; i < salaList.size(); i++ ) {%>
       
       
       	<option value = "<%=  salaList.get(i).getNome() %>" ><%=  salaList.get(i).getNome() %></option>
       	
       	<%}
       	
       	%>
       
       
       </select>
       </div>
       <input type = "dateTime-local" name="dataOra"> 
        
        <select name = "Film">
      
       <%List<Film> filmList = (List<Film>)request.getAttribute("ListaFilm");
       if(filmList!=null) for (int i = 0; i < filmList.size(); i++ ) {%>
       
       
       	<option value = "<%=  filmList.get(i).getTitolo() %>" ><%=  filmList.get(i).getTitolo() %></option>
       	
       	<%}
       	
       	%>
       </select>
       
       <button type="submit">Invia</button>
    </form>

</body>
</body>
</html>
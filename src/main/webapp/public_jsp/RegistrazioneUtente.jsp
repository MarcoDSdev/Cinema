<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrati</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/AggiungiUtenteServlet" method="POST">
          <input type="text" name="username" placeholder="Username" required>
          <input type="email" name="email" placeholder="Email" required>
          <input type="password" name="password" placeholder="Password" required>
          <input type="password" name="confirm_password" placeholder="Conferma Password" required>
          <input type="date" name="dataNascita" required>
          <button type="submit">Registrati</button>
        </form>
</body>
</html>
package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import org.elis.utility.BusinessLogic;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

/**
 * Servlet implementation class AggiungiUtenteServlet
 */
@WebServlet("/AggiungiUtenteServlet")
public class AggiungiUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AggiungiUtenteServlet() {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String dataNascita = request.getParameter("dataNascita");
		LocalDate data = LocalDate.parse(dataNascita);
		Utente nuovoUtente = new Utente(username,email, password,  Ruolo.BASE, data);
		BusinessLogic.creaUtente(nuovoUtente);
		
		response.sendRedirect("public_jsp/LoginUtente.jsp");
		
		
		
		
            	
     	
	}

}

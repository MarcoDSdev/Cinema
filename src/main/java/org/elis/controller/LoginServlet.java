package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.elis.model.Utente;
import org.elis.utility.BusinessLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = BusinessLogic.loginUtente(email, password);
		if (utente !=null ) {
			
			HttpSession session = request.getSession();
			session.setAttribute("utenteLoggato", utente);
			
			request	
			
			.getRequestDispatcher("public_jsp/IndexPage.jsp")
			.forward(request,response);
		}
		
	}
	}



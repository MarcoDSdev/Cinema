package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.model.Sala;
import org.elis.utility.BusinessLogic;


@WebServlet("/AggiungiSalaServlet")
public class AggiungiSalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AggiungiSalaServlet() {
        super();
       
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/public_jsp/Form_jsp.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroPostiString;
		String nomeSala;
		
			numeroPostiString = request.getParameter("numeroPosti");
			nomeSala = request.getParameter("nomeSala");
			Integer numeroPosti = Integer.parseInt(numeroPostiString);
			
		Sala s1 = new Sala(null, nomeSala, numeroPosti);
		BusinessLogic.creaSala(s1);
		
		response.sendRedirect("public_jsp/Form_jsp.jsp");
			
			
		
		
		
		
	}
	 
	
}

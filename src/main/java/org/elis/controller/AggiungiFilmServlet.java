package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.model.Film;
import org.elis.utility.BusinessLogic;

/**
 * Servlet implementation class AggiungiFilm
 */
@WebServlet("/AggiungiFilm")
public class AggiungiFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiFilmServlet() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String titolo = request.getParameter("titoloFilm");
			String durataString = request.getParameter("durata"); 
			int durata = Integer.parseInt(durataString); 
			String genere = request.getParameter("genere");
			Film s1 = new Film (titolo, durata, BusinessLogic.selectByNome(genere));
			BusinessLogic.creaFilm(s1);
			response.sendRedirect("public_jsp/AggiungiFilm.jsp");
			
			
			
	}

}

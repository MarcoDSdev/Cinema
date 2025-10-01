package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import org.elis.model.Film;
import org.elis.model.Sala;
import org.elis.model.Spettacolo;
import org.elis.utility.BusinessLogic;

/**
 * Servlet implementation class AggiugiSpettacoloServlet
 */
@WebServlet("/AggiungiSpettacoloServlet")
public class AggiungiSpettacoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AggiungiSpettacoloServlet() {
        super();
      
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.setAttribute("ListaFilm", BusinessLogic.selectAllFilm());
		request.setAttribute("ListaSala", BusinessLogic.selectAllSale());
		
		
		request.getRequestDispatcher("/public_jsp/AggiungiSpettacolo.jsp").forward(request, response);
		
		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String titoloFilm = request.getParameter("Film");
			String salaNome = request.getParameter("Sala");
			String dataOra =request.getParameter("dataOra");
			LocalDateTime dataOraConvertita = LocalDateTime.parse(dataOra);
			Sala sala = BusinessLogic.selectSalaByNome(salaNome);
			Film film = BusinessLogic.selectFilmByTitolo(titoloFilm);
			Spettacolo s1 = new Spettacolo (null, film,sala,dataOraConvertita);
			BusinessLogic.creaSpettacolo(s1);
			doGet(request, response);
			
			
			
	}

}

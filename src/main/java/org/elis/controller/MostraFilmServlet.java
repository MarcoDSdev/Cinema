package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.utility.BusinessLogic;

/**
 * Servlet implementation class MostraFilmServlet
 */
@WebServlet("/MostraFilmServlet")
public class MostraFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MostraFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("ListaFilm", BusinessLogic.selectAllFilm());
	
		request.getRequestDispatcher("public_jsp/MostraFilm.jsp").forward(request, response);
	}

	

}

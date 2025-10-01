package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.utility.BusinessLogic;


@WebServlet("/MostraGenereFilmServlet")
public class MostraGenereFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MostraGenereFilmServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("ListaGenere", BusinessLogic.selectAllGenere());
		
		request.getRequestDispatcher("/public_jsp/AggiungiFilm.jsp").forward(request, response);
		
	}

	
	

}

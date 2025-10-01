package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.model.Genere;
import org.elis.utility.BusinessLogic;

/**
 * Servlet implementation class AggiungiGenereServlet
 */
@WebServlet("/AggiungiGenereServlet")
public class AggiungiGenereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiGenereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeGenere = request.getParameter("NomeGenere");
		Genere s1 = new Genere(nomeGenere);
		BusinessLogic.creaGenere(s1);
		System.out.println(s1);
		response.sendRedirect("public_jsp/AggiungiGenereForm.jsp");
	}

}

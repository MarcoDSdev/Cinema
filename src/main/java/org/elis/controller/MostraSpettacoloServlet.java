package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.model.Spettacolo;
import org.elis.utility.BusinessLogic;

/**
 * Servlet implementation class MostraSpettacoloServlet
 */
@WebServlet("/MostraSpettacoloServlet")
public class MostraSpettacoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Spettacolo> s = BusinessLogic.selectAllSpettacolo();
		request.setAttribute("ListaSpettacolo", s);
		request.getRequestDispatcher("/public_jsp/MostraSpettacolo.jsp").forward(request, response);
	}

	

}

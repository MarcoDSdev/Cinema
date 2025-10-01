package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.utility.BusinessLogic;


@WebServlet("/MostraSale")
public class MostraSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MostraSale() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("ListaSale", BusinessLogic.selectAllSale());
	
		request.getRequestDispatcher("public_jsp/Index_jsp.jsp").forward(request, response);
		
	}

		


}

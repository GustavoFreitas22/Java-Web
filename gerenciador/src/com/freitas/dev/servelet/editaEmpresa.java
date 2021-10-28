package com.freitas.dev.servelet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editaEmpresa
 */
@WebServlet("/editaEmpresa")
public class editaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Editando...");
		
		Empresa empresa = new Empresa();
		Banco banco = new Banco();
		
		String paramId = request.getParameter("id");
		
		int id =	Integer.valueOf(paramId);
		System.out.println(id);
		
		empresa = banco.buscaId(id);
		
		if(empresa != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/formEditaEmpresa.jsp");
			request.setAttribute("empresa", empresa);
			rd.forward(request, response);
			
		}
		
		
	}

}

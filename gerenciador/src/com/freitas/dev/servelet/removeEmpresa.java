package com.freitas.dev.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class removeEmpresa
 */
@WebServlet("/removeEmpresa")
public class removeEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Empresa empresa = new Empresa();
		
		String paramId = request.getParameter("id");
		
		int id =	Integer.valueOf(paramId);
		System.out.println(id);
		
		banco.remove(id);
		
		response.sendRedirect("ListaEmpresas");
	}

}

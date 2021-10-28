package com.freitas.dev.servelet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newName = request.getParameter("nome");
		String newDataAbertura = request.getParameter("dataAbertura");
		Date paramAbertura = null;
		Empresa empresa = new Empresa();
		Banco banco = new Banco();
		
		String paramId = request.getParameter("id");
		
		int id =	Integer.valueOf(paramId);
		System.out.println(id);
		
		empresa = banco.buscaId(id);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formatador de Date
		    paramAbertura = sdf.parse(newDataAbertura); // Formatando de String para a Date pattern
		} catch (ParseException e) {
			
			throw new ServletException(e);
		}
		
		empresa.setDataAbertura(paramAbertura);
		empresa.setNome(newName);
		response.sendRedirect("ListaEmpresas");
	}


}

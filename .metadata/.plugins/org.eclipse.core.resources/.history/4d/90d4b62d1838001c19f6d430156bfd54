package com.freitas.dev.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		/* Regra de negocio do servlet */
		
		Empresa empresa = new Empresa();
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura"); // pega o paramentro do JSP
		Banco banco = new Banco();
		Date paramAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formatador de Date
		    paramAbertura = sdf.parse(dataAbertura); // Formatando de String para a Date pattern
		} catch (ParseException e) {
			
			throw new ServletException(e);
		}
		

		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(paramAbertura);
		banco.add(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("ListaEmpresas"); // Faz um retorno para o browser, dizendo "Meu rei, faz o seguinte, manda uma request para esse lugar aqui: ... "
		
//		// Chamando JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/ListaEmpresas"); // É a forma de dispachar o objeto para o JSP
//		request.setAttribute("empresa", empresa.getNome()); // Define o objeto a ser passado pelo request
//		rd.forward(request, response); // envia para o JSP
		
	}

}

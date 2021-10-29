package com.freitas.dev.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freitas.dev.model.Banco;
import com.freitas.dev.model.Empresa;

public class NovaEmpresa implements Acao{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		Empresa empresa = new Empresa();
		
		String nomeEmpresa = request.getParameter("nome");
		String paramData = request.getParameter("data"); // pega o paramentro do JSP
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formatador de Date
		    dataAbertura = sdf.parse(paramData); // Formatando de String para a Date pattern
		} catch (ParseException e) {	
			throw new ServletException(e);
		}
		

		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		banco.add(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		 return "redirect: entrada?acao=ListaEmpresas";
	}
}

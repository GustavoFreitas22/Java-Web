package com.freitas.dev.servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freitas.dev.model.Banco;
import com.freitas.dev.model.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class EmpresasServices
 */
@WebServlet("/empresas")
public class EmpresasServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco(); 
		String valor = request.getHeader("Accept");
		
		if(valor.endsWith("xml")) {
			XStream xStream = new XStream(); // Objto que converte em XML
			List<Empresa> list = banco.getEmpresa();
			
			String xml = xStream.toXML(list); // Convertendo
			
			response.setContentType("application/xml"); // Passando para o Headers o tipo de dado trabalhado
			response.getWriter().print(xml); // escrevendo na tela
			
		}else if(valor.endsWith("json")) {
			Gson gson = new Gson(); // Objto que converte em JSON
			List<Empresa> list = banco.getEmpresa();
			
			String json = gson.toJson(list); // Convertendo
			
			response.setContentType("application/json"); // Passando para o Headers o tipo de dado trabalhado
			response.getWriter().print(json); // escrevendo na tela
		} else {
			response.setContentType("application/json");
			response.getWriter().print("no content");
		}
		
		
		
		
		
		
		
	}

}

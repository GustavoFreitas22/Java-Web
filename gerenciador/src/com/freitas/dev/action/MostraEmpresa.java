package com.freitas.dev.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freitas.dev.model.Banco;
import com.freitas.dev.model.Empresa;

public class MostraEmpresa implements Acao {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("Editando...");
		
		Empresa empresa = new Empresa();
		Banco banco = new Banco();
		
		String paramId = request.getParameter("id");
		
		int id =	Integer.valueOf(paramId);
		System.out.println(id);
		
		empresa = banco.buscaId(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formEditaEmpresa.jsp";
	}
}

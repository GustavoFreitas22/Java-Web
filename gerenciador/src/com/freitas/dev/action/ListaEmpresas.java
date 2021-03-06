package com.freitas.dev.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.freitas.dev.model.Banco;
import com.freitas.dev.model.Empresa;

public class ListaEmpresas implements Acao {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Banco banco = new Banco();
		List<Empresa> list = banco.getEmpresa();
		
		
		request.setAttribute("empresas", list); 
		
		
		
		return "forward:ListEmpresas.jsp";
	}
}

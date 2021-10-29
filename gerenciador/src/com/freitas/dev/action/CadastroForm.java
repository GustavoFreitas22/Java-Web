package com.freitas.dev.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freitas.dev.model.Banco;
import com.freitas.dev.model.Empresa;

public class CadastroForm implements Acao{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "forward:formNovaEmpresa.jsp";
			
		}
}

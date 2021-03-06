package com.freitas.dev.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freitas.dev.model.Banco;
import com.freitas.dev.model.Empresa;

public class RemoveEmpresa implements Acao{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("removendo empresa");

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        Banco banco = new Banco();
        banco.remove(id);

        return "redirect: entrada?acao=ListaEmpresas";
			
		}
}

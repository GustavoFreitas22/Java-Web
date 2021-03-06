package com.freitas.dev.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.freitas.dev.model.Banco;
import com.freitas.dev.model.Usuario;

public class Login implements Acao {

	// Class que faz a regra de negecio do Login
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		
		Usuario user = banco.buscaUser(login, senha);
		
		if(user != null) {
			System.out.println("Ta certin meu rei");
			HttpSession sessao = request.getSession(); // Objeto que guarda as informa??es dos usuarios
			sessao.setAttribute("userLogado", user);
			return "redirect: entrada?acao=ListaEmpresas";
		}else {
			System.out.println("Ai ? moios");
			return "redirect:entrada?acao=LoginForm";
		}
		
		
	}

}

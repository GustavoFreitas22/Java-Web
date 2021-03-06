package com.freitas.dev.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.freitas.dev.action.Acao;
import com.freitas.dev.action.AlteraEmpresa;
import com.freitas.dev.action.CadastroForm;
import com.freitas.dev.action.ListaEmpresas;
import com.freitas.dev.action.MostraEmpresa;
import com.freitas.dev.action.NovaEmpresa;
import com.freitas.dev.action.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntrada
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Verifica??o de Login*/
		
		String paramAcao = request.getParameter("acao");
//		HttpSession sessao = request.getSession();
//		boolean userNaoLogado = (sessao.getAttribute("userLogado")==null); // Capturando o Obejto do HttpSession
//		boolean actionProtected = !(paramAcao.equals("Login")||paramAcao.equals("LoginForm")); // l?gica inversa para liberar as p?ginas
//		
//		if(userNaoLogado && actionProtected ) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
//		
		
		/*Isso daqui ? basicamente o controlador generico que consegue criar uma action apartir de uma classe no packge Action*/
		// Claro sempre usando um pattern!!!
		
		
		
		
		String nomeClass =  "com.freitas.dev.action."+paramAcao;
		
		
		String nomeAction;
		try {
			Class classe = Class.forName(nomeClass); //carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nomeAction = acao.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			
			throw new ServletException(e);
		}
		
		String[] tipo = nomeAction.split(":");

		if(tipo[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipo[1]); 
			rd.forward(request,response);
		}else {
			response.sendRedirect(tipo[1]);
		}
		
		
		/* Antigo controlador: baseado em elseIf */
		
		
//		if(paramAcao.equals("ListaEmpresas")) {
//			
//			ListaEmpresas action = new ListaEmpresas();
//			
//			nome = action.execute(request, response);
//			
//		}else if(paramAcao.equals("RemoveEmpresa")) {
//			
//			RemoveEmpresa action = new RemoveEmpresa();
//			
//			nome = action.execute(request, response);
//			
//			
//		}else if(paramAcao.equals("MostraEmpresa")) {
//			
//			MostraEmpresa action = new MostraEmpresa();
//			
//			nome = action.execute(request, response);
//			
//		}else if(paramAcao.equals("AlteraEmpresa")) {
//			
//			AlteraEmpresa action = new AlteraEmpresa();
//			
//			nome = action.execute(request, response);
//			
//		}else if(paramAcao.equals("NovaEmpresa")) {
//			
//			NovaEmpresa action = new NovaEmpresa();
//			
//			nome = action.execute(request, response);	
//		}else if(paramAcao.equals("CadastroForm")) {
//			
//			CadastroForm action = new CadastroForm();
//			
//			nome = action.execute(request, response);
//		}
		
		
		
	}

}

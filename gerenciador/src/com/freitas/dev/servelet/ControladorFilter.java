package com.freitas.dev.servelet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freitas.dev.action.Acao;


@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest filterRequest, ServletResponse filterResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) filterRequest;
		HttpServletResponse response = (HttpServletResponse) filterResponse;

		String paramAcao = request.getParameter("acao");

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
		
		
		chain.doFilter(request, response);
	}


}

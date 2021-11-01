package com.freitas.dev.servelet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest filterRequest, ServletResponse filterResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) filterRequest;
		HttpServletResponse response = (HttpServletResponse) filterResponse;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean userNaoLogado = (sessao.getAttribute("userLogado")==null); // Capturando o Obejto do HttpSession
		boolean actionProtected = !(paramAcao.equals("Login")||paramAcao.equals("LoginForm")); // lógica inversa para liberar as páginas
		
		if(userNaoLogado && actionProtected ) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		
		chain.doFilter(request, response);
	}

	

}

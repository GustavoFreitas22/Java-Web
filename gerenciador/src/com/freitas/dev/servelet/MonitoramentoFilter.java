package com.freitas.dev.servelet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter{

	/*Um filter e um servlet sa? quase a mesma coisa "Objetos que s?o chamados atravas de um HTTP"*/
	// No filter tu pode travar uma request
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		//Execucao da requi??o
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		
		System.out.println("Tempo exec da " +acao+": " +(depois-antes));
		
	}

}

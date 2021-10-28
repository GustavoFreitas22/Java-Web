package com.freitas.dev.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello") // é o mapping do Spring
public class HelloWord extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		PrintWriter out = resp.getWriter(); // imprime no fluxo do processo
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Hello word!");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Sera se?");
	} // basicamente essa classe faz o outPut do tela

}

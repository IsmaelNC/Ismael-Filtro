package br.com.Filtro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Filtro1
 */
@WebFilter("/Filtro1")
public class Filtro1 implements Filter {

    /**
     * Default constructor. 
     */
	
//	int contadorFiltro;
	
    public Filtro1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		PrintWriter out = response.getWriter();
		out.write("<html><body><div id='servletResponse' style='text-align: center;'>");
		
		request.setAttribute("variavelRequestMsgErro", "Usuário e Senha Inválido");
		
		if(userName.equals("Ismael") && (password.equals("12345"))) {
			RequestDispatcher rd = request.getRequestDispatcher("Accept.jsp");
			rd.forward(request, response);
		//	this.contadorFiltro = 0;
		}else {
		//	this.contadorFiltro = contadorFiltro + 1;
			out.print("<p id='errMsg' style='color: red; font-size: larger;'>Username Or Password Is Invalid. Please Try Again ....!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}
		out.write("</div></body></html>");
		out.close();
	//	chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

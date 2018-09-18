package br.com.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Usuario: <input type='text' name='Usuario'><br>");
		out.println("Senha: <input type='text' name='Senha' ><br>");
		out.println("<input type='submit' value='Enviar'>");
		out.println("<input type='submit' value='SignUp' onclick='form.action='SignUp';>");

		out.println("</form>");
		out.println("</body></html>");
	}
	
	protected void SignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("SignUp.java");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		PrintWriter out = response.getWriter();
		Users novo = new Users();
		boolean flag = dao.checkLogin(request.getParameter("Usuario"),request.getParameter("Senha"));
		if (flag) {
			response.sendRedirect("teste.jsp");
		}
		
		else {
			out.println("Usuario e/ou senha incorreto");
		}
		dao.close();
	}
	}


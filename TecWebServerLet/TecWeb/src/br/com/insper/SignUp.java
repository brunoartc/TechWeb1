package br.com.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		out.println("<input type='submit' value='Submit'>");	
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		PrintWriter out = response.getWriter();
		Users novo = new Users();
		boolean flag = dao.checkSignup(request.getParameter("Usuario"));
		if (flag) {
		novo.setUsername(request.getParameter("Usuario"));
		novo.setPassword(request.getParameter("Senha"));
		novo.setLastAccess(new Date(System.currentTimeMillis()));
		dao.adicionaUsuario(novo);
		}
		
		else {
			out.println("Usuario ja existente");
			response.sendRedirect("/SignUp.java");
		}
		dao.close();
		
		response.sendRedirect("/SignIn.java");

	}
	
	

}

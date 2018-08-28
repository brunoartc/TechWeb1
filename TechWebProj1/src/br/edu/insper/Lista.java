package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/Lista")
public class Lista extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		DAO dao = new DAO();
		
		List<Pessoas> pessoas = dao.getLista();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><ts>ID</td><td>Nome</td></tr>"+
		"<td>Nascimento</td><td>Altura</td></tr>");
		
		for (Pessoas pessoa : pessoas) {
			out.println("<tr><td>"+pessoa.getID()+"</td>");
			out.println("<td>" + pessoa.getNome() + "</td>");
			out.println("<td>" + pessoa.getNascimento().getTime()+"</td>");
			out.println("<td>" + pessoa.getAltura()+"</td>");
		}
		out.println("</table></body></html>");
		dao.close();
		
		
	}
}

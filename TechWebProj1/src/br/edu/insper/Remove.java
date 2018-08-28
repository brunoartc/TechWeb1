package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/remove")
public class Remove extends HttpServlet {
@Override
 protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	 PrintWriter out = response.getWriter();
	 out.println("<html><body>");
	 out.println("<form method='post'>");
	 out.println("Remover ID: <input type='number' name='id'><br>");
	 out.println("<input type='submit' value='Submit'>");
	 out.println("</form>");
	 out.println("<body><html>");
}
@Override
 protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	 DAO dao = new DAO();
	 try {
		dao.remove(Integer.valueOf(request.getParameter("id")));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 PrintWriter out = response.getWriter();
	 out.println("<html><body>");
	 out.println("removido");
	 out.println("</body></html>");
	 dao.close();
 }
}



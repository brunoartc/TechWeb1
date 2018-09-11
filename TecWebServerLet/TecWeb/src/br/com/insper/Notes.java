package br.com.insper;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Notes
 */
@WebServlet("/Notes/add")
public class Notes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served with <3 at: ").append(request.getContextPath())
				.append(" (required parameters: bg | title | content) ").append(request.getParameter("teste"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("content").replace("\t", "").replace("\n", ""));
		DAO dao = new DAO();
		System.out.println(request.getParameter("title").replace("\t", "").replace("\n", " ").length());
		if (request.getParameter("id") != null) {

			if (dao.getListaWhere(Integer.parseInt(request.getParameter("id"))).size() > 0)
				dao.atualiza(
						new Note(request.getParameter("bg"),
								request.getParameter("title").replace("\t", "").replace("\n", " "),
								request.getParameter("content").replace("\t", "").replace("\n", " "),
								new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())),
						Integer.parseInt(request.getParameter("id")));

		} else {
			dao.adiciona(new Note(request.getParameter("bg"),
					request.getParameter("title").replace("\t", "").replace("\n", " "),
					request.getParameter("content").replace("\t", "").replace("\n", " "),
					new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
		}
		dao.close();
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		System.out.println(request.getParameter("id"));
		if (request.getParameter("id") != null) {
			dao.delete(Integer.parseInt(request.getParameter("id")));
		}
		dao.close();
		doGet(request, response);
	}
	
	

}

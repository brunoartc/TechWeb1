package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cria
 */
@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
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
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("Nascimento: <input type='date' name='nascimento'><br>");
		out.println("Altura: <input type='number' name='altura'><br>");
		out.println("<input type='submit' name='Submit'><br>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		
		Pessoas pessoa = new Pessoas();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setAltura(Double.valueOf(request.getParameter("altura")));
		
		String nascimento = request.getParameter("nascimento");
		Date data = null;
		try {
			data = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		pessoa.setNascimento(dataNascimento);
		
		try {
			dao.adiciona(pessoa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("adicionadoa" + pessoa.getNome());
		out.println("</body></hmtl>");
		
		dao.close();
	}
	
	

}

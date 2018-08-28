package br.edu.insper;

import java.sql.*;
import java.sql.Date;
import java.util.*;


public class DAO {
	private	Connection connection = null;

	public	DAO (){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/meus_dados","Vinicius","123321");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
	public List<Pessoas> getLista() {
		
		List<Pessoas> pessoas = new ArrayList<Pessoas>();
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Pessoas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				Pessoas pessoa = new Pessoas();
				pessoa.setId(rs.getInt("Id"));
				pessoa.setNome(rs.getString("nome"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("nascimento"));
				pessoa.setNascimento(data);
				pessoa.setAltura(rs.getDouble("altura"));
				pessoa.add(pessoa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return pessoas;
	}
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adiciona(Pessoas pessoa) throws SQLException {
		String sql = "INSERT INTO Pessoas" + "(nome,nascimento,altura) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, pessoa.getNome());
		stmt.setDate(2, new Date(pessoa.getNascimento().getTimeInMillis()));
		stmt.setDouble(3,pessoa.getAltura());
		stmt.execute();
		stmt.close();
		
	}
	
	public void altera(Pessoas pessoa) throws SQLException {
		String sql = "UPDATE Pessoas SET " +
		 "nome=?, nascimento=?, altura=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, pessoa.getNome());
		stmt.setDate(2, new Date(pessoa.getNascimento()
		.getTimeInMillis()));
		stmt.setDouble(3, pessoa.getAltura());
		stmt.setInt(4, pessoa.getID());
		stmt.execute();
		stmt.close();
		}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Pessoas WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		}
	
	}
		


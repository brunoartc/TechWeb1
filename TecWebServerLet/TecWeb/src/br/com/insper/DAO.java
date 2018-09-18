package br.com.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private int loggedUser;

	private Connection connection = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tecweb", "root", "root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	private void getLoggedUser() {
		this.loggedUser = 0;
		
	}
	
	public List<Note> getListaWhere(int id) {
		List<Note> Note = new ArrayList<Note>();

		ResultSet rs;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notes WHERE id=? AND user_id=?");
			stmt.setInt(1,id);
			stmt.setInt(2, this.loggedUser);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Note note = new Note();
				note.setId(rs.getInt("id"));
				note.setBg(rs.getString("bg"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setCreationDate(rs.getDate("creation_date"));
				note.setUpdatedDate(rs.getDate("update_date"));
				Note.add(note);
			}
			rs.close();
			stmt.close();
			return Note;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Note> getLista() {
		List<Note> Note = new ArrayList<Note>();

		ResultSet rs;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notes WHERE USER_ID=?");
			stmt.setInt(1, this.loggedUser);
			System.out.println(this.loggedUser);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Note note = new Note();
				note.setId(rs.getInt("id"));
				note.setUserId(rs.getInt("user_id"));
				note.setBg(rs.getString("bg"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setCreationDate(rs.getDate("creation_date"));
				note.setUpdatedDate(rs.getDate("update_date"));
				note.setActive(rs.getBoolean("active"));
				Note.add(note);
			}
			rs.close();
			stmt.close();
			return Note;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adiciona(Note note) {
		String sql = "INSERT INTO Notes" + "(user_id,bg,title,content,creation_date,update_date) values(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, this.loggedUser);
			stmt.setString(2, note.getBg());
			stmt.setString(3, note.getTitle());
			stmt.setString(4, note.getContent());
			stmt.setDate(5, note.getCreationDate());
			stmt.setDate(6, note.getUpdatedDate());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void adicionaUsuario(Users user) {
		String sql = "INSERT INTO Usuario" + "(username,password,lastAccess) values(?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setDate(3, user.getLastAccess());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected boolean checkSignup(String user) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE username=?");
			return (true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (false);
		}
	}
	
	protected void deleteUser(String user) {
		ResultSet rs;
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM usuario WHERE username=?");
			rs = stmt.executeQuery();
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public boolean checkLogin(String username, String password){

		int flag = 0;  
		String user = null;
		String pass = null;
		ResultSet rs;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE username=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = rs.getString("username");
				pass = rs.getString("password");
				flag = rs.getInt("ID");
				System.out.println(user+pass+flag+username+password+pass.equals(password)+user.equals(username));
				System.out.println(flag);
			}
			rs.close();
			stmt.close();
			if (user.equals(username) && pass.equals(password)) {
				
				this.loggedUser = flag;
				System.out.println(this.loggedUser);
				System.out.println(loggedUser);
				
				rs.close();
				stmt.close();
				return (true);
			}
			else {
				rs.close();
				stmt.close();
				return false;
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;

		
	}
	

	public void atualiza(Note note, int id) {
		String sql = "UPDATE Notes SET " + "bg=?, title=?, content=?, update_date=? WHERE id=? AND user_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, note.getBg());
			stmt.setString(2, note.getTitle());
			stmt.setString(3, note.getContent());
			stmt.setDate(4, note.getUpdatedDate());
			stmt.setInt(5, id);
			stmt.setInt(6, this.loggedUser);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void delete(int id) {
		String sql = "UPDATE Notes SET " + "active=false WHERE id=? AND user_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, this.loggedUser);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

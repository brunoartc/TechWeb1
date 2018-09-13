package br.com.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private int loggedUser = 1;

	private Connection connection = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TecWeb", "root", "root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public List<Note> getListaWhere(int id) {
		List<Note> Note = new ArrayList<Note>();

		ResultSet rs;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notes WHERE id=? AND user_id=?");
			stmt.setInt(1,id);
			stmt.setInt(2, loggedUser);
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
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notes");
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
			stmt.setInt(1, loggedUser);
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

	public void atualiza(Note note, int id) {
		String sql = "UPDATE Notes SET " + "bg=?, title=?, content=?, update_date=? WHERE id=? AND user_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, note.getBg());
			stmt.setString(2, note.getTitle());
			stmt.setString(3, note.getContent());
			stmt.setDate(4, note.getUpdatedDate());
			stmt.setInt(5, id);
			stmt.setInt(6, loggedUser);
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
			stmt.setInt(2, loggedUser);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

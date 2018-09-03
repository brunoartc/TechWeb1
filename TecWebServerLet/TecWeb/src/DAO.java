import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {

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

	public List<Note> getLista() {
		List<Note> Note = new ArrayList<Note>();

		ResultSet rs;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notes");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Note note = new Note();
				note.setId(rs.getInt("id"));
				note.setBg(rs.getString("bg"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("creation_date"));
				note.setCreationDate(data);
				data.setTime(rs.getDate("update_date"));
				note.setUpdatedDate(data);
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

}

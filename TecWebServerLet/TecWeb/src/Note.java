import java.util.Calendar;

public class Note {

	/**
	 * CREATE TABLE Notes( ID int NOT NULL AUTO_INCREMENT, bg VARCHAR(20), title
	 * VARCHAR(10), content VARCHAR(255), creation_date TIMESTAMP, update_date
	 * TIMESTAMP, PRIMARY KEY (ID))
	 **/

	private int id;
	private String bg;
	private String title;
	private String content;
	private Calendar creationDate;
	private Calendar updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String bg) {
		this.bg = bg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

}

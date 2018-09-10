package br.com.insper;
import java.sql.Date;

public class Note {

	/**
	 * CREATE TABLE Notes( ID int NOT NULL AUTO_INCREMENT, bg VARCHAR(20), title
	 * VARCHAR(10), content VARCHAR(255), creation_date TIMESTAMP, update_date
	 * TIMESTAMP, PRIMARY KEY (ID))
	 **/

	private int id;
	public Note(String bg, String title, String content, Date creationDate, Date updatedDate) {
		super();
		//this.id = id;
		this.bg = bg;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
	}

	public Note() {
		// TODO Auto-generated constructor stub
	}

	private String bg;
	private String title;
	private String content;
	private Date creationDate;
	private Date updatedDate;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}

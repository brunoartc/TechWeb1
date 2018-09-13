package br.com.insper;

import java.sql.Date;

public class Users {

	private int id;
	private String username;
	private String password;
	private Date lastAccess;
	public int getId() {
		return id;
	}
	
	public Users() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public Users(int id, String username, String password, Date lastAccess) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastAccess = lastAccess;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}
	
}

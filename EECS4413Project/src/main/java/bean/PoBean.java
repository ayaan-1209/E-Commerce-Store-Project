package bean;

import java.io.Serializable;

public class PoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String lname;
	private String fname;
	private String status;
	private int address;
	
	public PoBean(int id, String lname, String fname, String status, int address) {
		this.id = id;
		this.lname = lname;
		this.fname = fname;
		this.status = status;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	
}

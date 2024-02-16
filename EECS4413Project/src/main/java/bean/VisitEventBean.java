package bean;

import java.io.Serializable;

public class VisitEventBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ipAddress;
	private String day;
	private String bid;
	private String eventType;
	
	public VisitEventBean(String ipAdress, String day, String bid, String eventType) {
		this.ipAddress = ipAdress;
		this.day = day;
		this.bid = bid;
		this.eventType = eventType;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	

}

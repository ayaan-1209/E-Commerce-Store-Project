package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.google.gson.Gson;

import bean.VisitEventBean;
import model.VisitEvents;

public class VisitEventDAO {
	public DataSource ds;

	public VisitEventDAO(DataSource ds) {
		this.ds = ds;
	}
	
	public void addVisitEvent(String ipAdress, String day, String bid, String eventType) throws SQLException {
		String query = "INSERT INTO VisitEvent (ipaddress, day, bid, eventtype) VALUES (?,?,?,?)";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, ipAdress);
		p.setString(2, day);
		p.setString(3, bid);
		p.setString(4, eventType);
		p.executeQuery();
	}
	
	public String getVisitEvents(VisitEvents events) throws SQLException {
		String query = "select * from VisitEvent";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			String ipAdress = rs.getString("ipaddress");
			String day = rs.getString("day");
			String bid = rs.getString("bid");
			String eventType = rs.getString("eventtype");
			VisitEventBean event = new VisitEventBean(ipAdress, day, bid, eventType);
			events.addEvent(event);
		}
		 Gson gson = new Gson();
		 return gson.toJson(events);
	}
}

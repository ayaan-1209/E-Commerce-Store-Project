package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.google.gson.Gson;

import bean.PoBean;
import bean.VisitEventBean;
import model.PurchaseOrders;
import model.VisitEvents;

public class PoDAO {
	public DataSource ds;

	public PoDAO(DataSource ds) {
		this.ds = ds;
	}
	
	
	public void addPO(String lname, String fname, String status, int address) throws SQLException {
		String query = "Select COUNT(*) From PO";
		Statement st = ds.getConnection().createStatement();
		ResultSet rs = st.executeQuery(query);
		int id = rs.getInt(1)+1;
		String query2 = "INSERT INTO PO (id, lname, fname, status, address) VALUES (?,?,?,?,?)";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query2);
		p.setInt(1, id);
		p.setString(2, lname);
		p.setString(3, fname);
		p.setString(4, status);
		p.setInt(5, address);
		p.executeQuery();
	}
	
	public String getPurchaseOrders(PurchaseOrders orders) throws SQLException {
		String query = "select * from PO";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			int id  = rs.getInt("id");
			String lname = rs.getString("lname");
			String fname = rs.getString("fname");
			String status = rs.getString("status");
			int address = rs.getInt("address");
			PoBean order = new PoBean(id, lname, fname, status, address);
			orders.addOrder(order);
		}
		 Gson gson = new Gson();
		 return gson.toJson(orders);
	}
	
}

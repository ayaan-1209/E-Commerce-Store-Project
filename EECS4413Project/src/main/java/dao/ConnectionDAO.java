package dao;

import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.google.gson.Gson;

import bean.ItemBean;
import model.Catalog;
import model.ShoppingCart;

public class ConnectionDAO {
	public DataSource ds;
	
	public ConnectionDAO() throws ClassNotFoundException{
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public void testDB() throws SQLException {
		 String Statement ="select * From Address";
		 Connection con = this.ds.getConnection();
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(Statement);
		 while(rs.next()) {
			 System.out.println("id: " + rs.getString("id") + ", street: " + rs.getString("street") + ", phone: "+ rs.getString("phone"));
		 }
	}
	
}

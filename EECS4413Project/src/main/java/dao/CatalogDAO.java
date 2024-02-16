package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.google.gson.Gson;

import bean.ItemBean;
import model.Catalog;

public class CatalogDAO {
	public DataSource ds;
	
	public CatalogDAO(DataSource ds) {
		this.ds = ds;
	}
	
	public String populateCatalog(Catalog cat) throws SQLException {
		String query = "select * from Item";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		 while(rs.next()) {
			 if(rs.getInt("quantity") <= 0) {
				 continue;
			 }
			String bid = rs.getString("bid");
			String img = rs.getString("img");
			String name = rs.getString("name");
			String description = rs.getString("description");
			String type = rs.getString("type");
			String brand = rs.getString("brand");
			int quantity = rs.getInt("quantity");
			int price = rs.getInt("price");
			ItemBean item = new ItemBean(bid, img, name, description, type, brand, quantity, price);
			cat.addItem(item);
		 }
		 Gson gson = new Gson();
		 return gson.toJson(cat);
	}
	
}

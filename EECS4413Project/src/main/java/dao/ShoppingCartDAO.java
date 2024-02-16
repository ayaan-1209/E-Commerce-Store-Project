package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import bean.ItemBean;
import model.ShoppingCart;

public class ShoppingCartDAO {
	public DataSource ds;

	public ShoppingCartDAO(DataSource ds) {
		this.ds = ds;
	}
	
	public void addToCart(ShoppingCart cart, String bid) throws SQLException {
		String query = "select * from Item where bid = '" + bid+"'";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			String bid1 = rs.getString("bid");
			String img = rs.getString("img");
			String name = rs.getString("name");
			String description = rs.getString("description");
			String type = rs.getString("type");
			String brand = rs.getString("brand");
			int quantity = rs.getInt("quantity");
			int price = rs.getInt("price");
			ItemBean item = new ItemBean(bid1, img, name, description, type, brand, quantity, price);
			cart.addItem(item);
		}
	}
	
	public void checkOut(ShoppingCart cart) throws SQLException {
		Connection con = this.ds.getConnection();
		PreparedStatement p;
		for(ItemBean item: cart.getItems()) {
			int newQuantity = item.getQuantity()-1;
			String query = "UPDATE Item SET quantity ="+ newQuantity +"where bid = '" + item.getBid()+"'";
			p = con.prepareStatement(query);
			p.executeQuery();
		}
		
	}
}

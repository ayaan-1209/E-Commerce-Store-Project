package bean;

import java.io.Serializable;

public class ItemBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bid;
	private String img;
	private String name;
	private String description;
	private String type;
	private String brand;
	private int quantity;
	private int price; 
	
	
	public ItemBean(String bid, String img, String name, String description, String type, String brand, int quantity, int price){
		this.bid=bid;
		this.img=img;
		this.name=name;
		this.description=description;
		this.type=type;
		this.brand=brand;
		this.quantity=quantity;
		this.price=price;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}  
	
	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid= bid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	

}

package model;

import java.util.ArrayList;

import bean.ItemBean;

public class Catalog {
	ArrayList<ItemBean> items = new ArrayList<>();
	
	public Catalog(){}
	public void reset() {
		items = new ArrayList<>();
	}
	public void addItem(ItemBean item) {
		items.add(item);
	}
	
	public void removeItem(ItemBean item) {
		items.remove(item);
	}
	
	public Catalog filter(Boolean apple, Boolean samsung, Boolean phone, Boolean laptop) {
		Catalog cat = new Catalog();
		for(ItemBean item: items) {
			if(apple && item.getBrand().equals("apple")) 
				cat.addItem(item);
			else if(samsung && item.getBrand().equals("samsung")) 
				cat.addItem(item);
			else if(phone && item.getType().equals("phone")) 
				cat.addItem(item);
			else if(laptop && item.getType().equals("laptop"))
				cat.addItem(item);
		}
		return cat;
	}
}

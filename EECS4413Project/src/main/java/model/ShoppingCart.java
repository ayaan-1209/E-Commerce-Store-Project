package model;

import java.util.ArrayList;

import bean.ItemBean;

public class ShoppingCart {
	ArrayList<ItemBean> items = new ArrayList<>();
		
	public ShoppingCart(){}
	
	public void addItem(ItemBean item) {
		items.add(item);
	}
	
	public boolean removeItem(String bid) {
		for(ItemBean item: items) {
			if (item.getBid() == bid) {
				items.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<ItemBean> getItems() {
		return items;
	}

	public void checkOut() {
		items.removeAll(items);
	}
}

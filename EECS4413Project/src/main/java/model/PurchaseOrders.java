package model;

import java.util.ArrayList;

import bean.PoBean;

public class PurchaseOrders {
	ArrayList<PoBean> orders = new ArrayList<>();
	
	public void addOrder(PoBean order) {
		orders.add(order);
	}
}

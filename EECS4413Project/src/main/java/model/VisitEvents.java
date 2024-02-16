package model;

import java.util.ArrayList;

import bean.VisitEventBean;

public class VisitEvents {
	ArrayList<VisitEventBean> events = new ArrayList<>();
	
	public void addEvent(VisitEventBean event) {
		events.add(event);
	}
	
}

package com.publicissapient.DAO.pojo;

import java.util.Date;
import java.util.List;

public class OrderEvent {
	private int orderEventId;
	private String eventType;
	private long event_timestramp;
	public int getOrderEventId() {
		return orderEventId;
	}
	public void setOrderEventId(int orderEventId) {
		this.orderEventId = orderEventId;
	}
	public String getEventStatus() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public long getEvent_timestramp() {
		return event_timestramp;
	}
	public void setEvent_timestramp(long event_timestramp) {
		this.event_timestramp = event_timestramp;
	}
	public String getEventType() {
		return eventType;
	}
	
	
	
	
	
	

}

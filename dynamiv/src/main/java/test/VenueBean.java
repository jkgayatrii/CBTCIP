package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VenueBean implements Serializable {
	private String venuename,location;
	private long cost,contact,capacity;
	public VenueBean() {}
	public String getVenuename() {
		return venuename;
	}
	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity2) {
		this.capacity = capacity2;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	

}

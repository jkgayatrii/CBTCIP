package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustBean implements Serializable{
	private String type,loc,veg,lunch,dinner,lights,flowers,seats,evtdate;
	private String[] equip;
	private String[] food;
	private long cost,guests;
	public CustBean() {}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getVeg() {
		return veg;
	}
	public void setVeg(String veg) {
		this.veg = veg;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	public String getLights() {
		return lights;
	}
	public void setLights(String lights) {
		this.lights = lights;
	}
	public String getFlowers() {
		return flowers;
	}
	public void setFlowers(String flowers) {
		this.flowers = flowers;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getEvtdate() {
		return evtdate;
	}
	public void setEvtdate(String evtdate) {
		this.evtdate = evtdate;
	}
	public String[] getEquip() {
		return equip;
	}
	public void setEquip(String[] equip) {
		this.equip = equip;
	}
	public String[] getFood() {
		return food;
	}
	public void setFood(String[] food) {
		this.food = food;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public long getGuests() {
		return guests;
	}
	public void setGuests(long guests) {
		this.guests = guests;
	}
	
	
	

}

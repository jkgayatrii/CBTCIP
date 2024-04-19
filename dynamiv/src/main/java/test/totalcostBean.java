package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class totalcostBean implements Serializable{
 private long total_cost,cost,lunch,dinner,lights,flowers,seating;
 public totalcostBean() {}
public long getTotal_cost() {
	return total_cost;
}
public void setTotal_cost(long total_cost) {
	this.total_cost = total_cost;
}
public long getCost() {
	return cost;
}
public void setCost(long cost) {
	this.cost = cost;
}
public long getLunch() {
	return lunch;
}
public void setLunch(long lunch) {
	this.lunch = lunch;
}
public long getDinner() {
	return dinner;
}
public void setDinner(long dinner) {
	this.dinner = dinner;
}
public long getLights() {
	return lights;
}
public void setLights(long lights) {
	this.lights = lights;
}
public long getFlowers() {
	return flowers;
}
public void setFlowers(long flowers) {
	this.flowers = flowers;
}
public long getSeating() {
	return seating;
}
public void setSeating(long seating) {
	this.seating = seating;
}


}
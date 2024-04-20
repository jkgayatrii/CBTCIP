package test;
import java.io.Serializable;

@SuppressWarnings("serial")
public class EventBean implements Serializable {
	private String eventname,eventdesc;
	public EventBean() {}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventdesc() {
		return eventdesc;
	}
	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}
	
	

}

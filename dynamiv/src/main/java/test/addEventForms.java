package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/addEventForms")

public class addEventForms extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		totalcostBean tb=new totalcostBean(); 
		String type=req.getParameter("eventName");
		String place=req.getParameter("eventplace");
		long cost=Long.parseLong(req.getParameter("cost"));
		long guests=Long.parseLong(req.getParameter("guests"));
		String[] selectedValues=req.getParameterValues("option");
		 String[] selectedfood=req.getParameterValues("food");
		 tb.setCost(cost);
		 
		
		 String veg=req.getParameter("vegnonveg");
		 String lunch=req.getParameter("lunch");
		 String dinner=req.getParameter("dinner");
		 String lights=req.getParameter("lights");
		 String flowers=req.getParameter("flowers");
		 String seating=req.getParameter("seats");
		 String date=req.getParameter("eventDate");
		 if(lunch.contentEquals("Royal")) {
			 tb.setLunch(700*guests);
		 }
		 else {
			 tb.setLunch(300*guests);
		 }
		 if(dinner.contentEquals("Royal")) {
			 tb.setDinner(700*guests);
		 }
		 else {
			 tb.setDinner(300*guests);
		 }
		 
		 
		 if(lights.contentEquals("Royal")) {
			 tb.setLights(6000);
		 }
		 else {
			 tb.setLights(3000);
		 }
		 
		 if(flowers.contentEquals("Yes")) {
			 tb.setFlowers(6000);
		 }
		 else {
			 tb.setFlowers(0);
		 }
		 if(seating.contentEquals("Sofas's and Chairs")) {
			 tb.setSeating(8000);
		 }
		 else {
			 tb.setSeating(3000);
		 }
		 long total=tb.getCost()+tb.getLights()+tb.getFlowers()+tb.getSeating()+tb.getDinner()+tb.getLunch();
		 System.out.println(tb.getLights());
		 tb.setTotal_cost(total);
		 UserBean ub=(UserBean)hs.getAttribute("user"); 
		 String username=ub.getUname();
		 System.out.println(tb.getTotal_cost());
		 CustBean cb=new CustBean();
		
		cb.setType(type);
		cb.setLoc(place);
		cb.setCost(cost);
		cb.setGuests(guests);
		cb.setEquip(selectedValues);
		cb.setFood(selectedfood);
		cb.setVeg(veg);
		cb.setLunch(lunch);
		cb.setDinner(dinner);
		cb.setLights(lights);
		cb.setFlowers(flowers);
		cb.setSeats(seating);
		cb.setEvtdate(date);
	
		
		
		int k=new CustBeanDAO().show(cb,username);
		if(k>0) {
			req.setAttribute("bean", cb);
			req.setAttribute("totalbean", tb);
			req.getRequestDispatcher("form.jsp").forward(req, res);
		}
	}
	

}

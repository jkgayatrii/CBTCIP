<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,test.*"%>
<!DOCTYPE html>
<html>
<head>

        <title>Admin Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <div style="display: flex;align-items: center;justify-content: space-evenly;background-color: black;height: 70px;">
        <div style="text-align: center;color: white; font-size: 40px;">Our Event Management Portal!</div>
        <div style="display: flex;align-items: center;justify-content: space-evenly;">
			<a href="#" style="font-size: 30px;margin-right:25px;">Home</a>
            <a href="#" style="font-size: 30px;margin-right:25px;">Contact us</a>
            <a href="#" style="font-size: 30px;">Login</a>
        </div></div>
        <link rel="stylesheet" href="total.css"/>
        <link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
    </head>
    <meta charset="UTF-8">
    <title>View Events</title>
    
</head>
<body>
<center>
   <h2>Venue List</h2>
  </center>
   <table border="1" class="form-container">
        <thead>
            <tr>
                <th>Venue Name</th>
                 <th>Cost</th>
                  <th>LOcation</th>
                   <th>Capacity</th>
                <th>Contact</th>
            </tr>
        </thead>
        <tbody>
         
            <%
           
            ArrayList<VenueBean> venues = (ArrayList<VenueBean>)request.getAttribute("venues");
            if (venues != null) {
                for (VenueBean venue : venues) { %>
                    <tr>
                        <td><%= venue.getVenuename() %></td>
                        <td><%= venue.getCost() %></td>
                        <td><%= venue.getLocation() %></td>
                          <td><%= venue.getCapacity() %></td>
                         <td><%= venue.getContact() %></td> 
                    </tr>
                <% }
            } %>
        </tbody>
    </table>
   
    <right>
  
           <p>
               <a href="AdminEvent.html"><button>Home Page</button> </a>
           </p>
        
    </right>
    
</body>
</html>

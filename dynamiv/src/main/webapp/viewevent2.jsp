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

<%
UserBean ub=(UserBean)session.getAttribute("user"); 

%>
 
<form>
<input type="hidden" name="userName" value=<%=ub.getUname()%>>
</form>



<center>
   <h2>Event List</h2>
  </center>
   <table border="1" class="form-container">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
         
            <%
            EventBean ab=(EventBean)session.getAttribute("ebb");
            ArrayList<EventBean> events = (ArrayList<EventBean>)request.getAttribute("events");
            if (events != null) {
                for (EventBean event : events) { %>
                    <tr>
                        <td><%= event.getEventname() %></td>
                        <td><%= event.getEventdesc() %></td>
                    </tr>
                <% }
            } %>
        </tbody>
    </table>
   
    <right>
  
           <p>
               <a href="ParticipantEvent.jsp"><button>Home Page</button> </a>
           </p>
        
    </right>
    
</body>
</html>

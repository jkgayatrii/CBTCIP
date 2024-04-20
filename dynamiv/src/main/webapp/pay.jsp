<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>

<html>
   <head>
        <title>Customer login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <div style="display: flex;align-items: center;justify-content: space-evenly;background-color: black;height: 70px;">
        <div style="text-align: center;color: white; font-size: 40px;">Our Event Management Portal!</div>
        <div style="display: flex;align-items: center;justify-content: space-evenly;">
			<a href="#" style="font-size: 30px;margin-right:25px;">Home</a>
            <a href="#" style="font-size: 30px;margin-right:25px;">Contact Us</a>
            <a href="#" style="font-size: 30px;">Login</a>
        </div></div>
        <link rel="stylesheet" href="total.css">
        <link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <script>
        function displayImage() {
            var venue = document.getElementById("eventLocation").value;
            var img = document.getElementById("id1");
            if (venue === "Banjara hall") {
                img.value = "50000";
            } else if (venue === "Goteti Kalyana Vedika") {
                img.value = "80000";
            } else if(venue==="Sai Grand Convention."){
                img.value = "30000";
            }
            else if (venue==="Elite Convention."){
            	img.value="600000";
            }
            else{
            	img.value="650000";
            }
        	/*var selectedOption = document.getElementById("eventLocation").value;
            document.getElementById("id1").value = selectedOption;*/
        }
    </script>
     <script>
        function displayvenue() {
            var venue = document.getElementById("venueLocation").value;
            var img = document.getElementById("id2");
            if (venue === "Banjara hall") {
                img.value = venue;
            } else if (venue === "Goteti Kalyana Vedika") {
                img.value = venue;
            } else if(venue==="Sai Grand Convention."){
                img.value = venue;
            }
            else if (venue==="Elite Convention."){
            	img.value=venue;
            }
            else{
            	img.value=venue;
            }
        }
        
    </script>
     <script>
        function imagedisplay() {
            var venue = document.getElementById("venueLocation").value;
            var img = document.getElementById("id2");
            if (venue === "Banjara hall") {
                img.src = venue;
            } else if (venue === "Goteti Kalyana Vedika") {
                img.value = venue;
            } else if(venue==="Sai Grand Convention."){
                img.value = venue;
            }
            else if (venue==="Elite Convention."){
            	img.value=venue;
            }
            else{
            	img.value=venue;
            }
        }
        
    </script>
    </head>
    <body>
<%
UserBean ub=(UserBean)session.getAttribute("user"); 
CustBean b=(CustBean)request.getAttribute("bean");
%>
 
<form>
<input type="hidden" name="userName" value=<%=ub.getUname()%>>
</form>
       
        <div style="display: flex;align-items: center;justify-content: space-evenly;background-color:slategrey; height: 30px;margin-top: 5px;">
        <a href="#" onclick="showForm('addEventForm')">Book an Event</a>
        <a href="#" onclick="showForm('viewEventsForm')">View Events</a>
        <a href="#" onclick="showForm('viewvenueForm')">View Venues</a>
        <a href="#" onclick="showForm('mydetailsform')">My Details</a>
        <a href="Logout" onclick="showForm('addLogoutFOrm')">Logout</a>
        
        </div>
 
<div id="forms">
    <!-- Add Event Form -->
    <div id="addEvent" class="form-container" style="color: black;">
    <center>
    <form action="payServlet" method="post">
   
  <label for="card_number">Card Number:</label><br>
  <input type="text" id="card_number" name="card_number" maxlength="16" required><br><br>
  
  <label for="card_holder_name">Card Holder Name:</label><br>
  <input type="text" id="card_holder_name" name="card_holder_name" required><br><br>
  
  <label for="expiry_date">Expiry Date:</label><br>
  <input type="text" id="expiry_date" name="expiry_date" placeholder="MM/YYYY" pattern="^(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})$" required><br><br>
  
  <label for="cvv">CVV:</label><br>
  <input type="text" id="cvv" name="cvv" maxlength="4" required><br><br>
  
  <input type="submit" value="Submit">
</form>
    </center>
    </div>

    <!-- View Events Form -->
     <div id="viewEventsForm" class="form-container" style="display: none;color: black;">
        <h2>View Events Form</h2>
        <form action="vieweventServlet2" method="get">
			<button>Show List</button>
		</form>
        
    </div>
    
    <div id="viewvenueForm" class="form-container" style="display: none;color: black;">
       <center>
        <h2>View Venue</h2>

        <!-- <form action="viewvenueServlet" method="get">
			<button>Show List</button>
		</form>   --> 
		 
		<!-- Venue: 
		<select id="venueLocation" name="eventLocation" onchange="displayvenue()" onchange="imagedisplay" placeholder="select venue" style="color: black;"required>
            <option value="0">Select an option</option>
            <option value="50000">Banjara hall</option>
            <option value="50000">Goteti Kalyana Vedika.</option>
             <option value="60000">Sai Grand Convention.</option>
           <option value="30000">Elite Convention.</option>
           <option value="20000">Msr Convention Garden.</option>    
        </select><br>
        <br>
         Cost : &nbsp&nbsp <input type="text" id="id2"><br><br>
         
        </center> -->
        
        <select id="image-select" onchange="showImageAndCost()" placeholder="select venue" style="color: black;"required>
        <option value="option">Select an option</option>
            <option  value="Banjara hall" data-cost="50000">Banjara hall</option>
            <option value="Goteti Kalyana Vedika" data-cost="60000">Goteti Kalyana Vedika</option>
             <option value="Sai Grand Convention" data-cost="40000">Sai Grand Convention</option>
           <option value="Elite Convention" data-cost="30000">Elite Convention</option>
           <option value="Msr Convention Garden" data-cost="20000">Msr Convention Garden</option>    
              
</select><br><br>

<div id="image-container">
    <img id="display-image" src="" alt="Selected Image" width="350px" height="250px">
</div><br>

<label for="cost-input">Cost:</label>
<input type="text" id="cost-input" readonly>
<br>
<script>
function showImageAndCost() {
    var selectElement = document.getElementById("image-select");
    var selectedValue = selectElement.value;
    var imagePath;
    var cost;

    // Determine the image path and cost based on the selected option
    switch(selectedValue) {
        case "Banjara hall":
            imagePath = "venue1.jpg";
            cost = 50000;
            break;
        case "Goteti Kalyana Vedika":
            imagePath = "venue2.png";
            cost = 60000;
            break;
        case "Sai Grand Convention":
            imagePath = "venue3.jpg";
            cost = 40000;
            break;
        case "Elite Convention":
            imagePath = "venue4.jpg";
            cost = 30000;
            break;
        case "Msr Convention Garden":
            imagePath = "venue5.jpg";
            cost = 20000;
            break;
            
        default:
            imagePath = "";
            cost = 0;
    }

    // Update the src attribute of the image
    document.getElementById("display-image").src = imagePath;

    // Update the value of the cost input field
    document.getElementById("cost-input").value = cost;
}
</script>
        
		 </div>
    
    

    <!-- User Lists Form -->
    <div id="mydetailsform" class="form-container" style="display: none;color: white;">
       <center>
       <h2>My Details</h2>
       <!--  <a href="mydetails">Show</a>-->
        userName:<%out.println("&nbsp&nbsp"+""+ub.getUname()); %><br><br>
                Name :<%out.println("&nbsp&nbsp"+""+ub.getName()); %><br><br>
        
                Password :<%out.println("&nbsp&nbsp"+""+ub.getPw()); %><br><br>
        
                Address :<%out.println("&nbsp&nbsp"+""+ub.getAddr()); %><br><br>
        
                MailId :<%out.println("&nbsp&nbsp"+""+ub.getMailId()); %><br><br>
        
                Phone number :<%out.println("&nbsp&nbsp"+""+ub.getPhno()); %><br><br></center> 
    </div>
</div>

<script>
function showForm(formId) {
    // Hide all forms
    var forms = document.getElementsByClassName("form-container");
    for (var i = 0; i < forms.length; i++) {
        forms[i].style.display = "none";
    }

    // Show the selected form
    var form = document.getElementById(formId);
    form.style.display = "block";
}

function submitForm(formId) {
    // Perform form su66bmission logic here
    // For demonstration, let's just log the form ID
    console.log("Form submitted: " + formId);
}
</script>
 
</body>
</html>
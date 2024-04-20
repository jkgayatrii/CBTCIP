<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Logout</title>
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
<body class="form-container"><br><br><center>
<% String msg=(String)request.getAttribute("msg");
out.println(msg);
%></center><br><br><center>
<a href="index.html"><Button>Return to Home Page</Button></a></center>
</body>
</html>
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
<div class="form-container">
<%
String msg=(String)request.getAttribute("msg");
out.println(msg);
%>
</div>
<center style="margin-top:10px">
<div>
<a href="AdminEvent.html">Home Page</a>
<a href="Alogin.html">Logout</a>
</div>
</center>
</body>
</html>
				<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>View Employee Data</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="styles.css">

<link rel="icon" href="ideasLogo.PNG">
<title>IDeaS GOA Trip</title>
<style>
.fear{

height:200px;
    position: relative;
    display: block;
    float: left;
}
.ohGod{
	height:200px;
   
    
}
</style>
</head>
<body class="bg">
	<%@ include file="HeaderFiles.html"%>
	
	<div class="align-items-center">
  <div class="col" style="background:red">
  <center>
    <h1><a href="http://www.googlefeud.com">At Your Own Risk Press Me!</a></h1>
    </center>
  </div>
</div>
<div class="divlizard">
<a href="http://localhost:8080/GoaProject/FunPage.jsp">
<img class="fear"  src="lizardpic.PNG" >
</a>
</div>
<div class="divlizard">
<a href="http://localhost:8080/GoaProject/FunPage.jsp">
<img   class="ohGod" src="lizardpic.PNG" >
</a>
</div>
</body>
</html>
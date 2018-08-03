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

<script>
var request;  
function sendInfo()  
{  
var v=document.vinform.t1.value;  
var url="employee?val="+v;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try  
{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}  
catch(e)  
{  
alert("Unable to connect to server");  
}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('amit').innerHTML=val;  
}  
} 
</script>
</head>
<body>
	<%@ include file="HeaderFiles.html"%>

	<div class="container">
		<h2>Employee List</h2>
		<%@ include file="AddEmployeePage.html"%>

		<form name="vinform">
			<input type="text" name="t1"> <input type="button"
				value="ShowTable" onClick="sendInfo()">
		</form>
		<span id="amit"> </span> 
		<table class="table table-bordered">

			<thead>
				<tr>
					<th>Employee Id</th>
					<th>NAME</th>
					<th>Employee CompanyID</th>
					<th>Contact Number</th>
					<th>Department</th>
					<th>Details</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td>${employee.getEmpCompId()}</td>
						<td>${employee.getName()}</td>
						<td>${employee.getEmpContact()}</td>
						<td>${employee.getEmpDepartment()}</td>
						<td><a class="TextBlue"
							href="employeeDetails?employeeId=${employee.getEmpCompId()}">Details</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>
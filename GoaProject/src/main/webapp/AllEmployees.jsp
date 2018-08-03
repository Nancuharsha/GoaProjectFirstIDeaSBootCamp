
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IDeaS GOA Trip</title>
<link rel="icon" href="ideasLogo.PNG">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="styles.css">


<script>
	function myFunction(msg) {
		var txt;
		var r = confirm(msg);
		if (r == true) {
			//txt = "You pressed OK!";
			return true;
		} else {
			return false;
		}
		// document.getElementById("demo").innerHTML = txt;
	}

	function empPhoneChecking() {

		var searchString = $("#empPhone").val();
		console.log(searchString);
		$.get("${pageContext.request.contextPath}/employees?phoneString="
				+ searchString, function(data, status) {
			//alert(data);
			var employeeList = jQuery.parseJSON(data);

			console.log(employeeList);
			var ans = "";
			/* 
			 for(i=0 ;i< employeeList.length;i++){
			 */
			if (employeeList.length > 0) {
				ans += "Emp Phone Id is Taken";
			}
			/*	
			}  */
			//alert(employeeList[0].employeeName);
			//console.log(employeeList);
			//document.getElementById("employeeList").innerHTML = employeeList;
			document.getElementById("checkingPhone").innerHTML = ans;

		});
	}

	function empIdChecking() {

		var searchString = $("#empID").val();
		console.log(searchString);
		$.get("${pageContext.request.contextPath}/employees?searchString="
				+ searchString, function(data, status) {
			//alert(data);
			var employeeList = jQuery.parseJSON(data);

			console.log(employeeList);
			var ans = "";

			for (i = 0; i < employeeList.length; i++) {

				if (employeeList[i].companyEmployeeID == searchString) {
					ans += "Emp Company Id is Taken";
				}

			}
			//alert(employeeList[0].employeeName);
			//console.log(employeeList);
			//document.getElementById("employeeList").innerHTML = employeeList;
			document.getElementById("checkingEmpCompId").innerHTML = ans;

		});
	}

	function getAllEmployees() {
		var searchString = $("#searchString").val();
		if (searchString.length == 0) {
			document.getElementById("myText").innerHTML = "";
			document.getElementById("myText").style.border = "0px";
			return;
		}
		$
				.get(
						"${pageContext.request.contextPath}/employees?searchString="
								+ searchString,
						function(data, status) {
							//alert(data);
							var employeeList = jQuery.parseJSON(data);
							if (employeeList.length == 0) {
								document.getElementById("myText").innerHTML = "<div class='ColorType'>No One Exist</div>";
							} else {
								var ans = "<table border='1' cellpadding='2' width='100%' class='ColorType' ><tr class='active'><th>Employee Id</th><th>NAME</th><th>Contact Number</th><th>Department</th><th>EmployeeCompId</th><th>Details</th></tr>";

								for (i = 0; i < employeeList.length; i++) {
									ans += "<tr class="+"ColorType"+"><td>";
									ans += employeeList[i].employeeID;
									ans += "</td>";
									ans += "<td>";
									ans += employeeList[i].employeeName;
									ans += "</td>";
									ans += "<td>";
									ans += employeeList[i].contactNumber;
									ans += "</td>"
									ans += "<td>";
									ans += employeeList[i].department;
									ans += "</td>";
									ans += "<td>";
									ans += employeeList[i].companyEmployeeID;
									ans += "</td>";
									ans += "<td><a href="
											+ "http://localhost:8080/GoaProject/employeeDetails?employeeId="
											+ employeeList[i].employeeID
											+ ">Details</a></td></tr>";
									/* 
										<td>${employee.getEmpCompId()}</td>
													<td>${employee.getName()}</td>
													<td>${employee.getEmpContact()}</td>
													<td>${employee.getEmpDepartment()}</td>
													<td><a class="TextBlue"
														href="employeeDetails?employeeId=${employee.getEmpId()}">Details</a></td>
									 */

									//console.log(employeeList[i].employeeName);
								}
								ans += "</table>";
								//alert(employeeList[0].employeeName);
								//console.log(employeeList);
								//document.getElementById("employeeList").innerHTML = employeeList;
								document.getElementById("myText").innerHTML = ans;
							}
						});
	}
</script>

</head>
<body class="bg">
	<%@ include file="HeaderFiles.html"%>

	<div class="container">

		<h2>Employee List</h2>


		<form class="form-inline"
			action="http://localhost:8080/GoaProject/employees" method="post"
			onsubmit="return myFunction('Should insert!');">
			<div class="modal fade" id="modalContactForm" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header text-center">
							<h2 class="modal-title w-100 font-weight-bold">Add Employee</h2>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<p>
							<label>Name:</label> <input type="text" name="empName" required
								pattern="^[a-zA-Z]+( [a-zA-Z]+)*$"
								title="Only Alphabets and one space between words" />
						</p>
						<p>
							<label>Employee Company ID:</label> <input id="empID"
								type="text" name="companyEmpId" required pattern="\d*"
								onkeyup="empIdChecking()" title="Only Integer correct empID" /><span
								id="checkingEmpCompId"></span>
						</p>
						<p>
							<label>Employee Contact Number:</label><input id="empPhone"
								type="text" name="empContactNum" required minlength=10
								maxlength=10 onkeyup="empPhoneChecking()"
								title="Only integer of length 10"><span
								id="checkingPhone"></span>
						</p>

						<p>
							<label>Department:</label> <select name="Department">
								<option value="SD">SD</option>
								<option value="QA">QA</option>
								<option value="CARE">CARE</option>
								<option value="ROA">ROA</option>
								<option value="TECHOPS">TECHOPS</option>
								<option value="NULL">No Department</option>
							</select>
						</p>

						<div class="modal-footer d-flex justify-content-center">
							<button class="btn btn-unique" name="action" value="post">
								Send <i class="fa fa-paper-plane-o ml-1"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<div class="text-left">
			<a href="" class="btn btn-default btn-rounded mb-4"
				data-toggle="modal" data-target="#modalContactForm">Add Employee</a>
		</div>
		<div class="form-group">
			<label for="usr">Search:</label> <input
				placeholder="Search by EmployeeName.." type="text"
				class="form-control" id="searchString" onkeyup="getAllEmployees()">
		</div>
		<span id="myText" class="active"></span>
		<div class="container">

			<div class="container">

				<c:choose>
					<c:when test="${empty employeeList}">
						<h3>
							<p class="ColorType">No DATA AVALIABLE</p>
						</h3>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered">

							<thead>
								<tr class="active">
									<th>Employee Id</th>
									<th>Employee Comp Id</th>
									<th>NAME</th>
									<th>Contact Number</th>
									<th>Department</th>
									<th>Details</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employeeList}" var="employee">
									<tr class="active">
										<td>${employee.getEmpId()}</td>
										<td>${employee.getEmpCompId()}</td>
										<td>${employee.getName()}</td>
										<td>${employee.getEmpContact()}</td>
										<td><c:choose>
												<c:when test="${employee.getEmpDepartment() ==null}">No Department</c:when>
												<c:otherwise>${employee.getEmpDepartment()}</c:otherwise>
											</c:choose></td>
										<td><a class="TextBlue"
											href="employeeDetails?employeeId=${employee.getEmpId()}">Details</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>


			</div>
		</div>
</body>
</html>
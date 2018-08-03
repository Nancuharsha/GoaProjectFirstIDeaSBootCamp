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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="styles.css">
<link rel="icon" href="ideasLogo.PNG">
<script>
	function minmax(value, min, max) {
		if (parseInt(value) < min || isNaN(parseInt(value)))
			return min;
		else if (parseInt(value) > max)
			return max;
		else
			return value;
	}
	function empPhoneChecking() {

		var searchString = $("#empPhone").val();
		console.log(searchString);
		$.get("http://localhost:8080/GoaProject/employees?phoneString="
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
		$.get("http://localhost:8080/GoaProject/employees?searchString="
				+ searchString, function(data, status) {
			//alert(data);
			var employeeList = jQuery.parseJSON(data);

			console.log(employeeList);
			var ans = "";

			if (employeeList.length > 0) {
				ans += "Emp Company Id is Taken";
			}

			//alert(employeeList[0].employeeName);
			//console.log(employeeList);
			//document.getElementById("employeeList").innerHTML = employeeList;
			document.getElementById("checkingEmpCompId").innerHTML = ans;

		});
	}

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
</script>
</head>

<body class="bg">

	<%@ include file="HeaderFiles.html"%>
	
	<c:choose>
		<c:when test="${empty employee}">
			<h1>
				<p class="ColorType">What's Wrong With You</p>
			</h1>
		</c:when>
		<c:otherwise>

			<div class="container">
			<button class="btn btn-info">
					<a href="employees">Back</a>
				</button>
				<h2><p class="ColorTyper">${employee.getName()}&nbsp Details</p></h2>
				<form class="form-inline"
					action="http://localhost:8080/GoaProject/employees?employeeCompId=${employee.getEmpCompId()}"
					method="post" onsubmit="return myFunction('Should delete!');">
					<div class="modal-footer d-flex justify-content-center">
						<button class="btn btn-danger" name="action" value="delete">
							Delete Employee<i class="fa fa-paper-plane-o ml-1"></i>
						</button>
					</div>
				</form>
				<form class="form-inline"
					action="http://localhost:8080/GoaProject/employeeDetails?employeeId=${employee.getEmpId()}"
					method="post" onsubmit="return myFunction('Should update!');">
					<div class="modal fade" id="modalContactForm" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header text-center">
									<h2 class="modal-title w-100 font-weight-bold">Add
										Employee</h2>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<p>
									<label>Employee Id: </label><input type="text" name="empId"
										value="${employee.getEmpId()}" required pattern="\d*"
										title="Only Integer" />
								</p>
								<p>
									<label>Name: </label><input type="text" name="empName"
										value="${employee.getName()}" required
										pattern="^[a-zA-Z]+( [a-zA-Z]+)*$"
										title="Only Alphabets and one space between words" />
								</p>
								<p>
									<label>Employee Company ID: </label><input id="empID"
										type="text" name="companyEmpId"
										value="${employee.getEmpCompId()}" required pattern="\d*"
										onkeyup="empIdChecking()" title="Only Integer" /><span
										id="checkingEmpCompId"></span>
								</p>
								<p>
									<label>Employee Contact Number:</label><input id="empPhone"
										type="text" name="empContactNum"
										value="${employee.getEmpContact()}" required
										onkeyup="empPhoneChecking()" minlength=10 maxlength=10
										title="Only integer of length 10"><span
										id="checkingPhone"></span>
								</p>

								<p>
									<label>Department: </label><select name="Department">
										<option value="SD"
											<c:if test = "${employee.getEmpDepartment() =='SD'}">selected</c:if>>SD</option>
										<option value="QA"
											<c:if test = "${employee.getEmpDepartment() =='QA'}">selected</c:if>>QA</option>
										<option value="CARE"
											<c:if test = "${employee.getEmpDepartment() =='CARE'}">selected</c:if>>CARE</option>
										<option value="ROA"
											<c:if test = "${employee.getEmpDepartment() =='ROA'}">selected</c:if>>ROA</option>
										<option value="TECHOPS"
											<c:if test = "${employee.getEmpDepartment() =='TECHOPS'}">selected</c:if>>TECHOPS</option>
										<option value="NULL"
											<c:if test = "${employee.getEmpDepartment() ==null}">selected</c:if>>No
											Department</option>
									</select>
								</p>

								<div class="modal-footer d-flex justify-content-center">
									<button class="btn btn-unique" name="action"
										value="updateemployee">
										Send <i class="fa fa-paper-plane-o ml-1"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</form>

				<div class="text-right">
					<a href="" class="btn btn-default btn-rounded mb-4"
						data-toggle="modal" data-target="#modalContactForm">update
						Employee</a>
				</div>
				
				<table class="table table-bordered">


					<tr class="active">
						<td>Employee Id</td>
						<td>${employee.getEmpId()}</td>

					</tr>
					<tr class="active">
						<td>Employee Company Id</td>
						<td>${employee.getEmpCompId()}</td>
					</tr>
					<tr class="active">
						<td>NAME</td>
						<td>${employee.getName()}</td>
					</tr>
					<tr class="active">
						<td>Contact Number</td>
						<td>${employee.getEmpContact()}</td>
					</tr>
					<tr class="active">
						<td>Department</td>
						<td><c:choose>
								<c:when test="${employee.getEmpDepartment() ==null}">No Department</c:when>
								<c:otherwise>${employee.getEmpDepartment()}</c:otherwise>
							</c:choose></td>
					</tr>

				</table>
				<div>
					<h3>
						<p class="ColorType">Preferences</p>
					</h3>
				</div>
				<c:choose>
					<c:when test="${empty preference}">
						<!-- <h2>No Preferences</h2> -->
						<form class="form-inline"
							action="http://localhost:8080/GoaProject/employeeDetails?employeeId=${employee.getEmpId()}"
							method="post" onsubmit="return myFunction('Should insert!');">
							<div class="modal fade" id="modalContactForm1" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header text-center">
											<h2 class="modal-title w-100 font-weight-bold">Add
												Preferences</h2>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<p>
											<label>Employee ID:</label> <input type="text"
												name="employeeID" value="${employee.getEmpId()}" readonly />
										</p>
										<p>
											<label>Picnic Batch:</label> <select name="picnicBatch">
												<option value="FIRST_BATCH">FIRST_BATCH</option>
												<option value="FIRST_BATCH">SECOND_BATCH</option>
											</select>
										</p>
										<p>
											<label>Gender: </label><select name="gender">
												<option value="MALE">MALE</option>
												<option value="FEMALE">FEMALE</option>
											</select>
										<p>
										<p>
											<label>Mode Of Travel Onward: </label><select
												name="modeOfTravelOnward">
												<option value="BUS">BUS</option>
												<option value="AEROPLANE">AEROPLANE</option>
												<option value="CAR">CAR</option>
												<option value="TRAIN">TRAIN</option>
											</select>
										</p>
										<p>
											<label>Mode Of Travel Return:</label> <select
												name="modeOfTravelReturn">
												<option value="BUS">BUS</option>
												<option value="AEROPLANE">AEROPLANE</option>
												<option value="CAR">CAR</option>
												<option value="TRAIN">TRAIN</option>
											</select>
										</p>
										<p>
											<label>Set Of Family: </label><select name="setOfFamily">
												<option value="EMPLOYEE_SPOUSE_CHILDREN">EMPLOYEE_SPOUSE_CHILDREN
												</option>
												<option value="EMPLOYEE_DEPENDANT_PARENTS">EMPLOYEE_DEPENDANT_PARENTS
												</option>
												<option value="EMPLOYEE_SPOUSE">EMPLOYEE_SPOUSE</option>
												<option value="EMPLOYEE">EMPLOYEE</option>
											</select>
										</p>
										<p>
											<label>Total Family Count: </label><input type="text"
												name="totalFamilyCount" required pattern="\d*" />
										</p>
										<div class="modal-footer d-flex justify-content-center">
											<button class="btn btn-unique" name="action" value="get">
												Send <i class="fa fa-paper-plane-o ml-1"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</form>
						<div class="text-center">
							<a href="" class="btn btn-default btn-rounded mb-4"
								data-toggle="modal" data-target="#modalContactForm1">Add
								Preferences</a>
						</div>
					</c:when>
					<c:otherwise>
						<form class="form-inline"
							action="http://localhost:8080/GoaProject/employeeDetails?employeeId=${employee.getEmpId()}"
							method="post" onsubmit="return myFunction('Should delete!');">
							<div class="modal-footer d-flex justify-content-center">
								<button class="btn btn-danger" name="action"
									value="deleteprefrences">
									Delete Preferences<i class="fa fa-paper-plane-o ml-1"></i>
								</button>
							</div>
						</form>
						<form class="form-inline"
							action="http://localhost:8080/GoaProject/employeeDetails?employeeId=${employee.getEmpId()}"
							method="post" onsubmit="return myFunction('Should update!');">
							<div class="modal fade" id="modalContactForm2" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header text-center">
											<h2 class="modal-title w-100 font-weight-bold">Add
												Preferences</h2>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<p>
											<label>Employee ID: </label><input type="text"
												name="employeeID" value="${employee.getEmpId()}" readonly />
										</p>
										<p>
											<label>Picnic Batch: </label><select name="picnicBatch">
												<option value="FIRST_BATCH"
													<c:if test = "${preference.getPicnicBatch() =='FIRST_BATCH'}">selected</c:if>>FIRST_BATCH</option>
												<option value="SECOND_BATCH"
													<c:if test = "${preference.getPicnicBatch() =='SECOND_BATCH'}">selected</c:if>>SECOND_BATCH</option>
											</select>
										</p>
										<p>
											<label>Gender: </label><select name="gender">
												<option value="MALE"
													<c:if test = "${preference.getGender() =='MALE'}">selected</c:if>>MALE</option>
												<option value="FEMALE"
													<c:if test = "${preference.getGender() =='FEMALE'}">selected</c:if>>FEMALE</option>
											</select>
										<p>
										<p>
											<label>Mode Of Travel Onward: </label><select
												name="modeOfTravelOnward">
												<option value="BUS"
													<c:if test = "${preference.getModeOfTravelOnward() =='BUS'}">selected</c:if>>BUS
												</option>
												<option value="AEROPLANE"
													<c:if test = "${preference.getModeOfTravelOnward() =='AEROPLANE'}">selected</c:if>>AEROPLANE
												</option>
												<option value="CAR"
													<c:if test = "${preference.getModeOfTravelOnward() =='CAR'}">selected</c:if>>CAR
												</option>
												<option value="TRAIN"
													<c:if test = "${preference.getModeOfTravelOnward() =='TRAIN'}">selected</c:if>>TRAIN</option>
											</select>
										</p>
										<p>
											<label>Mode Of Travel Return: </label><select
												name="modeOfTravelReturn">
												<option value="BUS"
													<c:if test = "${preference.getModeOfTravelReturn() =='BUS'}">selected</c:if>>BUS
												</option>
												<option value="AEROPLANE"
													<c:if test = "${preference.getModeOfTravelReturn() =='AEROPLANE'}">selected</c:if>>AEROPLANE
												</option>
												<option value="CAR"
													<c:if test = "${preference.getModeOfTravelReturn() =='CAR'}">selected</c:if>>CAR
												</option>
												<option value="TRAIN"
													<c:if test = "${preference.getModeOfTravelReturn() =='TRAIN'}">selected</c:if>>TRAIN</option>
											</select>
										</p>
										<p>
											<label>Set Of Family: </label><select name="setOfFamily">
												<option value="EMPLOYEE_SPOUSE_CHILDREN"
													<c:if test = "${preference.getSetOfFamily() =='EMPLOYEE_SPOUSE_CHILDREN'}">selected</c:if>>EMPLOYEE_SPOUSE_CHILDREN
												</option>
												<option value="EMPLOYEE_DEPENDANT_PARENTS"
													<c:if test = "${preference.getSetOfFamily() =='EMPLOYEE_DEPENDANT_PARENTS'}">selected</c:if>>EMPLOYEE_DEPENDANT_PARENTS
												</option>
												<option value="EMPLOYEE_SPOUSE"
													<c:if test = "${preference.getSetOfFamily() =='EMPLOYEE_SPOUSE'}">selected</c:if>>EMPLOYEE_SPOUSE
												</option>
												<option value="EMPLOYEE"
													<c:if test = "${preference.getSetOfFamily() =='EMPLOYEE'}">selected</c:if>>EMPLOYEE</option>
											</select>
										</p>
										<p>
											<label>Total Family Count: </label><input type="text"
												name="totalFamilyCount"
												value="${preference.getTotalCount()}" required minlength=1
												maxlength=1 pattern="\d*" />
										</p>
										<div class="modal-footer d-flex justify-content-center">
											<button class="btn btn-unique" name="action"
												value="updateprefrences">
												Send <i class="fa fa-paper-plane-o ml-1"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</form>
						<div class="text-right">
							<a href="" class="btn btn-default btn-rounded mb-4"
								data-toggle="modal" data-target="#modalContactForm2">update
								Preferences</a>
						</div>

						<table class="table table-bordered">
							<tr class="active">
								<td>Batch</td>
								<td>${preference.getPicnicBatch()}</td>

							</tr>
							<tr class="active">

								<td>Going Mode Travel</td>
								<td>${preference.getModeOfTravelOnward()}</td>
							</tr>
							<tr class="active">
								<td>Coming Mode Travel</td>
								<td>${preference.getModeOfTravelReturn()}</td>
							</tr>
							<tr class="active">
								<td>Gender</td>
								<td>${preference.getGender()}</td>
							</tr>
							<tr class="active">
								<td>Set of family</td>
								<td>${preference.getSetOfFamily()}</td>
							</tr>
							<tr class="active">
								<td>Count</td>
								<td>${preference.getTotalCount()}</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>



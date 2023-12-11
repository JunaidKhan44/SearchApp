<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link href="<c:url  value="/resources/css/style.css" />"
	rel="stylesheet">
<script src="<c:url  value="/resources/js/script.js" />"
	type="text/javascript">


<title>Student Info</title>
</head>
<body>

<div>

<img src="<c:url value='/resources/images/myimage.jpg'/>"/>
</div>

<div class="container d-flex justify-content-center">
	<div class="card m-5 p-5 rounded-sm " style="width: 70% !important;">
		<h1 class="text-center">Student Info</h1>
		<div class="alert alert-danger" role="alert">
		
			<form:errors path="student.*"/>
		
		</div>
		<form action="processform" method="post">
			<div class="form-group">
				<label for="Name">Name</label> <input type="text"
					class="form-control" id="name" placeholder="Name" name="name" />
			</div>
			<div class="form-group">
				<label for="Email1">Email</label> <input type="email"
					class="form-control" id="Email" placeholder="Email" name="email">
			</div>

			<div class="form-group">
				<label for="dob">DOB</label> <input type="text" class="form-control"
					name="date" id="date" placeholder="dd/mm/yyyy">
			</div>

			<div class="form-group">
				<label for="exampleFormControlSelect2">Select Courses </label> <select
					name="courses" multiple class="form-control"
					id="exampleFormControlSelect">
					<option>Java</option>
					<option>C#</option>
					<option>Python</option>
					<option>Kotlin</option>
					<option>Java Script</option>
				</select>
			</div>

			<div class="form-group">
				<label for="Inputselect">Student</label> <select
					class="form-control" id="dropDown" name="studentType">
					<option>Old Student</option>
					<option>New Student</option>
					<option>Alumni Student</option>
				</select>
			</div>


			<div class="card" style="display: none;">
				<div class="card-body">
					<p>Address Section</p>
					<div class="form-group">
						<label for="Address">Street No</label> <input type="text"
							class="form-control" id="Address" name="address.street">
					</div>

					<div class="form-group">
						<label for="city">City</label> <input type="text"
							class="form-control" id="city" name="address.city">
					</div>

				</div>
			</div>

			<div class="form-group">
				<label for=" Email1msg">Message:</label>
				<!-- add text area here -->

			</div>
			<div class="checkbox">
				<label> <input type="checkbox" id="yesno" name="status">
					Yes / No
				</label>
			</div>

			<button type="submit" class="btn btn-info">Submit
				Information</button>
		</form>
	</div>

</div>

</body>
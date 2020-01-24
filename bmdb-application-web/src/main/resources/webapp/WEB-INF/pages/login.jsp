<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>BMDB</title>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
<link rel="stylesheet" type="text/css" href="assets/css/login.css" />
<link rel="stylesheet" type="text/css" href="assets/css/custom.css" />
</head>
<body>
	<form>
		<div class="p-3 mb-2 bg-dark text-white">
			<h1 class="text-center">Welcome to BMDB!</h1>
			<p class="text-center">${com.epam.training.bettingDefinition}</p>
		</div>
	</form>

	<div class="margin-all">
		<div>
			<h2>
				<a href="#">Login</a> or <a href="#">Register</a> to start!
			</h2>
		</div>

		<div class="card border-primary card-custom-width">
			<div class="card-header bg-primary text-white">Login</div>
			<div class="card-body">
				<form:form modelAttribute="loginRequest"
					action="home">
					<div class="form-group input-width">
						<form:input path="username" cssClass="form-control"
							id="username" placeholder="Username" />
					</div>
					<div class="form-group input-width">
						<form:password path="password" cssClass="form-control"
							id="password" placeholder="Password"  />
					</div>
					<p>
						<button type="submit" class="btn btn-primary">Login</button>
					</p>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>

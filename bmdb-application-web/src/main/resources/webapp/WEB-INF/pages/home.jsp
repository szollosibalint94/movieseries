<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>SportsBet</title>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
</head>
<body>
	<!--JavaScripts-->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<!--NavBar-->
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
		<span class="navbar-brand mb-0 h1">SportsBetting</span>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="events">Events</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Language </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<c:forEach var="language" items="${languageSelector.languages}">
							<a href="">${language}</a>
						</c:forEach>
					</div></li>
			</ul>
			<form class="form-inline my-2 my-lg-0"
				action="j_spring_security_logout">
				<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</div>
	</nav>

	<!--Account details-->
	<div class="card text-primary border-primary">
		<div class="card-header bg-primary text-white">Account details</div>
		<div class="card-body">
			<form:form modelAttribute="playerModel" action="savePlayer">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Name</span>
					</div>
					<form:input path="name" id="txtName" type="text"
						class="form-control" aria-describedby="basic-addon1" />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Date of
							birth</span>
					</div>
					<form:input path="dateOfBirth" id="txtDateOfBirth" type="text"
						class="form-control" aria-describedby="basic-addon1" />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Account
							number</span>
					</div>
					<form:input path="accountNumber" id="txtAcoountNumber" type="text"
						class="form-control" aria-describedby="basic-addon1" />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Currency</span>
					</div>
					<form:input path="currency" id="txtCurrency" type="text"
						class="form-control" aria-describedby="basic-addon1" />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Balance</span>
					</div>
					<form:input path="balance" id="txtBalance" type="text"
						class="form-control" aria-describedby="basic-addon1" />
				</div>
				<form:button type="submit" class="btn btn-primary">Save</form:button>
			</form:form>
		</div>
	</div>

	<!--Wagers-->
	<div class="card border-primary">
		<div class="card-header bg-primary text-white">Wagers</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table" id="tblWagers">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">#</th>
							<th scope="col">Event title</th>
							<th scope="col">Event type</th>
							<th scope="col">Bet type</th>
							<th scope="col">Outcome value</th>
							<th scope="col">Outcome odd</th>
							<th scope="col">Wager amount</th>
							<th scope="col">Winner</th>
							<th scope="col">Processed</th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="wager" items="${listWagerModel.wagerViews}">
							<tr>
								<td></td>
								<td>${wager.id}</td>
								<td>${wager.title}</td>
								<td>${wager.eventType}</td>
								<td>${wager.type}</td>
								<td>${wager.outcomeValue}</td>
								<td>${wager.outcomeOdd}</td>
								<td>${wager.wagerAmount}</td>
								<td>${wager.winner}</td>
								<td>${wager.processed}</td>
								<td><form action="removeWager">
										<input type="hidden" name="id" value="${wager.id}"></input>
										<button type="submit" class="btn btn-primary">Remove</button>
									</form></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

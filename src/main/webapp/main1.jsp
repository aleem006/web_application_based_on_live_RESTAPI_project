<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.webAppProject.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vessels and Certificate</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
#mainTable {
	margin-left: 2%;
	margin-right: 2%;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="#" class="navbar-brand">Vessels and Certificate</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<table class="table table-bordered" id="mainTable">
			<thead>
				<tr>
					<th>Name Of Vessel</th>
					<th>Member</th>
					<th>Flag</th>
					<th>GT</th>
					<th>IMO</th>
					<th>Year Built</th>
					<th>View Certificate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vessel" items="${vesselList }">
					<tr>
						<td>${vessel.vesselName}</td>
						<td>${vessel.member}</td>
						<td>${vessel.flagDescription}</td>
						<td>${vessel.grossTonnage}</td>
						<td>${vessel.imo}</td>
						<td>${vessel.builtYear}</td>
						<td><a class="btn btn-secondary btn-small navbar-btn"
							href="viewCertificate?imo=<c:out value='${vessel.imo}'/>&vesselType=<c:out value='${vessel.vesselType}'/>&note=<c:out value='${vessel.note}'/>">View
								Certificate</a> &nbsp;&nbsp;&nbsp;&nbsp;
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
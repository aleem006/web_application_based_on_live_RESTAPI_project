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
#mainTable, h2, card-body {
	margin-left: 2%;
	margin-right: 2%;
}

h2 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="navbar navbar-dark navbar-fixed-top"
		style="background-color: black">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Vessels and Certificate</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<div class="btn-nav">
					<a class="btn btn-secondary btn-small navbar-btn"
						style="width: 100px" href="<%=request.getContextPath()%>/">Back</a>
				</div>
			</li>
		</ul>
	</div>

	<div class="card">
		<div class="card-body">
			<dl class="row">
				<dt class="col-sm-3">Vessel Name</dt>
				<dd class="col-sm-9">${vessel.vesselName}</dd>

				<dt class="col-sm-3">Note</dt>
				<dd class="col-sm-9">${note1}</dd>

				<dt class="col-sm-3">Member</dt>
				<dd class="col-sm-9">${vessel.member}</dd>

				<dt class="col-sm-3">Imo</dt>
				<dd class="col-sm-9">${vessel.imo}</dd>

				<dt class="col-sm-3">Built Year</dt>
				<dd class="col-sm-9">${vessel.builtYear}</dd>

				<dt class="col-sm-3">Gross Tonnage</dt>
				<dd class="col-sm-9">${vessel.grossTonnage}</dd>

				<dt class="col-sm-3">Vessel Type</dt>
				<dd class="col-sm-9">${vessel.vesselType}</dd>

				<dt class="col-sm-3">Flag Description</dt>
				<dd class="col-sm-9">${vessel.flagDescription}</dd>

				<dt class="col-sm-3">Business Unit</dt>
				<dd class="col-sm-9">${vessel.businessUnit}</dd>

				<dt class="col-sm-3">Current Reg Owner</dt>
				<dd class="col-sm-9">${vessel.currentRegOwner}</dd>
			</dl>
		</div>
	</div>

	<h2>Certificate List</h2>

	<div class="row">
		<table class="table table-bordered" id="mainTable">
			<thead>
				<tr>
					<th>Certificate</th>
					<th>Certificate Type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cert" items="${certificateList }">
					<tr>
						<td>${cert.certificate}</td>
						<td>${cert.certificateType}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
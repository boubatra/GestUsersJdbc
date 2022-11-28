<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<link rel="stylesheet" href="<c:url value="/css/design.css"/>">
<script src="<c:url value="/js/script.js"/>"></script>
</head>
<body>
	<%
	String login = request.getParameter("login");
	%>

	<div id="box" style="margin-top: 150px;">
		<c:if test="${message==true}">
			<p style="color: #E15409;">Login et ou mot de passe Incorrecte !</p>
		</c:if>
		<form method="post" action="login">
			<div
				style="font-size: 20px; margin: 10px; color: #E2B842; font-family: sans-serif;">Veuillez
				entrer vos informations</div>

			<input id="text" type="text" name="login"
				placeholder="Entrez votre Email"
				><br> <br>
			<input id="text" type="password" name="password"
				placeholder="Entrez votre mot de passe"><br> <br>
			<input id="button" type="submit" value="Login"><br> <br>
		</form>
	</div>
	<%@include file="inc/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Utilisateur</title>
<link rel="stylesheet" href ="<c:url value="/css/design.css"/>">
<script src="<c:url value="/js/script.js"/>"></script>
</head>
<body>
	<div id="entete">GESTION DES UTILISATEURS</div>
	<div id="menu">
		<ul>
			<li><a href ="<c:url value="/"/>">ACCUEIL</a></li>
			<li><a href ="<c:url value="/list"/>">LISTER</a></li>
			<li><a href ="<c:url value="/add"/>">AJOUTER</a></li>
			<li><a href ="<c:url value="/logout"/>">DECONNEXION</a></li>
		</ul>
		
	</div>
	
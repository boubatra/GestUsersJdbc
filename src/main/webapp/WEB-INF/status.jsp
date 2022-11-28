	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>erreur</title>
<link rel="stylesheet" href ="<c:url value="/css/design.css"/>">
<script src="<c:url value="/js/script.js"/>"></script>
</head>
<body>
	<%
		String username =request.getParameter("username");
		String messageRecu = (String)(request.getAttribute("message")) ;
	%>
	<p>Wait <%= messageRecu %> <% out.print("<a href ="+ request.getContextPath() + "/login?username="+  username + "> Ressayer </a>"); %></p>
	<%@include file="inc/footer.jsp" %>	
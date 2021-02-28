<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des personnes : ${fn:length(liste)}</h1>
	
	<ul>
		<c:forEach items="${liste}" var="p">
			<li>${p.id } : ${p.prenom } ${p.nom } a ${p.age } ans </li>
		
		</c:forEach>
	</ul>
	
	<h2>Ajout</h2>
	
	<form action="ajout" method="post">
	
		<p>Nom : <input name = "nom"></p>
		<p>Prenom : <input name = "prenom"></p>
		<p>Age : <input name = "age"></p>
		<p><button>Ajout</button></p>
	</form>
</body>
</html>
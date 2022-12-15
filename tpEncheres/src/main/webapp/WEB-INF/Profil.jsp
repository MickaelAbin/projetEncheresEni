<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>    
</head>
<body>
	<h1>Profil</h1>
	<c:if test="${!empty sessionScope.utilisateur }"></c:if>
	<p> Pseudo : ${utilisateur.pseudo } </p>
	<p> Nom : ${nom.utilisateur } </p>
	<p> Prenom : ${prenom.utilisateur } </p>
	<p> Email : ${email.utilisateur } </p>
	<p> Telephone : ${telephone.utilisateur } </p>
	<p> Rue : ${rue.utilisateur } </p>
	<p> Code Postal : ${codePostal.utilisateur } </p>
	<p> Ville : ${ville.utilisateur } </p>
	<a href="/Connexion">Retour</a>
</body>
</html>
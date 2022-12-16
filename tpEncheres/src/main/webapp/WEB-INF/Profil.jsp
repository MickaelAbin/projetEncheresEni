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
	<p> Nom : ${utilisateur.nom } </p>
	<p> Prenom : ${utilisateur.prenom } </p>
	<p> Email : ${utilisateur.email } </p>
	<p> Telephone : ${utilisateur.telephone } </p>
	<p> Rue : ${utilisateur.rue } </p>
	<p> Code Postal : ${utilisateur.codePostal } </p>
	<p> Ville : ${utilisateur.ville } </p>
	<a href="/tpEncheres/NouvelleVente">Retour</a>
</body>
</html>
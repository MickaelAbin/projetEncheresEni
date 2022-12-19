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
	<%@ include file="Header.jsp"%>
	
	<fieldset>
	
		<legend><h2>Profil</h2></legend>
		
		
		<c:if test="${!empty sessionScope.utilisateurConnecte }"></c:if>
		<p> Pseudo : ${utilisateurConnecte.pseudo } </p>
		<p> Nom : ${utilisateurConnecte.nom } </p>
		<p> Prenom : ${utilisateurConnecte.prenom } </p>
		<p> Email : ${utilisateurConnecte.email } </p>
		<p> Telephone : ${utilisateurConnecte.telephone } </p>
		<p> Rue : ${utilisateurConnecte.rue } </p>
		<p> Code Postal : ${utilisateurConnecte.codePostal } </p>
		<p> Ville : ${utilisateurConnecte.ville } </p>
		<a href="/tpEncheres/Accueil">Accueil</a>
		<a href="/tpEncheres/ServletModifierProfil">Modifier</a>
		
		
	</fieldset>

</body>
</html>
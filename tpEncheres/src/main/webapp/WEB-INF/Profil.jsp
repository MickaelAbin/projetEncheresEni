<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./css/Profil.css" rel="stylesheet" type="text/css">
    <title>Profile Page</title>    
</head>
<body>
	<%@ include file="Header.jsp"%>
	
	<aside>
    	<img src="./images/backgroundTPencheres .jpg" alt="background">
    </aside>
	
		<h2>Profil</h2>
		
		<div class="liste">
		<c:if test="${!empty sessionScope.utilisateurConnecte }"></c:if>
		<p> Pseudo : ${utilisateurConnecte.pseudo } </p>
		<p> Nom : ${utilisateurConnecte.nom } </p>
		<p> Prenom : ${utilisateurConnecte.prenom } </p>
		<p> Email : ${utilisateurConnecte.email } </p>
		<p> Telephone : ${utilisateurConnecte.telephone } </p>
		<p> Rue : ${utilisateurConnecte.rue } </p>
		<p> Code Postal : ${utilisateurConnecte.codePostal } </p>
		<p> Ville : ${utilisateurConnecte.ville } </p>
		<a href="/tpEncheres/ServletModifierProfil">Modifier</a>
		<a href="/tpEncheres/ServletValiderSupression">Supprimer</a>
		</div>
		
	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>accueil</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<c:if test="${!empty test}">
		<div> Message : ${requestScope.test.pseudo}</div>
		<p>pseudo : ${sessionScope.utilisateurConnecte.pseudo}</p>
		<p>test du session : ${sessionScope.testUtilisateur.pseudo }</p>
	</c:if>
    	<a href="/tpEncheres/MonProfil">S'inscrire</a>
    	<a href="/tpEncheres/Connexion">Se connecter</a>
    	<a href="/tpEncheres/ServletsProfil">Mon profil</a>
    	<a href="/tpEncheres/NouvelleVente">Nouvelle vente</a>
</body>
</html>
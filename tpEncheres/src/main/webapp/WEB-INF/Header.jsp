<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<link href="./css/Header.css" rel="stylesheet" type="text/css">
<header>
  
	<h2><a href="<%=request.getContextPath()%>/Accueil">ENI-Enchères</a></h2>
	<div>
		<c:if test="${!empty utilisateurConnecte}">
			<a href="<%=request.getContextPath()%>/MonProfil">Mon profil</a>
    		<a href="<%=request.getContextPath()%>/NouvelleVente">Nouvelle vente</a>
    		<a href="<%=request.getContextPath()%>/Deconnexion">Se déconnecter</a>
		</c:if>
		
		<c:if test="${empty utilisateurConnecte}">	
			<a href="<%=request.getContextPath()%>/Inscription">S'inscrire</a>
    		<a href="<%=request.getContextPath()%>/Connexion">Se connecter</a>
		</c:if>
    	
	</div>
		
</header>
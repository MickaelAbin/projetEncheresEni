<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<link href="./css/Header.css" rel="stylesheet" type="text/css">
<header>
<!--  
	<h1><a href="<%=request.getContextPath()%>/Accueil">ENI-Enchères</a></h1>
	<div>
		<c:if test="${!empty utilisateurConnecte}">
			<a href="<%=request.getContextPath()%>/MonProfil">Mon profil</a>
    		<a href="<%=request.getContextPath()%>/NouvelleVente">Nouvelle vente</a>
    		<a href="<%=request.getContextPath()%>/Deconnexion">Se déconnecter</a>
		</c:if>
		
		<c:if test="${empty utilisateurConnecte}">	
			<a href="<%=request.getContextPath()%>/Inscription">S'inscrire"</a>
    		<a href="<%=request.getContextPath()%>/Connexion">Se connecter</a>
		</c:if>
    	
	</div>
		-->

  	<input class="menu-icon" type="checkbox" id="menu-icon" name="menu-icon"/>
  	<label for="menu-icon"></label>
  	<nav class="nav"> 	
  	<c:if test="${!empty sessionScope.utilisateurConnecte }"></c:if>	
  		<ul class="pt-5">
  		    <li><a href="<%=request.getContextPath()%>/Accueil">Accueil</a></li>
  			<li><a href="<%=request.getContextPath()%>/MonProfil">Mon profil</a></li>
  			<li><a href="<%=request.getContextPath()%>/NouvelleVente">Nouvelle vente</a></li>
  			<li><a href="<%=request.getContextPath()%>/Inscription">S'inscrire</a></li>
  			<li><a href="<%=request.getContextPath()%>/Connexion">Se connecter</a></li>
  			<li><a href="<%=request.getContextPath()%>/Deconnexion">Se déconnecter</a></li>
  		</ul>
  		
  	</nav> 
</header>
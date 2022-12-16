<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<h1>ENI-Enchères</h1>
	<div>
		<c:if test="${!empty utilisateurConnecte}">
			<a href="/tpEncheres/ServletsProfil">Mon profil</a>
    		<a href="/tpEncheres/NouvelleVente">Nouvelle vente</a>
    		<input type="button" action="<%=request.getContextPath()%>/Deconnexion"  method="POST" value="Se déconnecter">
		</c:if>
		
		<c:if test="${empty utilisateurConnecte}">
			<a href="/tpEncheres/MonProfil">S'inscrire</a>
    		<a href="/tpEncheres/Connexion">Se connecter</a>
		</c:if>
    	
	</div>
</header>
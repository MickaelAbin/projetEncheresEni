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
	
<link href="./css/StyleAccueil.css" rel="stylesheet" type="text/css">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>accueil</title>
</head>

<body>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	
	<main>
		<h2 class="sousTitre">Liste des enchères</h2>
		<form action="<%=request.getContextPath()%>/Accueil"  method="POST">
			<h3>Filtres :</h3>
			
			<div>
				<input type="search" placeholder="Le nom de l'article contient">
			</div>
			
			<div>
				<label for="categorie">Categorie:</label>
		
				<select name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
				    <c:forEach var="cat" items="${sessionScope.listeCategories}">
						<option value="${cat.noCategorie }" ${cat.noCategorie == rechercheCategorie ? 'selected="selected"' : ''}>
							<c:out value="${cat.libelle}"/>
						</option>
					</c:forEach>
				</select>
				
				<div>${testCat}</div>
			</div>
			
			<c:if test="${!empty utilisateurConnecte}">
				<div>
					<input type="radio" name="filtre" value="achats" checked="checked"/>Achats
					
					<input type="checkbox" name="filtreAchats" value="encheresOuvertes" checked="checked">enchère ouverte
					<input type="checkbox" name="filtreAchats" value="encheresEnCours">mes enchères en cours
					<input type="checkbox" name="filtreAchats" value="encheresRemportees">mes enchères remportées
				</div>
				
				<div>
					<input type="radio" name="filtre" value="mesVentes" ${filtreAchatVente == 'ventes' ? 'checked="checked"' : ''}/>Mes ventes
					
					<input type="checkbox" name="filtreVentes" value="ventesEnCours">mes ventes en cours
					<input type="checkbox" name="filtreVentes" value="ventesNonDebutees">ventes non débutées
					<input type="checkbox" name="filtreVentes" value="ventesTerminees">ventes terminées
				</div>
				
			</c:if>
			
			<input type="submit" name="connexion" value="Rechercher"/>
		</form>
	    
	    <div style="width: 90%;display: flex; flex-wrap: wrap;
	flex-direction: row;
	justify-content: center">
	    	<c:if test="${empty listeArticles }">listes articles vide</c:if>
			<c:forEach var="articleVente" items="${sessionScope.listeArticles }" >
				<div style= "border: 1px solid black; background-color: lightgray; width: 40%; margin:10px; align-self: center;" classe="article">
	 
		  			<img src="./images/test.png" alt="Description de l'image" width="200" height="200" border="0">
		  
		  			<div>
			  			<a href="<%=request.getContextPath() %>/ServletDetailVente?id=${articleVente.nombreArticle }"><h3>${articleVente.nomArticle }</h3> </a>
						<div>Prix : ${articleVente.prixVente }  points</div>
						<div>Fin de l'enchère : ${articleVente.dateFinEncheres }</div>
						<div>Vendeur : ${articleVente.vendeur.pseudo }</div>
				
				
					</div>
				</div>
				<br>
				<br>
				
			</c:forEach>
	    </div>	
		
	</main>
	

	
	
	
    	

</body>
</html>
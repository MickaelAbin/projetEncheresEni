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
	
<link href="${pageContext.request.contextPath}/css/StyleAccueil.css" rel="stylesheet" type="text/css">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>accueil</title>
</head>

<body>
	<%@ include file="Header.jsp"%>
	
	<h2 class="sousTitre">Liste des enchères</h2>
	<form action="<%=request.getContextPath()%>/Accueil"  method="POST">
		<h3>Filtres :</h3>
		
		<div>
			<input type="search" placeholder="Le nom de l'article contient">
		</div>
		
		<div>
			<label for="categorie">Categorie:</label>
	
			<select name="categorie" id="categorie">
				<option>Toutes</option>
			    <c:forEach var="cat" items="${sessionScope.listeCategories}">
					<option value="${cat.noCategorie }"><c:out value="${cat.libelle}"/></option>
				</c:forEach>
			</select>
		</div>
		<c:if test="${!empty utilisateurConnecte}">
			<div>
				<input type="radio" name="achats" value="Achats"/>
				
				<input type="checkbox" name="encheresOuvertes" value="enchères ouvertes">
				<input type="checkbox" name="encheresEnCours" value="mes enchères en cours">
				<input type="checkbox" name="encheresRemportees" value="mes enchères remportées">
			</div>
			
			<div>
				<input type="radio" name="mesVentes" value="Mes ventes"/>
				
				<input type="checkbox" name="ventesEnCours" value="mes ventes en cours">
				<input type="checkbox" name="ventesNonDebutees" value="ventes non débutées">
				<input type="checkbox" name="ventesTerminees" value="ventes terminées">
			</div>
			
			
		</c:if>
		<input type="submit" name="connexion" value="Rechercher"/>
	</form>
    	
    <div class="d-grid gap-4 col-3 mx-auto">
		<button class="btn btn-primary" type="button">Button</button>
	</div>







<!-- Example single danger button -->
<div class="btn-group">
  <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
    Action
  </button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">Action</a></li>
    <li><a class="dropdown-item" href="#">Another action</a></li>
    <li><a class="dropdown-item" href="#">Something else here</a></li>
    <li><hr class="dropdown-divider"></li>
    <li><a class="dropdown-item" href="#">Separated link</a></li>
  </ul>
</div>

<nav class="navbar navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">ENI-ENCHERES</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Dark offcanvas</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Dropdown
            </a>
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex mt-3" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-success" type="submit">Search</button>
        </form>
      </div>
    </div>
  </div>
</nav>

=======
	
	<div>ici se trouve l'accueil</div>
	

	
	
	
	
		<c:forEach var="articleVente" items="${listeArticles }">
			<div style= "border: 1px solid black; 
  background-color: lightgray">
 
  			<img src="./images/test.png" alt="Description de l'image" width="200" height="200" border="0">
  
  			<div>
			<h3>${articleVente.nomArticle }</h3> 
			<div>Prix : ${articleVente.prixInitial }  points</div>
			<div>Fin de l'enchère : ${articleVente.dateFinEncheres }</div>
			<div>Vendeur : ${articleVente.vendeur.pseudo }</div>
			
			</div>
			</div>
	<br>
			<br>
		</c:forEach>

	
	
	
    	
>>>>>>> branch 'main' of https://github.com/AntoineTurmeau/tpEncheres.git
</body>
</html>
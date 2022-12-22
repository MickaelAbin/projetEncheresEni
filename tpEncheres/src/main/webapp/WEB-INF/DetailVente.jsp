<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%@ include file="Header.jsp"%>
	
	<h2>Détail vente</h2>

	
	
	
	
		
			<div style= "border: 1px solid black; 
  background-color: lightgray">
 
  			<img src="./images/test.png" alt="Description de l'image" width="400" height="400" border="0">
  
  			<div>
			<div> ${article.nomArticle }</div>
			<div> ${article.description }</div>
			<div>Prix : ${article.prixVente }  points</div>
			<div>Fin de l'enchère : ${article.dateFinEncheres }</div>
			<div>Retrait : ${article.retrait.rue } </div>
			<div>${article.retrait.codePostal }  ${article.retrait.ville }</div>
			<div>Vendeur : ${article.vendeur.pseudo }</div>
			<div></div>
		
			<form action="<%=request.getContextPath()%>/ServletNouvelleEnchere" method="POST">
				<input id="prodId" name="IdArticle" type="hidden" value="${article.nombreArticle }">
			
				<label for="tentacles">Ma Proposition:</label> <input type="number"
					name="PRIX" step="5" min="${article.prixVente+1 }" max="1000"> 
				<c:if test="${!empty utilisateurConnecte }"><input type="submit" value="Enchérir"></c:if>
				<c:if test="${empty utilisateurConnecte }"><p style="color:red">Vous devez etre connecté pour pouvoir encherir</p></c:if>
				<c:if test="${!empty erreurCredit}">${erreurCredit}</c:if>
			</form>
		
			</div>
			</div>
	<br>
			<br>
	
	
	
</body>
</html>
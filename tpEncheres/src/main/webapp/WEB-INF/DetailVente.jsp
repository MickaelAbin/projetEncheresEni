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
			<div>Prix : ${article.prixInitial }  points</div>
			<div>Fin de l'enchère : ${article.dateFinEncheres }</div>
			<div>Retrait : ${article.retrait.rue } </div>
			<div>${article.retrait.codePostal }  ${article.retrait.ville }</div>
			<div>Vendeur : ${article.vendeur.pseudo }</div>
			<div></div>
		
			<form action="<%=request.getContextPath()%>/ServletNouvelleEnchere" method="POST">
			<input id="prodId" name="IdArticle" type="hidden" value="${article.nombreArticle }">
			
				<label for="tentacles">Ma Proposition:</label> <input type="number"
			name="PRIX" step="5" min="0" max="1000"> 
			<input type="submit" value="Enchérir">
			</form>
		
			</div>
			</div>
	<br>
			<br>
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<form action="<%=request.getContextPath()%>/ServletNouvelleVente"  method="POST">
		Article : <input type="text" name="article"> <br> <br>

		Description :
		<textarea name="description" rows="5" cols="33">
	</textarea>
		<br> <br> Catégorie :
		<div class="dropdown">
			<button class="btn btn-secondary dropdown-toggle" type="button" name="categorie"
				data-bs-toggle="dropdown" aria-expanded="false">Categorie</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="#">Maison</a></li>
				<li><a class="dropdown-item" href="#">Jardin</a></li>
				<li><a class="dropdown-item" href="#">Informatique</a></li>
			</ul>
		</div>
		<br> <br> photo de l'article : <input type="file"
			name="phtoto" accept="image/png, image/jpeg"> <br> <br>
		<label for="tentacles">Mise à prix:</label> <input type="number"
			name="PRIX" step="5" min="0" max="1000"> <br> <br>

		Début de l'enchère : <input type="date" name="dateDebut"
			value="2022-07-22" min="2018-01-01" max="2018-12-31"> <br>
		<br> Fin de l'enchère : <input type="date" name="dateFin"
			value="2022-07-22" min="2018-01-01" max="2018-12-31"> <br>
		<br>
		<fieldset>
			<legend>
				<h2>Retrait</h2>
			</legend>
			<table>
				<tr>
					<td><label for="rue">Rue : </label></td>
					<td><input type="text" name="rue" id="rue" /> <br /></td>
				</tr>

				<tr>
					<td><label for="nom">Code postal : </label></td>
					<td><input type="number" name="codePostal" /> <br /></td>
				</tr>
				<tr>
					<td><label for="ville">Ville : </label></td>
					<td><input type="text" name="ville" id="ville" /> <br /></td>
				</tr>





				<tr>
					<td><input type="submit" value="Enregistrer"></td>
					<td><input type="reset" value="Annuler"></td>
					<td><input type="reset" value="Annuler la vente"></td>
				</tr>
			</table>
		</fieldset>

	</form>

	</div>
</body>
</html>
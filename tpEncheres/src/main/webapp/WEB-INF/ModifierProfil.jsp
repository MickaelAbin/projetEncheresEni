<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modifier Mon Profil</title>
</head>
<body>
   <%@ include file="Header.jsp"%>

	<fieldset>
	
		<legend><h2>Modifier Mon Profil</h2></legend>

		<form  action="<%=request.getContextPath()%>/ServletModifierProfil"  method="POST" >
		    <div>
			    <label for="pseudo">Pseudo : </label>
				<input type="text" name="pseudo" id="pseudo" value=${utilisateurConnecte.pseudo }>
		    </div>
		    
			<br />
			<br />
			
			<div>
			    <label for="nom">Nom : </label>
				<input type="text" name="nom" id="nom" value=${utilisateurConnecte.nom }>
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="prenom">Prenom : </label>
				<input type="text" name="prenom" id="prenom" value=${utilisateurConnecte.prenom } />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="email">Email : </label>
				<input type="text" name="email" id="email" value=${utilisateurConnecte.email } required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="telephone">Telephone : </label>
				<input type="text" name="telephone" id="telephone" value=${utilisateurConnecte.telephone } required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="rue">Rue : </label>
				<input type="text" name="rue" id="rue" value=${utilisateurConnecte.rue } required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="codePostal">Code Postal : </label>
				<input type="text" name="codePostal" id="codePostal" value=${utilisateurConnecte.codePostal } required />
		    </div>
			
			<br />
			<br />
			
			<div>
		    	<label for="ville">Ville : </label>
				<input type="text" name="ville" id="ville" value=${utilisateurConnecte.ville } required />
		    </div>
			
			<br />
			<br />
			
			<div>	
				<label for="motDePasse">Mot de passe : </label>
				<input type="password" name="motDePasse" id="motDePasse" value=${utilisateurConnecte.motDePasse }required />
		    </div>
			
			<br />
			<br />
			
			<div>
		    	<label for="remotDePasse">Confirmation : </label>
				<input type="password" name="remotDePasse" id="remotDePasse" value=${utilisateurConnecte.motDePasse } required />
			
		    </div>
		    
			<br />
			<br />
			
			
			<div>
		    	<input type="submit" name="envoyer" />
				<input type="reset" value="Annuler">
		    </div>
				
		</form>
	</fieldset>


</body>
</html>
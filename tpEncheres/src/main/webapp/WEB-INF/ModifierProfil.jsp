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
			    <label for="nom">Pseudo : </label>
				<input type="text" name="pseudo" id="pseudo" required />
		    </div>
		    
			<br />
			<br />
			
			<div>
			    <label for="nom">Nom : </label>
				<input type="text" name="nom" id="nom" required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="nom">Prenom : </label>
				<input type="text" name="prenom" id="prenom" required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="nom">Email : </label>
				<input type="text" name="email" id="email" required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="nom">Telephone : </label>
				<input type="text" name="telephone" id="telephone" required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="nom">Rue : </label>
				<input type="text" name="rue" id="rue" required />
		    </div>
			
			<br />
			<br />
			
			<div>
			    <label for="nom">Code Postal : </label>
				<input type="text" name="codePostal" id="codePostal" required />
		    </div>
			
			<br />
			<br />
			
			<div>
		    	<label for="nom">Ville : </label>
				<input type="text" name="ville" id="ville" required />
		    </div>
			
			<br />
			<br />
			
			<div>	
				<label for="nom">Mot de passe : </label>
				<input type="password" name="motDePasse" id="motDePasse" required />
		    </div>
			
			<br />
			<br />
			
			<div>
		    	<label for="nom">Confirmation : </label>
				<input type="password" name="remotDePasse" id="remotDePasse" required />
			
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
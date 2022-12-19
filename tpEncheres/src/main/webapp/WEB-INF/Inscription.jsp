<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<fieldset>
	
		<legend>Inscription</legend>

		<form  action="<%=request.getContextPath()%>/Inscription"  method="POST" >
		    <div>
			    <label for="nom">Pseudo : </label>
				<input type="text" name="pseudo" id="pseudo" required />
		    </div>
		    
			<br />
			<br />
			
			<div class="position-absolute top-50 start-50 translate-middle">
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
				<input type="text" name="email" id="email" value="courriel@exemple.com" required />
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
		    	<input type="submit" name="creer" />
				<input type="reset" value="Annuler">
		    </div>
				
		</form>
	</fieldset>

</body>
</html>
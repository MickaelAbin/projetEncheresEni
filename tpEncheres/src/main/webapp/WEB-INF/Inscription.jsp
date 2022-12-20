<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/Inscription.css" rel="stylesheet" type="text/css">
<title>Inscription</title>
</head>
<body>

	<%@ include file="Header.jsp"%>


		<h2>Inscription</h2>

		<form  action="<%=request.getContextPath()%>/Inscription"  method="POST" >
		    <div>			
				<input type="text" name="pseudo" id="pseudo" placeholder="Pseudo" required />
		    </div>
		    
			<br />
			<br />
			
			<div>
				<input type="text" name="nom" id="nom" placeholder="Nom" required />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="prenom" id="prenom" placeholder="Prenom"  required />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="email" id="email" placeholder="exemple@.com"  required />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="telephone" id="telephone" placeholder="Tel mobile" required />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="rue" id="rue" placeholder="Rue"  required />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="codePostal" id="codePostal" placeholder="Code Postal" required />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="ville" id="ville" placeholder="Ville" required />
		    </div>
			
			<br />
			<br />
			
			<div>	
				<input type="password" name="motDePasse" id="motDePasse" placeholder="Mot de Passe" required />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="password" name="remotDePasse" id="remotDePasse" placeholder="Confirmation" required />
			
		    </div>
		    
			<br />
			<br />
			
			<div>
		    	<input type="submit" name="creer" />
				<input type="reset" value="Annuler">
		    </div>
				
		</form>
	

</body>
</html>
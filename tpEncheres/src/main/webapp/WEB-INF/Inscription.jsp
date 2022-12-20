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

	<%@ include file="Header.jsp" %>
	<aside>
    	<img src="./images/backgroundTPencheres .jpg" alt="background">
    </aside>


		<h2>Inscription</h2>

		<form  action="<%=request.getContextPath()%>/Inscription"  method="POST" >
		    <div>			
				<input type="text" name="pseudo" id="pseudo" placeholder="Pseudo" required class="liste1"/>
		    </div>
		    
			<br />
			<br />
			
			<div>
				<input type="text" name="nom" id="nom" placeholder="Nom" required class="liste1" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="prenom" id="prenom" placeholder="Prenom"  required class="liste1"/>
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="email" id="email" placeholder="exemple@.com"  required class="liste1"/>
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="telephone" id="telephone" placeholder="Tel mobile" required class="liste1"/>
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="rue" id="rue" placeholder="Rue"  required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="codePostal" id="codePostal" placeholder="Code Postal" required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="ville" id="ville" placeholder="Ville" required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>	
				<input type="password" name="motDePasse" id="motDePasse" placeholder="Mot de Passe" required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="password" name="remotDePasse" id="remotDePasse" placeholder="Confirmation" required class="liste2" />
			
		    </div>
		    
			<br />
			<br />
			
			<div>
		    	<input type="submit" name="creer" class="bt1"/>
				<input type="reset" value="Annuler" class="bt2">
		    </div>
				
		</form>
	

</body>
</html>
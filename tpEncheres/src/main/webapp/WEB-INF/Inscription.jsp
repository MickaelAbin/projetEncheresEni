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
	


		<h2>Inscription</h2>

		<form  action="<%=request.getContextPath()%>/Inscription"  method="POST" >
		    <div>			
				<input type="text" name="pseudo" id="pseudo" placeholder="Pseudo" value="${requestScope.pseudo }" required class="liste1"/>
		    </div>
		    
			<br />
			<br />
			
			<div>
				<input type="text" name="nom" id="nom" placeholder="Nom" value="${requestScope.nom }" required class="liste1" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="prenom" id="prenom" placeholder="Prenom" value="${requestScope.prenom }"  required class="liste1"/>
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="email" id="email" placeholder="exemple@eni.com" value="${requestScope.email }" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required class="liste1"/>
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="telephone" id="telephone" placeholder="Tel:0601XXXXXX" value="${requestScope.telephone }" pattern="[0-9]{10}" required class="liste1"/>
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="rue" id="rue" placeholder="Rue" value="${requestScope.rue }" required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="codePostal" id="codePostal" placeholder="Code Postal" value="${requestScope.codePostal }" required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="text" name="ville" id="ville" placeholder="Ville" value="${requestScope.ville }" required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>	
				<input type="password" name="motDePasse" id="motDePasse" placeholder="Mot de Passe" required class="liste2" />
		    </div>
			
			<br />
			<br />
			
			<div>
				<input type="password" name="reMotDePasse" id="reMotDePasse" placeholder="Confirmation" required class="liste2" />
			     
		    </div>
		        <c:if test="${!empty errorMDP }">${errorMDP }</c:if>
		    
			<br />
			<br />
			
			<div>
		    	<input type="submit" name="creer" class="bt1"/>
				<input type="reset" value="Annuler" class="bt2">
		    </div>
				
		</form>
	

</body>
</html>
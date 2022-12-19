<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>

<body>
	
	<%@ include file="Header.jsp"%>
	
	<form  action="<%=request.getContextPath()%>/Connexion"  method="POST" >
		<div>
			<label for="identifiant">Identifiant : </label>
			<input type="text" name="identifiant" id="identifiant" required />
		</div>
		
		<div>
			<label for="motDePasse">Mot de passe : </label>
			<input type="password" name="motDePasse" id="motDePasse" required />
		</div>
		
		<div name="erreurConnexion" style="color:red">
			<c:if test="${!empty messageConnexion}">
				${sessionScope.messageConnexion}
			</c:if>
	    	
		</div>
		
		<input type="submit" name="connexion" value="Connexion"/>
	</form>
	
	<a href="<%=request.getContextPath()%>/Inscription">Créer un compte</a>
	
</body>
</html>
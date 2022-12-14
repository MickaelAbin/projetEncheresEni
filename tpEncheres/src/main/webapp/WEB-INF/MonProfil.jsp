<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>
<%@ include file="MonProfil.html" %>


<fieldset>
  <legend><h2>Inscription</h2></legend>
  


<form  action="<%=request.getContextPath()%>/MonProfil"  method="POST" >
    <label for="nom">Pseudo : </label>
	<input type="text" name="pseudo" id="pseudo" required />
	<br />
	<br />
	<label for="nom">Nom : </label>
	<input type="text" name="nom" id="nom" required />
	<br />
	<br />
	<label for="nom">Prenom : </label>
	<input type="text" name="prenom" id="prenom" required />
	<br />
	<br />
	<label for="nom">Email : </label>
	<input type="text" name="email" id="email" required />
	<br />
	<br />
	<label for="nom">Telephone : </label>
	<input type="text" name="telephone" id="telephone" required />
	<br />
	<br />
	<label for="nom">Rue : </label>
	<input type="text" name="rue" id="rue" required />
	<br />
	<br />
	<label for="nom">Code Postal : </label>
	<input type="text" name="codePostal" id="telephone" required />
	<br />
	<br />
	<label for="nom">ville : </label>
	<input type="text" name="ville" id="ville" required />
	<br />
	<br />
	<label for="nom">Mot de passe : </label>
	<input type="text" name="motDePasse" id="motDePasse" required />
	<br />
	<br />
	<input type="submit" name="creer" />
	
</form>
</fieldset>
</body>
</html>
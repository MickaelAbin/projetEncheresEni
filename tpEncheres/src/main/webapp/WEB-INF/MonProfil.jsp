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
	<label for="nom">Nom : </label>
	<input type="text" name="nom" id="nom" required />
	<input type="submit" name="creer" />
	
	
	
	
<!--
    <table>
        <tr>
            <td>
                <label for="nom">Nom : </label>
            </td>
            <td>
                <input type="text" name="nom" id="nom"/>
                
                <br />
            </td>
        </tr>
        <tr>
            <td>
                <label for="prenom">Prenom : </label>
            </td>
            <td>
                <input type="text" name="prenom" id="prenom" />
                <br />
            </td>
        </tr>
         <tr>
            <td>
                <label for="nom">Pseudo : </label>
            </td>
            <td>
                <input type="text" name="pseudo" id="pseudo" />
                <br />
            </td>
        </tr>
        <tr>
        <tr>
            <td>
                <label for="email">Mail : </label>
            </td>
            <td>
                <input type="text" name="email" id="email" value="...@..."/>
                <br />
            </td>
        </tr>
        <tr>
            <td>
                <label for="sexe">Sexe : </label>
            </td>
            <td>
                <input type="radio" name="sexe" id = "sm" value="M" /> H
                <input type="radio" name="sexe" id = "sf" value="F" /> F
                <br />
            </td>
        </tr>
        <tr>
            <td>
                <label for="rue">Rue : </label>
            </td>
            <td>
                <input type="text" name="rue" id="rue" />
                <br />
            </td>
        </tr>
        <tr>
            <td>    
                <label for="pays">Pays : </label>
            </td>
            <td>
                <select name="pays">
                <option value="">Choisissez</option>
                <option value="maroc">Maroc</option>
                <option value="france">France</option>
                <option value="italie">Italie</option>
                <option value="USA">USA</option>
                <option value="Allemagne">Allemagne</option>
                <option value="italie">Italie</option>
                <option value="Espagne">Espagne</option>
                </select>
                <br />
            </td>
        </tr>
        <tr>
            <td>    
                <label for="password">Mot de passe : </label>
            </td>
            <td>
                <input type="password" name="password" id="password" />
                <br />
            </td>
        </tr>
        <tr>
            <td>    
                <label for="rePassword">Confirmez mot de passe : </label>
            </td>
            <td>
                <input type="password" name="rePassword" id="rePassword" />
                <br />
            </td>
        </tr>
        
        <tr>
            <td>    
                <input type="submit" value="Valider">
            </td>
            <td>
                <input type="reset" value="Annuler">
            </td>
        </tr>
    </table>
    -->
</form>
<c:if test="${ !empty param.nom }"><p><c:out value="Bonjour, vous vous appelez ${ param.nom } "/></p></c:if>
</fieldset>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 15/02/2021
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<form method="post" action="Inscription">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous s'inscrire via ce formulaire.</p>

        <label for="nom">Nom d'utilisateur : <span class="requis">*</span></label>
        <input type="text" id="nom" name="nom" value="<c:out value='${ utilisateur.nomutilisateur}'/>" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['nom'] }</span>
        <br />

        <label for="prenom">Prénom d'utilisateur :  <span class="requis">*</span></label>
        <input type="text" id="prenom" name="prenom" value="<c:out value='${ utilisateur.prenomutilisateur}'/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['prenom'] }</span>
        <br />

        <label for="cin">CIN d'utilisateur : <span class="requis">*</span></label>
        <input type="text" id="cin" name="cin" value="<c:out value='${ utilisateur.cinutilisateur}'/>"  size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['cin'] }</span>
        <br />

        <label for="tel">Telephone d'utilisateur : </label>
        <input type="text" id="tel" name="tel"  value="<c:out value='${ utilisateur.teleutilisateur}'/> " size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['tel'] }</span>
        <br />
        <label for="ville" >Ville</label>
        <select  name="ville" id="ville">
            <option selected>Choisir votre ville</option>
            <c:forEach items="${villes}" var="ville">
                <option value="<c:out value="${ville.idVille}"/>"><c:out value="${ville.nomVille}"/></option>
            </c:forEach>
        </select>
        <span class="erreur">${form.erreurs['ville'] }</span>
        <br />
        <label for="ville" >Groupe du Sang</label>
        <select  name="groupe" id="groupe">
            <option selected>Choisir votre groupe du sang</option>
            <c:forEach items="${groupes}" var="groupe">
                <option value="<c:out value="${groupe.idGroupe}"/>"><c:out value="${groupe.nomGroupe}"/></option>
            </c:forEach>
        </select>
        <span class="erreur">${form.erreurs['groupe'] }</span>
        <br/>
        <label for="email">Email d'utilisateur : </label>
        <input type="text" id="email" name="email"  value="<c:out value='${ utilisateur.emailutilisateur}'/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['email'] }</span>
        <br />
        <label for="motdepasse">Mot de passe   : </label>
        <input type="password" id="motdepasse" name="motdepasse"  value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['motdepasse'] }</span>
        <br />
        <label for="confirmation">Confirmation mot de passe  : </label>
        <input type="password" id="confirmation" name="confirmation"  value="" size="20" maxlength="20" />

        <br />

        <input type="submit" value="Inscription" class="sansLabel" />
        <br />
    </fieldset>
    <p id="${empty form.erreurs ? succes:erreur }">${form.resultat }</p>
</form>

</body>

</html>

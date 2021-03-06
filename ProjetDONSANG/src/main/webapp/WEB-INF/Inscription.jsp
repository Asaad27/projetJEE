<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 15/02/2021
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
    <%@include file="../header.jsp"%>
</head>
<body class="bg">
<%@include file="../navBar.jsp"%>
<form method="post" action="Inscription"  style="width: 500px;position: absolute;top:10px;left:540px;background-color: white;z-index: 0;
padding:50px;">
    <h5 class="card-header white-text text-center py-4" style="background: #ff4d4d;color:white;height: 40px;padding-top: 10px;">
        <strong >Inscription</strong>
    </h5>
    <fieldset>

        <p>Vous pouvez vous s'inscrire via ce formulaire.</p>
       <div class="row">
           <div class="col-md-6">
            <label for="nom">Nom d'utilisateur <span class="requis">*</span></label>
            <input type="text" id="nom" name="nom" value="<c:out value='${ utilisateur.nomutilisateur}'/>"  class="form-control" />
            <span class="erreur">${form.erreurs['nom'] }</span>
        </div>

           <div class="col-md-6">
        <label for="prenom">Prénom d'utilisateur   <span class="requis">*</span></label>
        <input type="text" id="prenom" name="prenom" value="<c:out value='${ utilisateur.prenomutilisateur}'/>" class="form-control" />
        <span class="erreur">${form.erreurs['prenom'] }</span>
        </div>
       </div>
            <br />
        <div class="row">
            <div class="col-md-6">
        <label for="cin">CIN d'utilisateur  <span class="requis">*</span></label>
        <input type="text" id="cin" name="cin" value="<c:out value='${ utilisateur.cinutilisateur}'/>"  size="20" maxlength="20"  class="form-control"/>
        <span class="erreur">${form.erreurs['cin'] }</span>
            </div>

            <div class="col-md-6">
        <label for="tel">Telephone d'utilisateur  </label>
        <input type="text" id="tel" name="tel"  value="<c:out value='${ utilisateur.teleutilisateur}'/> " class="form-control" />
        <span class="erreur">${form.erreurs['tel'] }</span>
            </div>
                <br />
        </div>
            <div class="form-outline mb-4" >
        <label for="ville" >Ville <span class="requis">*</span></label></label>
        <select  name="ville" id="ville" class="form-control">
            <option selected>Choisir votre ville</option>
            <c:forEach items="${villes}" var="ville">
                <option value="<c:out value="${ville.idVille}"/>"><c:out value="${ville.nomVille}"/></option>
            </c:forEach>
        </select>
        <span class="erreur">${form.erreurs['ville'] }</span>
            </div>
                <br />
                    <div class="form-outline mb-4">
        <label for="groupe" >Groupe du Sang <span class="requis">*</span></label></label>
        <select  name="groupe" id="groupe" class="form-control">
            <option selected>Choisir votre groupe du sang</option>
            <c:forEach items="${groupes}" var="groupe">
                <option value="<c:out value="${groupe.idGroupe}"/>"><c:out value="${groupe.nomGroupe}"/></option>
            </c:forEach>
        </select>
        <span class="erreur" >${form.erreurs['groupe'] }</span>
                    </div>
                        <br/>
            <div class="form-outline mb-4">
        <label for="email">Email d'utilisateur <span class="requis">*</span></label> </label>
        <input type="text" id="email" name="email"  value="<c:out value='${ utilisateur.emailutilisateur}'/>" class="form-control" />
        <span class="erreur">${form.erreurs['email'] }</span>
            </div>
                <br />
        <div class="row">
        <div class="col-md-6">
        <label for="motdepasse">Mot de passe   <span class="requis">*</span></label> </label>
        <input type="password" id="motdepasse" name="motdepasse"  value="" class="form-control" />
        <span class="erreur">${form.erreurs['motdepasse'] }</span>
            </div>
            <div class="col-md-6">
        <label for="confirmation">Confirmation  <span class="requis">*</span></label> </label>
        <input type="password" id="confirmation" name="confirmation"  value="" class="form-control" />

            </div>
        </div>
        <br />

            <button type="submit" class="btn btn-danger btn-block">S'inscrire </button>
        <br />
    </fieldset>
    <c:if test="${not empty form.resultat}">
    <c:choose>
        <c:when test="${empty form.erreurs }">
            <div class="alert alert-success">${form.resultat }</div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-danger">${form.resultat }</div>
        </c:otherwise>
    </c:choose>
    </c:if>
</form>

</body>
<%@include file="../footer.jsp"%>
</html>

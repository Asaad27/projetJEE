<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 20/02/2021
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="../header.jsp"%>
    <title>Title</title>
</head>
<body style="height: 900px;">
<%@include file="../navBar.jsp"%>
  <div>${message}</div>
        <section>

            <div class="card" style="text-align: center;margin-left:500px;">
            <form method="post" action="ProfilUtilisateur" id="newItemForm" style="width:500px;">

                <h5 class="card-header white-text text-center py-4" style="background: #ff4d4d;color:white;height: 40px;padding-top: 10px;">
                    <strong >Mon profil</strong>
                </h5>
                <fieldset>
                    <div class="row">
                        <div class="col-md-6">
                    <input type="hidden" id="id" name="id" value="<c:out value='${ utilisateurProfil.idutilisateur}'/>" size="20" maxlength="60"  />
                    <label for="nom">Nom d'utilisateur :</label>
                    <input type="text" id="nom" name="nom" value="<c:out value='${utilisateurProfil.nomutilisateur}'/>" size="20" maxlength="60" class="form-control"/>
                    <span class="erreur">${form.erreurs['nom'] }</span>
                        </div>
                        <div class="col-md-6">
                            <label for="prenom">Prénom d'utilisateur : </label>
                    <input type="text" id="prenom" name="prenom" value="<c:out value='${ utilisateurProfil.prenomutilisateur}'/>" size="20" maxlength="20" class="form-control"/>
                    <span class="erreur">${form.erreurs['prenom'] }</span>
                        </div>
                    </div>
                    <br />
                    <div class="row">
                        <div class="col-md-6">
                    <label for="cin">CIN d'utilisateur :</label>
                    <input type="text" id="cin" name="cin" value="<c:out value='${ utilisateurProfil.cinutilisateur}'/>"  size="20" maxlength="20"  class="form-control" />
                    <span class="erreur">${form.erreurs['cin'] }</span>
                        </div>
                        <div class="col-md-6">
                    <label for="tel">Telephone d'utilisateur : </label>
                    <input type="text" id="tel" name="tel"  value="<c:out value='${ utilisateurProfil.teleutilisateur}'/> " size="20" maxlength="20"  class="form-control"/>
                    <span class="erreur">${form.erreurs['tel'] }</span>
                        </div>
                        </div>
                    <br />
                    <div class="row">
                        <div class="col-md-6">
                    <label for="ville" >Ville</label>
                    <select  name="ville" id="ville"  class="form-control">

                            <c:forEach items="${villes}" var="ville">
                                    <c:if test="${utilisateurProfil.idvilleutilisateur eq ville.idVille}">
                        <option value="<c:out value="${ville.idVille}"/>" selected><c:out value="${ville.nomVille}"/></option>
                                    </c:if>
                            </c:forEach>
                        <c:forEach items="${villes}" var="ville">
                            <option value="<c:out value="${ville.idVille}"/>"><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>

                    <span class="erreur">${form.erreurs['ville'] }</span>
                    <br />
                        </div>

                            <div class="col-md-6">
                    <label for="ville" >Groupe du Sang</label>
                    <select  name="groupe" id="groupe"  class="form-control">

                        <c:forEach items="${groupes}" var="groupe">
                            <c:if test="${utilisateurProfil.idgrouputilisateur eq groupe.idGroupe}">
                            <option value="<c:out value="${groupe.idGroupe}"/>" selected><c:out value="${groupe.nomGroupe}"/></option>
                            </c:if>
                        </c:forEach>
                    </select>


                    <span class="erreur">${form.erreurs['groupe'] }</span>
                            </div>
                    <br/>
                    </div>
                        <div class="row">
                            <div class="col-md-12">
                    <label for="email">Email d'utilisateur : </label>
                    <input type="text" id="email" name="email"  value="<c:out value='${ utilisateurProfil.emailutilisateur}'/>" size="20" maxlength="20" class="form-control"/>
                    <span class="erreur">${form.erreurs['email'] }</span>

                            </div>
                        </div>
                    <button type="submit" class="btn btn-danger btn-block " style="margin-top: 10px;">modifier </button>

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
            </div>
        </section>
         <section style="text-align: center;">
             <div class="col-lg-3 col-md-3 col-xs-3 ">
                 <a href="ajouterdemande">
                 <img src="img/demandeSang.jpg" title="Ajouter une demande de sang" class=" img-circle" style="width:304px; height: 206px;"/>
                </a>
                 <p><strong>Ajouter une demande de sang</strong></p>
             </div>
             <div class="col-lg-3 col-md-3 col-xs-3 ">
             <a href="MesDemandes"><img src="img/his.png" class=" img-circle" style="width:304px;height: 206px;"/></a>
                 <p><strong>Historique des demandes</strong></p>
         </div>
             <div  class="col-lg-3 col-md-3 col-xs-3 ">
             <a href="UsersDemandes"><img src="img/demeande.PNG" class=" img-circle" style="width:304px;height: 206px;"/></a>
                 <p><strong>Consulter les demandes</strong></p>
             </div>
             <div  class="col-lg-3 col-md-3 col-xs-3 ">
                 <a href="AfficherCompagne"><img src="img/evenement.png" class=" img-circle" style="width:304px;height: 206px;"/></a>
                 <p><strong>Consulter les compagnes</strong></p>
             </div>

         </section>
<%@include file="../footer.jsp"%>
</body>
<script src="https://code.jquery.com/jquery-1.12.3.js" integrity="sha256-1XMpEtA4eKXNNpXcJ1pmMPs8JV+nwLdEqwiJeCQEkyc=" crossorigin="anonymous"></script>
<script type="text/javascript">
    $newItemForm.on('click',function(e) {
        if($('#changePassword').is(':checked')){
           alert("oui");
        }

    });
</script>
</html>

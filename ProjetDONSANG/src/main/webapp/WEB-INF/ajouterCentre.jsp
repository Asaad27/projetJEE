<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 25/02/2021
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="../header.jsp"%>
    <style>
        .form-group.required .control-label:after {
            content:" *";
            color:red;
        }
        .form-control:focus {
            border-color: #AE1F23;
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
        }
        select option:hover {
            background: #AE1F23;
            color: white;
        }
    </style>
</head>
<body style="height: 1200px;">
<%@include file="../navBar.jsp"%>
<!--- Contenue -->


                        <form method="post" action="ajouterCentre" style="width: 500px;margin-left: 500px;">

                            <div class="card-body">
                                <c:if test="${not empty flashMessageFaild }">
                                    <div class="alert alert-danger" role="alert">
                                            ${flashMessageFaild}
                                    </div>
                                </c:if>
                                <c:if test="${not empty flashMessageSuccess}">
                                    <div class="alert alert-success" role="alert">
                                            ${flashMessageSuccess}
                                    </div>
                                </c:if>
                            </div>
                            <h5 class="card-header white-text text-center py-4" style="background: #ff4d4d;color:white;height: 40px;padding-top: 10px;">
                                <strong >Ajouter Centre</strong>
                            </h5>
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="nom" class='control-label'>Nom du centre</label>
                                    <input type="text" name="nom" class="form-control" id="nom" placeholder="Centre Name" <c:if test="${oldNom ne null}"> value="${oldNom}" </c:if> >
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="email" class='control-label'>Email du centre</label>
                                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" <c:if test="${oldEmail ne null}"> value="${oldEmail}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>

                            <div class="row ">
                                <div class="col-md-12">
                                    <label for="tele" class='control-label'>Telephone du centre</label>
                                    <input type="text" name="tele" class="form-control" id="tele" placeholder="Phone Number" <c:if test="${oldTele ne null}"> value="${oldTele}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <label for="password" class='control-label'>Mot de passe du centre</label>
                                    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>


                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="addresse" class='control-label mt-4'>Adresse du centre</label>
                                            <input class="form-control" id="addresse" name="addresse" rows="7" placeholder="Centre adresse" valu="<c:if test="${oldAddresse ne null}">${oldAddresse}</c:if>"/>
                                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                        </div>



                                            <div class="col-md-6">
                                    <label for="ville" >Ville du centre</label>
                                    <select class="form-control" name="ville" id="ville">
                                        <option selected value="">Choisir ville</option>
                                        <c:forEach items="${villes}" var="ville">
                                            <option value="<c:out value="${ville.idVille}"/>" <c:if test="${oldVille eq ville.idVille}"> selected="" </c:if> ><c:out value="${ville.nomVille}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <!-- Submit -->

                                    <button class="btn  btn-block btn-danger "
                                            type="submit" style="width: 500px;margin-top: 10px;" name="ajouter">
                                        Create
                                    </button>
                        </form>
            <c:if test="${not empty centres}">
                            <section>


                                <table class="table table-striped" style="width: 1000px;margin-left: 200px; margin-top: 20px;">
                                    <thead>

                                    <tr style="background-color:#ff3333;color: white;text-align: center; ">

                                        <th><span><i class="glyphicon glyphicon-font"></i> Nom centre</span></th>
                                        <th><span><i class="fas fa-at"></i> Email Centre</span></th>
                                        <th><span><i class="fas fa-map-marker-alt"></i> Adresse Centre</span></th>
                                        <th><span><i class="glyphicon glyphicon-earphone"></i> Telephone Centre</span></th>
                                         <th><span><i class="glyphicon glyphicon-pencil"></i> Modifier</span></th>
                                         <th><span><i class="glyphicon glyphicon-remove"></i> Supprimer</span></th>
                                    </tr>

                                    </thead>
                                    <tbody>
                                    <c:forEach items="${centres}" var="centre">
                                        <tr>
                                            <form action="ajouterCentre" method="post">
                                                <input type="hidden" id="id" name="idCentre" value="<c:out value='${ centre.idCentre}'/>" />
                                                <td> <input type="text"  name="nom" value="<c:out value='${ centre.nameCentre}'/>"/></td>
                                                <td><input type="text"  name="email" value="<c:out value='${ centre.emailCentre}'/>"/></td>
                                                <td><input type="text"  name="adresse" value="<c:out value='${ centre.adresseCentre}'/>"/></td>
                                                <td><input type="text"  name="tele" value="<c:out value='${ centre.teleCentre}'/>"/></td>
                                                <td > <button type="submit" class="btn btn-danger " name="modifier" style="width: 100px;">Modifier</button></td>
                                                <td > <button type="submit" class="btn btn-danger " name="supprimer" style="width: 120px;">Supprimer</button></td>
                                            </form>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>



                        </form>

                </section>
            </c:if>

<%@include file="../footer.jsp"%>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 17/02/2021
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

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
            background-color: #AE1F23;
            color: white;
        }
    </style>
</head>
<body>

<c:if test="${empty sessionScope.utilisateur}">
    <c:redirect url="Login"></c:redirect>
</c:if>


<!--- Contenue -->
<div class="container col-md-8" style="margin-top: 100px;">

    <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
        <h1 class="h1-responsive">Créer une nouvelle demande</h1>
    </div>

    <div>${id}</div>
    <div>${date}</div>
   <div>${resultMessage}</div>
    <c:if test="${not empty result}">
        <c:choose>
            <c:when test="${result== 'ok'}">
                <h5 class='h5 text-center  mt-4'>
                    <div class='alert alert-success'>Demande ajoutée avec succès</div>

                </h5>
            </c:when>
            <c:when test="${result == 'non'}">
                <h5 class="h5 text-center mt-4">
                    <div class="alert alert-danger">Un problème est survenu</div>

                </h5>
            </c:when>
            <c:otherwise>
                <h5 class="h5 text-center mt-4">
                    <div class="alert alert-danger">Veuillez remplir tous les champs SVP</div>
                </h5>
            </c:otherwise>
        </c:choose>
    </c:if>

    <div class="row">
        <div class="col col-md-12">
            <form action="ajouterdemande" method="post">
                <div class="form-group required">
                    <label for="titleInput" class='control-label'>Titre de la demande</label>
                    <input type="text" name="titre" class="form-control" id="titleInput" placeholder="">
                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                </div>
                <div class="form-group required">
                    <label for="groupSangSelect" class='control-label'>Groupe sang</label>
                    <select class="form-control" id="groupSangSelect"  name="groupSangSelect">
                        <c:forEach items="${groupSangList}" var="groupSang" >
                            <option value="${groupSang.nomGroupe}"><c:out value="${groupSang.nomGroupe}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="urgentSelect" class='control-label'>C'est Urgent ?</label>
                    <select class="form-control" id="urgentSelect" name="urgentSelect">
                        <option selected>Est urgente?</option>
                        <option value="No">Non</option>
                        <option value="Yes">Oui</option>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="description" class='control-label'>Description de la demande</label>
                    <textarea class="form-control" id="description" rows="7" name="description"></textarea>
                </div>
                <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                        type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                    Send
                </button>
            </form>
        </div>

    </div>

</div>



</body>
</html>

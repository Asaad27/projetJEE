<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 23/02/2021
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ajouter Compagne</title>
    <%@include file="../header.jsp"%>
</head>
<body>
<%@include file="../navBar.jsp"%>
<div class="container col-md-8" style="">
    <div class="row" >
        <div class="col col-md-12">


                    <form method="post" action="AjouterCompagne" enctype="multipart/form-data" style="width:500px;margin-left: 500px;">
                        <c:if test="${not empty messageEchec}">
                        <h5 class='h5 text-center  mt-4'>
                            <div class="alert alert-danger" role="alert">
                                    ${messageEchec}
                            </div>
                            <h5 class='h5 text-center  mt-4'>
                                </c:if>
                                <c:if test="${not empty messageSucces}">
                                <h5 class='h5 text-center  mt-4'>
                                    <div class="alert alert-success" role="alert">
                                            ${messageSucces}
                                    </div>
                                    <h5 class='h5 text-center  mt-4'>
                                        </c:if>
                        <h5 class="card-header white-text text-center py-4" style="background-color: #ff3333;height: 40px;padding-top: 10px;color:white;">
                                <strong>Créer un événement</strong>
                        </h5>
                        <div class="form-group required">
                                <label for="title" class='control-label'>Titre d'événement:</label>
                                <input type="text" name="title" class="form-control" id="title" placeholder="">

                            </div>



                            <div class="form-group required ">
                                <label for="description" class='control-label'> Description d'événement</label>
                                <textarea class="form-control" id="description" name="description" rows="7" placeholder=""></textarea>
                                <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                            </div>


                            <div class="form-group required ">
                                <label for="date" class='control-label'> Date d'évenement</label>
                                <input type="date" name="date" class="form-control" id="date" <c:if test="${oldDate ne null}"> value="${oldDate}" </c:if>>
                                <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                            </div>



                        <div class="form-group required col-sm-12 custom-file ">
                            <label class="custom-file-label " for="imgInput">Photo de couverture d'événement </label>
                            <input type="file" class="custom-file-input" id="imgInput" name="imgInput"
                                   aria-describedby="imgInput" required>

                        </div>




                                <button class="btn btn-danger btn-block "
                                        type="submit" >
                                    Créer
                                </button>




                    </form>



        </div>


    </div>

</div>


<%@include file="../footer.jsp"%>
</body>
</html>

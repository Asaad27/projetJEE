<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 18/02/2021
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body class="grey lighten-5">
<h1>Les Demandes de sang dont vous pouvez répondre  !!!! </h1>

<main>

    <div class="container">
        <br><br><br>
        <div class="row mb-4 mt-3">

            <div class="col-6">
                <form class="form-inline md-form mr-auto" method="post" action="UsersDemandes">
                    <select class="form-control mr-sm-2 my-0" style="font-size: 15px;"  name="citySelect">
                        <option value="default">Filter By City : </option>
                        <c:forEach items="${villes}" var="ville" >
                            <option value="${ville.idVille}"><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>
                    <button class="btn btn-outline-info btn-rounded btn-md my-0 waves-effect" style="border-color: #D92228 !important; font-size: 10px; color: #D92228 !important;"  type="submit">Submit</button>
                </form>
            </div>




        </div>

        <!--Section: Requests-->
        <c:if test="${empty requests}">
            <!-- Card -->
            <!-- Grid column -->
            <br><br>
            <div class="col-md-10 offset-1 mb-4">

                <!--Card-->
                <div class="card mb-5" style="border: 1px #ae1f23; background: #ffffff">

                    <!--Card image-->
                    <div class="card-header btn-outline-danger pt-4" style="border: 1px #AE1F23; background: white">
                        <h2 class="card-title black-text text-center" style="font-size: 18px;">No request available</h2>
                    </div>

                    <!--Card content-->
                    <div class="card-body text-center">
                        <!--Title-->
                        <!--Text-->
                        <br>
                        <p class="card-text black-text" style="font-size: 15px;">Pas de demandes pour le moment,merci de nous revisiter pour voir de nouvelles demandes
                        </p>
                        <br>
                        <a href="login" class="btn btn-outline-danger btn-md waves-effect" style="font-size: 14px;">Join us</a>
                    </div>

                </div>
                <!--/.Card-->
            </div>
        </c:if>
        <c:if test="${not empty requests}">
            <section>
                <div>Les Demandes</div>
                <c:forEach var="i" begin="0" end="${requests.size()-1}">

                    <div class="well">
                        <div class="media">

                            <div class="media-body">
                                <h2 class="media-heading">${requests.get(i).titreDemande}</h2>
                                <p class="text-right">Demande de : ${users.get(i).nomutilisateur} ${users.get(i).prenomutilisateur}</p>
                                <p class="text-right">Son téléphone : ${users.get(i).teleutilisateur}</p>
                                <p>${requests.get(i).descriptionDemande}</p>
                                <ul class="list-inline list-unstyled">
                                    <li><span><i class="glyphicon glyphicon-calendar"></i> ${requests.get(i).dateDemande} </span></li>

                                    <li>|</li>
                                    <span><i class="glyphicon glyphicon-comment"></i> 2 comments</span>
                                    <li>|</li>
                                    <li>
                                        <!-- Use Font Awesome http://fortawesome.github.io/Font-Awesome/ -->
                                        <span><i class="fa fa-facebook-square"></i></span>
                                        <span><i class="fa fa-twitter-square"></i></span>
                                        <span><i class="fa fa-google-plus-square"></i></span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </c:forEach>

                <!--Pagination-->


                <!--Pagination-->
            </section>
        </c:if>
    </div>
</main>



</body>
</html>
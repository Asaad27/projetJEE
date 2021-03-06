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
    <%@include file="../header.jsp"%>

</head>
<body  style="height:1500px;">
<img src="img/don-sang.jpg" class="bg1"/>
<%@include file="../navBar.jsp"%>


<main style="margin-left: 200px;">

        <div class="row mb-4 mt-3">

            <div class="col-6" style="margin-left: 300px;margin-bottom: 20px;">
                <form class="form-inline md-form mr-auto" method="post" action="UsersDemandes">
                    <select class="form-control mr-sm-2 my-0" style="font-size: 15px;"  name="citySelect">
                        <option value="default">Filtrer par ville : </option>
                        <c:forEach items="${villes}" var="ville" >
                            <option value="${ville.idVille}"><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-danger ">Chercher</button>
                </form>
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
            <section style="width: 600px;margin-left: 300px;" id="section2">

                <c:forEach var="i" begin="0" end="${requests.size()-1}">

                  <div class="panel panel-default">
                      <div class="panel-heading">
                          <h2 class="panel-title" >Demande de : ${users.get(i).nomutilisateur} ${users.get(i).prenomutilisateur}</h2>
                      </div>

                      <div class="panel-body">
                          <h3 >${requests.get(i).titreDemande}</h3>
                          <p >${requests.get(i).descriptionDemande}</p>

                      </div>
                      <div class="panel-footer">
                          <span><i class="fas fa-calendar-alt"></i>  ${requests.get(i).dateDemande} </span>| <span><i class="glyphicon glyphicon-earphone"></i>  ${users.get(i).teleutilisateur} </span>
                      </div>
                  </div>

                </c:forEach>

                <!--Pagination-->


                <!--Pagination-->
            </section>
        </c:if>
    </div>

</main>

<section style="margin-left: 740px;" class="pagination">
    <c:if test="${pageCourante != 1}">
        <button><a href="<c:url value="/UsersDemandes?pageCourante=${pageCourante - 1}"/>">&laquo;</a></button>
    </c:if>


        <c:forEach begin="1" end="${nbPages}" var="i">
            <c:choose>
                <c:when test="${pageCourante eq i}">
                <button>${i}</button>
                </c:when>
                <c:otherwise>  <button><a href="UsersDemandes?pageCourante=${i}">${i}</a></button> </c:otherwise>
            </c:choose>

        </c:forEach>
    <c:if test="${pageCourante lt nbPages}">
    <button><a href="<c:url value="/UsersDemandes?pageCourante=${pageCourante + 1}"/>">&raquo;</a><button>
    </c:if>
</section>



<%@include file="../footer.jsp"%>

</body>
</html>

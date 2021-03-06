<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 19/02/2021
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mes demandes</title>
    <%@include file="../header.jsp"%>
</head>
<body>

<%@include file="../navBar.jsp"%>
<c:if test="${not empty modif}">
    <h3>${modif}</h3>
</c:if>
<c:if test="${not empty requests}">

    <section>


        <table class="table table-striped" style="width: 800px;margin-left: 300px;">
            <thead>

            <tr style="background-color:#ff3333;">

                <th><span><i class="glyphicon glyphicon-font"></i>Titre</span></th>
                <th><span><i class="fas fa-calendar-alt"></i> Date de demande</span></th>
                <th><span><i class="fas fa-exclamation-triangle"></i> Urgente</span></th>
                <th><span><i class="glyphicon glyphicon-remove"></i> Fermer</span></th>
            </tr>

            </thead>
            <tbody>
            <c:forEach items="${requests}" var="request">
            <tr>
                <form action="MesDemandes" method="post">
                    <input type="hidden" id="id" name="idDemande" value="<c:out value='${ request.idDemande}'/>" />
                <td>${ request.titreDemande}</td>
                <td>${ request.dateDemande}</td>
                <td><c:choose>
                    <c:when test="${ not request.estUrgente}">
                        <c:out value="Non"/>
                    </c:when>
                    <c:otherwise> <c:out value="Oui"/></c:otherwise>
                </c:choose></td>
                    <td>
                        <button type="submit" class="btn btn-danger ">Fermer</button>
                </form>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>


    </section>
</c:if>
<section style="margin-left: 600px;" class="pagination">
    <c:if test="${pageCourante != 1}">
        <button class="butt"><a href="<c:url value="/MesDemandes?pageCourante=${pageCourante - 1}"/>">&laquo;</a></button>
    </c:if>


    <c:forEach begin="1" end="${nbPages}" var="i">
        <c:choose>
            <c:when test="${pageCourante eq i}">
                <button class="butt">${i}</button>
            </c:when>
            <c:otherwise>  <button class="butt"><a href="MesDemandes?pageCourante=${i}">${i}</a></button></c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${pageCourante lt nbPages}">
    <button class="butt"><a href="<c:url value="/MesDemandes?pageCourante=${pageCourante + 1}"/>">&raquo;</a><button>
        </c:if>
</section>
<%@include file="../footer.jsp"%>

</body>
</html>
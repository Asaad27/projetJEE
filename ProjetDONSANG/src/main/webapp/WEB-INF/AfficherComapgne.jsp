<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 23/02/2021
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Title</title>
    <%@include file="../header.jsp"%>
</head>
<body style="height: 1000px;">
<%@include file="../navBar.jsp"%>
<c:if test="${not empty compagnes}">
    <section style="width: 600px;margin-left: 180px;margin-top: 100px;" id="section2">

        <div class="container">
            <div class="row-fluid ">
                <!-- my php code which uses x-path to get results from xml query. -->
                <c:forEach var="i" begin="0" end="${compagnes.size()-1}">
                <div class="col-sm-4 ">
                    <div class="card-columns-fluid">
                        <div class="panel" style = "width: 350px; height: 400px;" >
                            <img class="card-img-top"  src=" imagesEvent/${compagnes.get(i).imageComapgne} " alt="Card image cap" style="width: 320px;height: 100px;">

                            <div class="panel-body" >
                                <h3 >${compagnes.get(i).titreCompagne}</h3>
                                <p >${compagnes.get(i).descriptionCompagne}</p>

                            </div>
                            <div class="panel-footer">
                                <span><i class="fas fa-calendar-alt"></i>  ${compagnes.get(i).dateCompagne} </span>| <span><i class="glyphicon glyphicon-earphone"></i>  ${centres.get(i).teleCentre} </span>
                                <br/> <span><i class="fas fa-map-marker-alt"></i>  ${centres.get(i).adresseCentre} </span> |<span><i class="fas fa-hospital"></i> ${centres.get(i).nameCentre} </span>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>

        <!--Pagination-->


        <!--Pagination-->
    </section>
</c:if>
</div>

</main>

<section style="margin-left: 740px;" class="pagination">
    <c:if test="${pageCourante != 1}">
        <button><a href="<c:url value="/AfficherCompagne?pageCourante=${pageCourante - 1}"/>">&laquo;</a></button>
    </c:if>


    <c:forEach begin="1" end="${nbPages}" var="i">
        <c:choose>
            <c:when test="${pageCourante eq i}">
                <button>${i}</button>
            </c:when>
            <c:otherwise>  <button><a href="AfficherCompagne?pageCourante=${i}">${i}</a></button> </c:otherwise>
        </c:choose>

    </c:forEach>
    <c:if test="${pageCourante lt nbPages}">
    <button><a href="<c:url value="/AfficherCompagne?pageCourante=${pageCourante + 1}"/>">&raquo;</a><button>
        </c:if>
</section>


<%@include file="../footer.jsp"%>


</body>
</html>

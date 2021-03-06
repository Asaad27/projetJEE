<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 24/02/2021
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../header.jsp"%>
</head>
<body>
   <%@include file="../navBar.jsp"%>

   <div class="container col-md-8" style="">
       <c:if test="${not empty resultatEchec}">
       <h5 class='h5 text-center  mt-2' style="margin-left: 300px;width: 800px;">
           <div class="alert alert-danger" role="alert">
                   ${resultatEchec}
           </div>
       </h5>
               </c:if>
               <c:if test="${not empty resultatSucces}">
               <h5 class='h5 text-center  mt-2' style="margin-left: 300px;width: 800px;">
                   <div class="alert alert-success" role="alert">
                           ${resultatSucces}
                   </div>
               </h5>
                       </c:if>
       <div class="row" >
           <div class="col col-md-12">
               <form action="AjouterStock" method="post">
               <table class="table table-striped" style="width: 800px;margin-left: 300px;">
                   <thead>

                   <tr style="background-color:#ff3333;">
                       <th><span><i class="glyphicon glyphicon-tint"></i>Groupe du Sang</span></th>
                       <th><span><i class="glyphicon glyphicon-stats"></i> Quantité </span></th>
                   </tr>

                   </thead>
                   <tbody>
                   <c:forEach var="i" begin="0" end="7"  >
                       <tr>
                               <td>${ groupSangList.get(i).nomGroupe}</td>
                               <td> <input type="text" name="quantite${i+1}" value=""/> </td>
                       </tr>
                   </c:forEach>
                   </tbody>
               </table>
                   <div style="margin-left: 300px;">
                   <button type="submit" class="btn btn-danger " name="ajouter" >Ajouter</button>
                   <button type="submit" class="btn btn-danger " name="soustraire" >Soustraire</button>
                   </div>
               </form>

           </div>


       </div>

   </div>

   <%@include file="../footer.jsp"%>
</body>
</html>

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
</head>
<body>
<c:if test="${not empty modif}">
    <h3>${modif}</h3>
</c:if>
<c:if test="${not empty requests}">
    <section>
    <div>Les Demandes</div>
    <c:forEach items="${requests}" var="request">
       <form action="MesDemandes" method="post">
           <input type="hidden" id="id" name="idDemande" value="<c:out value='${ request.idDemande}'/>" size="20" maxlength="60"/>
           <label for="titre">Titre demande :</label>
           <input type="text" id="titre" name="titre" value="<c:out value='${ request.titreDemande}'/>" size="20" maxlength="60"  disabled />
           <br />

           <label for="date">Date  Demande:  </label>
           <input type="text" id="date" name="date" value="<c:out value='${ request.dateDemande}'/>" size="20" maxlength="20"disabled />
           <br />
           <label for="etat">Est elle urgente ?:  </label>
               <select class="form-control" id="etat"  name="estUrgente" disabled>
                   <option selected><c:choose>
                                   <c:when test="${ not request.estUrgente}">
                                       <c:out value="Non"/>
                                   </c:when>
                                   <c:otherwise> <c:out value="Oui"/></c:otherwise>
                   </c:choose></option>

               </select>

           <button type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
              fermer
           </button>
       </form>
    </c:forEach>

    </section>
</c:if>
    </body>
</html>

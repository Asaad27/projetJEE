<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 16/02/2021
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <%@include file="../header.jsp"%>
</head>
<body class="bg" style="z-index: 1;">

<%@include file="../navBar.jsp"%>

<c:if test="${(not empty sessionScope.utilisateur) }">
    <c:redirect url="/"></c:redirect>
</c:if>

<section style="" >
<form style="width: 500px;position: absolute;top:170px;left:540px;background-color: white;padding:50px;" action="Login" method="post">
    <!-- Email input -->
    <h5 class="card-header white-text text-center py-4" style="background: #ff4d4d;color:white;height: 40px;padding-top: 10px;">
        <strong >Connexion</strong>
    </h5>
    <div class="form-outline mb-4">
        <input type="email" id="form1Example1" class="form-control" name="email"  />
        <label class="form-label" for="form1Example1"> Addresse Email </label>
    </div>

    <!-- Password input -->
    <div class="form-outline mb-4">
        <input type="password" id="form1Example2" class="form-control" name="password" />
        <label class="form-label" for="form1Example2">Mot de passe</label>
    </div>

    <!-- 2 column grid layout for inline styling -->
    <div class="row mb-4">
        <div class="col justify-content-center" style="display: flex;">
            <!-- Checkbox -->
            <div class="form-check" style="margin-left:15px;">
                <input
                        class="form-check-input"
                        type="checkbox"
                        value=""
                        id="form1Example3"
                        checked
                />
                <label class="form-check-label" for="form1Example3"> Se souvenir de moi </label>
            </div>
            <div class="col" style=" margin-left: 120px;margin-top: 2px;">
                <!-- Simple link -->
                <a href="#!">Mot de passe oubliè?</a>
            </div>
        </div>


    </div>

    <!-- Submit button -->
    <button type="submit" class="btn btn-danger btn-block">Se Connecter</button>
</form>
</section>
    <c:if test="${not empty msg}">
        <p>
        <div class="alert alert-danger">${msg}</div>
        </p>
    </c:if>

<%@include file="../footer.jsp"%>
</body>
</html>
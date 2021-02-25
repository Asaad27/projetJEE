<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 16/02/2021
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<c:if test="${(not empty sessionScope.utilisateur) }">
    <c:redirect url="/"></c:redirect>
</c:if>
<div class="container col-md-4 align-content-center mt-5 mb-5">
    <div class="card">
        <!-- Default form login -->

        <h5 class="card-header white-text text-center py-4" style="background: #AE1F23">
            <strong>Sign in</strong>
        </h5>
        <div class="card-body">
            <form class="text-center border border-light p-3" method="post" action="Login">
                <!-- Email -->
                <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail"
                       name="email">

                <!-- Password -->
                <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password"
                       name="password">

                <div class="d-flex justify-content-around">
                    <div>
                        <!-- Remember me -->
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                            <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
                        </div>
                    </div>
                    <div>
                        <!-- Forgot password -->
                        <a href="">Forgot password?</a>
                    </div>
                </div>

                <!-- Sign in button -->
                <button class="btn btn-block my-4" style="background: #AE1F23" type="submit">Sign in</button>

                <!-- Register -->
                <p>Not a member?
                    <a href="/registre">Register</a>
                </p>



            </form>
            <!-- Default form login -->
        </div>
    </div>
    <c:if test="${not empty msg}">
        <p>
        <div class="alert alert-danger">${msg}</div>
        </p>
    </c:if>
</div>
</body>
</html>
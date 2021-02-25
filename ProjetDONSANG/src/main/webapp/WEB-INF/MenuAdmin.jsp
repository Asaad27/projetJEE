<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        background: #AE1F23;
        color: white;
    }
</style>
<html>
<head>
    <%@include file="Header.jsp"%>
</head>
<body>
<%@include file="adminNavBar.jsp"%>
<div class="container col-md-8  pt-5 ">

    <br><br>


    <div class="card card-cascade wider reverse">

        <!-- Card content -->
        <div class="card-body card-body-cascade">

            <!-- Title -->
            <div class="section-title text-center wow zoomInfont-weight-bold">
                <h1>Center Management</h1>
            </div>

            <div class="row mt-5">
                <div class="col-md-3 offset-2"><a href="/ajouterCentre" class="btn btn-success">Create Center</a></div>
                <div class="col-md-3"><a href="" data-toggle="modal" data-target="#deleteModel" class="btn btn-danger">Delete Center</a></div>
            </div>
        </div>
    </div>
    <div class="card card-cascade wider reverse mt-5">

        <!-- Card content -->
        <div class="card-body card-body-cascade">

            <!-- Title -->
            <div class="section-title text-center wow zoomInfont-weight-bold">
                <h1>List of Centers</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Identifiant</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Adresse</th>
                    <th scope="col">Ville</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${centres}" var="centre">
                    <tr>
                        <th scope="row"><c:out value="${centre.idCentre}"/></th>
                        <th scope="row"><c:out value="${centre.nameCentre}"/></th>
                        <th scope="row"><c:out value="${centre.emailCentre}"/></th>
                        <th scope="row"><c:out value="${centre.teleCentre}"/></th>
                        <th scope="row"><c:out value="${centre.adresseCentre}"/></th>
                        <th scope="row">
                            <c:forEach items="${villes}" var="ville">
                                <c:if test="${ville.idVille eq centre.idVille}">
                                    <c:out value="${ville.nomVille}"/>
                                </c:if>
                            </c:forEach>
                        </th>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>

</div>
<%@include file="Footer.jsp"%>
</body>
</html>

<div class="modal fade" id="deleteModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Delete Centre</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="/supprimerCentre">
                <div class="modal-body mx-3">
                    <div>
                        <!-- Nom input -->
                        <label for="email" class="mt-4">Email Centre</label>
                        <input type="email" id="email" name="email" class="form-control "/>
                        <label for="expassword" class="control-label mt-4">Your actual password:</label>
                        <input type="password" id="expassword" name="expassword" class="form-control "/>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-danger" value="Delete"/>
                </div>
            </form>
        </div>
    </div>
</div>
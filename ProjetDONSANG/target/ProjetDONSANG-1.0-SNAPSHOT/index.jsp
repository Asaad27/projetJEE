
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/fontawesome-all.min.js"></script>
    <style>
        body, html {
            height: 100%;
            margin: 0;
        }

        .bg {
            /* The image used */
            background-image: url("/img/background.jpg");

            /* Full height */
            height: 50%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="navbar-header"> <a class="navbar-brand" href="#"><a class="navbar-brand" href="/"  >
        <img src="img/logo.png" style="height: 38px; margin-top: -2px;" class="mr-4">
    </a>dondesang</a></div>
    <ul class="nav navbar-nav">
        <li> <a href="#"> <span class="glyphicon glyphicon-home"></span> Acceuil</a> </li>
        <li> <a href="TestDon"><span class="glyphicon glyphicon-question-sign"></span> je peux donner ? </a> </li>
        <li> <a href="#"><span class="glyphicon glyphicon-envelope"></span> contacter nous</a> </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li class="nav-item mr-1 ${(not empty sessionScope.utilisateur)  ? 'd-none': ''}">
            <a href="Login"
               class="nav-link border border-light rounded">
                <span class="glyphicon glyphicon-log-in"></span> se connecter
            </a>
        </li>
        <li class="nav-item mr-1 ${(not empty sessionScope.utilisateur)  ? 'd-none': ''}">
            <a class="nav-link border-light">
                or
            </a>
        </li>

        <li class="nav-item ${(not empty sessionScope.utilisateur)  ? 'd-none': ''}">
            <a href="Inscription" class="nav-link border border-light rounded">
                <span class="glyphicon glyphicon-user"></span> s'inscrire
            </a>
        </li>



    </ul>
    <div class="dropdown ${(empty sessionScope.utilisateur)  ? 'd-none' : ''}">
        <button class="btn btn-default " data-toggle="dropdown ${(empty sessionScope.utilisateur)  ? 'd-none' : ''}">
        <ul class="dropdown-menu  ${(empty sessionScope.utilisateur)  ? 'd-none' : ''}"> ${not empty sessionScope.utilisateur.getNomutilisateur() ?
                sessionScope.utilisateur.getNomutilisateur() : ''}
            <li>
                <a href="">Mon profil</a>

            </li>
            <li>
                <a href="">se déconnecter</a>

            </li>
        </ul>
        </button>
    </div>
</nav>
<div class="bg"></div>

<footer class="bg-light text-center text-white">
    <!-- Grid container -->
    <div class="container p-4 pb-0">
        <!-- Section: Social media -->
        <section class="mb-4">
            <!-- Facebook -->
            <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #3b5998;"
                    href="#!"
                    role="button"
            ><i class="fab fa-facebook-f"></i
            ></a>

            <!-- Twitter -->
            <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #55acee;"
                    href="#!"
                    role="button"
            ><i class="fa fa-twitter"></i
            ></a>

            <!-- Google -->
            <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #dd4b39;"
                    href="#!"
                    role="button"
            ><i class="fab fa-google"></i
            ></a>

            <!-- Instagram -->
            <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #ac2bac;"
                    href="#!"
                    role="button"
            ><i class="fab fa-instagram"></i
            ></a>

            <!-- Linkedin -->
            <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #0082ca;"
                    href="#!"
                    role="button"
            ><span class="glyphicon  glyphicon-user"></span
            ></a>
            <!-- Github -->
            <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #333333;"
                    href="#!"
                    role="button"
            ><i class="fab fa-github"></i
            ></a>
        </section>
        <!-- Section: Social media -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2020 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>
</body>
</html>

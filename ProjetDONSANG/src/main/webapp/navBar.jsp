<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 21/02/2021
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>


<nav class="navbar navbar-inverse" style="
background-color: rgba(255,255,255,0.5);border-color: rgba(255,255,255,0.5);z-index: 5;">
    <div class="navbar-header" > <a class="navbar-brand" href="#" style=margin-top:13px;" ><a class="navbar-brand" href="/"  >
        <img src="img/logo.PNG" style="height: 38px; margin-top: -10px;
" class=" img-circle"/>
        <p style="color:#ff3333">dondesang</p>
    </a></a>
    </div>
    <ul class="nav navbar-nav">
        <li > <a href="#" > <span class="glyphicon glyphicon-home"></span> Acceuil</a> </li>
        <li> <a href="TestDon"><span class="glyphicon glyphicon-question-sign"></span> je peux donner ? </a> </li>
        <li> <a href="#"><span class="glyphicon glyphicon-envelope"></span> contacter nous</a> </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li class="nav-item mr-1 ${( not empty sessionScope.utilisateur)  ? 'd-none': ''} " style="display:${(not empty sessionScope.utilisateur) || (not empty sessionScope.centre) || (not empty sessionScope.admin)  ? 'none': 'block' };">
            <a href="Login"
               class="nav-link border border-light rounded">
                <span class="glyphicon glyphicon-log-in"></span> se connecter
            </a>
        </li>


        <li class="nav-item }" style="margin-right: 10px;display:${( not empty sessionScope.utilisateur) || (not  empty sessionScope.centre) || (not  empty sessionScope.admin)? 'none': 'block' };">
            <a href="Inscription" class="nav-link border border-light rounded">

                <span class="glyphicon glyphicon-user" ></span> s'inscrire
            </a>
        </li>
        <li class="nav-item " style="margin-right: 10px;display: ${( empty sessionScope.utilisateur)  ? 'none': 'block'}
                ">
            <a href="ProfilUtilisateur" class="nav-link border border-light rounded">
                <span class="glyphicon glyphicon-user" ></span>
                ${ utilisateur.nomutilisateur}
            </a>
        </li>
        <li class="nav-item " style="margin-right: 10px;display: ${( empty sessionScope.centre)   ? 'none': 'block'}
                ">
            <a href="ProfilCentre" class="nav-link border border-light rounded">
                <span class="glyphicon glyphicon-user" ></span>
                ${ centre.nameCentre
                }
            </a>
        </li>
        <li class="nav-item " style="margin-right: 10px;display: ${( empty sessionScope.admin)   ? 'none': 'block'}
                ">
            <a href="ProfilCentre" class="nav-link border border-light rounded">
                <span class="glyphicon glyphicon-user" ></span>
                ${ admin.nomAdmin}

            </a>
        </li>
        <li class="nav-item " style="margin-right: 10px;display: ${( empty sessionScope.admin)  &&  ( empty sessionScope.centre) && ( empty sessionScope.utilisateur) ? 'none': 'block'}
                ">
            <a href="Deconnexion" class="nav-link border border-light rounded">
                <span class="glyphicon glyphicon-user" ></span>
                Deconnexion

            </a>



    </ul>

</nav>

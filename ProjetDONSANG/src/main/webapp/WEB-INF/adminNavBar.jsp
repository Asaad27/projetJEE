<nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar" style="background-color: #ae1f23;">
    <div class="container">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=""
                aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/dashboard">DashBoard</a>
                </li>
            </ul>
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <i class="fas fa-user"></i> ${sessionScope.admin.nomAdmin} </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <a class="dropdown-item" href="logout">Log out</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- for authencation tags to show -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <!-- from a file is external styling (the lowest precedent) -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Exo:wght@200;400&display=swap" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="/pub/css/global.css">

        <!-- attempting to create a toggle video playback button for background video using youtube api -->
        <script src="/pub/js/capstonescripts.js"></script>
    </head>

    <body>
        <!-- navigation bar -->
        <nav id="headergradient" class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
                <!-- <img src="https://www.trueachievements.com/imagestore/0006853200/6853232.jpg" alt="logo" /></a> -->
                <img src="\pub\images\BufuSmallLogo.png" alt="logo" /></a>
                <h4 id="pageTitle">Bufu Guild Commissions</h4>


                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- drop down menu for navigation bar -->
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/home">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/portfolio">Meet The Team</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/waitlist">Waitlists</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/commission">Commission Form & TOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/create">Create a New Account</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/user/search">Select Your Guild Member</a>
                        </li>
                        <!-- this brings the question of are you logged in or not and responds with showing either the logout words or the log in words -->
                        <sec:authorize access="isAuthenticated()">
                            <li class="nav-item">
                                <a class="nav-link" href="/login/logout">Logout</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">
                                    <sec:authentication property="principal.username" />
                                </a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/login/loginPage">Login</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="hasAnyAuthority('ADMIN')">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="">Admin Exclusive Link</a>
                            </li>
                        </sec:authorize>

                    </ul>
                </div>
            </div>
        </nav>
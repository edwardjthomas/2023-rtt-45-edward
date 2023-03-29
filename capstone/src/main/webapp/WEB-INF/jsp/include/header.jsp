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

    <link rel="stylesheet" type="text/css" href="pub/css/global.css">

    <!-- attempting to create a toggle video playback button for background video using youtube api -->
    <script src="capstonescripts.js"></script>
</head>

<body>
    <!-- funny YouTube background video -->
    <!-- looped by putting video into playlist with only the video playing -->
    <div> <iframe width="560" height="315" id="backgroundVideo"
            src="https://www.youtube.com/embed/KClnQgyPacU?autoplay=1&loop=1&list=PLnjowaTwz63G6pwPZk0hL2K-iiQH37-6R&mute=1&controls=0&showinfo=0&enablejsapi=1"
            title="YouTube video player" frameborder="0"
            allow="accelerometer; autoplay; mute; loop; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen></iframe>
    </div>
    <!-- the opacity screen for the background to prevent the video from being too bright -->
    <div
        style="background-color:black; opacity: 80%; position: fixed; right: 0; bottom: 0; min-width: 100%; min-height: 100%;">
    </div>

    <!-- navigation bar -->
    <nav id="headergradient" class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="home"><img
                    src="https://www.trueachievements.com/imagestore/0006853200/6853232.jpg" alt="logo" /></a>
            <h4 id="pageTitle">Services by You Should Leave Him Be</h4>


            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- drop down menu for navigation bar -->
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="home">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="portfolio">Portfolio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="queue">Queue</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="commission">Commission Form & TOS</a>
                    </li>
                    <li class="nav-item">
                        <!-- Use a button to pause/play the video with JavaScript -->
                        <button id="videoButton" onclick="pauseVideo()">Pause Video</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
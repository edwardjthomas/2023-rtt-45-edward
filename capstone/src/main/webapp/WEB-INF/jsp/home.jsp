
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

<jsp:include page="include/header.jsp" />


<!-- a card with a image for about information -->
<div class="card mb-3 mx-auto"
    style="width: 30%; left: auto; bottom: auto; position: relative; vertical-align: middle;">
    <img src="https://blazblue.wiki/images/thumb/7/70/BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Main.png/800px-BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Main.png"
        class="card-img-top" alt="card-img-top">
    <div class="card-body">
        <h5 class="card-title">About You Should Leave Him Be...</h5>
        <p class="card-text">You know what? Maybe you should leave him be...</p>
    </div>
</div>

<!-- a card with a list group inside -->
<div class="card mb-3 mx-auto" style="width: 30%; position: relative;">
    <img src="https://blazblue.wiki/images/2/22/BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Cutin.png"
        class="card-img-top" alt="card-img-top">
    <div class="card-body">
        <h5 class="card-title">What does he do?</h5>
        <ul class="list-group">
            <li class="list-group-item">Commissions of the various variety!</li>
            <li class="list-group-item">Singing</li>
            <li class="list-group-item">Voice Over</li>
            <li class="list-group-item">Art</li>
        </ul>
        <p class="card-text">If you need his services then he's ready to go!</p>
        <p class="card-text">For more information, just head over to<a class="nav-link" href="commission.html">
                Commission Form & TOS </a></p>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
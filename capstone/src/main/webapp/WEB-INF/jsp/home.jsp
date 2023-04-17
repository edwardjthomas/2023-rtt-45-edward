<!-- funny YouTube background video -->
<!-- looped by putting video into playlist with only the video playing -->
<!-- 4/16 changed video to another opening -->
<div> <iframe width="560" height="315" id="backgroundVideo"
        src="https://www.youtube.com/embed/uhD8P7_llf0?autoplay=1&loop=1&list=PLnjowaTwz63G6pwPZk0hL2K-iiQH37-6R&mute=1&controls=0&showinfo=0&enablejsapi=1"
        title="YouTube video player" frameborder="0"
        allow="accelerometer; autoplay; mute; loop; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen></iframe>
</div>
<!-- the opacity screen for the background to prevent the video from being too bright -->
<div
    style="background-color:black; opacity: 80%; position: fixed; right: 0; bottom: 0; min-width: 100%; min-height: 100%;">
</div>

<jsp:include page="include/header.jsp" />

<div class="pb-3"></div>

<!-- a card with a image for about information -->
<div class="row">
    <div class="card mb-3 mx-auto"
        style="width: 30%; left: auto; bottom: auto; position: relative; vertical-align: middle;">
        <img src="\pub\images\BufuLogo.png" class="card-img-top" alt="card-img-top">
        <div class="card-body">
            <h3 class="text-center card-title">Welcome to the Bufu Guild Website!</h3>
            <p class="text-center card-text">Where Our Commissions Are Ice Cold</p>
        </div>
    </div>

    <!-- a card with a list group inside -->
    <div class="card mb-3 mx-auto" style="width: 30%; position: relative;">
        <img src="https://scontent-atl3-2.xx.fbcdn.net/v/t31.18172-8/705298_536023636426394_263518077_o.jpg?_nc_cat=104&ccb=1-7&_nc_sid=19026a&_nc_ohc=3VyBRAhXJgMAX_fLIGD&_nc_ht=scontent-atl3-2.xx&oh=00_AfCMN7rzLM4-FNcqGvDAjEAi7oTHfzzymmnKFdR-J2Xttw&oe=644511EC"
            class="card-img-top" alt="card-img-top">
        <div class="card-body">
            <h3 class="text-center card-title">Bufu Guild has Specialists for:</h3>
            <ul class="text-center list-group">
                <li class="list-group-item">Art by Ame</li>
                <li class="list-group-item">Live 2D Animation by Yuki</li>
                <li class="list-group-item">Mixing & Mastering Music by Asa</li>
                <li class="list-group-item">3D Modeling through Unity & Blender by Yoru</li>
                <li class="list-group-item">& Voice Over by Bufu</li>
            </ul>
            <h3>
                <p class="text-center card-text">
                    <a class="nav-link" href="portfolio">See their portfolio here</a>
                    or if you know what you like...
                    <a class="nav-link" href="commission">Apply for a commission today! </a>
                </p>
            </h3>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
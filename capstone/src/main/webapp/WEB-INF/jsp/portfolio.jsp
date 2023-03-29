<jsp:include page="include/header.jsp" />

<!-- image for the portfolio -->
<section>
    <h1>Examples of his work</h1>
    <div class="d-flex text-center align-items-center">
        <figure class="figure ">
            <img src="https://blazblue.wiki/images/2/22/BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Cutin.png"
                class="figure-img img-fluid rounded" alt="...">
            <figcaption class="figure-caption">A caption for the above image.</figcaption>
        </figure>
    </div>
</section>


<!-- a carousel for the portfolio -->
<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://blazblue.wiki/images/2/22/BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Cutin.png"
                class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://blazblue.wiki/images/2/22/BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Cutin.png"
                class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://blazblue.wiki/images/2/22/BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Cutin.png"
                class="d-block w-100" alt="...">
        </div>
    </div>
</div>

<!-- another youtube video embed using the api -->
<div id="player"></div>

<jsp:include page="include/footer.jsp" />
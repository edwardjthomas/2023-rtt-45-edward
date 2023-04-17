<jsp:include page="include/header.jsp" />

<div class="pb-3"></div>

<div class="card text-center">
    <div class="card-header">
        <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="ame-tab" data-bs-toggle="tab" data-bs-target="#ame" type="button"
                    role="tab" aria-controls="ame" aria-selected="true">Ame</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="yuki-tab" data-bs-toggle="tab" data-bs-target="#yuki" type="button"
                    role="tab" aria-controls="yuki" aria-selected="false">Yuki</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="asa-tab" data-bs-toggle="tab" data-bs-target="#asa" type="button"
                    role="tab" aria-controls="asa" aria-selected="false">Asa</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="yoru-tab" data-bs-toggle="tab" data-bs-target="#yoru" type="button"
                    role="tab" aria-controls="yoru" aria-selected="false">Yoru</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="bufu-tab" data-bs-toggle="tab" data-bs-target="#bufu" type="button"
                    role="tab" aria-controls="bufu" aria-selected="false">Bufu</button>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="ame" role="tabpanel" aria-labelledby="ame-tab">
                <div class="card-group">
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
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
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to show that equal
                                height action.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="yuki" role="tabpanel" aria-labelledby="yuki-tab">
                <div class="card-group">
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This card has supporting text below as a natural lead-in to additional
                                content.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to show that equal
                                height action.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="asa" role="tabpanel" aria-labelledby="asa-tab">
                <div class="card-group">
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <!-- another youtube video embed using the api -->
                            <div id="player"></div>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to show that equal
                                height action.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="yoru" role="tabpanel" aria-labelledby="yoru-tab">
                <div class="card-group">
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <!-- image for the portfolio -->
                            <div class="d-flex text-center align-items-center">
                                <figure class="figure ">
                                    <img src="https://blazblue.wiki/images/2/22/BlazBlue_Cross_Tag_Battle_Yosuke_Hanamura_Cutin.png"
                                        class="figure-img img-fluid rounded" alt="...">
                                    <figcaption class="figure-caption">A caption for the above image.</figcaption>
                                </figure>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to show that equal
                                height action.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="bufu" role="tabpanel" aria-labelledby="bufu-tab">
                <div class="card-group">
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This card has supporting text below as a natural lead-in to additional
                                content.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to show that equal
                                height action.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>








<jsp:include page="include/footer.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


        <jsp:include page="include/header.jsp" />

        <section class="pt-5 pb-5 light-color-bg">
            <div class="container text-center">
                <h1> ${services.artistName}'s ${services.type} Commission Details </h1>
            </div>
        </section>

        <section class="pt-5 pb-5 light-color-bg">
            <div class="container text-center" id="detailsContainer">
                <div class="card mb-3" style="max-width: 2160px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="${services.image_Url}" class="img-fluid rounded-start"
                                alt="${services.image_Url}">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h3 class="card-title">${services.description}</h3>
                                <h5 class="card-body">${services.quote}</h5>
                                <p><a href="/order/addtocart?serviceId=${services.id}"
                                        class="btn btn-primary btn-lg">Add To
                                        Cart</a></p>
                                <p><a href="/search?type=${services.type}" class="btn btn-secondary btn-sm">Return to
                                        Search</a>
                                    <sec:authorize access="isAuthenticated()">
                                        <a href="/order/viewcart" class="btn btn-primary btn-sm">Return to Cart</a>
                                    </sec:authorize>
                                </p>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <jsp:include page="include/footer.jsp" />
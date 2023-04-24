<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <section class="pt-3 pb-3 light-color-bg">
        <div class="container text-center">
            <h1> Previously Ordered Commissions </h1>
        </div>
    </section>

    <section class="pt-3 pb-3 light-color-bg">
        <div class="container text-center" id="pastOrderContainer">


            <c:set var="orderTotalPrice" value='${ord.price + orderTotalPrice}'></c:set>

            <c:forEach items="${order}" var="ord">
                <c:set var="orderQuantityPrice" value='${ord.price * ord.quantity}'></c:set>
                <c:set var="subTotalPrice" value='${orderQuantityPrice + subTotalPrice}'></c:set>
                <div class="card border-secondary mb-3" style="max-width: 2160px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="${ord.image_Url}" class="img-fluid rounded-start" alt="${ord.image_Url}">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h3 class="card-title"><a href="/details/${ord.id}">${ord.artist_name}'s ${ord.type}
                                        Commissions</a> x${ord.quantity}<p>Order placed on: ${ord.start_date}</p>
                                </h3>
                                <h4 class="card-body">Amount Paid: $${orderQuantityPrice}</h4>
                                <p><a href="/order/addtocart?serviceId=${ord.id}" class="btn btn-primary btn-lg">Order
                                        One More</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <div class="container text-center justify-content-center">
            <p><a href="/search" class="btn btn-primary">Search for New Commissions</a></p>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <section style="background-color: #ffffff;">
        <div class="container text-center">
            <h1>Your Cart</h1>
        </div>
    </section>

    <c:choose>
        <c:when test="${orderDetailsList[0].status == 'Cart'}">
            <section class="pt-3 pb-3 light-color-bg">
                <div class="container text-center" id="viewCartContainer">


                    <c:set var="orderTotalPrice" value='${ord.price + orderTotalPrice}'></c:set>

                    <c:forEach items="${orderDetailsList}" var="ord">
                        <c:set var="orderQuantityPrice" value='${ord.price * ord.quantity}'></c:set>
                        <c:set var="subTotalPrice" value='${orderQuantityPrice + subTotalPrice}'></c:set>

                        <div class="card border-primary mb-3" style="max-width: 200px; margin: 5px;">
                            <div class="card-header"><a href="/details/${ord.id}">${ord.artist_name}'s ${ord.type} Commissions</a> x${ord.quantity}</div>
                            <img src="${ord.image_Url}" class="card-img-top" alt="${ord.image_Url}">

                            <div class="card-body">
                                <h5 class="card-title">$${orderQuantityPrice}</h5>
                                <p class="card-text"></p>
                            </div>
                        </div>

                    </c:forEach>

                </div>
                <section>
                    <div class="container text-center" id="subTotalContainer">
                        <div class="card border-primary mb-3 text-center" style="max-width: 250px; margin: 5px;">

                            <div class="card-header">
                                <h4>SubTotal:</h4>
                            </div>
                            <div class="card-body text-primary">
                                <h2 class="card-title">$${subTotalPrice}</h2>
                                <p class="card-text"></p>
                            </div>
                        </div>
                    </div>
                </section>
                <div class="container text-center justify-content-center">
                    <p><a href="/order/submitOrder" class="btn btn-primary btn-lg">Checkout</a></p>
                    <p><a href="/search" class="btn btn-primary">Add More Commissions</a></p>
                </div>
            </section>
        </c:when>

        <c:otherwise>
            <section class="pt-3 pb-3 light-color-bg">
                <!-- have the cart be empty. -->
                <div class="container text-center">
                    <div class="justify-content-center">
                        <div class="card">
                            <!-- <img class="card-img-top" src="..." alt="Card image cap"> -->
                            <div class="card-body">
                                <h5 class="card-title">Cart is empty</h5>
                                <p class="card-text">Please add items to the cart to make a purchase.</p>
                                <p><a href="/search" class="btn btn-primary">Return to Search</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </c:otherwise>
    </c:choose>

    <jsp:include page="../include/footer.jsp" />
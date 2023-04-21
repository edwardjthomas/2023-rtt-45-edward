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

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Artist</th>
                                <th scope="col">Type of Commissions</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${orderDetailsList}" var="ord">

                                <tr>
                                    <td scope="row">${ord.artist_name}</td>
                                    <td scope="row">${ord.type}</td>
                                    <td scope="row">$${ord.price}</td>
                                    <td scope="row">${ord.quantity}</td>
                                </tr>

                                <div class="card border-primary mb-3" style="max-width: 250px; margin: 5px;">
                                    <div class="card-header">${ord.artist_name}'s ${ord.type} Commissions x${ord.quantity}</div>
                                    <div class="card-body text-primary">
                                        <h5 class="card-title">$${ord.price}</h5>
                                        <p class="card-text"></p>
                                    </div>
                                    <img src="${ord.image_Url}" class="card-img-bottom" alt="${ord.image_Url}">
                                </div>
                            </c:forEach>

                        </tbody>
                    </table>


                </div>
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
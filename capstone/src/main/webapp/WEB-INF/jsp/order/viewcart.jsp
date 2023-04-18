<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <section style="background-color: #ffffff;">
        <div class="container text-center">
            <h1>Cart</h1>
        </div>
    </section>

    <section style="background-color: #ffffff;">
        <!-- have one side show the product and have the other side show the quantity and price. -->
        <!-- but until then have the cart be empty. -->
        <div class="container text-center">
            <div class="justify-content-center">
                <div class="card">
                    <!-- <img class="card-img-top" src="..." alt="Card image cap"> -->
                    <div class="card-body">
                        <h5 class="card-title">Cart is empty</h5>
                        <p class="card-text">Please add items to the cart to make a purchase.</p>
                        <a href="" class="btn btn-primary">Checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <section style="background-color: #ffffff;">
        <div class="container text-center">
            <h1>Your Cart</h1>
        </div>
    </section>

       <section class="pt-3 pb-3 light-color-bg">
           <div class="container text-center">
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
                    </c:forEach>

                </tbody>
               </table>
               <a href="/order/submitOrder" class="btn btn-primary">Checkout</a>

           </div>
       </section>

    <jsp:include page="../include/footer.jsp" />
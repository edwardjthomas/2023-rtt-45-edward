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

                    <c:forEach items="${orderItem}" var="ord">

                        <tr>
                            <td scope="row">${ord.id}</td>
                            <td scope="row">${ord.userId}</td>
                            <td scope="row">$${ord.startDate}</td>
                            <td scope="row">${ord.status}</td>
                        </tr>
                    </c:forEach>

                </tbody>
               </table>
           </div>
       </section>

    <jsp:include page="../include/footer.jsp" />
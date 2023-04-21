<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <section class="pt-3 pb-3 light-color-bg">
        <div class="container text-center">
            <h1> Previously Ordered Commissions </h1>
        </div>
    </section>

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container text-center">

            <h4 class="pb-2">You have previously ordered ${order.size()} Commissions</h4>


            <table class="table table-striped border">
                <!-- thead specifices this is the header row for the table -->
                <thead>
                    <tr>
                        <!-- we were asked to add the id to this page. it takes two lines of code to cover it -->
                        <!-- in the second implementation, we connect it to a link by using the <a></a> reference with href to send it to the detail page with the id attached -->
                        <th scope="col">Artist</th>
                        <th scope="col">Type of Commission</th>
                        <th scope="col">Price</th>
                        <th scope="col">Image Example</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- this is the second step for for loop in jsp -->
                    <!-- for each items in this list, call this iteration as emp -->
                    <c:forEach items="${order}" var="serv">

                        <tr>
                            <!-- this is the third step. make sure to check back to the object's respective entity folder to clarify files -->
                            <!-- remember: you HAVE to include it on each page this is being used -->
                            <td scope="row">${serv.artist_name}</td>
                            <td scope="row">${serv.type}</td>
                            <td scope="row">$${serv.price}</td>
                            <td scope="row"><img src="${serv.image_Url}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
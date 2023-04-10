<!-- this the first step in using a for loop in a jsp. it is called JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!-- when working in new folders from main folders make sure to use ../ in front of your file names to fix the weird servlet exception -->
    <jsp:include page="../include/header.jsp" />

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container text-center">
            <h1> Select Your Guild Member </h1>
        </div>
    </section>

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container">
            <div class="row text-center justify-content-center">
                <div class="col-7">
                    <form>
                        <div class="input-group mb-3">
                            <!-- if you want the form to submit you remove type = "button" -->
                            <!-- you need to give input tag a name if you want to search for something on the page. it will reflect on the url if the search submit was successful -->
                            <input type="text" class="form-control" name="artistName"
                                placeholder="Choose between Ame, Yuki, Asa, Yoru, or Bufu"
                                aria-label="Choose between Ame, Yuki, Asa, Yoru, or Bufu" aria-describedby="search"
                                value="${artistNameParameter}">
                        </div>
                        <button class="btn btn-outline-secondary" id="search">Search</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container text-center">

            <h4 class="pb-2">${servicesList.size()} Guild Member Selected!</h4>


            <table class="table table-striped border">
                <!-- thead specifices this is the header row for the table -->
                <thead>
                    <tr>
                        <!-- we were asked to add the id to this page. it takes two lines of code to cover it -->
                        <!-- in the second implementation, we connect it to a link by using the <a></a> reference with href to send it to the detail page with the id attached -->
                        <th scope="col">Id</th>
                        <th scope="col">Artist</th>
                        <th scope="col">Type of Commissions</th>
                        <th scope="col">Starting Price of Commission</th>
                        <th scope="col">Description</th>
                        <th scope="col">Image Example</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- this is the second step for for loop in jsp -->
                    <!-- for each items in this list, call this iteration as emp -->
                    <c:forEach items="${servicesList}" var="serv">

                        <tr>
                            <!-- this is the third step. make sure to check back to the object's respective entity folder to clarify files -->
                            <!-- remember: you HAVE to include it on each page this is being used -->
                            <th scope="row"><a href="/details/${serv.id}">${serv.id}</a></th>
                            <td scope="row">${serv.artistName}</td>
                            <td scope="row">${serv.type}</td>
                            <td scope="row">$${serv.price}</td>
                            <td scope="row">${serv.description}</td>
                            <td scope="row"><img src="${serv.image_Url}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
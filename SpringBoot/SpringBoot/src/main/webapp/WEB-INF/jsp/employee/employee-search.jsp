<!-- this the first step in using a for loop in a jsp. it is called JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!-- when working in new folders from main folders make sure to use ../ in front of your file names to fix the weird servlet exception -->
    <jsp:include page="../include/header.jsp" />

    <section class="pt-5 pb-5 bg-dark-color">
        <div class="container text-center">
            <h1> Employee Search </h1>
        </div>
    </section>

    <section class="pt-5 pb-5 bg-light-color">
        <div class="container">
            <div class="row text-center justify-content-center">
                <div class="col-7">
                    <form>
                        <div class="input-group mb-3">
                            <!-- if you want the form to submit you remove type = "button" -->
                            <!-- you need to give input tag a name if you want to search for something on the page. it will reflect on the url if the search submit was successful -->
                            <input type="text" class="form-control" name="firstsearch" placeholder="Employee First Name"
                                aria-label="Employee First Name" aria-describedby="search"
                                value="${firstsearchParameter}">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="lastsearch"
                                    placeholder="Employee Last Name" aria-label="Employee Last Name"
                                    aria-describedby="search" value="${lastsearchParameter}">
                            </div>
                        </div>
                        <button class="btn btn-outline-secondary" id="search">Search</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section class="pt-5 pb-5 bg-dark-color">
        <div class="container text-center">

            <h4 class="pb-2">${employeesList.size()} Search Results</h4>


            <table class="table">
                <!-- thead specifices this is the header row for the table -->
                <thead>
                    <tr>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Job Title</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- this is the second step for for loop in jsp -->
                    <!-- for each items in this list, call this iteration as emp -->
                    <c:forEach items="${employeesList}" var="emp">

                        <tr>
                            <!-- this is the third step. make sure to check back to the object's respective entity folder to clarify files -->
                            <!-- remember: you HAVE to include it on each page this is being used -->
                            <th scope="row">${emp.firstName}</th>
                            <td scope="row">${emp.lastName}</td>
                            <td scope="row">${emp.email}</td>
                            <td scope="row">${emp.jobTitle}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
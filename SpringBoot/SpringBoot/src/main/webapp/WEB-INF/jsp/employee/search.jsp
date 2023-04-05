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
                            <input type="text" class="form-control" name="firstName" placeholder="Employee First Name"
                                aria-label="Employee First Name" aria-describedby="search"
                                value="${firstsearchParameter}">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="lastName"
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


            <table class="table table-striped border">
                <!-- thead specifices this is the header row for the table -->
                <thead>
                    <tr>
                        <!-- we were asked to add the id to this page. it takes two lines of code to cover it -->
                        <!-- in the second implementation, we connect it to a link by using the <a></a> reference with href to send it to the detail page with the id attached -->
                        <th scope="col">Id</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Job Title</th>
                        <th scope="col">Office City</th>
                        <th scope="col">Extension</th>
                        <th scope="col">Vacation Hours</th>
                        <th scope="col">Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- this is the second step for for loop in jsp -->
                    <!-- for each items in this list, call this iteration as emp -->
                    <c:forEach items="${employeesList}" var="emp">

                        <tr>
                            <!-- this is the third step. make sure to check back to the object's respective entity folder to clarify files -->
                            <!-- remember: you HAVE to include it on each page this is being used -->
                            <th scope="row"><a href="/employee/detail/${emp.id}">${emp.id}</a></th>
                            <td scope="row">${emp.firstName}</td>
                            <td scope="row">${emp.lastName}</td>
                            <td scope="row">${emp.email}</td>
                            <td scope="row">${emp.jobTitle}</td>
                            <td scope="row">${emp.officeId}</td>
                            <td scope="row">${emp.extension}</td>
                            <td scope="row">${emp.vacationHours}</td>
                            <td><a href="/employee/edit/${emp.id}">Edit</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
    <!-- please for the love of god remember to use ../ for header and footer if it cannot be found within the project's directory on the webpage -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <section class="pt-5 pb-5 bg-dark-color">
        <div class="container text-center">
            <h1> Employee Details </h1>
        </div>
    </section>

    <section class="pt-5 pb-5 bg-light-color">
        <div class="container text-center">

            <h4 class="pb-2">Employee Details</h4>
            <a href="/employee/edit/${employee.id}">Return To Edit</a>
            <!-- creating a table that will take one row of employee's keys and another row of the employee's values -->
            <table class="table table-striped border">
                <tr>
                    <td>Id</td>
                    <td>${employee.id}</td>
                </tr>
                <!-- this will allow someone to click on the name inside the details page and then just go back to the employee search page with their search parameters in tact -->
                <tr>
                    <td>First Name</td>
                    <td><a href="/employee/search?firstName=${employee.firstName}">${employee.firstName}</a></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><a href="/employee/search?lastName=${employee.lastName}">${employee.lastName}</a></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${employee.email}</td>
                </tr>
                <tr>
                    <td>Job Title</td>
                    <td>${employee.jobTitle}</td>
                </tr>
                <tr>
                    <td>Extension</td>
                    <td>${employee.extension}</td>
                </tr>
                <tr>
                    <td>Vacation Hours</td>
                    <td>${employee.vacationHours}</td>
                </tr>
                <!-- to show the url properly you gotta use img src="" -->
                <tr>
                    <td>Profile Image</td>
                    <td><img src="${employee.profileImage}"></img></td>
                </tr>
            </table>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
    <!-- please for the love of god remember to use ../ for header and footer if it cannot be found within the project's directory on the webpage -->
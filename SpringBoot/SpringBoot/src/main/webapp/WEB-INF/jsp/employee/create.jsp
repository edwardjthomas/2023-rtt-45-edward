<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <section class="pt-5 pb-5 bg-dark-color">
        <div class="container text-center">
            <!-- an if statement to determine the page header as a create form or as edit form depending on whether the form.id is empty or not-->
            <c:if test="${empty form.id}">
                <h1> Employee Create </h1>
            </c:if>
            <c:if test="${not empty form.id}">
                <h1> Employee Edit </h1>
            </c:if>
        </div>
    </section>

    <section class="pt-5 pb-5 bg-light-color">
        <div class="container mt-3">
            <!-- the action tag here indicates "when the form is submitted, submit it to this url here" -->
            <form action="/employee/createSubmit" method="POST">
                <!-- we have to add the id that we established from the employeecontroller as a hidden value underneath the form call -->
                <input type="hidden" name="id" value="${form.id}" />
                
                <div class=" mb-3">
                    <c:if test="${not empty form.id}">
                        <label for="editEmp" class="form-label"> Return to  </label>
                        <a id="editEmp" href="/employee/detail/${form.id}"> Employee Details </a>
                    </c:if>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                        value="${form.email}">
                </div>

                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName"
                        aria-describedby="firstNameHelp" value="${form.firstName}">
                </div>

                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName"
                        aria-describedby="lastNameHelp" value="${form.lastName}">
                </div>

                <!-- playing with office entity and adding the office stuff from the officedao and office entity -->
                <div class="mb-4">
                    <label for="office" class="form-label">Office</label>
                    <!-- make sure that the name parameter is the same as the name in the EmployeeFormBean. in this example, officeId -->
                    <select id="office" name="officeId" class="form-select">
                        <!-- this is a call over at the employeecontroller for the offices as well -->
                        <c:forEach items="${offices}" var="office">
                            <!-- so if the office id in the value is equals to the form's office id, then it will select said office id -->
                            <option value="${office.id}" <c:if test="${office.id eq form.officeId}">
                                selected
                                </c:if>
                                >${office.city}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="jobTitle" class="form-label">Job Title</label>
                    <input type="text" class="form-control" id="jobTitle" name="jobTitle"
                        aria-describedby="jobTitleHelp" value="${form.jobTitle}">
                </div>

                <div class="mb-3">
                    <label for="profileImage" class="form-label">Profile Image</label>
                    <input type="text" class="form-control" id="profileImage" name="profileImage"
                        aria-describedby="profileImageHelp" value="${form.profileImage}">
                </div>

                <div class="mb-3">
                    <label for="vacationHours" class="form-label">Vacation Hours</label>
                    <input type="number" class="form-control" id="vacationHours" name="vacationHours"
                        aria-describedby="vacationHoursHelp" value="${form.vacationHours}">
                </div>

                <div class="mb-3">
                    <label for="extension" class="form-label">Extension</label>
                    <input type="text" class="form-control" id="extension" name="extension"
                        aria-describedby="extensionHelp" value="${form.extension}">
                </div>

                <!-- in conjunction with EmployeeFormBean.java we get things working -->
                <!-- <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2" onclick="formSubmit()">Create
                    Account</button> -->

                <c:if test="${empty form.id}">
                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2"
                        onclick="formSubmit()">Create Employee</button>
                </c:if>
                <c:if test="${not empty form.id}">
                    <button type="submit" id="edit_btn" class="btn btn-primary mt-3 me-2" onclick="formSubmit()">Edit
                        Employee</button>
                </c:if>
            </form>
        </div>
    </section>

    <jsp:include page="../include/footer.jsp" />
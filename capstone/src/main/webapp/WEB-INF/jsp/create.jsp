<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="include/header.jsp" />

    <section style="padding: 2%; background-color: #ffffff;">
        <div class="container">
            <div class="row justify-content-center">
                <h1 class="text-center">Create New User</h1>
                <form method="POST" action="/create">
                    <c:if test="${success}">
                        <div class="alert alert-success" role="alert">
                            New User Created
                        </div>
                    </c:if>
                    <!-- gather the information of a new user via username, password, email, name, and contact method -->
                    <input type="hidden" name="id" value="${form.id}" />
                    <div class="col-6 offset-md-3">
                        <c:if test="${bindingResult.hasFieldErrors('username')}">
                            <c:forEach items="${bindingResult.getFieldErrors('username')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="username" placeholder="@username"
                                name="username" aria-describedby="usernameHelp" value="${form.username}">
                            <label for="username">Username</label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <c:if test="${bindingResult.hasFieldErrors('password')}">
                            <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="password" placeholder="Password"
                                name="password" aria-describedby="passwordHelp" value="${form.password}">
                            <label for="password">Password</label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                            <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="confirmPassword"
                                placeholder="Confirm Password" name="confirmPassword"
                                aria-describedby="confirmPasswordHelp" value="${form.password}">
                            <label for="confirmPassword">Confirm Password</label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <c:if test="${bindingResult.hasFieldErrors('email')}">
                            <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" id="email" placeholder="name@example.com"
                                name="email" aria-describedby="emailHelp" value="${form.email}">
                            <label for="email">Email address</label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <c:if test="${bindingResult.hasFieldErrors('name')}">
                            <c:forEach items="${bindingResult.getFieldErrors('name')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="name" placeholder="name" name="name"
                                aria-describedby="nameHelp" value="${form.name}">
                            <label for="name">Name</label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <c:if test="${bindingResult.hasFieldErrors('preferredContact')}">
                            <c:forEach items="${bindingResult.getFieldErrors('preferredContact')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                        <!-- dropdown menu for preferred contact method -->
                        <div class="form-floating mb-3">
                            <select class="form-select" id="preferredContact" aria-label="Floating label select"
                                name="preferredContact" aria-describedby="preferredContactHelp"
                                value="${form.preferredContact}">
                                <option selected="E-Mail">E-Mail</option>
                                <option value="Twitter">Twitter</option>
                                <option value="Discord">Discord</option>
                            </select>
                            <label for="preferredContact">Preferred Contact Method</label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <p class="text-secondary fst-italic"><small>I would like to opt in to the mailing list for Bufu
                                Guild Commissions:</small></p>
                        <div class="form-check form-check-inline mb-3">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                                value="option1">
                            <label class="form-check-label" for="inlineRadio1">Yes</label>
                        </div>
                        <div class="form-check form-check-inline mb-3">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                                value="option2">
                            <label class="form-check-label" for="inlineRadio2">No</label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">
                                I agree to the Terms and Conditions
                            </label>
                        </div>
                    </div>

                    <div class="col-6 offset-md-3">
                        <button type="submit" id="create_btn" class="btn btn-primary">Confirm Changes</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <jsp:include page="include/footer.jsp" />
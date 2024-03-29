<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <div style="padding: 1%;"></div>

    <section style="padding: 2%; background-color: #ffffff;">
        <div class="container">
            <div class="row justify-content-center">
                <h1 class="text-center">Login</h1>
                <form method="POST" action="/login/loginpost">
                    <c:if test="${param['error'] != null}">
                        <section class="pt-5 bg-light-color">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-sm-10 col-md-7 col-xl-5">
                                        <div class="alert alert-danger" role="alert">
                                            Invalid Username or Password
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </c:if>
                    <div class="col-6 offset-md-3">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="username" placeholder="Username">
                            <label for="username">Username</label>
                        </div>
                    </div>
                    <div class="col-6 offset-md-3">
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" name="password" placeholder="Password">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <div class="col-6 offset-md-3">
                        <button type="submit" id="create_btn" class="btn btn-primary">Sign In</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <jsp:include page="../include/footer.jsp" />
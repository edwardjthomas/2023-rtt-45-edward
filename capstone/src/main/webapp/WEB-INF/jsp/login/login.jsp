<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../include/header.jsp" />

    <form method="POST" action="/login/loginpost">

        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="username" placeholder="Username">
            <label for="username">Username</label>
        </div>

        <div class="form-floating mb-3">
            <input type="password" class="form-control" name="password" placeholder="Password">
            <label for="password">Password</label>
        </div>

        <div class="col-12">
            <button type="submit" id="create_btn" class="btn btn-primary">Sign In</button>
        </div>

    </form>

    <jsp:include page="../include/footer.jsp" />
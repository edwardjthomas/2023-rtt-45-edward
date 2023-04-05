<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="include/header.jsp" />

    <div class="form-floating mb-3">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        <label for="floatingInput">Username</label>
    </div>

    <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
    </div>

    <div class="col-12">
        <button type="submit" class="btn btn-primary" onclick="formSubmit()">Sign In</button>
    </div>

    <jsp:include page="include/footer.jsp" />
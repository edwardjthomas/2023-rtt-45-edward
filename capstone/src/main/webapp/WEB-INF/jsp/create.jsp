<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<form>
    <!-- gather the information of a new user via username, password, email, name, and contact method -->
    <div class="form-floating mb-3">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        <label for="floatingInput">Username</label>
    </div>

    <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
    </div>

    <div class="form-floating mb-3">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        <label for="floatingInput">Email address</label>
    </div>

    <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Name</label>
    </div>

    <!-- dropdown menu for preferred contact method -->
    <div class="form-floating mb-3">
        <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
            <option selected>Please Select a Contact Method</option>
            <option value="1">Twitter</option>
            <option value="2">Discord</option>
            <option value="3">E-Mail</option>
        </select>
        <label for="floatingSelect">Preferred Contact Method</label>
    </div>

    <div class="col-12">
        <button type="submit" class="btn btn-primary" onclick="formSubmit()">Confirm Changes</button>
    </div>
</form>
<jsp:include page="include/footer.jsp" />
// Due to needing to create Spring Security compatibility this has been removed

<% @taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="include/header.jsp" />

    <form action="/createSubmit">
        <!-- gather the information of a new user via username, password, email, name, and contact method -->
        <input type="hidden" name="id" value="${form.id}" />

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="username" placeholder="@username" name="username"
                aria-describedby="usernameHelp" value="${form.username}">
            <label for="username">Username</label>
        </div>

        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="password" placeholder="Password" name="password"
                aria-describedby="passwordHelp" value="${form.password}">
            <label for="password">Password</label>
        </div>

        <div class="form-floating mb-3">
            <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email"
                aria-describedby="emailHelp" value="${form.email}">
            <label for="email">Email address</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="name" placeholder="name" name="name" aria-describedby="nameHelp"
                value="${form.name}">
            <label for="name">Name</label>
        </div>

        <!-- dropdown menu for preferred contact method -->
        <div class="form-floating mb-3">
            <select class="form-select" id="preferredContact" aria-label="Floating label select" name="preferredContact"
                aria-describedby="preferredContactHelp" value="${form.preferredContact}">
                <option selected>Please Select a Contact Method</option>
                <option value="Twitter">Twitter</option>
                <option value="Discord">Discord</option>
                <option value="E-Mail">E-Mail</option>
            </select>
            <label for="preferredContact">Preferred Contact Method</label>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary" onclick="formSubmit()">Confirm Changes</button>
        </div>
    </form>
    <jsp:include page="include/footer.jsp" />
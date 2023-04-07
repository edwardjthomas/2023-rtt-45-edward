<jsp:include page="../include/header.jsp" />

<section class="pt-5 pb-5" style="background-color:rgb(218, 225, 234)">
    <div class="container text-center">
        <h2 class="m-0">Login</h2>
    </div>
</section>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <!-- the method must...just refer to the git pull... -->
                <!-- the form method ALWAYS has to be a post -->
                <!-- the reason for login loginpost is so that everything login related would be under the login url -->
                <form method="POST" action="/login/loginpost">
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <!-- the input field's names HAS to be username and password because Spring Security says so -->
                        <input type="text" name="username"  class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="text" name="password"  class="form-control">
                    </div>
                     <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Login</button>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />

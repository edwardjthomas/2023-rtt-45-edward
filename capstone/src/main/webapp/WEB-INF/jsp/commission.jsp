<jsp:include page="include/header.jsp" />

<!-- a scrollpy for the terms of service -->
<section style="background-color: #87cefa86;">
    <nav id="navbar-example3" class="navbar navbar-light bg-light flex-column align-items-stretch p-3">
        <a class="navbar-brand" href="#">Terms of Service</a>
        <nav class="nav nav-pills flex-column">
            <a class="nav-link" href="#item-1">Item 1</a>
            <nav class="nav nav-pills flex-column">
                <a class="nav-link ms-3 my-1" href="#item-1-1">Item 1-1</a>
                <a class="nav-link ms-3 my-1" href="#item-1-2">Item 1-2</a>
            </nav>
            <a class="nav-link" href="#item-2">Item 2</a>
            <a class="nav-link" href="#item-3">Item 3</a>
            <nav class="nav nav-pills flex-column">
                <a class="nav-link ms-3 my-1" href="#item-3-1">Item 3-1</a>
                <a class="nav-link ms-3 my-1" href="#item-3-2">Item 3-2</a>
            </nav>
        </nav>
    </nav>

    <div data-bs-spy="scroll" data-bs-target="#navbar-example3" data-bs-offset="0" tabindex="0">
        <h4 id="item-1">Item 1</h4>
        <p>...</p>
        <h5 id="item-1-1">Item 1-1</h5>
        <p>...</p>
        <h5 id="item-1-2">Item 1-2</h5>
        <p>...</p>
        <h4 id="item-2">Item 2</h4>
        <p>...</p>
        <h4 id="item-3">Item 3</h4>
        <p>...</p>
        <h5 id="item-3-1">Item 3-1</h5>
        <p>...</p>
        <h5 id="item-3-2">Item 3-2</h5>
        <p>...</p>
    </div>
</section>

<div style="padding: 1%;"></div>

<!-- form to apply for commissions  -->
<section style="background-color: #87cefa86;">
    <h3 style="text-align: center;"> Apply For A Commission!</h3>
    <form class="row g-3 needs-validation" novalidate>
        <div class="col-md-4">
            <label for="validationCustom01" class="form-label">First name</label>
            <input type="text" class="form-control" id="validationCustom01" value="Mark" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-4">
            <label for="validationCustom02" class="form-label">Last name</label>
            <input type="text" class="form-control" id="validationCustom02" value="Otto" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-4">
            <label for="validationCustomUsername" class="form-label">Twitter Handle</label>
            <div class="input-group has-validation">
                <span class="input-group-text" id="inputGroupPrepend">@</span>
                <input type="text" class="form-control" id="validationCustomUsername"
                    aria-describedby="inputGroupPrepend" required>
                <div class="invalid-feedback">
                    Please enter a handle.
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <label for="validationCustom03" class="form-label">Any References?</label>
            <input type="text" class="form-control" id="validationCustom03" required>
            <div class="invalid-feedback">
                Any link from twitter or youtube will suffice.
            </div>
        </div>
        <div class="col-md-3">
            <label for="validationCustom04" class="form-label">Which commission?</label>
            <select class="form-select" id="validationCustom04" required>
                <option selected disabled value="">Select Here!</option>
                <option>Singing</option>
                <option>Voice Over</option>
                <option>Art</option>
                <option>Video Editing</option>
            </select>
            <div class="invalid-feedback">
                Please select a commission!
            </div>
        </div>
        <h4> Gender? </h4>
        <div class="col-12">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Male
            </label>
        </div>
        <div class="col-12">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Female
            </label>
        </div>
        <div class="col-12">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Non-Binary
            </label>
        </div>
        <div class="col-12">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Other
            </label>
        </div>
        <div class="col-12">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                <label class="form-check-label" for="invalidCheck">
                    I agree to You Should Leave Him Be and his Terms of Service and understand that he holds all
                    rights to reject or cancel a commission
                </label>
                <div class="invalid-feedback">
                    You must agree before submitting.
                </div>
            </div>
        </div>

        <div class="col-12">
            <button class="btn btn-primary" type="submit">Apply</button>
        </div>
        <div style="padding: 1%;"></div>
    </form>
</section>

<table class="table table-info table-hover">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
        </tr>
    </thead>
    <tbody>
        <tr class="table-primary">
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
        </tr>
        <tr class="table-secondary">
            <th scope="row">3</th>
            <td colspan="2">Larry the Bird</td>
            <td>@twitter</td>
        </tr>
    </tbody>
</table>

<section style="background-color: #87cefa86;">
    <h3>Subscribe to the Mailing List for commission openings!</h3>
    <form>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Apply</button>
        </div>
        <!-- dealing with the issue of not being able to click on the bottom -->
        <div style="padding: 5%;"></div>
    </form>
</section>

<jsp:include page="include/footer.jsp" />
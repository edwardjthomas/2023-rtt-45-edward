<jsp:include page="include/header.jsp" />

<!-- example of style & internal styling (middle precedent) here -->
<style>
    .page-header {
        margin-left: 40px;
        margin-top: 30px;
        color: green;
    }

    /* i want all h1 tags on my page to have a 1 pixel solid border */
    h1 {
        border: 1px solid;
    }


    h1:hover {
        background-color: bisque;
    }

    /* playing with hyperlink colors */
    /* css is applied in order from top to bottom & left to right */


    a:visited {
        color: purple;
    }

    a:hover {
        color: red;
    }

    /* an example of using id tags to single out properties */
    #firsth1 {
        text-decoration: underline;
    }

    /* An example of using absolute
        you'd implement it inside the body like
        <div class="absolute-example">div box</div> */

    .absolute-example {
        width: 200px;
        height: 200px;
        background-color: chartreuse;
        position: absolute
    }

    .circle {
        margin-left: 30px;
        width: 30px;
        height: 30px;
        background-color: blue;
        border-radius: 15px;
        color: aliceblue;
        text-align: center;
        vertical-align: middle;

    }
</style>

<!-- example of in-line styling (highest precedent) -->
<h1 id="firsth1" class="page-header">This is a page title</h1>
<h2 class="page-header" style="background-color: gray;">This is another page title</h2>
<h1 class="page-header">This is a second h1</h1>

<!-- messing with hyperlinks -->
<br>
<p><a href="#">This is a link</a></p>
<p><a href="/ayo">This link is not visited</a></p>
<br>

<div class="circle"> 1 </div>

<div class="container" style="padding-top: 30px;">
    <!-- you can use table-dark to make it dark mode -->
    <table class="table table-bordered table-success table-hover table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td colspan="2">Larry the Bird</td>
                <td>@twitter</td>
            </tr>
        </tbody>
    </table>

    <button type="button" class="btn btn-primary btn-sm">Save</button>
    <button type="button" class="btn btn-secondary btn-sm">Cancel</button>

</div>

<jsp:include page="include/footer.jsp" />
<!-- please for the love of god remember to use ../ for header and footer if it cannot be found within the project's directory on the webpage -->
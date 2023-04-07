<jsp:include page="include/header.jsp" />


<section class="pt-5 pb-5 bg-light-color">
    <div class="container text-center">
        <h1> File Upload </h1>
    </div>
</section>

<section class="pt-5 pb-5 bg-light-color">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
           <!-- this is where you upload the file by using a POST method and describing it as a multipart/form-data -->
           <!-- and because of it being type post, it doesn't come back as a getmapping so you can have get and postmapping in the controller -->
                <form action="/fileupload" method="post" enctype="multipart/form-data">
                    <div class="mb-4">
                        <label for="fileUpload" class="form-label">File Upload</label>
                        <input type="file" id="fileUpload" name="fileUpload">
                    </div>
                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Upload</button>
                </form>
            </div>
        </div>
    </div>

<img src="${fileUrl}"/>

</section>

<jsp:include page="include/footer.jsp" />
<!-- this the first step in using a for loop in a jsp. it is called JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!-- when working in new folders from main folders make sure to use ../ in front of your file names to fix the weird servlet exception -->
    <jsp:include page="include/header.jsp" />

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container text-center">
            <h1> What Type of Commission Do You Desire? </h1>
        </div>
    </section>

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container">
            <div class="row text-center justify-content-center">
                <div class="col-7">
                    <form>
                        <div class="input-group mb-3">
                            <!-- if you want the form to submit you remove type = "button" -->
                            <!-- you need to give input tag a name if you want to search for something on the page. it will reflect on the url if the search submit was successful -->
                            <input type="text" class="form-control" name="type"
                                placeholder="Art, Animation, Music, 3D Modeling, or Voice Over"
                                aria-label="Art, Animation, Music, 3D Modeling, or Voice Over" aria-describedby="search"
                                value="${typeParameter}">
                        </div>
                        <button class="btn btn-outline-secondary" id="search">Search</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section class="pt-5 pb-5 light-color-bg">

        <h4 class="pb-2 text-center">${servicesList.size()} Guild Member(s) Selected!</h4>

        <div class="container text-center" id="searchResultsContainer">


                    <c:forEach items="${servicesList}" var="serv">

						<div class="card" style="width: 18rem; margin: 20px;">
                          <img src="${serv.image_Url}" class="card-img-top" alt="${serv.image_Url}">
                          <div class="card-body">
                            <h5 class="card-title">${serv.artistName}'s ${serv.type} Commissions</h5>
                            <p class="card-text">${serv.description}</p>
                            <a href="/details/${serv.id}" class="btn btn-primary">More details</a>
                          </div>
                        </div>

                    </c:forEach>
        </div>
    </section>

    <jsp:include page="include/footer.jsp" />
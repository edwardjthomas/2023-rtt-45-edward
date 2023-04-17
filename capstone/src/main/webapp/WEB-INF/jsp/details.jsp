<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="include/header.jsp" />

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container text-center">
            <h1> Guild Member Details </h1>
        </div>
    </section>

    <section class="pt-5 pb-5 light-color-bg">
        <div class="container text-center">

            <h4 class="pb-2">${services.artistName}'s Details</h4>
            <table class="table table-striped border">
                <tr>
                    <td>Id</td>
                    <td>${services.id}</td>
                </tr>
                <tr>
                    <td>Artist</td>
                    <td><a href="/user/search?artistName=${services.artistName}">${services.artistName}</a></td>
                </tr>
                <tr>
                    <td>Type of Commissions</td>
                    <td>${services.type}</a></td>
                </tr>
                <tr>
                    <td>Starting Price of Commission</td>
                    <td>$${services.price}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${services.description}</td>
                </tr>
                <tr>
                    <td>Image Example</td>
                    <td><img src="${services.image_Url}"></img></td>
                </tr>
            </table>
        </div>
    </section>

    <jsp:include page="include/footer.jsp" />
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">


    <h1>Books</h1>
    <div class="container text-center">

        <c:forEach var="book" items="${books}">
            <div class="row">

                <div class="col">
                        ${book.bookName}
                </div>
                <div class="col">
                        ${book.nrPagini}
                </div>
                <div class="col">
                        ${book.autor.numeAutor} ${book.autor.prenumeAutor}
                </div>

            </div>
        </c:forEach>


    </div>

</t:pageTemplate>
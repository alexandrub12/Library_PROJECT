<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">


    <h1>Books</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Books">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddBook">Add Book</a>
        <button class="btn btn-danger" type="submit">Delete Books</button>
        <div class="container text-center">

            <c:forEach var="book" items="${books}">
                <div class="row">

                    <div class="col">
                        <input type="checkbox" name="book_ids" value="${book.id}"/>
                    </div>

                    <div class="col">
                            ${book.bookName}
                    </div>

                    <div class="col">
                            ${book.nrPagini}
                    </div>

                    <div class="col">
                            ${book.autor.numeAutor} ${book.autor.prenumeAutor}
                    </div>

                    <div class="col">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditBook?id=${book.id}">Edit
                            Book</a>
                    </div>

                </div>
            </c:forEach>

        </div>
    </form>
</t:pageTemplate>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">


    <h1>Books</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Books">
        <c:if test="${pageContext.request.isUserInRole('WRITE_BOOKS')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddBook">Add Book</a>
            <button class="btn btn-danger" type="submit">Delete Books</button>
        </c:if>
        <div class="container text-center">

            <c:forEach var="book" items="${books}">
                <div class="row">
                    <c:if test="${pageContext.request.isUserInRole('WRITE_AUTORS')}">
                        <div class="col">
                            <input type="checkbox" name="book_ids" value="${book.id}"/>
                        </div>
                    </c:if>
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/BookPhotos?id=${book.id}" width="100"/>
                    </div>
                    <div class="col">
                            <b>Nume carte</b>: ${book.bookName}
                        <br>
                            <b>Nume autor</b>: ${book.autor.numeAutor} ${book.autor.prenumeAutor}
                        <br>
                            <b>Numar pagini</b>: ${book.nrPagini}
                        <br>
                            <b>Stoc disponibil</b>: ${book.cantitate}
                    </div>
                    <c:if test="${pageContext.request.isUserInRole('WRITE_BOOKS')}">
                        <div class="col">
                            <a class="btn btn-secondary"
                               href="${pageContext.request.contextPath}/AddBookPhoto?id=${book.id}" role="button">Add
                                Photo</a>
                            <br>
                                <a class="btn btn-secondary"
                                   href="${pageContext.request.contextPath}/EditBook?id=${book.id}">Edit Book</a>
                        </div>
                    </c:if>
                </div>
                <br>
            </c:forEach>
        </div>
    </form>
</t:pageTemplate>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Book">

    <h1>Edit Book</h1>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/EditBook">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="book_name">Book Name</label>
                <input type="text" class="form-control" id="book_name" name="book_name" placeholder="" value="${book.bookName}" required>
                <div class="invalid-feedback">
                    Book Name is required.
                </div>
                <label for="pages_number">Pages Number</label>
                <input type="text" class="form-control" id="pages_number" name="pages_number" placeholder="" value="${book.nrPagini}" required>
                <div class="invalid-feedback">
                    Pages Number is required.
                </div>
                <select class="custom-select d-block w-100" id="autor_id" name="autor_id" required>
                    <option value="">Choose...</option>
                    <c:forEach var="autor" items="${autori}" varStatus="status">
                        <option value="${autor.id}" ${book.autor.numeAutor eq autor.numeAutor && book.autor.prenumeAutor eq autor.prenumeAutor ? 'selected' : ''}>${autor.numeAutor} ${autor.prenumeAutor}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-primary btn-lg" type="submit" >Save</button>
            </div>
            <input type="hidden" name="book_id" value="${book.id}" />
        </div>



    </form>

</t:pageTemplate>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">

    <h1>ADD CAR</h1>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/AddBook">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="book_name">Book Name</label>
                <input type="text" class="form-control" id="book_name" name="book_name" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Book Name is required.
                </div>
                <label for="pages_number">Pages Number</label>
                <input type="text" class="form-control" id="pages_number" name="pages_number" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Pages Number is required.
                </div>
                <select class="custom-select d-block w-100" id="autor_id" name="autor_id" required>
                    <option value="">Choose...</option>
                    <c:forEach var="autor" items="${autori}" varStatus="status">
                        <option value="${autor.id}">${autor.numeAutor} ${autor.prenumeAutor}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-primary btn-lg" type="submit" >Save</button>
            </div>
        </div>
    </form>

</t:pageTemplate>
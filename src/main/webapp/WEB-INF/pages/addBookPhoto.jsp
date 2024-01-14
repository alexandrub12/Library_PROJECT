<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Book Photo">

    <h1>ADD Book Photo</h1>
    <form class="needs-validation" novalidate method="post" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/AddBookPhoto">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="file">Photo</label>
                <input type="file" name="file" id="file" required>
                <div class="invalid-feedback">
                    Photo is required.
                </div>
            </div>
        </div>
        <input type="hidden" name="book_id" value="${book.id}"/>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit" >Save</button>
    </form>
</t:pageTemplate>
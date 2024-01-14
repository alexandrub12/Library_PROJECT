<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Imprumutare">

  <h1>Edit Imprumutare</h1>
  <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/EditImprumutare">

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="book_id">Book</label>
        <select class="custom-select d-block w-100" id="book_id" name="book_id" required disabled>
          <option value="">Choose...</option>
          <c:forEach var="book" items="${books}" varStatus="status">
            <option value="${book.id}" ${imprumutare.book.bookName eq book.bookName ? 'selected' : ''}>${book.bookName} </option>
          </c:forEach>
        </select>
      </div>
    </div>
    <input type="hidden" name="user_id" value="${user.id}" />
    <input type="hidden" name="imprumutare_id" value="${imprumutare.id}" />

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="data_imprumutare">Data imprumutare</label>
        <input type="date" class="form-control" id="data_imprumutare" name="data_imprumutare" placeholder="" value="${imprumutare.dataImprumut}" required>
        <div class="invalid-feedback">
          Data imprumutare is required.
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="data_returnare">Data returnare</label>
        <input type="date" class="form-control" id="data_returnare" name="data_returnare" placeholder="" value="${imprumutare.dataReturnareMaxima}" required>
        <div class="invalid-feedback">
          Data returnare is required.
        </div>
      </div>
    </div>


    <hr class="mb-4">
    <button class="btn btn-primary btn-lg" type="submit" >Save</button>

  </form>

</t:pageTemplate>
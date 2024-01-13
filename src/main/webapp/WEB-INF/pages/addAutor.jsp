<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Autor">

    <h1>ADD Autor</h1>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/AddAutor">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nume_autor">Nume Autor</label>
                <input type="text" class="form-control" id="nume_autor" name="nume_autor" placeholder="" value=""
                       required>
                <div class="invalid-feedback">
                    Nume Autor is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="prenume_autor">Prenume Autor</label>
                <input type="text" class="form-control" id="prenume_autor" name="prenume_autor" placeholder="" value=""
                       required>
                <div class="invalid-feedback">
                    Prenume Autor is required.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg" type="submit" >Save</button>
    </form>

</t:pageTemplate>
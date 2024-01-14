<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Autori">

    <h1>Autori</h1>

    <form method="POST" action="${pageContext.request.contextPath}/Autori">
        <c:if test="${pageContext.request.isUserInRole('WRITE_AUTORS')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddAutor">Add Autor</a>
            <button class="btn btn-danger" type="submit">Delete Autor</button>
        </c:if>

        <div class="container text-center">
            <div class="row">
                <div class="col">

                </div>
                <div class="col">
                    <b>Prenume</b>
                </div>
                <div class="col">
                    <b>Nume</b>
                </div>
                <div class="col">

                </div>
            </div>
            <br>
            <c:forEach var="autor" items="${autori}">
                <div class="row">
                    <c:if test="${pageContext.request.isUserInRole('WRITE_AUTORS')}">
                        <div class="col">
                            <input type="checkbox" name="autor_ids" value="${autor.id}"/>
                        </div>
                    </c:if>
                    <div class="col">
                            ${autor.numeAutor}
                    </div>
                    <div class="col">
                            ${autor.prenumeAutor}
                    </div>
                    <c:if test="${pageContext.request.isUserInRole('WRITE_AUTORS')}">
                        <div class="col">
                            <a class="btn btn-secondary"
                               href="${pageContext.request.contextPath}/EditAutor?id=${autor.id}">Edit Autor</a>
                        </div>
                    </c:if>
                </div>
            </c:forEach>

        </div>
    </form>
</t:pageTemplate>
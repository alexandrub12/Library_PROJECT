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
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Prenume</th>
                    <th scope="col">Nume</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="autor" items="${autori}">
                    <tr>
                        <td>
                            <c:if test="${pageContext.request.isUserInRole('WRITE_AUTORS')}">
                                <input type="checkbox" name="autor_ids" value="${autor.id}" />
                            </c:if>
                        </td>
                        <td>${autor.prenumeAutor}</td>
                        <td>${autor.numeAutor}</td>
                        <td>
                            <c:if test="${pageContext.request.isUserInRole('WRITE_AUTORS')}">
                                <a class="btn btn-secondary"
                                   href="${pageContext.request.contextPath}/EditAutor?id=${autor.id}">Edit Autor</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </form>
</t:pageTemplate>
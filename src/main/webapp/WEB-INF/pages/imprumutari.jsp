<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Imprumutari">


    <h1>Imprumutari</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Imprumutari">

        <c:if test="${pageContext.request.isUserInRole('WRITE_IMPRUMUTARI')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddImprumutare" >Add Imprumutari</a>
        </c:if>
        <c:if test="${pageContext.request.isUserInRole('DELETE_IMPRUMUTARI')}">
            <button class="btn btn-danger" type="submit">Delete Imprumutari</button>
        </c:if>


        <div class="container text-center">
            <br>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Titlul Cartii</th>
                    <th scope="col">Nume Autor</th>
                    <th scope="col">Data Imprumutare</th>
                    <th scope="col">Data Returnare</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="imprumutare" items="${imprumutari}">
                    <tr>
                        <td>
                            <c:if test="${pageContext.request.isUserInRole('DELETE_IMPRUMUTARI')}">
                                <input type="checkbox" name="imprumutare_ids" value="${imprumutare.id}" />
                            </c:if>
                        </td>
                        <td>${imprumutare.book.bookName}</td>
                        <td>${imprumutare.book.autor.numeAutor} ${imprumutare.book.autor.prenumeAutor}</td>
                        <td>${imprumutare.dataImprumut}</td>
                        <td>${imprumutare.dataReturnareMaxima}</td>
                        <td>
                            <c:if test="${pageContext.request.isUserInRole('EDIT_IMPRUMUTARI')}">
                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditImprumutare?id=${imprumutare.id}">Edit Imprumutare</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </form>

</t:pageTemplate>
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
            <c:forEach var="imprumutare" items="${imprumutari}">
                <div class="row">

                    <c:if test="${pageContext.request.isUserInRole('DELETE_IMPRUMUTARI')}">
                        <div class="col">
                            <input type="checkbox" name ="imprumutare_ids" value="${imprumutare.id}" />
                        </div>
                    </c:if>



                    <div class="col">
                            ${imprumutare.book.bookName}
                    </div>
                    <div class="col">
                            ${imprumutare.book.autor.numeAutor} ${imprumutare.book.autor.prenumeAutor}
                    </div>
                    <div class="col">
                            ${imprumutare.dataImprumut}
                    </div>
                    <div class="col">
                            ${imprumutare.dataReturnareMaxima}
                    </div>

                    <c:if test="${pageContext.request.isUserInRole('WRITE_IMPRUMUTARI')}">
                        <div class = "col">
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditImprumutare?id=${imprumutare.id}">Edit Imprumutare</a>
                        </div>
                    </c:if>

                </div>

            </c:forEach>

        </div>
    </form>

</t:pageTemplate>
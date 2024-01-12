<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Autori">


    <h1>Autori</h1>

    <div class="container text-center">

        <c:forEach var="autor" items="${autori}">
            <div class="row">

                <div class="col">
                        ${autor.numeAutor}
                </div>
                <div class="col">
                        ${autor.prenumeAutor}
                </div>

            </div>
        </c:forEach>


    </div>

</t:pageTemplate>
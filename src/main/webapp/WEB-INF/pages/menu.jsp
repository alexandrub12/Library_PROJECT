<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>

            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('READ_BOOKS')}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Books">Books</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('READ_USERS')}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Users">Users</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('READ_AUTORS')}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Autori">Autori</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('READ_IMPRUMUTARI')}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Imprumutari">Imprumutari</a>
                        </c:if>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${pageContext.request.getRemoteUser() == null}">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <c:if test="${pageContext.request.getRemoteUser() == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Register">Register</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>
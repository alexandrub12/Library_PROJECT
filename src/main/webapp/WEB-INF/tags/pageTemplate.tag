<%@tag description="base page template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/design.css">
    <title>${pageTitle}</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/menu.jsp" />
<main class="container-fluid mt-5">
    <jsp:doBody/>
</main>


</body>
</html>
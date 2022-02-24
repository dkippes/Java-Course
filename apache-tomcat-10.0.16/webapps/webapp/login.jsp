<%@page contentType="text/html" pageEncoding="utf-8" %>

<jsp:include page="layout/header.jsp" />
<h1>${title}</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="row my-2">
        <label class="form-label" for="username">Username</label>
        <div>
            <input class="form-control" type="text" name="username" id="username">
        </div>
    </div>
    <div class="row my-2">
        <label class="form-label" for="password">Password</label>
        <div>
            <input class="form-control" type="password" name="password" id="password">
        </div>
    </div>
    <div class="row my-2">
        <input class="btn btn-primary" type="submit" value="Login">
    </div>
</form>
<jsp:include page="layout/footer.jsp" />
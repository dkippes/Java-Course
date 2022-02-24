<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="layout/header.jsp"/>
<h1>${title}</h1>
<c:choose>
    <c:when test="${sessionScope.carro == null || sessionScope.carro.items.isEmpty()}">
        <div class="alert alert-warning">Lo sentimos no hay productos en el carro de compras</div>
    </c:when>
    <c:otherwise>
        <table class="table table-hover table-striped">
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>precio</th>
                <th>cantidad</th>
                <th>total</th>
            </tr>
            <c:forEach items="${sessionScope.carro.items}" var="item">
                <tr>
                    <th>${item.producto.id}</th>
                    <th>${item.producto.nombre}</th>
                    <th>${item.producto.precio}</th>
                    <th>${item.cantidad}</th>
                    <th>${item.importe}</th>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" style="text-align: right">Total</td>
                <td>${carro.total}</td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>
<div class="my-2">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/index.jsp">Volver</a>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/productos.html">Seguir comprando</a>
</div>
<jsp:include page="layout/footer.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de compras</title>
</head>
<body>
<h1>Carro de compras</h1>
<c:choose>
<c:when test="${sessionScope.carro == null || sessionScope.carro.items.isEmpty()}">
    <p>Lo sentimos no hay productos en el carro de compras</p>
</c:when>
<c:otherwise>
<table>
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
<p><a href="${pageContext.request.contextPath}/productos.html">Seguir comprando</a></p>
<p><a href="${pageContext.request.contextPath}/index.html">Volver</a></p>
</body>
</html>
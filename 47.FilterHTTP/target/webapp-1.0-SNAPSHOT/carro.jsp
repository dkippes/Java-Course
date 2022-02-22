<%@page contentType="text/html" pageEncoding="UTF-8" import="cabecera.models.*" %>
<%
    Carro carro = (Carro) session.getAttribute("carro");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de compras</title>
</head>
<body>
<h1>Carro de compras</h1>
<%if (carro == null || carro.getItems().isEmpty()) {%>
<p>Lo sentimos no hay productos en el carro de compras</p>
<%} else {%>

<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>precio</th>
        <th>cantidad</th>
        <th>total</th>
    </tr>
    <%for (ItemCarro item : carro.getItems()) {%>
    <tr>
        <th><%=item.getProducto().getId()%></th>
        <th><%=item.getProducto().getNombre()%></th>
        <th><%=item.getProducto().getPrecio()%></th>
        <th><%=item.getCantidad()%></th>
        <th><%=item.getImporte()%></th>
    </tr>
    <%}%>
    <tr>
        <td colspan="4" style="text-align: right">Total</td>
        <td><%=carro.getTotal()%></td>
    </tr>
</table>
<%}%>
<p><a href="<%=request.getContextPath()%>/productos.html">Seguir comprando</a></p>
<p><a href="<%=request.getContextPath()%>/index.html">Volver</a></p>
</body>
</html>
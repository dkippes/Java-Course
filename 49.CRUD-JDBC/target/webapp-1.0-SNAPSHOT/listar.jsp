<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*" import="cabecera.models.*" %>
<%
  List<Producto> productos = (List<Producto>) request.getAttribute("productos");
  Optional<String> username = (Optional<String>) request.getAttribute("username");
  String mensajeRequest = (String) request.getAttribute("mensaje");
  String mensajeApp = (String) getServletContext().getAttribute("mensaje");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listar productos</title>
</head>
<body>
<h1>Listado de productos</h1>
<% if (username.isPresent()) {%>
<div>Hola <%=username.get()%>, bienvenido!</div>
<p><a href="<%=request.getContextPath()%>/productos/form">Crear [+]</a></p>
<%}%>
<table>
  <tr>
    <th>id</th>
    <th>nombre</th>
    <th>tipo</th>
    <% if (username.isPresent()) {%>
    <th>precio</th>
    <th>agregar</th>
    <th>editar</th>
    <th>eliminar</th>
    <%}%>
  </tr>
  <% for(Producto p : productos) {%>
  <tr>
    <td><%=p.getId()%></td>
    <td><%=p.getNombre()%></td>
    <td><%=p.getCategoria().getNombre()%></td>
    <% if (username.isPresent()) {%>
    <td><%=p.getPrecio()%></td>
    <td><a href="<%=request.getContextPath()%>/agregar-carro?id=<%=p.getId()%>">agregar al carro</a></td>
    <td><a href="<%=request.getContextPath()%>/productos/form?id=<%=p.getId()%>">editar</a></td>
    <td><a onclick="return confirm('Esta seguro que desea eliminar?');" href="<%=request.getContextPath()%>/productos/eliminar?id=<%=p.getId()%>">eliminar</a></td>
    <%}%>
  </tr>
  <%}%>
</table>
</body>
</html>
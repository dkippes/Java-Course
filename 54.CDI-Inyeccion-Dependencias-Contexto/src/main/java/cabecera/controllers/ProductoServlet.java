package cabecera.controllers;

import cabecera.configs.ProductoServicePrincipal;
import cabecera.models.Producto;
import cabecera.services.LoginService;
import cabecera.services.ProductoService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/productos.html")
public class ProductoServlet extends HttpServlet {

    @Inject
    private LoginService auth;

    @Inject
    @ProductoServicePrincipal
    private ProductoService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Producto> productos = service.listar();

        Optional<String> cookieOptional = auth.getUsername(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", cookieOptional);
        req.setAttribute("title", req.getAttribute("title") + ": Listado de productos");
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}

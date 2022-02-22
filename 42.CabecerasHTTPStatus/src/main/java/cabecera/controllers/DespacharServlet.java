package cabecera.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Es como un redirect pero solo lo une, es como un solo request
        // No cambiar la url - Con el redirect se pierde
        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);
    }
}

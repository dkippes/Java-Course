package ejb.controllers;

import ejb.models.Producto;
import ejb.service.ServiceEjb;
import ejb.service.ServiceEjbLocal;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServletLocal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceEjbLocal service = null;
        ServiceEjbLocal service2 = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjb) ctx.lookup("java:global/webapp/ServiceEjb!ejb.service.ServiceEjb");
            service2 = (ServiceEjb) ctx.lookup("java:global/webapp/ServiceEjb!ejb.service.ServiceEjb");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Producto p = service.crear(new Producto("Uvas"));
        System.out.println("nuevo producto " + p);

        req.setAttribute("saludo", service.saludar("Diego"));
        req.setAttribute("saludo2", service2.saludar("Andres"));
        req.setAttribute("listado", service.listar());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

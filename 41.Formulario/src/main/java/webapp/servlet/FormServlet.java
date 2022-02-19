package webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");

        Map<String, String> errores = new HashMap<>();

        if (username == null || username.isBlank()) {
            errores.put("username", "el username es requerido");
        }
        if (password == null || password.isBlank()) {
            errores.put("password", "el password no puede ser vacio");
        }
        if (email == null || !email.contains("@")) {
            errores.put("email", "El email es requerido y debe tener @");
        }
        if (pais == null || pais.isBlank()) {
            errores.put("pais", "el pais es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguajes", "debe seleccionar al menos un tema");
        }
        if (roles == null || roles.length == 0) {
            errores.put("roles", "debe seleccionar al menos un role");
        }
        if (idioma == null) {
            errores.put("idioma", "debe seleccionar un idioma");
        }

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Resultado form</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Resultado form</h1>");

        out.println("<ul>");

        if (errores.isEmpty()) {
            out.println("<li>" + "Username: " + username + "</li>");
            out.println("<li>" + "Password: " + password + "</li>");
            out.println("<li>" + "Email: " + email + "</li>");
            out.println("<li>" + "Pais: " + pais + "</li>");

            out.println("<li>Lenguajes: <ul>");
            Arrays.asList(lenguajes).forEach(l -> {
                out.println("<li>" + l + "</li>");
            });
            out.println("</ul><li>");

            out.println("<li>Roles: <ul>");
            Arrays.asList(roles).forEach(r -> {
                out.println("<li>" + r + "</li>");
            });
            out.println("</ul><li>");

            out.println("<li>" + "Idioma: " + idioma + "</li>");
            out.println("<li>" + "Habilitar: " + habilitar + "</li>");
            out.println("<li>" + "Secreto: " + secreto + "</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
//          errores.forEach(e -> {
//              out.println("<li>" + e + "</li>");
//          });
//          out.println("<p><a href=\"/webapp/index.jsp\"</a>Volver</p>");
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}

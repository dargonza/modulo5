package bootcamp.modulo5.servlet;


import bootcamp.modulo5.dto.UserResponseDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    // Método doGet que maneja la solicitud GET para la página de inicio
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperar el usuario logueado de la sesión
        UserResponseDTO loggedUser = (UserResponseDTO) req.getSession().getAttribute("loggedUser");

        if (loggedUser == null) {
            // Si el usuario no está logueado, redirigir a la página de login
            resp.sendRedirect("login.jsp");
            return;
        }

        // Si el usuario está logueado, pasar los datos a la vista
        req.setAttribute("loggedUser", loggedUser);

        // Redirigir a la página de inicio (home.jsp)
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}

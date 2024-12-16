package bootcamp.modulo5.servlet;

import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.service.UserService;
import bootcamp.modulo5.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    private UserService userService;

    public ProfileServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperar el usuario logueado de la sesión
        UserResponseDTO loggedUser = (UserResponseDTO) req.getSession().getAttribute("loggedUser");

        if (loggedUser == null) {
            // Si el usuario no está logueado, redirigir a la página de login
            resp.sendRedirect("login.jsp");
            return;
        }

        // Verificar si hay mensajes de actualización
        String successMessage = req.getParameter("success");
        String errorMessage = req.getParameter("error");

        if ("update-success".equals(successMessage)) {
            req.setAttribute("alertMessage", "Perfil actualizado exitosamente");
            req.setAttribute("alertType", "success");
        } else if ("update-failed".equals(errorMessage)) {
            req.setAttribute("alertMessage", "Error al actualizar el perfil");
            req.setAttribute("alertType", "danger");
        }

        // Si el usuario está logueado, pasar los datos a la vista
        req.setAttribute("loggedUser", loggedUser);

        // Redirigir a la página del perfil (profile.jsp)
        req.getRequestDispatcher("user-profile.jsp").forward(req, resp);
    }
}
package bootcamp.modulo5.servlet;

import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.service.HoroscopeService;
import bootcamp.modulo5.service.HoroscopeServiceImpl;
import bootcamp.modulo5.service.UserService;
import bootcamp.modulo5.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns ={"/", "/login"})
public class LoginServlet extends HttpServlet {
    private final UserService userService;
    private final HoroscopeService horoscopeService;

    // Constructor para inicializar los servicios
    public LoginServlet() {
        this.userService = new UserServiceImpl();
        this.horoscopeService = new HoroscopeServiceImpl();
    }

    // Redirige a la página de login en peticiones GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    // Manejo del login en peticiones POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Validar entradas
        String username = req.getParameter("username");
        String password = req.getParameter("password");



        if (isInvalid(username) || isInvalid(password)) {
            req.setAttribute("error", "Usuario y contraseña son obligatorios.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        // Intentar autenticación
        UserResponseDTO loggedUser = userService.loginUser(username, password);

        if (loggedUser != null) {
            req.getSession().setAttribute("loggedUser", loggedUser);
            resp.sendRedirect("home.jsp");
        } else {
            // Usuario o contraseña incorrectos
            req.setAttribute("error", "Usuario o contraseña incorrectos.");
            req.getRequestDispatcher("login.jsp?error=success").forward(req, resp);
        }
    }

    // Método auxiliar para validar entradas
    private boolean isInvalid(String value) {
        return value == null || value.trim().isEmpty();
    }
}

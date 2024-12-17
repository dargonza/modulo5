package bootcamp.modulo5.servlet;

import bootcamp.modulo5.dto.UserCreateDTO;
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
import java.time.LocalDate;


@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService;
    private final HoroscopeService horoscopeService;

    public RegisterServlet() {
        this.userService = new UserServiceImpl();
        this.horoscopeService = new HoroscopeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthDateStr = request.getParameter("birthDate");

        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr);
            UserCreateDTO userCreate = new UserCreateDTO(name, username, email, password, birthDate, "");

            boolean isRegistered = userService.registerUser(userCreate);

            if (isRegistered) {
                request.setAttribute("successMessage", "Usuario registrado exitosamente");
                response.sendRedirect("login.jsp?register=success");
            } else {
                request.setAttribute("errorMessage", "Error al registrar usuario");
                request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
            }

        } catch (IllegalArgumentException e) {
            // Captura errores específicos de validación
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
        } catch (Exception e) {
            // Captura otros errores
            request.setAttribute("errorMessage", "Ocurrió un error inesperado");
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
        }

    }


}
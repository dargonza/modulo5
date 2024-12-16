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
import java.util.Enumeration;

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

        if (name == null || name.trim().isEmpty() || name.trim().length() < 2) {

            request.setAttribute("error", "El nombre debe tener al menos 2 caracteres");
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
            return;
        }

        String username = request.getParameter("username");

        if (username == null || username.trim().isEmpty() || username.trim().length() < 2) {
            request.setAttribute("error", "El nombre de usuario debe tener al menos 2 caracteres");
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
            return;
        }

        String email = request.getParameter("email");

        if (email == null || email.trim().isEmpty() || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            request.setAttribute("error", "El email es inválido");
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
            return;
        }

        String password = request.getParameter("password");

        if (password == null || password.length() < 6) {

            request.setAttribute("error", "La contraseña debe tener al menos 6 caracteres");
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
            return;
        }

        LocalDate birthDate;
        String animalSign;
        try {
            birthDate = LocalDate.parse(request.getParameter("birthDate"));

            if (birthDate.isAfter(LocalDate.now())) {

                request.setAttribute("error", "La fecha de nacimiento no puede ser futura");
                request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
                return;
            }

            animalSign = horoscopeService.getChineseZodiacAnimal(birthDate);

            if (animalSign == null || animalSign.trim().isEmpty()) {

                request.setAttribute("error", "Error al obtener el signo del zodiaco chino");
                request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
                return;
            }
        } catch (Exception e) {

            request.setAttribute("error", "Formato de fecha inválido");
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
            return;
        }

        UserCreateDTO userCreate = new UserCreateDTO(name, username, email, password, birthDate, animalSign);


        try {
            if (userService.registerUser(userCreate)) {

                request.setAttribute("success", "Usuario registrado exitosamente");
                response.sendRedirect("login.jsp?register=success");
            } else {

                request.setAttribute("error", "Error al registrar usuario_");
                request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
            }
        } catch (Exception e) {

            request.setAttribute("error", "Error al registrar usuario");
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
        }
    }


}
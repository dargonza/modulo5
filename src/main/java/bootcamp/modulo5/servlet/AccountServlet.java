package bootcamp.modulo5.servlet;


import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.dto.UserUpdateDTO;
import bootcamp.modulo5.model.User;
import bootcamp.modulo5.service.UserService;
import bootcamp.modulo5.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/account/*")
public class AccountServlet extends HttpServlet {
    private final UserService userService;

    public AccountServlet() {
        this.userService = new UserServiceImpl();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.getRequestDispatcher("user-account.jsp").forward(request, response);
        //response.sendRedirect("user-account.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if ("/update-profile".equals(pathInfo)) {
            HttpSession session = request.getSession();
            UserResponseDTO loggedUser = (UserResponseDTO) session.getAttribute("loggedUser");
            if (loggedUser == null) {
                request.setAttribute("errorMessage", "Usuario no autenticado");
                request.getRequestDispatcher("/user-account.jsp").forward(request, response);
                return;
            }

            try {
                // Obtener parámetros del formulario
                String name = request.getParameter("name");
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String birthDateStr = request.getParameter("birth_date");
                String password = request.getParameter("password");

                // Validar campos obligatorios
                if (isNullOrEmpty(name) || isNullOrEmpty(username) || isNullOrEmpty(email) || isNullOrEmpty(birthDateStr)) {
                    request.setAttribute("errorMessage", "Todos los campos obligatorios deben completarse.");
                    request.getRequestDispatcher("/user-account.jsp").forward(request, response);
                    return;
                }

                // Convertir fecha de nacimiento
                LocalDate birthDate;
                try {
                    birthDate = LocalDate.parse(birthDateStr);
                } catch (Exception e) {
                    request.setAttribute("errorMessage", "La fecha de nacimiento no tiene un formato válido.");
                    request.getRequestDispatcher("/user-account.jsp").forward(request, response);
                    return;
                }

                // Crear DTO de actualización de usuario
                UserUpdateDTO updatedUser = new UserUpdateDTO(loggedUser.getId(), name, username, email, password, birthDate);

                // Llamar al servicio para actualizar el usuario
                UserResponseDTO updatedUserResponse = userService.updateUser(updatedUser);

                // Redirigir con éxito si la actualización se realizó
                if (updatedUserResponse != null) {
                    session.setAttribute("loggedUser", updatedUserResponse);
                    request.setAttribute("successMessage", "Perfil actualizado exitosamente");
                    request.getRequestDispatcher("/user-account.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "No se pudo actualizar el perfil");
                    request.getRequestDispatcher("/user-account.jsp").forward(request, response);
                }
            }
            catch (Exception e) {
                // Manejar la excepción y redirigir con un mensaje de error
                System.out.println("Error al actualizar el perfil: " + e.getMessage());
                request.setAttribute("errorMessage", e.getMessage());
                request.getRequestDispatcher("/user-account.jsp").forward(request, response);
            }
        }
        else if ("/delete-account".equals(pathInfo)) { // Manejar la solicitud de eliminación de cuenta
            HttpSession session = request.getSession(false);
            UserResponseDTO loggedUser = (UserResponseDTO) session.getAttribute("loggedUser");
            if (loggedUser == null) {
                response.sendRedirect("user-account.jsp?error=not-logged");
                return;
            }

            if (session != null) {
                session.invalidate();
            }

            if (!userService.deleteUser(loggedUser.getId())) {
                response.sendRedirect(request.getContextPath() + "/account?error=delete-failed");
            }

            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    // Método utilitario para validar cadenas nulas o vacías
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
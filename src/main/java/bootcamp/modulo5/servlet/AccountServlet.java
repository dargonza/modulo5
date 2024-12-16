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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathInfo = request.getPathInfo();


        if ("/update-profile".equals(pathInfo)) {

            HttpSession session = request.getSession();
            UserResponseDTO loggedUser = (UserResponseDTO) session.getAttribute("loggedUser");
            if (loggedUser == null) {
                response.sendRedirect("user-account.jsp?error=not-logged");
                return;
            }

            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            LocalDate birthDate = LocalDate.parse(request.getParameter("birth_date"));
            String password = request.getParameter("password");


            UserUpdateDTO updatedUser = new UserUpdateDTO(loggedUser.getId(), name, username, email, password, birthDate);

            UserResponseDTO updatedUserResponse = userService.updateUser(updatedUser);

            String route = "/account";
            if (updatedUserResponse != null) {
                route = route + "?success=update-success";
                session.setAttribute("loggedUser", updatedUserResponse);
            }
            else {
                session.setAttribute("loggedUser", loggedUser);
                route = route + "?error=update-failed";
            }

            response.sendRedirect(request.getContextPath() + route);
        }
        else if ("/delete-account".equals(pathInfo)) {

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
}
package bootcamp.modulo5.servlet;

import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.service.UserService;
import bootcamp.modulo5.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet", value = "/users")
public class UserListServlet extends HttpServlet {
    private final UserService userService;

    public UserListServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("loggedUser") == null) {
            resp.sendRedirect("login");
            return;
        }

        List<UserResponseDTO> users = userService.getAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("user-list.jsp").forward(req, resp);
    }
}
package bootcamp.modulo5.servlet;

import bootcamp.modulo5.configuration.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Implementación del Servlet LogoutServlet
 * Maneja la funcionalidad de cierre de sesión y gestión de sesiones de usuario
 */
@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    /**
     * Instancia de conexión a la base de datos
     */
    private final DatabaseConnection databaseConnection;

    /**
     * Constructor que inicializa la conexión a la base de datos
     * Obtiene una instancia única de la conexión mediante el patrón Singleton
     */
    public LogoutServlet() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    /**
     * Maneja las peticiones GET para el cierre de sesión de usuario
     * @param req Objeto HttpServletRequest que contiene la petición del cliente
     * @param resp Objeto HttpServletResponse para enviar la respuesta
     * @throws ServletException si el servlet encuentra dificultades
     * @throws IOException si ocurre un error de E/S
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la sesión actual si existe
        HttpSession session = req.getSession(false);

        // Cerrar la conexión a la base de datos
        // Es importante liberar los recursos de la base de datos
        this.databaseConnection.closeConnection();

        // Invalidar la sesión si existe
        // Esto elimina todos los datos de la sesión del usuario
        if (session != null) {
            session.invalidate();
        }

        // Redireccionar a la página de inicio de sesión
        // Se incluye un mensaje de éxito en la URL
        resp.sendRedirect("login.jsp?logout=success");
    }
}
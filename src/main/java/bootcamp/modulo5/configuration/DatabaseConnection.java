
package bootcamp.modulo5.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que implementa el patrón Singleton para gestionar la conexión a la base de datos.
 * Proporciona métodos para obtener una única instancia de conexión y administrar su ciclo de vida.
 */
public class DatabaseConnection {

    // Constantes de configuración para la conexión a la base de datos
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/modulo5";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Instancia única de la clase (patrón Singleton)
    private static DatabaseConnection instance;
    private Connection connection;

    /**
     * Constructor privado que inicializa la conexión a la base de datos.
     * Implementa el patrón Singleton para asegurar una única instancia.
     */
    private DatabaseConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error al inicializar la conexión a la base de datos:", e);
        }
    }

    /**
     * Obtiene la instancia única de DatabaseConnection.
     * @return La instancia única de DatabaseConnection
     */
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /**
     * Obtiene la conexión a la base de datos.
     * Si la conexión no existe o está cerrada, crea una nueva.
     * @return La conexión a la base de datos
     * @throws RuntimeException si hay un error al obtener la conexión
     */
    public Connection getConnection() {
        try {
            if (connection == null | connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos:", e);
        }
    }

    /**
     * Cierra la conexión a la base de datos si está abierta.
     * @throws RuntimeException si hay un error al cerrar la conexión
     */
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexión a la base de datos:", e);
        }
    }
}
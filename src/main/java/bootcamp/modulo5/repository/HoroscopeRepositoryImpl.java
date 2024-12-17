package bootcamp.modulo5.repository;

import bootcamp.modulo5.configuration.DatabaseConnection;
import bootcamp.modulo5.model.Horoscope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de horóscopos que maneja las operaciones de base de datos
 * relacionadas con los signos del horóscopo chino.
 */
public class HoroscopeRepositoryImpl implements HoroscopeRepository {

    // Instancia de la conexión a la base de datos
    private final DatabaseConnection databaseConnection;

    /**
     * Constructor que inicializa la conexión a la base de datos
     * utilizando el patrón Singleton.
     */
    public HoroscopeRepositoryImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    /**
     * Recupera todos los horóscopos almacenados en la base de datos.
     *
     * @return Lista de objetos Horoscope con todos los horóscopos disponibles
     * @throws RuntimeException si ocurre un error durante la consulta a la base de datos
     */
    @Override
    public List<Horoscope> findAll() {
        // Definición de la consulta SQL
        String query = "SELECT id, animal, start_date, end_date " +
                      "FROM horoscopes";

        // Lista para almacenar los resultados
        List<Horoscope> horoscopes = new ArrayList<>();

        // Uso de try-with-resources para manejar automáticamente el cierre de recursos
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Iteración sobre los resultados de la consulta
            while (rs.next()) {
                // Creación y agregación de cada objeto Horoscope a la lista
                horoscopes.add(new Horoscope(
                    rs.getInt("id"),
                    rs.getString("animal"),
                    rs.getObject("start_date", LocalDate.class),
                    rs.getObject("end_date", LocalDate.class)
                ));
            }
            return horoscopes;

        } catch (SQLException e) {
            // Manejo de excepciones SQL
            throw new RuntimeException(e);
        }
    }
}
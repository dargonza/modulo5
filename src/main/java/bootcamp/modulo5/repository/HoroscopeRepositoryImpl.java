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

public class HoroscopeRepositoryImpl implements HoroscopeRepository {

    private final DatabaseConnection databaseConnection;

    public HoroscopeRepositoryImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    /**
     * Recupera todos los horóscopos almacenados en el repositorio.
     *
     * @return Una lista que contiene todos los objetos Horoscope disponibles
     */
    @Override
    public List<Horoscope> findAll() {
        String query = "SELECT id, animal, start_date, end_date " +
                       "FROM horoscope";

        List<Horoscope> horoscopes = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {
                horoscopes.add(new Horoscope(
                        rs.getInt("id"),
                        rs.getString("animal"),
                        rs.getObject("start_date", LocalDate.class),
                        rs.getObject("end_date", LocalDate.class)
                ));
            }
            return horoscopes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

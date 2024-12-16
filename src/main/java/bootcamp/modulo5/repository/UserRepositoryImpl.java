package bootcamp.modulo5.repository;

import bootcamp.modulo5.configuration.DatabaseConnection;
import bootcamp.modulo5.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final DatabaseConnection databaseConnection;

    public UserRepositoryImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public boolean saveUser(User user) {
        String query = "INSERT INTO users (name, username, email, birth_date, password, animal) " +
                "   VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setObject(4, user.getBirthDate());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getAnimal());

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }

            return true;
        } catch (Exception e) {
            //throw new RuntimeException("Error al guardar el usuario: ", e);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> findAllUsers() {
        String query = "SELECT id, name, username, email, birth_date, password, animal FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getObject("birth_date", LocalDate.class),
                        rs.getString("password"),
                        rs.getString("animal")
                ));
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException("Error finding all users", e);
        }
    }

    @Override
    public User findUserByUsername(String username) {
        String query = "SELECT id, name, username, email, birthDate, password, animal " +
                "FROM users " +
                "WHERE username = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getObject("birth_date", LocalDate.class),
                        rs.getString("password"),
                        rs.getString("animal")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding user by username", e);
        }
        return null;
    }

    @Override
    public User findUserById(int id) {
        String query = "SELECT id, name, username, email, birth_date, password, animal " +
                "FROM users " +
                "WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getObject("birth_date", LocalDate.class),
                        rs.getString("password"),
                        rs.getString("animal")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding user by id", e);
        }
        return null;
    }

    @Override
    public User findUserHoroscope(int userId) {
        // TODO: Implement the logic to fetch the user's horoscope
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        String query = "SELECT COUNT(*) " +
                "FROM users " +
                "WHERE username = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error checking username existence", e);
        }
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        String query = "SELECT COUNT(*) " +
                "FROM users " +
                "WHERE email = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error checking email existence", e);
        }
        return false;
    }

    @Override
    public User updateUser(User user) {
        String query = "UPDATE users " +
                "SET name = ?, username = ?, email = ?, birth_date = ?, password = ?, animal = ? " +
                "WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setObject(4, user.getBirthDate());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getAnimal());
            stmt.setInt(7, user.getId());

            if (stmt.executeUpdate() > 0) {
                return user;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM users " +
                "WHERE id = ? ";


        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, userId);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error deleting user", e);
        }
    }

    @Override
    public User login(String username, String password) {
        String query = "SELECT id, name, username, email, birth_date, password, animal " +
                "FROM users " +
                "WHERE username = ? AND password = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {


            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthDate(rs.getObject("birth_date", LocalDate.class));
                user.setAnimal(rs.getString("animal"));
                return user;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during login", e);
        }
        return null;
    }
}

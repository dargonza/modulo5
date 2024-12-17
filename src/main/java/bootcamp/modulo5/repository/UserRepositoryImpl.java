package bootcamp.modulo5.repository;

import bootcamp.modulo5.configuration.DatabaseConnection;
import bootcamp.modulo5.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de usuarios que maneja las operaciones CRUD en la base de datos.
 */
public class UserRepositoryImpl implements UserRepository {
    private final DatabaseConnection databaseConnection;

    /**
     * Constructor que inicializa la conexión a la base de datos.
     */
    public UserRepositoryImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     * @param user Usuario a guardar
     * @return true si el usuario fue guardado exitosamente, false en caso contrario
     */
    @Override
    public boolean saveUser(User user) {
        // Query SQL para insertar un nuevo usuario
        String query = "INSERT INTO users (name, username, email, birth_date, password, animal) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Establecer los parámetros del usuario
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setObject(4, user.getBirthDate());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getAnimal());

            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recupera todos los usuarios de la base de datos.
     * @return Lista de todos los usuarios
     */
    @Override
    public List<User> findAllUsers() {
        String query = "SELECT id, name, username, email, birth_date, password, animal FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Iterar sobre los resultados y crear objetos User
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
            throw new RuntimeException("Error al buscar todos los usuarios", e);
        }
    }

    /**
     * Busca un usuario por su nombre de usuario.
     * @param username Nombre de usuario a buscar
     * @return Usuario encontrado o null si no existe
     */
    @Override
    public User findUserByUsername(String username) {
        String query = "SELECT id, name, username, email, birth_date, password, animal FROM users WHERE username = ?";

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
            throw new RuntimeException("Error al buscar usuario por nombre de usuario", e);
        }
        return null;
    }

    /**
     * Busca un usuario por su ID.
     * @param id ID del usuario a buscar
     * @return Usuario encontrado o null si no existe
     */
    @Override
    public User findUserById(int id) {
        String query = "SELECT id, name, username, email, birth_date, password, animal FROM users WHERE id = ?";

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
            throw new RuntimeException("Error al buscar usuario por ID", e);
        }
        return null;
    }

    /**
     * Método para obtener el horóscopo de un usuario.
     * @param userId ID del usuario
     * @return Usuario con información de horóscopo
     */
    @Override
    public User findUserHoroscope(int userId) {
        // TODO: Implementar la lógica para obtener el horóscopo del usuario
        return null;
    }

    /**
     * Verifica si existe un usuario con el nombre de usuario especificado.
     * @param username Nombre de usuario a verificar
     * @return true si existe, false en caso contrario
     */
    @Override
    public boolean existsByUsername(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar existencia de nombre de usuario", e);
        }
        return false;
    }

    /**
     * Verifica si existe un usuario con el email especificado.
     * @param email Email a verificar
     * @return true si existe, false en caso contrario
     */
    @Override
    public boolean existsByEmail(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar existencia de email", e);
        }
        return false;
    }

    /**
     * Actualiza la información de un usuario existente.
     * @param user Usuario con la información actualizada
     * @return Usuario actualizado o null si la actualización falló
     */
    @Override
    public User updateUser(User user) {
        String query = "UPDATE users SET name = ?, username = ?, email = ?, birth_date = ?, password = ?, animal = ? WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Establecer los parámetros actualizados
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
            throw new RuntimeException("Error al actualizar usuario", e);
        }
        return null;
    }

    /**
     * Elimina un usuario por su ID.
     * @param userId ID del usuario a eliminar
     * @return true si el usuario fue eliminado exitosamente, false en caso contrario
     */
    @Override
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar usuario", e);
        }
    }

    /**
     * Realiza el proceso de login verificando las credenciales del usuario.
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return Usuario autenticado o null si las credenciales son inválidas
     */
    @Override
    public User login(String username, String password) {
        String query = "SELECT id, name, username, email, birth_date, password, animal FROM users WHERE username = ? AND password = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Crear y poblar el objeto User con los datos del resultado
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
            throw new RuntimeException("Error durante el proceso de login", e);
        }
        return null;
    }
}

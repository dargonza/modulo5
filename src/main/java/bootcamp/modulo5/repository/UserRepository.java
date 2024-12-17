package bootcamp.modulo5.repository;

import bootcamp.modulo5.model.User;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD y de autenticación para la entidad User
 */
public interface UserRepository {

    // ========== OPERACIONES DE CREACIÓN ==========
    /**
     * Guarda un nuevo usuario en el sistema
     * @param user Usuario a guardar
     * @return true si el usuario fue guardado exitosamente, false en caso contrario
     */
    boolean saveUser(User user);

    // ========== OPERACIONES DE LECTURA ==========
    /**
     * Recupera todos los usuarios del sistema
     * @return Lista de todos los usuarios
     */
    List<User> findAllUsers();

    /**
     * Busca un usuario por su nombre de usuario
     * @param username Nombre de usuario a buscar
     * @return Usuario encontrado o null si no existe
     */
    User findUserByUsername(String username);

    /**
     * Busca un usuario por su ID
     * @param id ID del usuario a buscar
     * @return Usuario encontrado o null si no existe
     */
    User findUserById(int id);


    /**
     * Verifica si existe un usuario con el nombre de usuario especificado
     * @param username Nombre de usuario a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsByUsername(String username);

    /**
     * Verifica si existe un usuario con el email especificado
     * @param email Email a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsByEmail(String email);

    // ========== OPERACIONES DE ACTUALIZACIÓN ==========
    /**
     * Actualiza la información de un usuario existente
     * @param user Usuario con la información actualizada
     * @return Usuario actualizado
     */
    User updateUser(User user);

    // ========== OPERACIONES DE ELIMINACIÓN ==========
    /**
     * Elimina un usuario del sistema
     * @param userId ID del usuario a eliminar
     * @return true si el usuario fue eliminado exitosamente, false en caso contrario
     */
    boolean deleteUser(int userId);

    // ========== OPERACIONES DE AUTENTICACIÓN ==========
    /**
     * Realiza el proceso de login de un usuario
     * @param username Nombre de usuario
     * @param password Contraseña del usuario
     * @return Usuario autenticado o null si las credenciales son inválidas
     */
    User login(String username, String password);
}
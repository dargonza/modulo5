package bootcamp.modulo5.service;

import bootcamp.modulo5.dto.UserCreateDTO;
import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.dto.UserUpdateDTO;

import java.util.List;

/**
 * Interfaz que define las operaciones de servicio para la gestión de usuarios.
 * Incluye operaciones CRUD y funcionalidades de autenticación.
 */
public interface UserService {
    // ========== Operaciones CRUD de Usuario ==========
    /**
     * Busca un usuario por su ID.
     * @param userId ID del usuario a buscar
     * @return DTO con la información del usuario encontrado
     */
    UserResponseDTO getUserById(int userId);

    /**
     * Actualiza la información de un usuario existente.
     * @param userUpdateDTO DTO con los datos actualizados del usuario
     * @return DTO con la información del usuario actualizado
     */
    UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO);

    /**
     * Elimina un usuario del sistema.
     * @param userId ID del usuario a eliminar
     * @return true si el usuario fue eliminado exitosamente, false en caso contrario
     */
    boolean deleteUser(int userId);

    /**
     * Obtiene una lista de todos los usuarios registrados.
     * @return Lista de DTOs con la información de todos los usuarios
     */
    List<UserResponseDTO> getAllUsers();

    // ========== Registro y Autenticación de Usuario ==========
    /**
     * Registra un nuevo usuario en el sistema.
     * @param userCreateDTO DTO con los datos del nuevo usuario
     * @return true si el registro fue exitoso, false en caso contrario
     */
    boolean registerUser(UserCreateDTO userCreateDTO);

    /**
     * Autentica un usuario en el sistema.
     * @param username nombre de usuario
     * @param password contraseña del usuario
     * @return DTO con la información del usuario autenticado
     */
    UserResponseDTO loginUser(String username, String password);
}
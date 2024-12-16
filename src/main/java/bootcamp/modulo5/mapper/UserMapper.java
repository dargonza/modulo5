package bootcamp.modulo5.mapper;

import bootcamp.modulo5.dto.UserCreateDTO;
import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.dto.UserUpdateDTO;
import bootcamp.modulo5.model.User;

/**
 * Clase que maneja el mapeo entre los DTOs y la entidad User.
 * Proporciona métodos para convertir entre diferentes representaciones de usuarios.
 */
public class UserMapper {

    /**
     * Convierte un objeto UserCreateDTO a una entidad User.
     *
     * @param createDTO El DTO con los datos para crear un nuevo usuario
     * @return Una nueva instancia de User con los datos proporcionados
     */
    public static User toEntity(UserCreateDTO createDTO) {
        // Creación de una nueva instancia de User
        User user = new User();

        // Asignación de los valores del DTO a la entidad
        user.setName(createDTO.getName());
        user.setUsername(createDTO.getUsername());
        user.setEmail(createDTO.getEmail());
        user.setBirthDate(createDTO.getBirthDate());
        user.setPassword(createDTO.getPassword());
        user.setAnimal(createDTO.getAnimal());

        return user;
    }

    /**
     * Actualiza una entidad User existente con los datos de un UserUpdateDTO.
     *
     * @param user La entidad User a actualizar
     * @param updateDTO El DTO con los nuevos datos
     * @return La entidad User actualizada
     */
    public static User updateEntity(User user, UserUpdateDTO updateDTO) {
        // Actualización de los campos de la entidad con los nuevos valores
        user.setName(updateDTO.getName());
        user.setUsername(updateDTO.getUsername());
        user.setEmail(updateDTO.getEmail());
        user.setPassword(updateDTO.getPassword());
        user.setBirthDate(updateDTO.getBirthDate());

        return user;
    }

    /**
     * Convierte una entidad User a un UserResponseDTO.
     *
     * @param user La entidad User a convertir
     * @return Un nuevo UserResponseDTO con los datos del usuario
     */
    public static UserResponseDTO toDto(User user) {
        // Creación y retorno del DTO de respuesta con los datos seleccionados del usuario
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getBirthDate(),
                user.getEmail(),
                user.getAnimal()
        );
    }
}
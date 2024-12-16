package bootcamp.modulo5.mapper;

import bootcamp.modulo5.dto.UserCreateDTO;
import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.dto.UserUpdateDTO;
import bootcamp.modulo5.model.User;

public class UserMapper {

    // Convierte un UserCreateDTO a una entidad User
    public static User toEntity(UserCreateDTO createDTO) {
        User user = new User();
        user.setName(createDTO.getName());
        user.setUsername(createDTO.getUsername());
        user.setEmail(createDTO.getEmail());
        user.setBirthDate(createDTO.getBirthDate());
        user.setPassword(createDTO.getPassword());
        user.setAnimal(createDTO.getAnimal());
        return user;
    }

    // Convierte un UserUpdateDTO a una entidad User
    public static User updateEntity(User user, UserUpdateDTO updateDTO) {
        user.setName(updateDTO.getName());
        user.setUsername(updateDTO.getUsername());
        user.setEmail(updateDTO.getEmail());
        user.setPassword(updateDTO.getPassword());
        user.setBirthDate(updateDTO.getBirthDate());
        return user;
    }

    // Convierte una entidad User a un UserResponseDTO
    public static UserResponseDTO toDto(User user) {
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

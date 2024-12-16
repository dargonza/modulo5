package bootcamp.modulo5.service;

import bootcamp.modulo5.dto.UserCreateDTO;
import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.dto.UserUpdateDTO;
import bootcamp.modulo5.mapper.UserMapper;
import bootcamp.modulo5.model.User;
import bootcamp.modulo5.repository.HoroscopeRepositoryImpl;
import bootcamp.modulo5.repository.UserRepository;
import bootcamp.modulo5.repository.UserRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HoroscopeService horoscopeService;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
        this.horoscopeService = new HoroscopeServiceImpl();
    }

    @Override
    public boolean registerUser(UserCreateDTO userCreateDTO) {
        if (userCreateDTO == null) {
            return false;
        }

        if (userRepository.existsByUsername(userCreateDTO.getUsername())) {
            return false;
        }

        if (userRepository.existsByEmail(userCreateDTO.getEmail())) {
            return false;
        }

        User user = UserMapper.toEntity(userCreateDTO);
        if (userRepository.saveUser(user)) {
            return true;
        }

        return false;
    }

    @Override
    public UserResponseDTO loginUser(String username, String password) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return null;
        }

        try {
            User user = userRepository.login(username.trim(), password.trim());
            return UserMapper.toDto(user);
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error al iniciar sesión: " + e.getMessage());
            return null;
        }
    }


    @Override
    public UserResponseDTO getUserByUsername(String username) {
        // Todo: Implementar el método para obtener un usuario por su nombre de usuario
        return null;
    }

    @Override
    public UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO) {

        // Validar si el DTO o su ID es inválido
        if (userUpdateDTO == null || userUpdateDTO.getId() == 0) {
            return null;
        }

        // Buscar el usuario por ID
        User user = userRepository.findUserById(userUpdateDTO.getId());
        if (user == null) {
            return null;
        }

        boolean isUpdated = false; // Para controlar si hubo cambios

        // Verificar y actualizar el nombre
        if (userUpdateDTO.getName() != null && !userUpdateDTO.getName().equals(user.getName())) {
            if (userUpdateDTO.getName().trim().isEmpty()) {
                return null;
            }
            user.setName(userUpdateDTO.getName());
            isUpdated = true;
        }

        // Verificar y actualizar el username
        if (userUpdateDTO.getUsername() != null && !userUpdateDTO.getUsername().equals(user.getUsername())) {

            if (userRepository.existsByUsername(userUpdateDTO.getUsername())) {

                return null;
            }
            user.setUsername(userUpdateDTO.getUsername());
            isUpdated = true;
        }

        // Verificar y actualizar el email
        if (userUpdateDTO.getEmail() != null && !userUpdateDTO.getEmail().equals(user.getEmail())) {

            if (userRepository.existsByEmail(userUpdateDTO.getEmail())) {
                return null;
            }
            user.setEmail(userUpdateDTO.getEmail());
            isUpdated = true;
        }

        // Verificar y actualizar la contraseña (solo si cambia)
        if (userUpdateDTO.getPassword() != null && !userUpdateDTO.getPassword().trim().isEmpty()) {
            if (!userUpdateDTO.getPassword().equals(user.getPassword())) {
                user.setPassword(userUpdateDTO.getPassword());
                isUpdated = true;
            }
        }

        // Verificar y actualizar la fecha de nacimiento
        if (userUpdateDTO.getBirthDate() != null && !userUpdateDTO.getBirthDate().equals(user.getBirthDate())) {
            if (userUpdateDTO.getBirthDate().isAfter(LocalDate.of(2024, 2, 9))) {
                return null;
            }
            user.setBirthDate(userUpdateDTO.getBirthDate());
            isUpdated = true;

            // Obtener un nuevo valor para el animal
            String newAnimal = horoscopeService.getChineseZodiacAnimal(userUpdateDTO.getBirthDate());
            if (newAnimal != null && !newAnimal.trim().isEmpty()) {
                user.setAnimal(newAnimal);
                isUpdated = true;
            }
        }

        // Guardar los cambios si se realizaron
        if (isUpdated) {

            User updatedUserEntity = userRepository.updateUser(user);
            if (updatedUserEntity != null) {
                return UserMapper.toDto(updatedUserEntity);
            }
        }

        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        User user = userRepository.findUserById(userId);
        if (user != null) {
            return userRepository.deleteUser(userId);
        }
        return false;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAllUsers();
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(int userId) {
        User user = userRepository.findUserById(userId);
        if (user != null) {
            return UserMapper.toDto(user);
        }
        return null;
    }
}

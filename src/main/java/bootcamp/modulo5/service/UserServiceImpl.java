package bootcamp.modulo5.service;

import bootcamp.modulo5.dto.UserCreateDTO;
import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.dto.UserUpdateDTO;
import bootcamp.modulo5.mapper.UserMapper;
import bootcamp.modulo5.model.User;
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
            throw new RuntimeException("El usuario no puede ser null");
        }

        if (userCreateDTO.getName() == null || userCreateDTO.getName().trim().isEmpty() || userCreateDTO.getName().trim().length() < 2) {
            throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres");
        }

        if (userCreateDTO.getUsername() == null || userCreateDTO.getUsername().trim().isEmpty() || userCreateDTO.getUsername().trim().length() < 2) {
            throw new IllegalArgumentException("El nombre de usuario debe tener al menos 2 caracteres");
        }

        if (userRepository.existsByUsername(userCreateDTO.getUsername())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe en la base de datos");
        }

        if (userCreateDTO.getEmail() == null || !userCreateDTO.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("El email es inválido");
        }

        if (userRepository.existsByEmail(userCreateDTO.getEmail())) {
            throw new IllegalArgumentException("El email ya existe en la base de datos");
        }

        if (userCreateDTO.getPassword() == null || userCreateDTO.getPassword().length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }

        if (userCreateDTO.getBirthDate() == null || userCreateDTO.getBirthDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }

        String animalSign = horoscopeService.getChineseZodiacAnimal(userCreateDTO.getBirthDate());
        if (animalSign == null || animalSign.trim().isEmpty()) {
            throw new IllegalArgumentException("Error al obtener el signo del zodiaco chino");
        }

        userCreateDTO.setAnimal(animalSign);

        User user = UserMapper.toEntity(userCreateDTO);

        return userRepository.saveUser(user);
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
            // TODO: Manejar la excepción de manera adecuada, como lanzar una excepción personalizada o registrar el error
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
        if (userUpdateDTO == null || userUpdateDTO.getId() <= 0) {
            throw new IllegalArgumentException("El DTO es nulo o el ID no es válido.");
        }

        // Buscar el usuario por ID
        User user = userRepository.findUserById(userUpdateDTO.getId());
        if (user == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }

        boolean isUpdated = false; // Para controlar si hubo cambios

        // Verificar y actualizar el nombre
        if (userUpdateDTO.getName() != null && !userUpdateDTO.getName().equals(user.getName())) {
            if (userUpdateDTO.getName().trim().length() < 2) {
                throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres.");
            }
            user.setName(userUpdateDTO.getName());
            isUpdated = true;
        }

        // Verificar y actualizar el username
        if (userUpdateDTO.getUsername() != null && !userUpdateDTO.getUsername().equals(user.getUsername())) {
            if (userUpdateDTO.getUsername().trim().length() < 2) {
                throw new IllegalArgumentException("El username debe tener al menos 2 caracteres.");
            }
            if (userRepository.existsByUsername(userUpdateDTO.getUsername())) {
                throw new IllegalArgumentException("El username ya existe.");
            }
            user.setUsername(userUpdateDTO.getUsername());
            isUpdated = true;
        }

        // Verificar y actualizar el email
        if (userUpdateDTO.getEmail() != null && !userUpdateDTO.getEmail().equals(user.getEmail())) {
            if (userRepository.existsByEmail(userUpdateDTO.getEmail())) {
                throw new IllegalArgumentException("El email ya existe.");
            }
            user.setEmail(userUpdateDTO.getEmail());
            isUpdated = true;
        }

        // Verificar y actualizar la contraseña (solo si cambia)
        if (userUpdateDTO.getPassword() != null && !userUpdateDTO.getPassword().trim().isEmpty()) {
            if (userUpdateDTO.getPassword().length() < 6) {
                throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
            }
            if (!userUpdateDTO.getPassword().equals(user.getPassword())) {
                user.setPassword(userUpdateDTO.getPassword());
                isUpdated = true;
            }
        }

        // Verificar y actualizar la fecha de nacimiento
        if (userUpdateDTO.getBirthDate() != null && !userUpdateDTO.getBirthDate().equals(user.getBirthDate())) {
            if (userUpdateDTO.getBirthDate().isAfter(LocalDate.of(2024, 2, 9))) {
                throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
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

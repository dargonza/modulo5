package bootcamp.modulo5.service;

import bootcamp.modulo5.dto.UserCreateDTO;
import bootcamp.modulo5.dto.UserResponseDTO;
import bootcamp.modulo5.dto.UserUpdateDTO;


import java.util.List;

public interface UserService {
    // User CRUD operations
    UserResponseDTO getUserByUsername(String username);
    UserResponseDTO getUserById(int userId);
    UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO);
    boolean deleteUser(int userId);
    List<UserResponseDTO> getAllUsers();

    // User registration and authentication
    boolean registerUser(UserCreateDTO userCreateDTO);
    UserResponseDTO loginUser(String username, String password);

}

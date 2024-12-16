package bootcamp.modulo5.repository;

import bootcamp.modulo5.model.User;

import java.util.List;

public interface UserRepository {

    // Create
    boolean saveUser(User user);

    // Read
    List<User> findAllUsers();
    User findUserByUsername(String username);
    User findUserById(int id);
    User findUserHoroscope(int userId);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    // Update
    User updateUser(User user);

    // Delete
    boolean deleteUser(int userId);

    // Auth operations
    User login(String username, String password);
}




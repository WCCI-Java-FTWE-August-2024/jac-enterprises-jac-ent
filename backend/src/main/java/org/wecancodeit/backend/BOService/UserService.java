package org.wecancodeit.backend.BOService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.wecancodeit.backend.DataModels.UserModel;
import org.wecancodeit.backend.Repositories.UserRepository;

import jakarta.annotation.Resource;

// Service class for managing user-related operations
@Service
public class UserService {

    @Resource
    private UserRepository userRepository; // Injected UserRepository for database access

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserModel> getAll() {

        return userRepository.findAll();
    }


    // Method to register a new user
    public UserModel registerUser(UserModel user) throws Exception {
        // Check if the username is already taken
        List<UserModel> checkUser = findUserByUsername(user.getUsername());
        if (checkUser != null && checkUser.size() > 0) { // If a user with the same username exists
            throw new Exception("Username is taken. Please use another. "); // Throw an exception
        }

        // Save the new user to the database
        return userRepository.save(user);
    }

    // Method to find a user by username (case-insensitive)
    public List<UserModel> findUserByUsername(String username) {
        // Return the user found by the username, ignoring case
        return userRepository.findByUsernameIgnoreCase(username);
    }

    // Method to find a user by their ID
    public Optional<UserModel> findUserById(Long id) {
        // Return an Optional containing the user if found
        return userRepository.findById(id);
    }

    // Method to update a user's information
    public UserModel updateUser(UserModel user) {
        // Save the updated user to the database
        return userRepository.save(user);
    }

    // Method to delete a user by ID
    public void deleteUser(Long id) {
        // Delete the user from the database
        userRepository.deleteById(id);
    }
}

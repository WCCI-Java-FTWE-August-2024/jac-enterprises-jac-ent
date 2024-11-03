package org.wecancodeit.backend.BOService;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wecancodeit.backend.Repositories.UserRepository;

// Service class for managing user-related operations
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Injected UserRepository for database access

    // Method to register a new user
    public User registerUser(User user) throws Exception {
        // Check if the username is already taken
        User checkUser = findUserByUsername(user.getUsername());
        if (checkUser != null) { // If a user with the same username exists
            throw new Exception("Username is taken. Please use another. "); // Throw an exception
        }

        // Save the new user to the database
        return userRepository.save(user);
    }

    // Method to find a user by username (case-insensitive)
    public User findUserByUsername(String username) {
        // Return the user found by the username, ignoring case
        return userRepository.findByUsernameIgnoreCase(username);
    }

    // Method to find a user by their ID
    public Optional<User> findUserById(Long id) {
        // Return an Optional containing the user if found
        return userRepository.findById(id);
    }

    // Method to update a user's information
    public User updateUser(User user) {
        // Save the updated user to the database
        return userRepository.save(user);
    }

    // Method to delete a user by ID
    public void deleteUser(Long id) {
        // Delete the user from the database
        userRepository.deleteById(id);
    }
}

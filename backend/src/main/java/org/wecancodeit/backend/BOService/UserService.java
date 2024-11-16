package org.wecancodeit.backend.BOService;

import java.util.*;

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

    /**
 * Service method to authenticate a user based on their username and password.
 * If authentication is successful, a unique token is generated and returned.
 *
 * @param password The password provided by the user for authentication.
 * @param username The username provided by the user for authentication.
 * @return A unique token if the login is successful.
 * @throws Exception If login credentials are invalid or user does not exist.
 */
public String getLogin(String password, String username) throws Exception {
    // Retrieve the list of users matching the provided username
    ArrayList<UserModel> userList = new ArrayList<>(findUserByUsername(username));

    // Check if any users were found with the provided username
    if (userList.size() >= 1) {
        // Get the first user from the list (assuming usernames are unique)
        UserModel user = userList.get(0);

        // Verify that the provided password matches the stored password
        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid Login"); // Throw an exception if password is incorrect
        }

        // Generate a new unique token for the user upon successful login
        user.setToken(UUID.randomUUID().toString());

        // Save the updated user information with the new token
        userRepository.save(user);

        // Return the generated token to the caller
        return user.getToken();
    } else {
        throw new Exception("Invalid Login Password"); // Throw an exception if no user is found
    }
}

/**
 * Service method to retrieve a user's token if valid.
 *
 * @param token The token provided by the user for validation.
 * @return The token if it is valid and associated with an existing user.
 * @throws Exception If the token is invalid or does not match any user.
 */
public String getToken(String token) throws Exception {
    // Look up a user by their token
    UserModel user = userRepository.findByToken(token);

    // If no user is found with the given token, throw an exception
    if (user == null) {
        throw new Exception("Invalid Login Token");
    }

    // Return the validated token if user is found
    return user.getToken();
}
}

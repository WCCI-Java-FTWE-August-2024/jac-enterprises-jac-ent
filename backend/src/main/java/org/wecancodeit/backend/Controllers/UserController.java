package org.wecancodeit.backend.Controllers;

import org.apache.catalina.User; // Ensure you are using the correct User class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.backend.BOService.UserService;

// Controller class for managing user-related API endpoints
@RestController
@RequestMapping("/api/v1/users") // Base URL for user-related endpoints
public class UserController {

    @Autowired
    private UserService userService; // Injected UserService for user operations

    // Endpoint to register a new user
    @PostMapping("/") // Handles POST requests to /api/v1/users/
    public ResponseEntity<User> register(@RequestBody User user) throws Exception {
        // Register the new user and return the created user
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Endpoint to get a user by username
    @GetMapping("/{username}") // Handles GET requests to /api/v1/users/{username}
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        // Find the user by username
        User user = userService.findUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user); // Return the found user
        }
        return ResponseEntity.notFound().build(); // Return 404 if not found
    }

    // Endpoint to get a user by ID
    @GetMapping("/id/{id}") // Use a different path to avoid conflict with username
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Find the user by ID and return the user if found
        return userService.findUserById(id)
            .map(ResponseEntity::ok) // Return the user if found
            .orElse(ResponseEntity.notFound().build()); // Return 404 if not found
    }

    // Endpoint to update a user's information
    @PutMapping("/{id}") // Handles PUT requests to /api/v1/users/{id}
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        
        User updatedUser = userService.updateUser(user); // Update the user
        return ResponseEntity.ok(updatedUser); // Return the updated user
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/{id}") // Handles DELETE requests to /api/v1/users/{id}
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Delete the user by ID
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}

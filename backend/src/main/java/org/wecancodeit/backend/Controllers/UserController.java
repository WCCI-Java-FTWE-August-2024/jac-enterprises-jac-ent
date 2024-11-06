package org.wecancodeit.backend.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.backend.BOService.UserService;
import org.wecancodeit.backend.DataModels.UserModel;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;



// Controller class for managing user-related API endpoints
@RestController
@RequestMapping("/api/v1/users") // Base URL for user-related endpoints
public class UserController {

    @Resource
    private UserService userService; // Injected UserService for user operations

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping  
    public ResponseEntity<?> getAllUsers() {

            return ResponseEntity.ok(userService.getAll());
        
    }
    
    
    // Endpoint to register a new user
    @PostMapping("/") // Handles POST requests to /api/v1/users/
    public ResponseEntity<UserModel> register(@RequestBody UserModel user) throws Exception {
        // Register the new user and return the created user
        UserModel newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Endpoint to get a user by username
    @GetMapping("/{username}") // Handles GET requests to /api/v1/users/{username}
    public ResponseEntity<List<UserModel>> getUserByUsername(@PathVariable String username) {
        // Find the user by username
        List<UserModel> user = userService.findUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user); // Return the found user
        }
        return ResponseEntity.notFound().build(); // Return 404 if not found
    }

    // Endpoint to get a user by ID
    @GetMapping("/{id}") // Use a different path to avoid conflict with username
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        // Find the user by ID and return the user if found
        return userService.findUserById(id)
            .map(ResponseEntity::ok) // Return the user if found
            .orElse(ResponseEntity.notFound().build()); // Return 404 if not found
    }

    // Endpoint to update a user's information
    @PutMapping("/{id}") // Handles PUT requests to /api/v1/users/{id}
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel user) {

        UserModel updatedUser = userService.updateUser(user); // Update the user
        return ResponseEntity.ok(updatedUser); // Return the updated user
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/{id}") // Handles DELETE requests to /api/v1/users/{id}
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Delete the user by ID
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}

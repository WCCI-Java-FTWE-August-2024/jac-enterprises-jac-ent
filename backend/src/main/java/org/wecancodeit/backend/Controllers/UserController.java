package org.wecancodeit.backend.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.backend.BOService.UserService;
import org.wecancodeit.backend.DTOs.LoginDTO;
import org.wecancodeit.backend.DTOs.LoginDTO;
import org.wecancodeit.backend.DataModels.UserModel;

import org.springframework.web.bind.annotation.GetMapping;

// Controller class for managing user-related API endpoints
@RestController
@RequestMapping("/api/v1/users") // Base URL for user-related endpoints
public class UserController extends BaseController{

    public UserController(UserService userService) {
        super(userService);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        String token = "";
        try {
            token = this.getUserService().getLogin(loginDTO.getPassword(), loginDTO.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        } return ResponseEntity.ok(token);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(@RequestHeader(name="Authorization", required = true) String authHeader) {
        if (checkToken(authHeader)) {
            return ResponseEntity.ok(getUserService().getAll());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid authorization header");
    }

    // Endpoint to register a new user
    @PostMapping("/") // Handles POST requests to /api/v1/users/
    public ResponseEntity<UserModel> register(@RequestBody UserModel user) throws Exception {
        // Register the new user and return the created user
        UserModel newUser = getUserService().registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Endpoint to get a user by username
    @GetMapping("/{username}") // Handles GET requests to /api/v1/users/{username}
    public ResponseEntity<List<UserModel>> getUserByUsername(@PathVariable String username) {
        // Find the user by username
        List<UserModel> user = getUserService().findUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user); // Return the found user
        }
        return ResponseEntity.notFound().build(); // Return 404 if not found
    }

    // Endpoint to get a user by ID
    @GetMapping("/{id}") // Use a different path to avoid conflict with username
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        // Find the user by ID and return the user if found
        return getUserService().findUserById(id)
                .map(ResponseEntity::ok) // Return the user if found
                .orElse(ResponseEntity.notFound().build()); // Return 404 if not found
    }

    // Endpoint to update a user's information
    @PutMapping("/{id}") // Handles PUT requests to /api/v1/users/{id}
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel user) {

        UserModel updatedUser = getUserService().updateUser(user); // Update the user
        return ResponseEntity.ok(updatedUser); // Return the updated user
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/{id}") // Handles DELETE requests to /api/v1/users/{id}
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        getUserService().deleteUser(id); // Delete the user by I
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}

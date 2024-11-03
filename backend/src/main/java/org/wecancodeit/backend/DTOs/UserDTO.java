package org.wecancodeit.backend.DTOs;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Data Transfer Object (DTO) for transferring user data
public class UserDTO {

    // Unique identifier for the user (not typically sent in the DTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID value
    private Long id;

    // Username for the user
    @NotBlank // Ensures that the username is not empty
    @Size(min = 3, max = 20) // Ensures the username length is between 3 and 20 characters
    private String username;

    // Password for the user
    @NotBlank // Ensures that the password is not empty
    @Size(min = 6) // Ensures the password has a minimum length of 6 characters
    private String password;

    // Age of the user
    @NotBlank // Ensures that the age is not empty; consider changing to a numeric constraint
              // instead
    private int age; // Age of the user (should typically be an integer)

    // Getters and Setters

    public String getUsername() {
        return username; // Returns the username
    }

    public void setUsername(String username) {
        this.username = username; // Sets the username
    }

    public String getPassword() {
        return password; // Returns the password
    }

    public void setPassword(String password) {
        this.password = password; // Sets the password
    }

    public Long getId() {
        return id; // Returns the user's ID
    }

    public void setId(Long id) {
        this.id = id; // Sets the user's ID
    }

    public int getAge() {
        return age; // Returns the user's age
    }

    public void setAge(int age) {
        this.age = age; // Sets the user's age
    }
}

package org.wecancodeit.backend.DataModels;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// User database entity class representing the user model

@Entity // Indicates that this class is a JPA entity
@Table(name = "users") // Specifies the table name in the database
public class UserModel {

    // ###### Constructor
    // Constructor for creating a new UserModel instance with specified fields
    public UserModel(Long id, String username, String password, int age) {
        this.id = id; // Assigning the user's ID
        this.username = username; // Assigning the username
        this.password = password; // Assigning the password
        this.age = age; // Assigning the user's age
    }

    // ############### Objects

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID value
    private Long id; // Unique identifier for the user

    @NotBlank // Validation annotation to ensure this field is not empty
    @Size(min = 3, max = 20) // Validation for the length of the username
    private String username; // Username for the user

    @NotBlank // Validation annotation to ensure this field is not empty
    @Size(min = 6) // Validation for the minimum length of the password
    private String password; // Password for the user (should be stored hashed in practice)

    @NotBlank // Validation annotation to ensure this field is not empty
    private int age; // Age of the user

    // ###################################### Getters and Setters

    public Long getId() {
        return id; // Returns the user's ID
    }

    public void setId(Long id) {
        this.id = id; // Sets the user's ID
    }

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

    public int getAge() {
        return age; // Returns the user's age
    }

    public void setAge(int age) {
        this.age = age; // Sets the user's age
    }
}
